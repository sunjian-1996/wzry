package com.bbs.controller;

import com.bbs.domain.BbsArticleTable;
import com.bbs.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/findAll.do")
    public @ResponseBody
    List<BbsArticleTable> findAll(@RequestParam(name = "zoneId", defaultValue = "1") @RequestBody int zoneId) throws Exception {
        List<BbsArticleTable> articleList = articleService.findAll(zoneId);
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

}
