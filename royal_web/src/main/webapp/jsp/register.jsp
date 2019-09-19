<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>王者荣耀论坛注册页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common-new.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/search.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
</head>
<body>


<!-- 头部 -->
<jsp:include page="common/header.jsp"/>


<div class="hm-header">
    <div class="hm-inner clearfix">
        <div class="hm-header-t clearfix">
            <h1 class="logo l">
                <a href="javascript:;"><img src="../images/logo.png" height="64" width="168" alt=""/></a>
            </h1>
        </div>
        <div class="hm-header-b">
            <i class="hm-ico-home"></i>
            <a href="${pageContext.request.contextPath}/jsp/index.jsp">首页</a><span>></span>注册页面
        </div>
    </div>
</div>


<div class="hm-body hm-body-bgc">
    <div class="hm-inner">
        <div class="reg-box">
            <h2>用户注册<span>（红色型号代表必填）</span></h2>
            <div class="reg-info">
                <form action="${pageContext.request.contextPath}/user/save.do" method="post">
                    <ul>
                        <li>
                            <div class="reg-l">
                                <span class="red">*</span> 用户名：
                            </div>
                            <div class="reg-c">
                                <input type="text" id="username" name="userName" class="txt" onblur="checkName()"/>
                                <span id="userName_message"></span>
                            </div>
                            <span class="tips">用户名必须是由英文、数字、下划线组成</span>
                        </li>
                        <li>
                            <div class="reg-l">
                                <span class="red">*</span> 密&nbsp;&nbsp;&nbsp;码：
                            </div>
                            <div class="reg-c">
                                <input type="password" id="mima" name="userPass" class="txt" value=""
                                       onblur="checkMima()"/>
                                <span id="userPass_message"></span>
                            </div>
                            <span class="tips">密码长度必须6~10位的英文或数字</span>
                        </li>
                        <li class="no-tips">
                            <div class="reg-l">&nbsp;&nbsp;邮&nbsp;&nbsp;&nbsp;箱：</div>
                            <div class="reg-c">
                                <input type="text" id="email" name="email" class="txt" value=""/>
                            </div>
                        </li>
                        <li>
                            <div class="reg-l"></div>
                            <div class="reg-c">
                                <input type="hidden" id="zhuce" class="submit-btn" value="注册"/><br/>
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
    var n = 0;
    var p = 0;


    //判断用户名是否可用
    function checkName() {
        //1.获取用户输入的内容
        var userName = $("#username").val();
        //2.定义正则表达式
        var tel1 = /^[a-zA-Z0-9_-]{3,16}$/;


        if (tel1.test(userName)) {

            $("#userName_message").html("<font color='green'>用户名格式正确</font>");

            //3.若内容不为空，发送ajax
            //3.1请求路径
            $.post("${pageContext.request.contextPath}/user/findByuserName.do",
                //3.2请求参数 方法名 和 用户输入的用户名
                {"userName": userName},
                //3.3回调函数
                function (date) {
                    //3.4判断回调函数
                    if (date != null) {
                        $("#userName_message").html("<font color='red'>该用户名已存在，请重新输入</font>");
                        $("#zhuce").prop("type", "hidden");
                        if (n == 1) {
                            n = 0;
                        }
                    } else {
                        if (n == 0) {
                            n = 1;
                        }

                        if (n + p == 2) {
                            $("#zhuce").prop("type", "submit");
                        }
                    }
                    //提示信息在前台做或者后台做都是一样的效果
                }, "json"
            )


        } else {
            if (n == 1) {
                n = 0;
            }
            //4.若用户输入的格式不对或为空，提示信息
            $("#userName_message").html("<font color='red'>格式错误</font>");
            $("#zhuce").prop("type", "hidden");
            return;

        }

        if (n + p == 2) {
            $("#zhuce").prop("type", "submit");
        }

    };

    function checkMima() {
        //定义密码正则表达式
        var mima = /^[a-zA-Z0-9_-]{6,10}$/;
        var mm = $("#mima").val();

        if (mima.test(mm)) {
            if (p == 0) {
                p = 1;
            }
            if (n + p == 2) {
                $("#zhuce").prop("type", "submit");
            }
            $("#userPass_message").html("<font color='green'>密码格式正确</font>");
        } else {
            if (p == 1) {
                p = 0;
            }
            $("#zhuce").prop("type", "hidden");
            $("#userPass_message").html("<font color='red'>你输入的密码格式不正确，请重新输入</font>");
            return;
        }

        if (n + p == 2) {
            $("#zhuce").prop("type", "submit");
        }
    }


</script>

</body>
</html>