package com.bbs.service;

import com.bbs.domain.BbsReportTable;

import java.util.List;

public interface ReportService {
    int jubaozhuangtai(String userName, long articleId) throws Exception;

    void addReport(BbsReportTable reportTable) throws Exception;

    List<BbsReportTable> findByPage();

    void deleteArticle(Integer reportId);

    String findArticleContent(int articleId) throws Exception;

    void upreportStatus(Integer reportId, Integer reportStatus);
}
