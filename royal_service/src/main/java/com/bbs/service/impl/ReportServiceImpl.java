package com.bbs.service.impl;

import com.bbs.dao.ReportDao;
import com.bbs.domain.BbsReportTable;
import com.bbs.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("reportService")
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportDao reportDao;

    @Override
    public int jubaozhuangtai(String userName, long articleId) throws Exception {
        BbsReportTable reportTable = null;
        try {
            reportTable = reportDao.findByUserNameAndArticleId(userName, articleId);
        } catch (Exception e) {

        }
        if (reportTable != null) {
            return 1;
        }
        return 0;
    }

    @Override
    public void addReport(BbsReportTable reportTable) throws Exception {
        BbsReportTable ropert = null;
        try {
            ropert = reportDao.findByUserNameAndArticleId(reportTable.getReportUserName(), reportTable.getArticleId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (ropert == null) {
            reportDao.addReport(reportTable);
        }
    }
}
