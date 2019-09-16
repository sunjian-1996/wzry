package com.bbs.controller;

import com.bbs.domain.BbsArticleTable;
import com.bbs.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
