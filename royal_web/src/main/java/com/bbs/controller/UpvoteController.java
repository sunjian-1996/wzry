package com.bbs.controller;

import com.bbs.domain.BbsUserTable;
import com.bbs.service.UpvoteService;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/upvote")
public class UpvoteController {

    @Autowired
    private UpvoteService upvoteService;

    @Autowired
    private UserService userService;

    //查询点赞状态
    @RequestMapping("/findDianZanStatus.do")
    public @ResponseBody
    Map<String, Integer> findDianZanStatus(HttpSession session) throws Exception {
        BbsUserTable user = (BbsUserTable) session.getAttribute("loginUser");
        long articleId = (long) session.getAttribute("articleId");
        int status = upvoteService.findDianZanStatus(user.getUserName(), articleId);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("status", status);
        return map;
    }

    //点赞功能并返回点赞数
    @RequestMapping("/dianZan.do")
    public @ResponseBody
    Map<String, Long> dianZan(HttpSession session) throws Exception {
        BbsUserTable user = (BbsUserTable) session.getAttribute("loginUser");
        long articleId = (long) session.getAttribute("articleId");
        long dianZanCount = upvoteService.dianZan(user.getUserName(), articleId);
        HashMap<String, Long> map = new HashMap<>();
        map.put("dianZanCount", dianZanCount);
        return map;
    }



}
