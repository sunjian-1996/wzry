package com.bbs.controller;

import com.bbs.domain.BbsWordTable;
import com.bbs.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/word")
public class WordController {

    @Autowired
    private WordService wordService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() {
        List<BbsWordTable> words = wordService.findAllWord();
        ModelAndView mv = new ModelAndView();
        mv.addObject("words", words);
        mv.setViewName("redirect:/jsp/index.jsp");
        return mv;
    }


}
