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
    <link rel="icon" type="image/png" href="image/title_logo.png">
    <style>
    *{
	    margin: 0;
	    padding: 0;
    }
    a{
    	color:inherit;
    	text-decoration: none;
    	cursor: pointer;
    }
    body{
    	overflow: hidden;
    }
    ul{
    	position: absolute;
    	top:20%;
    	z-index: 9999;
    }
    	iframe{
    		width:100%;
    		height: 100vh;
    		position: absolute;
    		border: none;
    	}
    </style>
  </head>
  
  <body>
  <ul>
    <c:forEach items="${sessionScope.kss}" var="ks">
    	<li><a href="GHServlet?index=ks_ser&ks=${ks.getKsno()}" target="frame">${ks.getKsname()}</a></li>
    </c:forEach>
   </ul>
    <iframe name="frame" src="GHServlet?index=ks_ser&ks=KS01"></iframe>
  </body>
</html>
