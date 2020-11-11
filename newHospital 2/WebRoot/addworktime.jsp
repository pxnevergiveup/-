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
    <link rel="stylesheet" href="css/register.css" type="text/css"/>
  </head>
  
  <body>
    <div class="register">
	    <c:forEach var="week" items="${requestScope.weeks}">
	    	<div class="week">
	            <header class="worktime"></header>
	            	<c:forEach var="reg" begin="1" end="4">
	                	<input form="yuyue" type="radio" name="register" class="worktime" value="${week}&${reg}"/>  
	                </c:forEach>             
	            <div class="menu">
	                <label class="time">${week}</label>                       
	                <label class="time">0:00-6:00</label>
	                <label class="time">6:00-12:00</label>                       
	                <label class="time">12:00-18:00</label>  
	                <label class="time">18:00-24:00</label>                     
	            </div>
	        </div>   
	    </c:forEach>
    </div>
  </body>
</html>
