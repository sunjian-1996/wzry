package com.bbs.controller;

import com.bbs.domain.BbsArticleTable;
import com.bbs.service.ArticleService;
import com.bbs.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @ResponseBody
    public String publish(@RequestBody BbsArticleTable articleTable) throws Exception {
        articleService.publish(articleTable);
        long zoneId = articleTable.getZoneId();
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("zoneId", zoneId);
//        mv.setViewName("index");
        return "redirect:/article/findAll.do";
    }




    //全部帖子
    @RequestMapping("/tiezifindAll.do")
    public @ResponseBody
    Map<String, String> tiezifindAll() throws Exception {
        int total = articleService.tiezifindAll();
        String date = DateUtils.date2String(new Date(),"yyyy-MM-dd");
        int jinri = articleService.jinritiezifindAll(date+"%");
        HashMap<String, String> map = new HashMap<>();
        map.put("total", total+"");
        map.put("jinri",jinri+"");
        return map;
    }




}
