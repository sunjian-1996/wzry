package com.bbs.controller;

import com.bbs.dao.WordDao;
import com.bbs.domain.BbsArticleTable;
import com.bbs.domain.BbsCommentTable;
import com.bbs.domain.BbsReplyTable;
import com.bbs.domain.BbsWordTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WordUtilsBean {
    @Autowired
    private WordDao wordDao;

    //敏感词过滤工具类放入spring容器
    @Bean(name = "wordUtils")
    public WordUtils createWordUtils() {
        List<String> wordList = findWordList();
        WordUtils wordUtils = new WordUtils();
        wordUtils.setList(wordList);
        if (wordList.size() == 0) {
            System.out.println("敏感词获取失败或数据库中没有敏感词");
        } else {
            System.out.println("敏感词初始化完成");
        }
        return wordUtils;
    }

    //查询敏感词集合
    public List<String> findWordList() {
        List<BbsWordTable> all = wordDao.findAll();
        ArrayList<String> list = new ArrayList<>();
        for (BbsWordTable bbsWordTable : all) {
            if (bbsWordTable.getStatus() == 0) {
                list.add(bbsWordTable.getWord());
            }
        }
        return list;
    }

    public class WordUtils {

        private List<String> list;

        public List<String> getList() {
            return list;
        }

        public void setList(List<String> list) {
            this.list = list;
        }

        //更新敏感词库
        public void update() {
            List<String> wordList = findWordList();
            this.setList(wordList);
            System.out.println("更新明感词库");
        }

        //输入一个集合文本，返回过滤后的集合文本
        public List<String> updateWord(List<String> words) {
            ArrayList<String> updateList = new ArrayList<>();
            for (String word : words) {
                for (String s : list) {
                    updateList.add(word.replace(s, "***"));
                }
            }
            return updateList;
        }

        //帖子集合屏蔽
        public List<BbsArticleTable> updateArticle(List<BbsArticleTable> articleTables) {
            ArrayList<BbsArticleTable> list = new ArrayList<>();
            for (BbsArticleTable articleTable : articleTables) {
                list.add(updateArticle(articleTable));
            }
            return list;
        }

        //帖子单个屏蔽
        public BbsArticleTable updateArticle(BbsArticleTable article) {
            for (String s : list) {
                article.setContent(article.getContent().replace(s, "***"));
                article.setTitle(article.getTitle().replace(s, "***"));
                article.setSenderName(article.getSenderName().replace(s, "***"));

                List<BbsCommentTable> bbsCommentTables = article.getBbsCommentTables();
                if (bbsCommentTables != null && bbsCommentTables.size() > 0) {
                    article.setBbsCommentTables(updateComment(bbsCommentTables));
                }
            }
            return article;
        }

        //评论集合屏蔽
        public List<BbsCommentTable> updateComment(List<BbsCommentTable> commentTable) {
            ArrayList<BbsCommentTable> list = new ArrayList<>();
            for (BbsCommentTable comment : commentTable) {
                list.add(updateComment(comment));
            }
            return list;
        }

        //评论单个屏蔽
        public BbsCommentTable updateComment(BbsCommentTable commentTable) {
            for (String s : list) {
                commentTable.setCommentContent(commentTable.getCommentContent().replace(s, "***"));
                commentTable.setCommentUserName(commentTable.getCommentUserName().replace(s, "***"));

                List<BbsReplyTable> bbsReplyTables = commentTable.getBbsReplyTables();
                if (bbsReplyTables != null && bbsReplyTables.size() > 0) {
                    commentTable.setBbsReplyTables(updateReply(bbsReplyTables));
                }
            }
            return commentTable;
        }

        //回复集合屏蔽
        public List<BbsReplyTable> updateReply(List<BbsReplyTable> replyTables) {
            ArrayList<BbsReplyTable> list = new ArrayList<>();
            for (BbsReplyTable replyTable : replyTables) {
                list.add(updateReply(replyTable));
            }
            return list;
        }

        //回复单个屏蔽
        public BbsReplyTable updateReply(BbsReplyTable replyTable) {
            for (String s : list) {
                replyTable.setReplyContent(replyTable.getReplyContent().replace(s, "***"));
                replyTable.setReplyUserName(replyTable.getReplyUserName().replace(s, "***"));
            }
            return replyTable;
        }
    }

}
