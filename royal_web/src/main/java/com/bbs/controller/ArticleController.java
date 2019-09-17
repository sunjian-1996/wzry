package com.bbs.controller;

import com.bbs.domain.BbsArticleTable;
import com.bbs.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/article")
@SessionAttributes({"zoneId", "articleId"})
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/findAll.do")
    public @ResponseBody
    List<BbsArticleTable> findAll(ModelMap modelMap, @RequestParam(name = "zoneId", defaultValue = "1") @RequestBody int zoneId) throws Exception {
        List<BbsArticleTable> articleList = articleService.findAll(zoneId);
        modelMap.addAttribute("zoneId", zoneId);
        return articleList;
    }

    @RequestMapping("/publish.do")
    public ModelAndView publish(BbsArticleTable articleTable, HttpSession session) throws Exception {
        articleService.publish(articleTable);
        long zoneId = articleTable.getZoneId();
        ModelAndView mv = new ModelAndView();
        mv.addObject("zoneId", zoneId);
        session.removeAttribute("articleId");
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/getArticle.do")
    public ModelAndView getArticle(@RequestParam(name = "articleId") long articleId) throws Exception {
        BbsArticleTable bbsArticleTable = articleService.getArticle(articleId);
        ModelAndView mv = new ModelAndView();
        mv.addObject("bbsArticleTable", bbsArticleTable);
        mv.addObject("articleId", articleId);
        mv.setViewName("getArticle");
        return mv;
    }

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
