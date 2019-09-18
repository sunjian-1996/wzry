<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>黑马程序员论坛首页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common-new.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/user_info.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/search.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/hm-bbs.js"></script>
    <style type="text/css">
        .hm-header-b { border-bottom: 1px solid #d9d9d9; }
    </style>
</head>
<body>


<!-- 头部 -->
<jsp:include page="common/header.jsp" />



<!--头部信息-->
<div class="hm-header">
    <div class="hm-inner clearfix">
        <div class="hm-header-t clearfix">
            <h1 class="logo l">
                <a href="javascript:;"><img src="images/logo.png" height="64" width="168" alt=""/></a>
            </h1>
            <div class="search-box l">
                <form action="javascript:;">
                    <input type="text" class="txt l" placeholder="请输入关键字">
                    <input type="button" value="搜索" class="btn l"/>
                </form>
            </div>
        </div>
        <div class="hm-header-b">
            <i class="hm-ico-home"></i>
            <a href="index.do">首页</a><span>></span>个人信息
        </div>
    </div>
</div>



<div class="hm-body hm-body-bgc">
    <div class="hm-inner">
        <div class="user-info clearfix">
            <div class="user-info-t" style="height:20px;"></div>

            <!--左侧用户名，头像-->
            <div class="user-info-l l">
                <div class="user-info-l-t">
                    <img id="pic" src=""/>
                    <div class="username">${loginUser.userName}</div>
                </div>
                <ul class="user-info-l-b">
                    <li class="cur"><i class="info-icon"></i>我的资料</li>
                    <li><i class="safe-icon"></i>修改密码</li>
                </ul>
            </div>


            <!--右侧用户信息-->
            <div class="user-info-r r">
                <ul class="clearfix hd">
                    <li><a href="/jsp/userInfo.jsp">个人信息</a></li>
                    <%--id="login" class="to-login"--%>
                    <li><a href="/jsp/userPwd.jsp">修改密码</a></li>
                    <c:if test="${loginUser.role == 1}">
                        <li class="cur"><a href="/jsp/userInfoGj.jsp">申请高级用户</a></li>
                    </c:if>
                    <c:if test="${loginUser.role == 2}">
                        <li class="cur"><a href="/jsp/addZone.jsp">开辟新板块</a></li>
                    </c:if>
                </ul>


                <form action="${pageContext.request.contextPath}/userInfo/updateToPass.do" method="post" enctype="multipart/form-data">
                    <ul class="bd">


                            <li class="clearfix"  style="left: 100px;">
                                <i class="red">高级特权：</i>开辟新板块
                            </li>


                            <li class="clearfix" style="left: 100px;">
                                <i class="red">申请条件：</i>发帖数≥5
                            </li>



                            <li class="clearfix" style="left: 100px;">
                                <i class="red">当前发帖数：</i>0
                            </li>


                        <li class="clearfix">
                            <div class="info-l"></div>
                            <div class="info-r">
                                <input type="submit" class="btn" value="申请"/>
                                <span style="color:red;">${msgg}</span>
                            </div>
                        </li>

                    </ul>
                </form>


            </div>


        </div>
    </div>
</div>


<!-- 底部 -->
<jsp:include page="common/footer.jsp"/>

<script>
    $(function () {
        $.ajax({
            type:"get",
            url:"${pageContext.request.contextPath}/userInfo/findPic.do",
            dataType:"text",
            success:function (data) {
                $("#pic").prop("src",data);
            }
        })

    })
</script>



</body>
</html>