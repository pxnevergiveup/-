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
	<title></title>
    <link type="image/jpg" rel="icon" href="img/icon.jpg" />
    <link type="text/css" rel="stylesheet" href="css/login.css" />
    <link rel="stylesheet" type="text/css" href="css/flavr.css"/>
    <link rel="stylesheet" type="text/css" href="css/animate.css" />
  </head>
  <body>
    <div class="login_main">
        <div class="logins">
            <input type="radio" name="rad" id="r1" checked="checked" />
            <input type="radio" name="rad" id="r2" />
            <input type="radio" name="rad" id="r3" />
            <div class="login s1">
                <header>医生登录</header>
                <h4>输入您的账号与密码：</h4>
                <form class="content" action="loginServlet?index=doctor" method="post">
                    <div class="text">
                        <input type="text" name="dno" placeholder="账号" required="required" autofocus="autofocus" autocomplete="off"/>
                    </div>
                    <div class="text">
                        <input type="password" name="dpwd" placeholder="密码" required="required" />
                    </div>
                    <input type="submit" class="submit" value="登录" />
                </form>
            </div>
            <div class="login">
                <header>管理员登录</header>
                <h4>输入您的账号与密码：</h4>
                <form class="content" action="loginServlet?index=adm" method="post">
                    <div class="text">
                        <input type="text" name="gno" placeholder="账号" required="required" autofocus="autofocus" autocomplete="off"/>
                    </div>
                    <div class="text">
                        <input type="password" name="gpwd" placeholder="密码" required="required" />
                    </div>
                    <input type="submit" class="submit" value="登录" />
                </form>
            </div>          
        </div>
        <div class="nav">
            <label for="r1">医</label>
            <label for="r2">管</label>   
            <label onclick="window.location.href='zhuceServlet?index=serks'">注</label>       
        </div>
    </div>
    <script type="text/javascript" src="js/Jquery.js"></script>
    <script type="text/javascript" src="js/flavr.min.js"></script>
    <script type="text/javascript">
    	if(${requestScope.doctor == "0"}){
    		new $.flavr({
    		 	content : '账号密码错误!',
    			animateEntrance: 'rotateIn',
                animateClosing: 'rotateOut',
    		});
    	}
    </script>
  </body>
</html>
