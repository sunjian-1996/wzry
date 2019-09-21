<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理页面</title>

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
        <li><a href="#">用户管理</a></li>
        <li class="active">用户信息</li>
    </ol>
</div>
<hr>
<!-- Table -->
<div>
<div style="float: left">
<form method="post" id="userSearchForm"
action="${pageContext.request.contextPath}/user/SearchByUserAndRole.do?size=4&page=1">
<table>
<tr>
<th>
    <label for="title" class="control-label">用户:</label>
</th>
<th>
    <input type="text" id="title" class="form-control"
           name="userName" value="${condition.userName}"/>
    <input type="hidden" id="pageNum" name="pn" value=""/>
</th>
<th>
    <label for="article_sendername" class="control-label">用户组:</label>

</th>
<th>
<select id="article_sendername" class="form-control" name="role" value="${condition.role}">
<option value="0">-请选择-</option>
<option value="1" <c:if test="${condition.role==1}">selected</c:if>>普通用户</option>
    <option value="2" <c:if test="${condition.role==2}">selected</c:if>>高级用户</option>
        <option value="3" <c:if test="${condition.role==3}">selected</c:if>>超级管理员</option>
            </select>
            </th>
            <th colspan="2">
            <input type="submit" value="查询" class="form-control btn-primary" id="SearchByUserAndRoleBtn">
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
            <th>用户名</th>
            <th>用户组</th>
            <th>邮箱</th>
            <th>是否禁言</th>
            <th>最后登录时间</th>
            <th>操作</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${pageInfo.list}" var="article">
                <tr>

                    <td width="15%">${article.userName}</td>

                        <%--   <c:if test="${article.role==1}">
                               <td width="15%" class="line-limit-length">普通用户</td>
                           </c:if>
                           <c:if test="${article.role==2}">
                               <td width="15%" class="line-limit-length">高级用户</td>
                           </c:if>
                           <c:if test="${article.role==3}">
                               <td width="15%" class="line-limit-length">超级管理员</td>
                           </c:if>--%>
                    <td width="15%">${article.roleStr}</td>
                    <td width="15%" class="line-limit-length">${article.email}</td>
                    <td width="15%" class="line-limit-length">
                            ${article.talkStatusStr}
                    </td>
                    <td width="20%">
                            ${article.lastLoginTime}
                    </td>
                    <td width="20%">
                        <c:if test="${article.role==1}">
                            <a href="${pageContext.request.contextPath}/user/updateUser.do?userId=${article.userId}&role=2&page=${pageInfo.pageNum}"
                               role="button" class="btn btn-primary">升级</a>
                        </c:if>
                        <c:if test="${article.role==2}">
                            <a href="${pageContext.request.contextPath}/user/updateUser.do?userId=${article.userId}&role=2&page=${pageInfo.pageNum}"
                               role="button" class="btn btn-primary">升级</a>
                        </c:if>
                        <c:if test="${article.role==3}">
                            <a href="${pageContext.request.contextPath}/user/updateUser.do?userId=${article.userId}&role=3&page=${pageInfo.pageNum}"
                               role="button" class="btn btn-primary">升级</a>
                        </c:if>


                        <c:if test="${article.talkStatus==0}">
                            <a href="${pageContext.request.contextPath}/user/WordAndReply.do?userId=${article.userId}&talkStatus=1&page=${pageInfo.pageNum}"
                               role="button" class="btn btn-danger">禁言</a>
                        </c:if>
                        <c:if test="${article.talkStatus==1}">
                            <a href="${pageContext.request.contextPath}/user/WordAndReply.do?userId=${article.userId}&talkStatus=0&page=${pageInfo.pageNum}"
                               role="button" class="btn btn-info">恢复</a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
            </table>

            </div>
            <!-- /.panel panel-success -->
            <!--显示分页信息-->
            <div class="row">
            <!--文字信息-->
            <div class="col-md-6">
            当前第${pageInfo.pageNum}页.总共${pageInfo.pages}页.一共${pageInfo.total}条记录
            </div>

            <!--点击分页-->
            <div class="col-md-6">
            <nav aria-label="Page navigation">
            <ul class="pagination">
            <!--首页-->
            <li><a href="${pageContext.request.contextPath}/user/SearchByUserAndRole.do?page=1&size=${pageInfo.pageSize}&userName=${condition.userName}&role=${condition.role}" >首页</a></li>
            <!--上一页-->
            <li>
            <c:if test="${pageInfo.hasPreviousPage}">
                <a href="${pageContext.request.contextPath}/user/SearchByUserAndRole.do?page=${pageInfo.pageNum-1}&size=${pageInfo.pageSize}&userName=${condition.userName}&role=${condition.role}"
                   aria-label="Previous">
                    <span aria-hidden="true">«</span>
                </a>
            </c:if>
            </li>

            <c:forEach begin="1" end="${pageInfo.pages}" var="pageNum">
                <li>
                    <a href="${pageContext.request.contextPath}/user/SearchByUserAndRole.do?page=${pageNum}&size=${pageInfo.pageSize}&userName=${condition.userName}&role=${condition.role}">${pageNum}</a>
                </li>
            </c:forEach>

            <!--下一页-->
            <li>
            <c:if test="${pageInfo.hasNextPage}">
                <a href="${pageContext.request.contextPath}/user/SearchByUserAndRole.do?page=${pageInfo.pageNum+1}&size=${pageInfo.pageSize}&userName=${condition.userName}&role=${condition.role}"
                   aria-label="Next">
                    <span aria-hidden="true">»</span>
                </a>
            </c:if>
            </li>
            <li><a href="${pageContext.request.contextPath}/user/SearchByUserAndRole.do?page=${pageInfo.pages}&size=${pageInfo.pageSize}&userName=${condition.userName}&role=${condition.role}" >尾页</a></li>
            </ul>
            </nav>
            </div>
            </div>
            </div><!-- /.dept_info -->
            <!-- 尾部-->
            <%@ include file="foot.jsp" %>
            </div><!-- /.hrms_dept_body -->

            </div><!-- /.hrms_dept_container -->
            <%--<%@ include file="ArticleUpdate.jsp"%>
            <%@ include file="ArticleAdd.jsp"%>--%>
            </body>
            </html>
