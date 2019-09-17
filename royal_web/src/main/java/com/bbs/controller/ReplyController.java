package com.bbs.controller;

import com.bbs.domain.BbsReplyTable;
import com.bbs.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/reply")
@Controller
public class ReplyController {
    @Autowired
    private ReplyService replyService;

    @RequestMapping("/addReply.do")
    public String addReply(BbsReplyTable bbsReplyTable) throws Exception {
        replyService.addReply(bbsReplyTable);
        return "redirect:/article/show.do";
    }

}
