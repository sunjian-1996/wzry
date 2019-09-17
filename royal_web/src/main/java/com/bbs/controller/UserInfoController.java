package com.bbs.controller;

import com.bbs.domain.BbsUserTable;
import com.bbs.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("userInfo")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    //修改邮箱
    @RequestMapping("update.do")
    public ModelAndView update(@RequestParam(value="file",required=false) MultipartFile file, BbsUserTable bbsUserTable){
        userInfoService.update(bbsUserTable);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("userInfo");
        return mv;
    }
}
