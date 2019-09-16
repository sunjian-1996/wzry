package com.bbs.controller;

import com.bbs.domain.BbsUserTable;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    //异步验证用户名
    @RequestMapping("findByuserName.do")
    public @ResponseBody BbsUserTable findByuserName(String userName){
        return userService.findByuserName(userName);
    }
    //注册
    @RequestMapping("save.do")
    public ModelAndView save(BbsUserTable bbsUserTable){
        userService.save(bbsUserTable);
        ModelAndView mv = new ModelAndView();
        mv.addObject("",bbsUserTable.getUserName());
        mv.setViewName("");
        return mv;

    }
}
