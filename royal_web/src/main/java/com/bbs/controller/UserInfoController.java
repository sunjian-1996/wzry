package com.bbs.controller;

import com.bbs.domain.BbsUserTable;
import com.bbs.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("userInfo")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    //修改邮箱
    @RequestMapping("update.do")
    public ModelAndView update(@RequestParam(value="file",required=false) MultipartFile file, BbsUserTable bbsUserTable, HttpServletRequest request) throws IOException {
        // 使用fileupload组件完成文件上传
        // 上传的位置
        String path = request.getSession().getServletContext().getRealPath("/upload/images/");
        // 判断，该路径是否存在
        File file2 = new File(path);
        if(!file2.exists()){
            // 创建该文件夹
            file2.mkdirs();
        }

        // 说明上传文件项
        // 获取上传文件的名称
        String filename = file.getOriginalFilename();
        // 把文件的名称设置唯一值，uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid+"_"+filename;
        // 完成文件上传

        file.transferTo(new File(path,filename));



        bbsUserTable.setPicUrl("" +
                "upload/images/"+filename);
        userInfoService.update(bbsUserTable);
        ModelAndView mv = new ModelAndView();
        mv.addObject("msgg","修改成功");
        mv.setViewName("userInfo");
        return mv;
    }

    //图片
    @RequestMapping("findPic")
    @ResponseBody
    public String findPic(HttpServletRequest request){
        BbsUserTable loginUser = (BbsUserTable)request.getSession().getAttribute("loginUser");
        return loginUser.getPicUrl();
    }


    //修改密码
    @RequestMapping("updateToPass")
    public ModelAndView updateToPass(HttpServletRequest request,String newPassword){
        BbsUserTable loginUser = (BbsUserTable)request.getSession().getAttribute("loginUser");
        loginUser.setUserPass(newPassword);
        userInfoService.updateToPass(loginUser);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        mv.addObject("msgg","修改成功");
        return mv;

    }
}
