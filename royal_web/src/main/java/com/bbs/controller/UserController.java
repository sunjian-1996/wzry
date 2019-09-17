package com.bbs.controller;

import com.bbs.domain.BbsUserTable;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    //异步验证用户名
    @RequestMapping("findByuserName.do")
    public @ResponseBody
    BbsUserTable findByuserName(String userName) {
        return userService.findByuserName(userName);
    }

    //注册
    @RequestMapping("save.do")
    public ModelAndView save(BbsUserTable bbsUserTable) {
        userService.save(bbsUserTable);
        bbsUserTable = userService.findByuserName(bbsUserTable.getUserName());
        ModelAndView mv = new ModelAndView();
        mv.addObject("loginUser", bbsUserTable);
        mv.setViewName("redirect:/article/show.do");
        return mv;
    }

    //登陆
    @RequestMapping("login.do")
    public ModelAndView login(BbsUserTable bbsUserTable, HttpServletRequest request) {
        BbsUserTable bb = userService.findByuserName(bbsUserTable.getUserName());

        ModelAndView mv = new ModelAndView();
        if (bb == null) {
            mv.addObject("msg", "账号或密码有误");
        } else {
            if (bb.getUserPass().equals(bbsUserTable.getUserPass()) && bb.getUserName().equals(bbsUserTable.getUserName())) {
                request.getSession().setAttribute("loginUser", bb);
            } else {
                mv.addObject("msg", "账号或密码有误");
            }
        }

        mv.setViewName("redirect:/article/show.do");
        return mv;

    }

    //注销
    @RequestMapping("logout.do")
    public ModelAndView logout(HttpSession httpSession) {
        httpSession.removeAttribute("loginUser");
        httpSession.removeAttribute("articleId");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/article/show.do");
        return modelAndView;
    }
}
