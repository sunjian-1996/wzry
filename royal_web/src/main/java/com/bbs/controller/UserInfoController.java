package com.bbs.controller;

import com.bbs.domain.BbsUserTable;
import com.bbs.service.UserInfoService;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    private BCryptPasswordEncoder bCryptPasswordEncoder =new BCryptPasswordEncoder();

    @Autowired
    private UserService userService;

    //修改邮箱
    @RequestMapping("update.do")
    public ModelAndView update(@RequestParam(value="file",required=false) MultipartFile file, BbsUserTable bbsUserTable, HttpServletRequest request) throws IOException {
        // 使用fileupload组件完成文件上传
        // 上传的位置
        if (file.getSize() != 0){
            String path = request.getSession().getServletContext().getRealPath("/jsp/upload/images/");
            // 判断，该路径是否存在
            File file2 = new File(path);
            if(!file2.exists()){
                // 创建该文件夹
                file2.mkdirs();

            }

            // 说明上传文件项
            // 获取上传文件的名称
            String filename = file.getOriginalFilename();
            String substring = filename.substring(filename.lastIndexOf(".") + 1);
            if((!"jpg".equals(substring.toLowerCase())) && (!"png".equals(substring.toLowerCase()))){
                ModelAndView mv = new ModelAndView();
                //mv.addObject("msgg","修改成功");
                request.getSession().setAttribute("msggs","图片格式非法");
                mv.setViewName("redirect:/jsp/userInfo.jsp");
                return mv;
            }
            // 把文件的名称设置唯一值，uuid
            String uuid = UUID.randomUUID().toString().replace("-", "");
            filename = uuid+"_"+filename;
            // 完成文件上传

            file.transferTo(new File(path,filename));

            bbsUserTable.setPicUrl("" +
                    "upload/images/"+filename);
        }
        request.getSession().removeAttribute("msgg");
        userInfoService.update(bbsUserTable);
        BbsUserTable userTable = userService.findByuserName(bbsUserTable.getUserName());
        request.getSession().setAttribute("loginUser",userTable);
        ModelAndView mv = new ModelAndView();
        //mv.addObject("msgg","修改成功");
        request.getSession().setAttribute("msggs","修改成功");
        mv.setViewName("redirect:/jsp/userInfo.jsp");
        return mv;
    }

    //图片
    @RequestMapping("findPic")
    @ResponseBody
    public String findPic(HttpServletRequest request){
        BbsUserTable loginUser = (BbsUserTable)request.getSession().getAttribute("loginUser");
        BbsUserTable bbsUserTable = userService.findByuserName(loginUser.getUserName());
        request.getSession().setAttribute("loginUser",bbsUserTable);
        return bbsUserTable.getPicUrl();
    }


    //修改密码
    @RequestMapping("updateToPass")
    public ModelAndView updateToPass(HttpServletRequest request,String oldPassword,String newPassword){
        BbsUserTable loginUser = (BbsUserTable)request.getSession().getAttribute("loginUser");
        ModelAndView mv = new ModelAndView();
//        loginUser.getUserPass().equals(oldPassword)
      if (bCryptPasswordEncoder.matches(oldPassword,loginUser.getUserPass())){
          loginUser.setUserPass(bCryptPasswordEncoder.encode(newPassword));
          userInfoService.updateToPass(loginUser);
          mv.setViewName("redirect:/jsp/userPwd.jsp");
          request.getSession().setAttribute("msgg","修改成功");
//          mv.addObject("msgg","修改成功");
      }else {
          mv.setViewName("redirect:/jsp/userPwd.jsp");
//          mv.addObject("msgg","修改失败");
          request.getSession().setAttribute("msgg","修改失败");

      }
        return mv;
    }
    @RequestMapping("yanZhengMM.do")
    public @ResponseBody BbsUserTable yanZhengMM(String oldPassword,HttpServletRequest request){
        BbsUserTable loginUser = (BbsUserTable)request.getSession().getAttribute("loginUser");
        if (bCryptPasswordEncoder.matches(oldPassword,loginUser.getUserPass())){
            return loginUser;
        }else {
            return null;
        }
    }

    //申请高级用户
    @RequestMapping("upgrade.do")
    public ModelAndView  upgrade(HttpServletRequest request){
    BbsUserTable loginUser = (BbsUserTable)request.getSession().getAttribute("loginUser");
    userInfoService.upgrade(loginUser);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/jsp/userInfoGj.jsp");
        return modelAndView;
    }
    //销毁session
    @RequestMapping("SChu.do")
    public void  xiaohui(HttpServletRequest request){
        request.getSession().removeAttribute("msgg");
        request.getSession().removeAttribute("msggs");

    }
}
