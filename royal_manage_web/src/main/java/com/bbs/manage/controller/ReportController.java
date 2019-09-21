package com.bbs.manage.controller;

import com.bbs.domain.BbsReportTable;
import com.bbs.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ReportService reportService;

    /**
     * 举报查询所有
     *
     * @return
     */
    @RequestMapping("/findByPage.do")
    public ModelAndView findByPage() {
        List<BbsReportTable> report = reportService.findByPage();
        ModelAndView mv = new ModelAndView();
        mv.addObject("report", report);
        mv.setViewName("forward:/jsp/common/RePortPage.jsp");
        return mv;
    }

    /**
     * 修改举报状态
     */
    @RequestMapping("/upreportStatus.do")
    public String upreportStatus(Integer reportId, Integer reportStatus) {
        reportService.upreportStatus(reportId, reportStatus);
        return "redirect:/report/findByPage.do";

    }

    /**
     * 删除
     *
     * @param reportId
     */
    @RequestMapping("/deleteArticle.do")
    public String deleteArticle(Integer reportId) {
        System.out.println(reportId);
        reportService.deleteArticle(reportId);
        return "redirect:/report/findByPage.do";
    }


    @RequestMapping("/findArticleContent.do")
    public @ResponseBody
    Map<String, String> findArticleContent(int articleId) throws Exception {
        System.out.println(articleId);
        String content = reportService.findArticleContent(articleId);
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("content", content);
        System.out.println(map);
        return map;
    }

}
