package com.bbs.controller;

import com.bbs.domain.BbsReportTable;
import com.bbs.domain.BbsUserTable;
import com.bbs.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ReportService reportService;

    //查询举报状态
    @RequestMapping("/jubaozhuangtai.do")
    public @ResponseBody
    Map<String, Integer> jubaozhuangtai(HttpSession session) throws Exception {
        BbsUserTable bbsUserTable = (BbsUserTable) session.getAttribute("loginUser");
        long articleId = (long) session.getAttribute("articleId");
        int status = reportService.jubaozhuangtai(bbsUserTable.getUserName(), articleId);
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("jubao", status);
        return map;
    }

    //举报功能
    @RequestMapping("/saveReportByArtcleId.do")
    public String saveReportByArtcleId(BbsReportTable reportTable) throws Exception {
        reportTable.setReportStatus(0);
        reportTable.setReportTime(new Date());
        reportService.addReport(reportTable);
        return "redirect:/article/show.do";
    }
}
