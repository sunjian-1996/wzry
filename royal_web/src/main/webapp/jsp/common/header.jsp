<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户登录</title>
</head>
<body>
<div class="hm-top-nav">
    <div class="hm-inner clearfix">
        <div class="hm-inner-l l"></div>
        <div class="hm-inner-r r">

            <div class="box">
                <c:if test="${msg!=null}">
                    <script language='JavaScript'>alert('您的账号或密码输入错误！')</script>
                </c:if>
                <c:if test="${loginUser==null||empty loginUser}">
                    <a href="javascript:void(0);" id="login" class="to-login">游客登录</a>
                </c:if>

                <c:if test="${loginUser!=null||not empty loginUser}">
                    <%--多余的一步--%>
                    <c:if test="${loginUser.role == 1}">
                        <a href="javascript:void(0);">欢迎普通用户${loginUser.userName}</a>
                        <a href="/jsp/userInfo.jsp">个人中心</a>
                        <a href="${pageContext.request.contextPath}/user/logout.do">注销</a>
                    </c:if>
                    <c:if test="${loginUser.role == 2}">
                        <a href="javascript:void(0);" >高级用户${loginUser.userName}</a>
                    </c:if>
                    <c:if test="${loginUser.role == 3}">
                        <a href="javascript:void(0);">超级管理员${loginUser.userName}</a>
                    </c:if>
                </c:if>


                <a href="/jsp/register.jsp">【新用户注册】</a>
                <div id="dialogBg"></div>
                <div id="dialog" class="animated">
                    <img class="dialogIco" width="50" height="40" src="../../images/ico.png"/>
                    <div class="dialogTop" style="height:25px;">
                        <a href="javascript:;" class="closeDialogBtn">关闭</a>
                    </div>
                    <form action="${pageContext.request.contextPath}/user/login.do" method="post">
                        <ul class="editInfos">
                            <li>用户名：<input type="text" id="userName" name="userName" class="ipt"/></li>
                            <li>密&nbsp;&nbsp;&nbsp;码：<input type="password" id="userPass" name="userPass" class="ipt"/>
                            </li>
                            <li><input type="submit" value="登录" class="submitBtn"/></li>

                        </ul>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    $(function () {
        //显示弹框
        $('.box #login').click(function () {
            var className = $(this).attr('class');
            $('#dialogBg').fadeIn(300);
            $('#dialog').removeAttr('class').addClass('animated ' + className + '').fadeIn();
            $('#userName').focus();
            $("#j_fixedBar").hide();
        });

        //关闭弹窗
        $('.closeDialogBtn').click(function () {
            $('#dialogBg').fadeOut(300, function () {
                $('#dialog').addClass('bounceOutUp').fadeOut();
                $("#j_fixedBar").show();
            });
        });
    });
</script>
</html>