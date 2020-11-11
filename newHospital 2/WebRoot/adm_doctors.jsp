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
    <link rel="stylesheet" type="text/css" href="css/pullme.css"/>
    <style>
    	th{
    		width:initial!important;
    	}
    	.del{
    		background: linear-gradient(#3ecae1,#327d7d);
    	}
    	.ref{
    		background: linear-gradient(#db3d3d,#7d301e);
    		color:#fff;
    	}
    </style>
  </head>
  
  <body>
    <div class="content">    
        <table>
            <tr>
                <th>名字</th>
                <th>电话</th>
                <th>生日</th>
                <th>科室</th>
                <th>性别</th>
                <th>专家</th>
                <th colspan="2">操作</th>
            </tr>
            <c:forEach var="doctor" items="${requestScope.doctors}">
            <tr>
                <td>${doctor.getDname()}</td>
               	<td>${doctor.getDid()}</td>
               	<td>${doctor.getDage()}</td>
               	<td>${doctor.getkSno()}</td>
               	<td>${doctor.getDsex()}</td>
               	<c:if test="${doctor.getSfzj()==1}">
               		<td>是</td>
               	</c:if>
               	<c:if test="${doctor.getSfzj()==0}">
               		<td>否</td>
               	</c:if>
               	<td class="action ${doctor.getDid()}"><a class="but del" href="infoServlet?index=ser_doctor&no=${doctor.getDno()}">更改信息</a></td>
                <td class="action ${doctor.getDid()}"><a class="but ref" href="WorktimeServlet?index=Arrang&no=${doctor.getDno()}">工作安排</a></td>
            </tr>
            </c:forEach>
        </table>
    </div>
    <script type="text/javascript" src="js/Jquery.js"></script>
    <script type="text/javascript">
    </script>
  </body>
</html>
