package com.bbs.manage.controller;

import com.bbs.domain.BbsWordTable;
import com.bbs.service.WordService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/word")
public class WordController {
    @Autowired
    private WordService wordService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") int page, @RequestParam(name = "size",required = true,defaultValue = "4") int size){

        ModelAndView mv = new ModelAndView();
        List<BbsWordTable> bbsWordTableList=wordService.findAll(page,size);
        //分页bean,pageInfo
        PageInfo pageInfo =new PageInfo(bbsWordTableList);
        mv.setViewName("WordPage");
        mv.addObject("pageInfo",pageInfo);
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(BbsWordTable wordId){

        wordService.save(wordId);
        return "redirect:findAll.do";
    }

}
