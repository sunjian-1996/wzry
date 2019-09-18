package com.bbs.manage.controller;

import com.bbs.domain.BbsUserTable;
import com.bbs.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /*登录*/
    @RequestMapping("/login.do")
    public ModelAndView login(@RequestParam("userName") String userName, @RequestParam("userPass") String userPass) {
        BbsUserTable bbsUserTable = new BbsUserTable();
        bbsUserTable.setUserName( userName );
        bbsUserTable.setUserPass( userPass );
        BbsUserTable bt = userService.findByUserName( bbsUserTable );
        ModelAndView mv = new ModelAndView();
        if (bt == null) {
            //登陆失败
            mv.addObject( "message", "用户不能为空" );
            mv.setViewName( "/login" );
        } else {
            if (!bt.getUserPass().equals( userPass )){
                //登陆失败
//            mv.setViewName("/foot");
                mv.addObject( "message", "用户名或密码错误,请重新输入" );
                mv.setViewName( "/login" );
            }else{
                //登陆成功,登录信息存入session
                mv.setViewName( "/main" );
            }
        }
        return mv;
    }

    /*查询所有用户*/
    @RequestMapping("/findByPage.do")
    public ModelAndView findByPage() {
        ModelAndView mv = new ModelAndView();
        List<BbsUserTable> users = userService.findByPage();
        mv.addObject( "all", users );
        mv.setViewName( "/userMassage" );
        return mv;
    }

    /*升级*/
    @RequestMapping("/updateUser.do")
    public String updateUser(int userId,int role) {
        userService.updateUser(userId,role);
        return "redirect:/user/findByPage.do";

    }

    /*模糊查询*/
    @RequestMapping("SearchByUserAndRole.do")
    public ModelAndView SearchByUserAndRole(String userName, Long role) {
        BbsUserTable bbsUserTable = new BbsUserTable();
        bbsUserTable.setUserName( userName );
        bbsUserTable.setRole( role );
        ModelAndView mv = new ModelAndView();
        List<BbsUserTable> userTables = (List<BbsUserTable>) userService.findByUserName( bbsUserTable );
        mv.addObject( "", userTables );
        mv.setViewName( "userMassage" );
        return mv;
    }

    /*禁言*/
    @RequestMapping("/WordAndReply.do")
    public String WordAndReply(@RequestParam("userId") int userId,@RequestParam("talkStatus") int talkStatus){
        userService.WordAndReply(userId,talkStatus);
        return "redirect:/user/findByPage.do";
    }

    /*退出*/


}


