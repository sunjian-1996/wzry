package com.bbs.manage.controller;

import com.bbs.domain.BbsArticleTable;
import com.bbs.service.ArticleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;


@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    //分页查询+模糊查询
    @RequestMapping("/findByPage.do")
    public ModelAndView findByPage(@RequestParam(name = "page",required = true,defaultValue = "1") int page,
                                   @RequestParam(name = "size",required = true,defaultValue = "4") int size,
                                   String title, String senderName, HttpServletRequest request){
        String temp = request.getParameter("title");
        if (temp!=null){
            try {
                title = new String(temp.getBytes("ISO-8859-1"), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        ModelAndView mv = new ModelAndView();
       List<BbsArticleTable> articleTableList=articleService.findByPage(page,size,title,senderName);
    //分页bean,pageInfo
        PageInfo pageInfo =new PageInfo(articleTableList);
        mv.addObject("pageInfo",pageInfo);
        mv.addObject("title",title);
        mv.addObject("senderName",senderName);
        mv.setViewName("ArticlePage");
        return mv;
    }


    @RequestMapping("/changeStatus.do")
    public String changeStatus(Integer articleId, Integer isTop) {
        articleService.changeStatus(articleId, isTop);
        return "redirect:/article/findByPage.do";
    }

    /**
     * 查询所有
     *
     * @return
     */
    @RequestMapping("/findAllPage.do")
    public ModelAndView findAllPage() throws Exception {
        List<BbsArticleTable> all = articleService.findAllPage();
        ModelAndView mv = new ModelAndView();
        mv.addObject("all", all);
        mv.setViewName("forward:/jsp/Article.jsp");
        return mv;
    }

    /**
     * 屏蔽暗纽
     *
     * @param articleId
     * @return
     */
    @RequestMapping("/deleteArticle.do")
    public String articleStatus(Integer articleId, Integer articleStatus) {
        articleService.articleStatus(articleId, articleStatus);
        return "redirect:/article/findAllPage.do";
    }

}
