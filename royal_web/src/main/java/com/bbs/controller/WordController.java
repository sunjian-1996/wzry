package com.bbs.controller;

import com.bbs.domain.BbsWordTable;
import com.bbs.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/word")
public class WordController {

    @Autowired
    private WordService wordService;
    @Autowired
    private WordUtilsBean.WordUtils wordUtils;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() {
        List<BbsWordTable> words = wordService.findAllWord();
        ModelAndView mv = new ModelAndView();
        mv.addObject("words", words);
        mv.setViewName("redirect:/jsp/index.jsp");
        return mv;
    }

    @RequestMapping("/updateWordUtils.do")
    public @ResponseBody
    Map<String, String> updateWordUtils() throws Exception {
        Thread.sleep(300);
        wordUtils.update();
        HashMap<String, String> map = new HashMap<>();
        map.put("message", "前台已更新敏感词库");
        return map;
    }
}
