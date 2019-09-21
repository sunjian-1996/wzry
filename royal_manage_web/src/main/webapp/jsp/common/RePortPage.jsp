<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>审批举报管理页面</title>

</head>
<style type="text/css">
    html, body {
        overflow: auto;
        height: 100%;
    }

    .line-limit-length {
        max-width: 220px;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
    }


</style>
<script>

</script>
<body>
<div class="hrms_dept_container">
    <!-- 导航栏-->
    <%@ include file="/jsp/common/head.jsp" %>


    <!-- 中间部分（左侧栏+表格内容） -->
    <div class="hrms_dept_body">
        <!-- 左侧栏 -->
        <%@ include file="/jsp/common/leftsidebar.jsp" %>

        <!-- 表格内容 -->
        <div class="dept_info col-sm-10">
            <div class="panel panel-success">
                <!-- 路径导航 -->
                <div>
                    <ol class="breadcrumb">
                        <li><a href="#">用户帖管理</a></li>
                        <li class="active">审批举报</li>
                    </ol>
                </div>

                <table class="table table-bordered table-hover">
                    <thead>
                    <tr>
                        <th>举报内容</th>
                        <th>举报人</th>
                        <th>举报时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${report}" var="report">
                        <tr>
                            <td width="30%">
                                    ${report.reportContent}
                            </td>

                            <td width="10%">
                                    ${report.reportUserName}
                            </td>
                            <td width="20%">
                                    ${report.reportTime}
                            </td>
                            <td width="10%">
                                <c:if test="${report.reportStatus==0}">
                                    未处理
                                </c:if>
                                <c:if test="${report.reportStatus==1}">
                                   处理
                                </c:if>
                            </td>
                            <td width="30%">

                                <!DOCTYPE html>
                                <html>
                                <head>
                                    <meta charset="utf-8">
                                    <title>Bootstrap 实例 - 模态框（Modal）插件</title>
                                    <link rel="stylesheet"
                                          href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
                                    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
                                    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
                                </head>
                                <body>


                                <!-- 按钮触发模态框 -->
                                <button onclick="contextBut(${report.articleId})" class="btn btn-primary"
                                        data-toggle="modal"
                                        data-target="#myModal">
                                    查询帖子信息
                                </button>
                                <!-- 模态框（Modal） -->
                                <div class="modal fade" id="myModal" tabindex="-1" role="dialog"
                                     aria-labelledby="myModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal"
                                                        aria-hidden="true">
                                                    &times;
                                                </button>
                                                <h4 class="modal-title" id="myModalLabel">
                                                    用户帖子信息
                                                </h4>
                                            </div>
                                            <div class="modal-body">
                                                <span id="contentSpan"></span>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                                                </button>
                                            </div>
                                        </div><!-- /.modal-content -->
                                    </div><!-- /.modal -->
                                </div>
                                </body>
                                </html>

                                <a href="/report/deleteArticle.do?reportId=${report.reportId}" role="button"
                                   class="btn btn-primary">删除</a>

                                <c:if test="${report.reportStatus==0}">
                                    <a href="/report/upreportStatus.do?reportId=${report.reportId}&reportStatus=1"
                                       role="button" class="btn btn-info">处理</a>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>


            </div><!-- /.panel panel-success -->
            <!--显示分页信息-->
            <div class="row">
                <!--文字信息-->
                <div class="col-md-6">
                    当前第 ${articleMsgs.pageNum} 页.总共 ${articleMsgs.pages} 页.一共 ${articleMsgs.total} 条记录
                </div>

                <!--点击分页-->
                <div class="col-md-6">
                    <nav aria-label="Page navigation">
                        <ul class="pagination">
                            <!--首页-->
                            <li><a href="#" onclick="searchArticle(1)">首页</a></li>
                            <!--上一页-->
                            <li>
                                <c:if test="${articleMsgs.hasPreviousPage}">
                                    <a href="#" onclick="searchArticle('${articleMsgs.pageNum-1}')"
                                       aria-label="Previous">
                                        <span aria-hidden="true">«</span>
                                    </a>
                                </c:if>
                            </li>

                            <c:forEach items="${articleMsgs.navigatepageNums}" var="page_num">
                                <c:if test="${page_num == articleMsgs.pageNum}">
                                    <li class="active"><a href="#">${page_num}</a></li>
                                </c:if>
                                <c:if test="${page_num != articleMsgs.pageNum}">
                                    <li><a href="#" onclick="searchArticle('${page_num}')">${page_num}</a></li>
                                </c:if>
                            </c:forEach>

                            <!--下一页-->
                            <li>
                                <c:if test="${articleMsgs.hasNextPage}">
                                    <a href="javascript:void(0)" onclick="searchArticle('${articleMsgs.pageNum+1}')"
                                       aria-label="Next">
                                        <span aria-hidden="true">»</span>
                                    </a>
                                </c:if>
                            </li>
                            <li><a href="javascript:void(0)" onclick="searchArticle('${articleMsgs.pages}')">尾页</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div><!-- /.dept_info -->
        <!-- 尾部-->
        <%@ include file="/jsp/common/foot.jsp" %>
    </div><!-- /.hrms_dept_body -->

</div><!-- /.hrms_dept_container -->
<script>
    function contextBut(articleId) {
        $.post("${pageContext.request.contextPath}/report/findArticleContent.do", {"articleId": articleId}, function (date) {


            var content = date['content'];

            $("#contentSpan").text(content);
        }, "json")

    }
</script>

</body>
</html>
