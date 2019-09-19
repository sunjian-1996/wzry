package com.bbs.manage.controller;

import com.bbs.domain.BbsUserTable;
import com.bbs.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /*查询所有用户*/
    @RequestMapping("/findByPage.do")
    public ModelAndView findByPage(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "4") int size) {
        ModelAndView mv = new ModelAndView();
        List<BbsUserTable> users = userService.findByPage( page, size );
        /*pageInfo就是一个分页bean*/
        PageInfo pageInfo = new PageInfo( users );
        mv.addObject( "pageInfo", pageInfo );
        mv.setViewName( "/userMassage" );
        return mv;
    }

    /*升级*/
    @RequestMapping("/updateUser.do")
    public String updateUser(int userId, int role, int page) {
        userService.updateUser( userId, role );
        return "redirect:/user/findByPage.do?page=" + page;
    }

    /*条件查询*/
    @RequestMapping("SearchByUserAndRole.do")
    public ModelAndView SearchByUserAndRole(BbsUserTable bbsUserTable, @RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "5") int size) {
        ModelAndView mv = new ModelAndView();
        List<BbsUserTable> userTables = userService.findByUserName( bbsUserTable.getUserName(), bbsUserTable.getRole()+"", page, size);
        PageInfo pageInfo = new PageInfo( userTables );
        mv.addObject( "pageInfo", pageInfo );
        mv.addObject( "condition",bbsUserTable );
        mv.addObject( "all", userTables );
        mv.setViewName( "userMassage" );
        return mv;
    }


    /*禁言和恢复*/
    @RequestMapping("/WordAndReply.do")
    public String WordAndReply(@RequestParam("userId") int userId, @RequestParam("talkStatus") int talkStatus, int page) {
        userService.WordAndReply( userId, talkStatus );
        return "redirect:/user/findByPage.do?page=" + page;
    }

    /*退出*/
    @RequestMapping("/logout.do")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute( "bbsUserTable" );
        return "login";

    }


}


