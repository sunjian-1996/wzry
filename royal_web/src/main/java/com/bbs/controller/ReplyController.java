package com.bbs.controller;

import com.bbs.domain.BbsReplyTable;
import com.bbs.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@RequestMapping("/reply")
@Controller
public class ReplyController {
    @Autowired
    private ReplyService replyService;

    //新增回复
    @RequestMapping("/addReply.do")
    public String addReply(BbsReplyTable bbsReplyTable, HttpSession session) throws Exception {
        Long articleId = (Long) session.getAttribute("articleId");
        replyService.commentNumber(articleId);
        replyService.addReply(bbsReplyTable);
        return "redirect:/article/show.do";
    }

}
