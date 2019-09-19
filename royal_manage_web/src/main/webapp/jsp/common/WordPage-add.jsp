<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>敏感词汇管理</title>

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
    <%@ include file="head.jsp"%>


    <!-- 中间部分（左侧栏+表格内容） -->
    <div class="hrms_dept_body">
        <!-- 左侧栏 -->
        <%@ include file="leftsidebar.jsp"%>
        <!-- 内容区域 -->
        <div class="content-wrapper">

            <!-- 内容头部 -->
            <section class="content-header">
                <h1>
                    敏感词管理 <small>敏感词表单</small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="${pageContext.request.contextPath}/jsp/common/main.jsp"><i
                            class="fa fa-dashboard"></i> 用户贴管理</a></li>
                    <li><a href="${pageContext.request.contextPath}/word/findAll.do">敏感词管理</a></li>
                    <li class="active">敏感词表单</li>
                </ol>
            </section>
            <!-- 内容头部 /-->

            <form action="${pageContext.request.contextPath}/word/save.do"
                  method="post">
                <!-- 正文区域 -->
                <section class="content"> <!--产品信息-->
                            <div class="col-md-2 title">敏感词</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="word"
                                       placeholder="" value="">
                            </div>
                            <div class="col-md-2 title">是否启用</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="roleDesc"
                                       placeholder="" value="">
                            </div>
                    <!--订单信息/--> <!--工具栏-->
                    <div class="box-tools text-center">
                        <button type="submit" class="btn bg-maroon">保存</button>
                        <button type="button" class="btn bg-default"
                                onclick="history.back(-1);">返回</button>
                    </div>
                    <!--工具栏/--> </section>
                <!-- 正文区域 /-->
            </form>
        </div>

        <!-- 尾部-->
        <%@ include file="foot.jsp"%>
    </div><!-- /.hrms_dept_body -->

</div><!-- /.hrms_dept_container -->

<%--<%@ include file="ArticleAdd.jsp"%>--%>
<%@ include file="ArticleUpdate.jsp"%>
</body>
</html>
