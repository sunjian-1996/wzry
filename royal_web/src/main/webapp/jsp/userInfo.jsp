<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        .hm-header-b {
            border-bottom: 1px solid #d9d9d9;
        }
    </style>
</head>
<body>


<!-- 头部 -->
<jsp:include page="common/header.jsp"/>


<!--头部信息-->
<div class="hm-header">
    <div class="hm-inner clearfix">
        <div class="hm-header-t clearfix">
            <h1 class="logo l">
                <a href="javascript:;"><img src="images/logo.png" height="64" width="168" alt=""/></a>
            </h1>
            <div class="search-box l">
                <img src="/jsp/upload/images/f9c286bcff024c0499a0c6f719f28a02_logo.png">
            </div>
        </div>
        <div class="hm-header-b">
            <i class="hm-ico-home"></i>
            <a href="${pageContext.request.contextPath}/jsp/index.jsp">首页</a><span>></span>个人信息
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
                    <c:if test="${loginUser.role == 1}">
                    <li><i class="safe-icon"></i>申请高级用户</li>
                    </c:if>
                    <c:if test="${loginUser.role == 2}">
                        <li><i class="safe-icon"></i>开启新板块</li>
                    </c:if>

                </ul>
            </div>


            <!--右侧用户信息-->
            <div class="user-info-r r">
                <ul class="clearfix hd">
                    <li class="cur"><a href="/jsp/userInfo.jsp">个人信息</a></li>
                    <li><a href="/jsp/userPwd.jsp">修改密码</a></li>
                    <c:if test="${loginUser.role == 1}">
                        <li><a href="/jsp/userInfoGj.jsp">申请高级用户</a></li>
                    </c:if>
                    <c:if test="${loginUser.role == 2}">
                        <li><a href="/jsp/addZone.jsp">开辟新板块</a></li>
                    </c:if>
                </ul>


                <form action="${pageContext.request.contextPath}/userInfo/update.do" method="post"
                      enctype="multipart/form-data">
                    <input type="hidden" id="picUrl" name="picUrl" value="">
                    <ul class="bd">
                        <li class="clearfix">
                            <div class="info-l"><i class="red">*</i>用户名：</div>
                            <div class="info-r"><input type="text" name="userName" class="txt"
                                                       value="${loginUser.userName}" readonly="readonly"/></div>
                        </li>
                        <li class="clearfix">
                            <div class="info-l">邮箱地址：</div>
                            <div class="info-r"><input type="text" name="email" class="txt" value="${loginUser.email}"/>
                            </div>
                        </li>
                        <li class="clearfix">
                            <div class="info-l">上传头像：</div>
                            <div class="info-r"><input type="file" name="file" class="file-btn"/></div>
                        </li>
                        <li class="clearfix">
                            <div class="info-l"></div>
                            <div class="info-r">
                                <input type="submit" class="btn" value="保存"/>
                                <span style="color:red;">${msggs}</span>
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
            type: "get",
            url: "${pageContext.request.contextPath}/userInfo/findPic.do",
            dataType: "text",
            success: function (data) {
                $("#pic").prop("src", data);
                $("#picUrl").val(data);
            }
        })
        $.ajax({
            type: "get",
            url: "${pageContext.request.contextPath}/userInfo/SChu.do",
            dataType: "text",
            success: function (data) {

            }
        })
    })
</script>


</body>
</html>