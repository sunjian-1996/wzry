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

    /*登录*/
//    @RequestMapping("/login.do")
//    public ModelAndView login(@RequestParam("userName") String userName, @RequestParam("userPass") String userPass, HttpSession session) {
//        BbsUserTable bbsUserTable = new BbsUserTable();
//        bbsUserTable.setUserName( userName );
//        bbsUserTable.setUserPass( userPass );
//        BbsUserTable bt = userService.findByUserName( bbsUserTable );
//        ModelAndView mv = new ModelAndView();
//        if (bt == null) {
//            //登陆失败
//            mv.addObject( "message", "用户不能为空" );
//            mv.setViewName( "/login" );
//        } else {
//            if (!bt.getUserPass().equals( userPass )) {
//                //登陆失败
////            mv.setViewName("/foot");
//                mv.addObject( "message", "用户名或密码错误,请重新输入" );
//                mv.setViewName( "/login" );
//            } else {
//                //登陆成功,登录信息存入session
//                session.setAttribute( "bbsUserTable", bbsUserTable );
//                mv.setViewName( "/main" );
//            }
//        }
//        return mv;
//    }

    /*查询所有用户*/
    @RequestMapping("/findByPage.do")
    public ModelAndView findByPage(@RequestParam(name = "page",required = true,defaultValue = "1") int page,@RequestParam(name = "size",required = true,defaultValue = "5") int size) {
        ModelAndView mv = new ModelAndView();
        List<BbsUserTable> users = userService.findByPage(page,size);
       /*pageInfo就是一个分页bean*/
        PageInfo pageInfo= new PageInfo(users);
        mv.addObject( "pageInfo", pageInfo );
        mv.setViewName( "/userMassage" );
        return mv;
    }

    /*升级*/
    @RequestMapping("/updateUser.do")
    public String updateUser(int userId, int role) {
        userService.updateUser( userId, role );
        return "redirect:/user/findByPage.do";

    }


    /*条件查询*/
    @RequestMapping("SearchByUserAndRole.do")
    public ModelAndView SearchByUserAndRole(@RequestParam("userName") String userName, @RequestParam("role") String role,@RequestParam(name = "page",required = true,defaultValue = "1") int page,@RequestParam(name = "size",required = true,defaultValue = "5") int size){
        ModelAndView mv = new ModelAndView();
        List<String> list = new ArrayList<>();
        list.add( userName );
        list.add( role );
        List<BbsUserTable> userTables = userService.findByUserName( userName,role,page,size);
        PageInfo pageInfo= new PageInfo(userTables);
        mv.addObject( "pageInfo", pageInfo );
        mv.addObject( "all", userTables );
        mv.addObject( "list", list );

        mv.setViewName( "userMassage" );
        return mv;
    }

    /*禁言*/
    @RequestMapping("/WordAndReply.do")
    public String WordAndReply(@RequestParam("userId") int userId, @RequestParam("talkStatus") int talkStatus) {
        userService.WordAndReply( userId, talkStatus );
        return "redirect:/user/findByPage.do";
    }


    /*退出*/
    @RequestMapping("/logout.do")
    public String logout(HttpServletRequest request){
        HttpSession session =request.getSession();
        session.removeAttribute("bbsUserTable");
        return "login";

    }


    /*分页*/

}


