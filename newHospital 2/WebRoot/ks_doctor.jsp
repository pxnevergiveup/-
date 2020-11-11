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
    <link rel="stylesheet" href="https://cdn.bootcss.com/fullPage.js/2.8.9/jquery.fullPage.min.css" />
    <link rel="stylesheet" type="text/css" href="css/zhuzhan.css">
    <link rel="stylesheet" type="text/css" href="css/flavr.css"/>
    <link rel="stylesheet" type="text/css" href="css/animate.css" />
  	<style type="text/css">
  		
  	</style>
  </head>
  
  <body>
	  <div id="full">
		<section id="s2" class="section">
		  	<a onclick="gh('${requestScope.ksno}')">挂号此科室</a>
		    <c:forEach items="${requestScope.ks_doctors}" step="4" varStatus="slide">
		       	<div class="slide">
		       		<div class="yisheng">
		                <header>${requestScope.ksno}</header>
		        		<c:forEach var="doctor" items="${requestScope.ks_doctors}" begin="${slide.index}" end="${slide.index + 3}">
		        			<div class="jieshao">
		                    <header>
		                        <img src="image/yisheng.jpg" />
		                        <span>${doctor.getDname()}</span>
		                        		${doctor.getKsname()}<br />
			                        	 珠海吉大附属医院 
		                    </header>
		                    <content>${doctor.getDjs()}</content>
		                    <div class="zixunyuyue">
		                        <a class="zixun" onclick="zixun('${doctor.getkSno()}','${doctor.getKsname()}')">在线咨询</a>
		                        <a class="yuyue" onclick="yuyue(${doctor.getDno()})">预约挂号</a>
		                    </div>
		                </div>
		        		</c:forEach>
		  			</div>
		       	</div>
		    </c:forEach>  
	    </section>    
	  </div>
	  <script type="text/javascript" src="js/Jquery.js"></script>
   	  <script type="text/javascript" src="js/jquery.fullPage.min.js"></script>     
   	  <script type="text/javascript" src="js/flavr.min.js"></script>
   	  <script type="text/javascript">
   	  	$('#full').fullpage();
   	  	function gh(a){
   	  		if(${sessionScope.p.getPno()==null}){
           		new $.flavr('预约前请先登录');
           	}
           	else{
           		top.location.href="GHServlet?index=ks_inner&ks="+a;
           	}
   	  	}
   	  	function yuyue(a){
           	if(${sessionScope.p.getPno()==null}){
           		new $.flavr('预约前请先登录');
           	}
           	else{
           		top.location.href="GHServlet?index=search&dno="+a;
           	}
        }
        function zixun(a,b){
           	if(${sessionScope.p.getPno()==null}){
           		new $.flavr('咨询前请先登录');
           	}
           	else{
           		top.location.href="sToRequest?index=p&ksno="+a+"&ksname="+b;
           	}
        }
   	  </script>
  </body>
</html>
