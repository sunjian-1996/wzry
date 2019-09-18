package com.bbs.controller;

import com.bbs.domain.BbsCommentTable;
import com.bbs.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    //评论功能
    @RequestMapping("addComment.do")
    public String addComment(BbsCommentTable bbsCommentTable) throws Exception {

        commentService.addComment(bbsCommentTable);
        return "redirect:/article/show.do";
    }

}
