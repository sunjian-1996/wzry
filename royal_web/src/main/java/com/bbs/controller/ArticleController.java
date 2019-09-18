package com.bbs.controller;

import com.bbs.domain.BbsArticleTable;
import com.bbs.service.ArticleService;
import com.bbs.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    //版块所有的帖
    @RequestMapping("/findAll.do")
    public @ResponseBody
    List<BbsArticleTable> findAll(@RequestParam(name = "zoneId", defaultValue = "1") @RequestBody int zoneId, HttpSession session) throws Exception {
        List<BbsArticleTable> articleList = articleService.findAll(zoneId);
        session.setAttribute("zoneId", zoneId);
        session.removeAttribute("articleId");
        return articleList;
    }

    //写帖
    @RequestMapping("/publish.do")
    public String publish(@RequestBody BbsArticleTable articleTable, HttpSession session) throws Exception {
        long articleId = articleService.publish(articleTable);
        session.setAttribute("articleId", articleId);
        return "redirect:/article/show.do";
    }

    //全部帖子
    @RequestMapping("/tiezifindAll.do")
    public @ResponseBody
    Map<String, String> tiezifindAll() throws Exception {
        int total = articleService.tiezifindAll();
        String date = DateUtils.date2String(new Date(), "yyyy-MM-dd");
        int jinri = articleService.jinritiezifindAll(date + "%");
        HashMap<String, String> map = new HashMap<>();
        map.put("total", total + "");
        map.put("jinri", jinri + "");
        return map;
    }

    //帖详情
    @RequestMapping("/getArticle.do")
    public ModelAndView getArticle(@RequestParam(name = "articleId") long articleId, HttpSession session) throws Exception {
        BbsArticleTable bbsArticleTable = articleService.getArticle(articleId);
        ModelAndView mv = new ModelAndView();
        mv.addObject("bbsArticleTable", bbsArticleTable);
        session.setAttribute("articleId", bbsArticleTable.getArticleId());
        mv.setViewName("getArticle");
        return mv;
    }

    //返回之前所在的页面
    @RequestMapping("/show.do")
    public String show(HttpSession session) {
        Object articleId = session.getAttribute("articleId");
        if (articleId != null) {
            return "redirect:/article/getArticle.do?articleId=" + articleId;
        } else {
            return "redirect:/jsp/index.jsp";
        }
    }

}
