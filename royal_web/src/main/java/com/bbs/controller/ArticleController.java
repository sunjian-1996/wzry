package com.bbs.controller;

import com.bbs.domain.BbsArticleTable;
import com.bbs.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/article")
@SessionAttributes("zoneId")
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
    public ModelAndView publish(BbsArticleTable articleTable) throws Exception {
        articleService.publish(articleTable);
        long zoneId = articleTable.getZoneId();
        ModelAndView mv = new ModelAndView();
        mv.addObject("zoneId", zoneId);
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("getArticle.do")
    public ModelAndView getArticle(@RequestParam(name = "articleId") long articleId) throws Exception {
        BbsArticleTable bbsArticleTable = articleService.getArticle(articleId);
        ModelAndView mv = new ModelAndView();
        mv.addObject("bbsArticleTable", bbsArticleTable);
        mv.setViewName("getArticle");
        return mv;
    }

}
