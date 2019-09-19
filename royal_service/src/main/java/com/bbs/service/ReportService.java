package com.bbs.service;

import com.bbs.domain.BbsReportTable;

public interface ReportService {
    int jubaozhuangtai(String userName, long articleId) throws Exception;

    void addReport(BbsReportTable reportTable) throws Exception;
}
