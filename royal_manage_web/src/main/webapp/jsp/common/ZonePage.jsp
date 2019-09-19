<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>帖信息管理页面</title>

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
    <%@ include file="head.jsp"%>


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
                        <li><a href="${pageContext.request.contextPath}/jsp/common/main.jsp">用户管理</a></li>
                        <li class="active">版块管理</li>
                    </ol>
                </div>
                <hr>
                <!-- Table -->
                <div>
                    <div style="float: left">
                        <form method="post" action="${pageContext.request.contextPath}/zoneApply/findByPage.do" id="articleSearchForm">
                            <table>
                                <tr>
                                    <th>
                                        <label for="zone" class="control-label">版块名:</label>
                                    </th>
                                    <th>
                                        <input type="text" id="zone" class="form-control"
                                               name="zone" value="${zone}">
                                        <input type="hidden" id="pageNum" name="pn" value="">
                                    </th>
                                    <th>
                                        <label for="senderName" class="control-label">申请人:</label>
                                    </th>
                                    <th>
                                        <input type="text" id="senderName" class="form-control"
                                               name="senderName" value="${senderName}">
                                    </th>
                                    <th colspan="2">
                                        <input type="submit" value="查询" class="form-control btn-primary">
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
                        <th>版块名</th>
                        <th>申请理由</th>
                        <th>申请人</th>
                        <th>是否同意</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${pageInfo.list}" var="ze">
                        <tr>
                            <td width="5%" class="line-limit-length">${ze.zoneName}</td>
                            <td width="15%" class="line-limit-length">${ze.reason}</td>
                            <td width="5%" class="line-limit-length">${ze.userName}</td>
                            <td width="15%">
                                    <a href="${pageContext.request.contextPath}/zoneApply/changeStatus1.do?page=${pageInfo.pageNum}&size=${pageInfo.pageSize}&zone=${zone}&senderName=${senderName}&applyZoneId=${ze.applyZoneId}&zoneName=${ze.zoneName}"
                                       role="button" class="btn btn-info">同意</a>
                                    <a href="${pageContext.request.contextPath}/zoneApply/changeStatus2.do?page=${pageInfo.pageNum}&size=${pageInfo.pageSize}&zone=${zone}&senderName=${senderName}&applyZoneId=${ze.applyZoneId}"
                                       role="button" class="btn btn-danger">驳回</a>
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
                            <li><a href="${pageContext.request.contextPath}/zoneApply/findByPage.do?page=1&size=${pageInfo.pageSize}" onclick="searchArticle(1)">首页</a></li>
                            <!--上一页-->
                            <li>
                                <c:if test="${pageInfo.hasPreviousPage}">
                                        <a href="${pageContext.request.contextPath}/zoneApply/findByPage.do?page=${pageInfo.pageNum-1}&size=${pageInfo.pageSize}" onclick="searchArticle('${pageInfo.pageNum-1}')" aria-label="Previous">
                                            <span aria-hidden="true">«</span>
                                        </a>
                                </c:if>
                            </li>

                            <%--<c:forEach items="${pageInfo.navigatepageNums}" var="page_num">--%>
                                <%--<c:if test="${page_num == pageInfo.pageNum}">--%>
                                    <%--<li class="active"><a href="${pageContext.request.contextPath}/zoneApply/findByPage.do?page=${page_num}&size=${pageInfo.pageSize}">${page_num}</a></li>--%>
                                <%--</c:if>--%>
                                <%--<c:if test="${page_num != pageInfo.pageNum}">--%>
                                    <%--<li><a href="${pageContext.request.contextPath}/zoneApply/findByPage.do?page=${page_num}&size=${pageInfo.pageSize}" onclick="searchArticle('${page_num}')">${page_num}</a></li>--%>
                                <%--</c:if>--%>
                            <%--</c:forEach>--%>
                            <c:forEach begin="1" end="${pageInfo.pages}" var="cpage">
                                <c:if test="${cpage==pageInfo.pageNum}">
                                    <li class="active"><a href="${pageContext.request.contextPath}/zoneApply/findByPage.do?page=${cpage}&size=${pageInfo.pageSize}">${cpage}</a></li>
                                </c:if>
                                <c:if test="${cpage!=pageInfo.pageNum}">
                                    <li><a href="${pageContext.request.contextPath}/zoneApply/findByPage.do?page=${cpage}&size=${pageInfo.pageSize}">${cpage}</a></li>
                                </c:if>
                            </c:forEach>

                            <!--下一页-->
                            <li>
                                <c:if test="${pageInfo.hasNextPage}">
                                    <a href="${pageContext.request.contextPath}/zoneApply/findByPage.do?page=${pageInfo.pageNum+1}&size=${pageInfo.pageSize}" onclick="searchArticle('${pageInfo.pageNum+1}')"
                                       aria-label="Next">
                                        <span aria-hidden="true">»</span>
                                    </a>
                                </c:if>
                            </li>
                            <li><a href="${pageContext.request.contextPath}/zoneApply/findByPage.do?page=${pageInfo.pages}&size=${pageInfo.pageSize}" onclick="searchArticle('${pageInfo.pages}')">尾页</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div><!-- /.dept_info -->
        <!-- 尾部-->
        <%@ include file="foot.jsp"%>
    </div><!-- /.hrms_dept_body -->

</div><!-- /.hrms_dept_container -->

<%--<%@ include file="ArticleAdd.jsp"%>--%>
<%@ include file="ArticleUpdate.jsp" %>
</body>
</html>
