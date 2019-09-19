<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>王者荣耀论坛</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common-new.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/search.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index-new.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/hm-bbs.js"></script>

</head>
<body>

<!-- 头部 -->
<jsp:include page="common/header.jsp"/>


<!-- 主体部分 -->
<div class="hm-header"></div>
<div class="hm-body hm-body-bgc">
    <div class="hm-inner">
        <div class="hm-banner"></div>


        <!--头部，帖子统计，搜索-->
        <div class="hm-bbs-info">
            <div class="hm-bbs-icon l" style="width:130px;">
                <span><img src="${pageContext.request.contextPath}/images/bbs-icon.png" height="80"/></span>
            </div>
            <div class="hm-bbs-info-in l" style="margin-left:30px;">
                <div class="t clearfix"><h2 class="l">王者荣耀</h2></div>
                <p>
                    <span>今日帖子<strong></strong><span id="jinri" style="color: red;font-weight:550;"></span></span>
                    <span>全部帖子<strong></strong><span id="total" style="color: red;font-weight:550;"></span></span>
                </p>
            </div>
            <!--关键字搜索-->
            <div class="search-box l">
                <form id="keywordForm" action="#" method="post">
                    <input id="keyword" type="text" class="txt l" placeholder="请输入关键字">
                    <input id="kwbtn" type="button" value="搜索" class="btn l"/>
                </form>
            </div>
        </div>


        <!-- 导航 -->
        <ul class="hm-bbs-nav border-lrb clearfix" id="bbs_zone_table">
            <%--<li>--%>
            <%--<a href="javaScript:findAll(1)"><em></em>综合交流区</a>--%>
            <%--</li>--%>
            <%--<li>--%>
            <%--<a href="javaScript:findAll(2)"><em></em>BUG反馈区</a>--%>
            <%--</li>--%>
            <%--<li>--%>
            <%--<a href="javaScript:findAll(3)"><em></em>新闻公告区</a>--%>
            <%--</li>--%>
            <%--<li>--%>
            <%--<a href="javaScript:findAll(4)"><em></em>活动专区</a>--%>
            <%--</li>--%>


        </ul>


        <!-- 主体部分 -->
        <div class="hm-bbs-main border-lrb clearfix">
            <!-- 左侧列表 -->
            <div class="list-view l">
                <ul id="articleUl">

                    <%--<li class="clearfix ding">--%>
                    <%--<div class="hm-index-title">--%>
                    <%--<i class="set-to-top">顶</i> <a href="getArticle.do">求官方出艾琳英雄活动</a>--%>
                    <%--</div>--%>
                    <%--<div class="hm-index-con">本人玩得迟，所以看到别人用艾琳的时候，特别羡慕，现贵族6了，很想要一个艾琳，我身边很多朋友也想要，求</div>--%>
                    <%--<div class="hm-index-info l">--%>
                    <%--<span class="article-username">晨曦初露</span>--%>
                    <%--<span class="post-time">2017-05-24 08:00:05</span>--%>
                    <%--</div>--%>
                    <%--<div class="hm-index-fun r">--%>
                    <%--<span class="icon-like"><i></i>1</span>--%>
                    <%--<span class="icon-talk"><i></i>0</span>--%>
                    <%--</div>--%>
                    <%--</li>--%>
                    <%--<li class="clearfix ding"><div class="hm-index-title"><a href="">没有帖子，来一发吧！</a></div></div></li>--%>
                </ul>
            </div>


            <!-- 右侧侧边栏,在线用户 -->
            <div class="aside l">
                <div class="aside-box">
                    <h3 class="t">
                        <a href="${pageContext.request.contextPath}/jsp/index.jsp">在线用户(${userOnline.totalNum})</a>
                    </h3>
                    <ul class="b clearfix">
                        <c:forEach items="${userOnline.list}" var="Online">
                            <li>
                                <div><img src="${pageContext.request.contextPath}${Online.picUrl}" height="55"/></div>
                                <p>${Online.userName}</p>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>


<!-- 底部 -->
<jsp:include page="common/footer.jsp"/>

<c:if test="${empty loginUser.userName}">
    <div class="fixedBar" id="j_fixedBar">
        <a href="javaScript:inspect()" class="newTopic"><span></span>发帖</a>
        <a href="#" class="goTop"><i></i><span>返回<br/>顶部</span></a>
    </div>
</c:if>
<c:if test="${!empty loginUser.userName}">
    <!-- 右边发帖，回顶部 -->
    <div class="fixedBar" id="j_fixedBar">
        <a id="newTopicBtn" href="javaScript:;" class="newTopic"><span></span>发帖</a>
        <a href="#" class="goTop"><i></i><span>返回<br/>顶部</span></a>
    </div>
</c:if>
<!-- 发帖弹出框 -->
<form id="articleAddForm" action="${pageContext.request.contextPath}/article/publish.do" method="post">
    <div class="pop-box ft-box">
        <div class="mask"></div>
        <div class="win">
            <div class="win_hd">
                <h4 class="l">主题帖</h4><span class="close r">&times;</span>
            </div>
            <div class="win_bd">
                <div class="win_bd_t">
                    <input type="text" id="title" name="title" placeholder="帖子标题"/>
                </div>
                <div class="win_bd_b">
                    <textarea id="content" name="content" placeholder="正文"></textarea>
                </div>
            </div>
            <%--此处需要获取域中的用户名--%>
            <input type="hidden" name="senderName" value="${loginUser.userName}">
            <%--<input type="hidden" name="senderName" value="测试用户">--%>
            <%--需要获取当前版块的id--%>
            <input id="zoneIdHidden" type="hidden" name="zoneId" value="${zoneId}">
            <div class="win_ft">
                <div class="win_ft_in">
                    <input type="button" class="btn" value="发表" onclick="addArticle()"/>
                </div>
            </div>
        </div>
    </div>
</form>


<script>

    function inspect() {
        alert("请先登陆再操作");
    }

    $.fn.serializeObject = function () {
        var o = {};
        var a = this.serializeArray();
        $.each(a, function () {
            if (o[this.name]) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = this.value || '';
            }
        });
        return o;
    };

    function addArticle() {
        var articleAddForm = $("#articleAddForm").serializeObject();
        if (articleAddForm['title'] && articleAddForm['content']) {
            $.ajax({
                url: '${pageContext.request.contextPath}/article/publish.do',
                data: JSON.stringify($("#articleAddForm").serializeObject()),
                contentType: 'application/json',
                cache: false,
                dataType: 'text',
                type: 'post',
                success: function (data) {
                    location.href = "/article/show.do";
                }
            })
        } else {
            alert("标题或内容为空！");
        }
    }

    //页面加载完毕获取版块
    $(function () {
        var zoneIdField = "${zoneId}";
        $.post("${pageContext.request.contextPath}/zone/findAll.do", function (date) {
            var number = 1;

            $(date).each(function () {

                var zone = "<li zoneId=" + this['zoneId'] + ">\n" +
                    "                <a href=\"javaScript:findAll(" + this['zoneId'] + ")\"><em></em>" + this['zoneName'] + "</a>\n" +
                    "            </li>";

                //页面第一次加载给第一个版块添加样式
                var JZoneId = $(zone);
                if (!zoneIdField && number == 1) {
                    JZoneId.addClass("current");
                    //不是第一次给特定版块添加样式
                } else if (JZoneId.attr("zoneId") == zoneIdField) {
                    JZoneId.addClass("current");
                }
                $("#bbs_zone_table").append(JZoneId);
                number++;

            })

        }, "json");


        //页面加载完毕获取版块内容，第一次访问默认选择第一版块
        if (zoneIdField) {
            findAll(zoneIdField);
        } else {
            findAll(1);
        }
        $.ajax({
            type: "get",
            url: "${pageContext.request.contextPath}/userInfo/SChu.do",
            dataType: "text",
            success: function (data) {

            }
        })


    });

    function findAll(num) {

        //ajax请求时版块选中添加样式
        var lis = $("#bbs_zone_table>li");
        lis.each(function () {
            $(this).removeClass("current");
            if ($(this).attr("zoneId") == num) {
                $(this).addClass("current")
            }
        });

        //清空版块内容
        var jArticleUl = $("#articleUl");
        jArticleUl.empty();
        //发送AJAX获取版块内容
        $.post("${pageContext.request.contextPath}/article/findAll.do", {"zoneId": num}, function (date) {

            //版块没有文章显示
            if (date.length == 0 || date == null) {
                jArticleUl.append($("<li class=\"clearfix ding\"><div class=\"hm-index-title\"><a href=\"\">没有帖子，来一发吧！</a></div></div></li>\n"));
                return;
            }
            $(date).each(function () {
                var article = "<li class=\"clearfix\">\n" +
                    "                        <div class=\"hm-index-title\">\n" +
                    "                            <i class=\"set-to-top\">顶</i> <a href=\"${pageContext.request.contextPath}/article/getArticle.do?articleId=" + this['articleId'] + "\">" + this['title'] + "</a>\n" +
                    "                        </div>\n" +
                    "                        <div class=\"hm-index-con\">" + this['content'] + "</div>\n" +
                    "                        <div class=\"hm-index-info l\">\n" +
                    "                            <span class=\"article-username\">" + this['senderName'] + "</span><span\n" +
                    "                                class=\"post-time\">" + this['sendTime'] + "</span>\n" +
                    "                        </div>\n" +
                    "                        <div class=\"hm-index-fun r\">\n" +
                    "                            <span class=\"icon-like\"><i></i>" + this['upvoteCount'] + "</span>\n" +
                    "                            <span class=\"icon-talk\"><i></i>" + this['replyCount'] + "</span>\n" +
                    "                        </div>\n" +
                    "                    </li>";

                var jArticle = $(article);
                //是否置顶并展示文章
                if (this['isTop'] == 1) {
                    jArticle.addClass("ding");
                    jArticleUl.prepend(jArticle);
                } else {
                    jArticleUl.append(jArticle);
                }


            })

        }, "json")
    }

    // 关键字搜索功能

    $("#kwbtn").click(function () {
        if ($("#keyword").val()){
            // 发送ajax请求查询关键字
            $.post("${pageContext.request.contextPath}/article/findByKeyword.do",{keyword:$("#keyword").val()},function (data) {

                //清空版块内容
                var jArticleUl = $("#articleUl");
                jArticleUl.empty();

                //未查询到关键字信息
                if (data.length == 0 || data == null) {
                    jArticleUl.append($("<li class=\"clearfix ding\"><div class=\"hm-index-title\">查询不到任何相关帖子信息</div></div></li>\n"));
                    return;
                }
                $(data).each(function () {
                    var article = "<li class=\"clearfix\">\n" +
                        "<div class=\"hm-index-title\">\n" +
                        "<i class=\"set-to-top\">顶</i> <a href=\"${pageContext.request.contextPath}/article/getArticle.do?articleId=" + this['articleId'] + "\">" + this['title'] + "</a>\n" +
                        "</div>\n" +
                        "<div class=\"hm-index-con\">" + this['content'] + "</div>\n" +
                        "<div class=\"hm-index-info l\">\n" +
                        "<span class=\"article-username\">" + this['senderName'] + "</span><span\n" +
                        " class=\"post-time\">" + this['sendTime'] + "</span>\n" +
                        "</div>\n" +
                        "<div class=\"hm-index-fun r\">\n" +
                        "<span class=\"icon-like\"><i></i>" + this['upvoteCount'] + "</span>\n" +
                        "<span class=\"icon-talk\"><i></i>" + this['replyCount'] + "</span>\n" +
                        "</div>\n" +
                        "</li>";
                    var jArticle = $(article);
                    //是否置顶并展示文章
                    if (this['isTop'] == 1) {
                        jArticle.addClass("ding");
                        jArticleUl.prepend(jArticle);
                    } else {
                        jArticleUl.append(jArticle);
                    }
                })
            }, "json")}
        else{
            alert("请输入关键字")
        }
    })
    $(function () {
        $.post("${pageContext.request.contextPath}/article/tiezifindAll.do", function (data) {
            $("#total").html(data['total']);
            $("#jinri").html(data['jinri']);
        }, "json");
    });

    // 页面加载的时候查询在线用户
    $(function () {
        $.post("${pageContext.request.contextPath}/online/showOnline.do")
    })
</script>


</body>
<script>
</script>
</html>