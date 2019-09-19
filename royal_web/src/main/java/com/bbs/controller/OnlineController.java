package com.bbs.controller;

import com.bbs.domain.UserOnline;
import com.bbs.service.OnlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/online")
public class OnlineController {
    @Autowired
    private OnlineService onlineService;
    @RequestMapping("/showOnline.do")
    public String showOnline(HttpServletRequest request) throws Exception {
        UserOnline userOnline = onlineService.showOnline();
        request.getSession().setAttribute("userOnline",userOnline);
        return "redirect:/article/findAll.do";
    }
}
