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
<<<<<<< HEAD:royal_manage_web/src/main/webapp/jsp/common/ArticlePage.jsp
    <%@ include file="head.jsp"%>
=======
    <%@ include file="../../jsp/commom/head.jsp" %>
>>>>>>> origin/dev2.0:royal_manage_web/src/main/webapp/WEB-INF/jsp/ArticlePage.jsp


    <!-- 中间部分（左侧栏+表格内容） -->
    <div class="hrms_dept_body">
        <!-- 左侧栏 -->
<<<<<<< HEAD:royal_manage_web/src/main/webapp/jsp/common/ArticlePage.jsp
        <%@ include file="leftsidebar.jsp"%>
=======
        <%@ include file="../../jsp/commom/leftsidebar.jsp" %>
>>>>>>> origin/dev2.0:royal_manage_web/src/main/webapp/WEB-INF/jsp/ArticlePage.jsp

        <!-- 表格内容 -->
        <div class="dept_info col-sm-10">
            <div class="panel panel-success">
                <!-- 路径导航 -->
                <div>
                    <ol class="breadcrumb">
                        <li><a href="#">用户帖管理</a></li>
                        <li class="active">帖子信息</li>
                    </ol>
                </div>
                <hr>
                <!-- Table -->
                <div>
                    <div style="float: left">
                        <form method="post" action="${pageContext.request.contextPath}/article/findByTitleOrSenderName.do" id="articleSearchForm">
                            <table>
                                <tr>
                                    <th>
                                        <label for="title" class="control-label">标题:</label>
                                    </th>
                                    <th>
                                        <input type="text" id="title" class="form-control"
                                               name="title" value="${title}">
                                        <input type="hidden" id="pageNum" name="pn" value="">
                                    </th>
                                    <th>
                                        <label for="article_sendername" class="control-label">创帖人:</label>
                                    </th>
                                    <th>
                                        <input type="text" id="article_sendername" class="form-control"
                                               name="sendername" value="${senderName}">
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
                        <th>标题</th>
                        <th>内容</th>
                        <th>发送时间</th>
                        <th>创帖人</th>
                        <th>是否置顶</th>
                        <th>回复数</th>
                        <th>点赞数</th>
                        <th>浏览数</th>
                        <th>所在交流区</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
<<<<<<< HEAD:royal_manage_web/src/main/webapp/jsp/common/ArticlePage.jsp
                    <c:forEach items="${pageInfo.list}" var="article">
                        <tr>
                            <td width="15%" class="line-limit-length">${article.title}</td>
                            <td width="5%" class="line-limit-length">${article.content}</td>
                            <td width="5%" class="line-limit-length">${article.sendTime}</td>
                            <td width="5%" class="line-limit-length">${article.senderName}</td>
                            <td width="5%" class="line-limit-length">${article.isTop}</td>
                            <td width="5%" class="line-limit-length">${article.replyCount}</td>
                            <td width="5%" class="line-limit-length">${article.upvoteCount}</td>
                            <td width="5%" class="line-limit-length">${article.browseCount}</td>
                            <td width="5%" class="line-limit-length">${article.zoneId}</td>
                            <td width="5%" class="line-limit-length">${article.isReport}</td>

                            <td width="15%">
                                <a href="/article/deleteArticle.do?id=${article.articleId}&pn=${articleMsgs.pageNum}&title=${articleSearch.title}&sendername=${articleSearch.sendername}"
                                   role="button" class="btn btn-primary">屏蔽</a>
                                <c:if test="${article.isTop==0}">
                                    <a href="/article/changeStatus.do?id=${article.articleId}&pn=${articleMsgs.pageNum}&title=${articleSearch.title}&sendername=${articleSearch.sendername}"
                                       role="button" class="btn btn-danger">置顶</a>
                                </c:if>
                                <c:if test="${article.isTop==1}">
                                    <a href="/article/changeStatus.do?id=${article.articleId}&pn=${articleMsgs.pageNum}&title=${articleSearch.title}&sendername=${articleSearch.sendername}"
                                       role="button" class="btn btn-info">取消</a>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
=======

                    <tr>
                        <td width="15%">标题</td>
                        <td width="30%" class="line-limit-length">

                        </td>
                        <td width="5%" class="line-limit-length">${article.sendername}</td>
                        <td width="5%" class="line-limit-length">

                        </td>
                        <td width="5%">

                        </td>
                        <td width="5%">

                        </td>
                        <td width="5%">

                        </td>
                        <td width="15%">

                        </td>
                        <td width="15%">
                            <a href="/article/deleteArticle.do?id=${article.articleid}&pn=${articleMsgs.pageNum}&title=${articleSearch.title}&sendername=${articleSearch.sendername}"
                               role="button" class="btn btn-primary">屏蔽</a>
                            <c:if test="${article.istop==0}">
                                <a href="/article/changeStatus.do?id=${article.articleid}&pn=${articleMsgs.pageNum}&title=${articleSearch.title}&sendername=${articleSearch.sendername}"
                                   role="button" class="btn btn-danger">置顶</a>
                            </c:if>
                            <c:if test="${article.istop==1}">
                                <a href="/article/changeStatus.do?id=${article.articleid}&pn=${articleMsgs.pageNum}&title=${articleSearch.title}&sendername=${articleSearch.sendername}"
                                   role="button" class="btn btn-info">取消</a>
                            </c:if>
                        </td>
                    </tr>
>>>>>>> origin/dev2.0:royal_manage_web/src/main/webapp/WEB-INF/jsp/ArticlePage.jsp
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
                            <li><a href="${pageContext.request.contextPath}/article/findByPage.do?page=1&size=${pageInfo.pageSize}" onclick="searchArticle(1)">首页</a></li>
                            <!--上一页-->
                            <li>
<<<<<<< HEAD:royal_manage_web/src/main/webapp/jsp/common/ArticlePage.jsp
                                <c:if test="${pageInfo.hasPreviousPage}">
                                        <a href="${pageContext.request.contextPath}/article/findByPage.do?page=${pageInfo.pageNum-1}&size=${pageInfo.pageSize}" onclick="searchArticle('${pageInfo.pageNum-1}')" aria-label="Previous">
                                            <span aria-hidden="true">«</span>
                                        </a>
=======
                                <c:if test="${articleMsgs.hasPreviousPage}">
                                    <a href="#" onclick="searchArticle('${articleMsgs.pageNum-1}')"
                                       aria-label="Previous">
                                        <span aria-hidden="true">«</span>
                                    </a>
>>>>>>> origin/dev2.0:royal_manage_web/src/main/webapp/WEB-INF/jsp/ArticlePage.jsp
                                </c:if>
                            </li>

                            <c:forEach items="${pageInfo.navigatepageNums}" var="page_num">
                                <c:if test="${page_num == pageInfo.pageNum}">
                                    <li class="active"><a href="${pageContext.request.contextPath}/article/findByPage.do?page=${page_num}&size=${pageInfo.pageSize}">${page_num}</a></li>
                                </c:if>
                                <c:if test="${page_num != pageInfo.pageNum}">
                                    <li><a href="${pageContext.request.contextPath}/article/findByPage.do?page=${page_num}&size=${pageInfo.pageSize}" onclick="searchArticle('${page_num}')">${page_num}</a></li>
                                </c:if>
                            </c:forEach>

                            <!--下一页-->
                            <li>
                                <c:if test="${pageInfo.hasNextPage}">
                                    <a href="${pageContext.request.contextPath}/article/findByPage.do?page=${pageInfo.pageNum+1}&size=${pageInfo.pageSize}" onclick="searchArticle('${pageInfo.pageNum+1}')"
                                       aria-label="Next">
                                        <span aria-hidden="true">»</span>
                                    </a>
                                </c:if>
                            </li>
                            <li><a href="${pageContext.request.contextPath}/article/findByPage.do?page=${pageInfo.pages}&size=${pageInfo.pageSize}" onclick="searchArticle('${pageInfo.pages}')">尾页</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div><!-- /.dept_info -->
        <!-- 尾部-->
<<<<<<< HEAD:royal_manage_web/src/main/webapp/jsp/common/ArticlePage.jsp
        <%@ include file="foot.jsp"%>
=======
        <%@ include file="../../jsp/commom/foot.jsp" %>
>>>>>>> origin/dev2.0:royal_manage_web/src/main/webapp/WEB-INF/jsp/ArticlePage.jsp
    </div><!-- /.hrms_dept_body -->

</div><!-- /.hrms_dept_container -->

<%--<%@ include file="ArticleAdd.jsp"%>--%>
<%@ include file="ArticleUpdate.jsp" %>
</body>
</html>
