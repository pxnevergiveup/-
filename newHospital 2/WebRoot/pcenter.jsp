<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>吉珠分院预约挂号平台</title>
    <meta charset="utf-8"/>
    <link rel="icon" type="image/png" href="image/title_logo.png">
    <link rel="stylesheet" type="text/css" href="css/center.css">
    <link rel="stylesheet" type="text/css" href="css/nav.css">
    <link rel="stylesheet" type="text/css" href="css/_login.css">
</head>
<body>
	<header id="h1">
        <div class="head_shadow"></div>
        <div class="head">
            <div class="min_head">
                <div class="link">
                    <ul>
                        <li><a href="#"><i class="fonteditor zhuzhan"></i>主站</a></li>
                    </ul>
                </div>
                <c:if test="${sessionScope.p.getPname()==null}">
                    <a href="zhuzhan.jsp"></a>
                </c:if>
                <c:if test="${sessionScope.p.getPname()!=null}">
                	<div class="nav">
                        <ul>
                            <li><i class="fonteditor denglu" id="denglu"></i>
                                <ul id="hover">
                                	<li>${sessionScope.p.getPname()}</li>
                                    <li><a href="pcenter.jsp">个人中心</a></li>
                                    <li><a href="GHServlet?index=my_reg">我的预约</a></li>
                                    <li><a class="getlogin">重新登录</a></li>
                                    <li><a href="loginServlet?index=clear">退出登录</a></li>
                                </ul>
                            </li>
                            <li><i class="fonteditor" style="font-size:20px">&#xe06d</i>消息
                                <ul>
                                    <li>收到的赞</li>
                                    <li>系统消息</li>
                                    <li>我的消息</li>
                                </ul>
                            </li>
                            <li style="width:200px"><i class="fonteditor" style="font-size:20px">&#xe068</i><a href="GHServlet?index=my_reg">我的预约</a></li>
                        </ul>
                    </div>
                </c:if>
            </div>
        </div>
    </header>
    <div id="content">
        <div class="content_left">
            <span>个人中心</span>
            <ul>
                <li><a href="center/pinfo.jsp" target="center"><i class="fonteditor" style="margin-right:7px;width:50px;">&#xe05c</i>个人信息</a></li>
                <li><a href="center/pwd.jsp" target="center"><i class="fonteditor">&#xe0d1</i>修改密码</a></li>
                <li><a href="GHServlet?index=my_reg" target="center"><i class="fonteditor">&#xe068</i>我的预约</a></li>
            </ul>
        </div>
        <iframe name="center"></iframe>
	</div>
    <script type="text/javascript" src="js/Jquery.js"></script>
    <script>
        $(function () {        
        	$("iframe").attr("src","center/pinfo.jsp");  
            $on = $(".content_left>ul>li");
            $on.click(function () {
                $(this).addClass("on").siblings().removeClass("on");
            })
            $on.eq(0).click();
             //登录
            $('.getlogin').click(function () {
                $('.login_body').css('display', 'block');
                $('.login_main').addClass('addClass_login');
            })
            $('.quxiao').click(function () {
                $('.login_body').css('display', 'none');
            })  
        })
    </script>
    <!--登录界面-->
        <div class="login_body" style="color:#000">
            <div class="login_main">
                <i class="fonteditor quxiao"></i>
                <div class="logins">
                    <input type="radio" name="rad" id="r1" checked="checked" />
                    <input type="radio" name="rad" id="r2" />
                    <input type="radio" name="rad" id="r3" />
                    <div class="login s1">
                        <header>登录</header>
                        <h4>输入您的账号与密码：</h4>
                        <form class="content" action="loginServlet?index=p" method="post">
                            <div class="text">
                                <input type="text" name="pno" placeholder="账号" required="required" autofocus="autofocus" />
                            </div>
                            <div class="text">
                                <input type="password" name="ppwd" placeholder="密码" required="required" />
                            </div>
                            <input type="submit" class="submit" value="登录" />
                        </form>
                    </div>
                </div>
            </div>
        </div>
</body>
</html>