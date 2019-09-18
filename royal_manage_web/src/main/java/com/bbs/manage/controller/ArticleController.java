package com.bbs.manage.controller;

import com.bbs.domain.BbsArticleTable;
import com.bbs.service.ArticleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    //模糊查询
    @RequestMapping("/findByTitleOrSenderName.do")
    public ModelAndView findByTitleOrSenderName(String title,String senderName){
       ModelAndView mv = new ModelAndView();
       List<BbsArticleTable> articleTableList=articleService.findByTitleOrSenderName(title,senderName);
       PageInfo pageInfo=new PageInfo(articleTableList);
       mv.setViewName("ArticlePage");
       mv.addObject("pageInfo",pageInfo);
       mv.addObject("title",title);
       mv.addObject("senderName",senderName);
        return mv;
    }
    //分页查询
    @RequestMapping("/findByPage.do")
    public ModelAndView findByPage( @RequestParam(name = "page",required = true,defaultValue = "1") int page,
                                   @RequestParam(name = "size",required = true,defaultValue = "4") int size){
        ModelAndView mv = new ModelAndView();
       List<BbsArticleTable> articleTableList=articleService.findByPage(page,size);
    //分页bean,pageInfo
        PageInfo pageInfo =new PageInfo(articleTableList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("ArticlePage");
        return mv;
    }

}
