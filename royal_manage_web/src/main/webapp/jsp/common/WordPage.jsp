<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>敏感词汇管理</title>

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
    <%@ include file="head.jsp" %>


    <!-- 中间部分（左侧栏+表格内容） -->
    <div class="hrms_dept_body">
        <!-- 左侧栏 -->
        <%@ include file="leftsidebar.jsp" %>

        <!-- 表格内容 -->
        <div class="dept_info col-sm-10">
            <div class="panel panel-success">
                <!-- 路径导航 -->
                <div>
                    <ol class="breadcrumb">
                        <li><a href="#">用户帖管理</a></li>
                        <li class="active">敏感词汇管理信息</li>
                    </ol>
                </div>
                <hr>
                <!-- Table -->
                <div>
                    <div style="float: left">
                        <form method="post" action="${pageContext.request.contextPath}/word/findAll.do"
                              id="articleSearchForm">
                            <table>
                                <tr>
                                    <th colspan="2">
                                        <button type="button" class="btn btn-default" title="新增敏感词汇"
                                                onclick="location.href='${pageContext.request.contextPath}/jsp/common/WordPage-add.jsp'">
                                            <i class="fa fa-file-o"></i> 新增敏感词汇
                                        </button>
                                    </th>
                                </tr>
                            </table>

                        </form>
                    </div>
                </div>
                <div style="clear:both"></div>
                <hr>
                <table class="table table-bordered table-hover">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>敏感词</th>
                        <th>是否启用</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${pageInfo.list}" var="word">
                        <tr>
                            <td width="15%" class="line-limit-length">${word.wordId}</td>
                            <td width="5%" class="line-limit-length">${word.word}</td>
                            <td width="5%" class="line-limit-length">${word.status}</td>
                            <td width="15%">
                                <c:if test="${word.status==0}">
                                    <a href="${pageContext.request.contextPath}/word/changeStatus.do?id=${word.wordId}&page=${pageInfo.pageNum}&size=${pageInfo.pageSize}&status=1"
                                       role="button" class="btn btn-danger" onclick="updateWordUtils()">启用</a>
                                </c:if>
                                <c:if test="${word.status==1}">
                                    <a href="${pageContext.request.contextPath}/word/changeStatus.do?id=${word.wordId}&page=${pageInfo.pageNum}&size=${pageInfo.pageSize}&status=0"
                                       role="button" class="btn btn-info" onclick="updateWordUtils()">停用</a>
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
                    当前第 ${pageInfo.pageNum} 页.总共 ${pageInfo.pages} 页.一共 ${pageInfo.total} 条记录
                </div>

                <!--点击分页-->
                <div class="col-md-6">
                    <nav aria-label="Page navigation">
                        <ul class="pagination">
                            <!--首页-->
                            <li>
                                <a href="${pageContext.request.contextPath}/word/findAll.do?page=1&size=${pageInfo.pageSize}"
                                   onclick="searchArticle(1)">首页</a></li>
                            <!--上一页-->
                            <li>
                                <c:if test="${pageInfo.hasPreviousPage}">
                                    <a href="${pageContext.request.contextPath}/word/findAll.do?page=${pageInfo.pageNum-1}&size=${pageInfo.pageSize}"
                                       onclick="searchArticle('${pageInfo.pageNum-1}')" aria-label="Previous">
                                        <span aria-hidden="true">«</span>
                                    </a>
                                </c:if>
                            </li>

                            <c:forEach items="${pageInfo.navigatepageNums}" var="page_num">
                                <c:if test="${page_num == pageInfo.pageNum}">
                                    <li class="active"><a
                                            href="${pageContext.request.contextPath}/word/findAll.do?page=${page_num}&size=${pageInfo.pageSize}">${page_num}</a>
                                    </li>
                                </c:if>
                                <c:if test="${page_num != pageInfo.pageNum}">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/word/findAll.do?page=${page_num}&size=${pageInfo.pageSize}"
                                           onclick="searchArticle('${page_num}')">${page_num}</a></li>
                                </c:if>
                            </c:forEach>

                            <!--下一页-->
                            <li>
                                <c:if test="${pageInfo.hasNextPage}">
                                    <a href="${pageContext.request.contextPath}/word/findAll.do?page=${pageInfo.pageNum+1}&size=${pageInfo.pageSize}"
                                       onclick="searchArticle('${pageInfo.pageNum+1}')"
                                       aria-label="Next">
                                        <span aria-hidden="true">»</span>
                                    </a>
                                </c:if>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/word/findAll.do?page=${pageInfo.pages}&size=${pageInfo.pageSize}"
                                   onclick="searchArticle('${pageInfo.pages}')">尾页</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div><!-- /.dept_info -->
        <!-- 尾部-->
        <%@ include file="foot.jsp" %>
    </div><!-- /.hrms_dept_body -->

</div><!-- /.hrms_dept_container -->

<%--<%@ include file="ArticleAdd.jsp"%>--%>
<%@ include file="ArticleUpdate.jsp" %>

<script>
    function updateWordUtils() {
        $.post("http://localhost:8081/word/updateWordUtils.do", function (date) {
            alert(date['message'])
        }, "json")
    }
</script>


</body>
</html>
