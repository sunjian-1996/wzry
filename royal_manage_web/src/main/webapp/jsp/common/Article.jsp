<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>帖信息管理页面</title>

</head>
<style type="text/css">
    html,body{
        overflow:auto;
        height:100%;
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
    <%@ include file="/jsp/common/head.jsp"%>


    <!-- 中间部分（左侧栏+表格内容） -->
    <div class="hrms_dept_body">
        <!-- 左侧栏 -->
        <%@ include file="/jsp/common/leftsidebar.jsp"%>

        <!-- 表格内容 -->
        <div class="dept_info col-sm-10">
            <div class="panel panel-success">
                <!-- 路径导航 -->
                <div >
                    <ol class="breadcrumb">
                        <li><a href="#">用户帖管理</a></li>
                        <li class="active">帖子信息</li>
                    </ol>
                </div>




                <table class="table table-bordered table-hover">
                    <thead>
                    <tr>
                        <th>标题</th>
                        <th>内容</th>
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
                    <c:forEach items="${all}" var="article">
                            <tr>

                                <td width="15%">${article.title}</td>

                                <td width="30%" class="line-limit-length">
                                        ${article.content}
                                </td>
                                <td width="5%" class="line-limit-length">${article.senderName}</td>
                                <td width="5%" class="line-limit-length">
                                    <c:if test="${article.isTop==0}">
                                        否
                                    </c:if>
                                    <c:if test="${article.isTop==1}">
                                        是
                                    </c:if>
                                </td>
                                <td width="5%">
                                        ${article.replyCount}
                                </td>
                                <td width="5%">
                                        ${article.upvoteCount}
                                </td>
                                <td width="5%">
                                        ${article.browseCount}
                                </td>
                                <td width="15%">
                                        ${article.zoneId}
                                </td>
                                <td width="15%">
                                    <c:if test="${article.articleStatus==0}">
                                    <a href="/article/deleteArticle.do?articleId=${article.articleId}&articleStatus=1" role="button" class="btn btn-primary">屏蔽</a>
                                    </c:if>
                                    <c:if test="${article.articleStatus==1}">
                                        <a href="/article/deleteArticle.do?articleId=${article.articleId}&articleStatus=0" role="button" class="btn btn-danger">取消</a>
                                    </c:if>
                                    <c:if test="${article.isTop==0}">
                                        <a href="/article/changeStatus.do?articleId=${article.articleId}&isTop=1" role="button" class="btn btn-danger" >置顶</a>
                                    </c:if>
                                    <c:if test="${article.isTop==1}">
                                        <a href="/article/changeStatus.do?articleId=${article.articleId}&isTop=0" role="button" class="btn btn-info" >取消</a>
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
                                        <a href="#" onclick="searchArticle('${articleMsgs.pageNum-1}')" aria-label="Previous">
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
        <%@ include file="/jsp/common/foot.jsp"%>
    </div><!-- /.hrms_dept_body -->

</div><!-- /.hrms_dept_container -->


</body>
</html>
