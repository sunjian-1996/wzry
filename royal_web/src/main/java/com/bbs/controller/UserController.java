package com.bbs.controller;

import com.bbs.domain.BbsUserTable;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    private BCryptPasswordEncoder bCryptPasswordEncoder =new BCryptPasswordEncoder();

    //异步验证用户名
    @RequestMapping("findByuserName.do")
    public @ResponseBody
    BbsUserTable findByuserName(String userName) {
        return userService.findByuserName(userName);
    }

    //注册
    @RequestMapping("save.do")
    public ModelAndView save(BbsUserTable bbsUserTable,HttpServletRequest request) {
        userService.save(bbsUserTable);
        bbsUserTable = userService.findByuserName(bbsUserTable.getUserName());
        request.getSession().setAttribute("loginUser",bbsUserTable);
        ModelAndView mv = new ModelAndView();
        mv.addObject("loginUser", bbsUserTable);
        mv.setViewName("index");
        return mv;
    }

    //删除msg
    @RequestMapping("zhuxiao.do")
    @ResponseBody
    public  String  zhuxiao(HttpServletRequest request){
        try {
            request.getSession().removeAttribute("msg");
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    //登陆
    @RequestMapping("login.do")
    public ModelAndView login(BbsUserTable bbsUserTable, HttpServletRequest request) {
        BbsUserTable bb = userService.findByuserName(bbsUserTable.getUserName());

        ModelAndView mv = new ModelAndView();
        if (bb == null) {
           // mv.addObject("msg", "账号或密码有误");
            request.getSession().setAttribute("msg", "账号或密码有误");
        } else {
         if (bCryptPasswordEncoder.matches(bbsUserTable.getUserPass(),bb.getUserPass()) && bb.getUserName().equals(bbsUserTable.getUserName())) {
          //改变登录状态
             userService.gaibiandengluzhuangtai(bbsUserTable.getUserName());
//                bb.getUserPass().equals(bbsUserTable.getUserPass())
                request.getSession().setAttribute("loginUser", bb);
                request.getSession().removeAttribute("msg");
            } else {
                request.getSession().setAttribute("msg", "账号或密码有误");
                /*mv.addObject("msg", "账号或密码有误");*/
            }
        }

        mv.setViewName("redirect:/article/show.do");
        return mv;

    }

    //注销
    @RequestMapping("logout.do")
    public ModelAndView logout(HttpSession httpSession) {
        BbsUserTable loginUser = (BbsUserTable)httpSession.getAttribute("loginUser");
        userService.gaibiandengluzhuangtai2(loginUser.getUserName());
        httpSession.removeAttribute("loginUser");
        httpSession.removeAttribute("articleId");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/article/show.do");
        return modelAndView;
    }
}
