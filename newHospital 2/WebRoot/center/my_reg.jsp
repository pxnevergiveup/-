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
    <link rel="stylesheet" type="text/css" href="css/info.css">
    <style>
    	body::BEFORE{
    		display: none;
    	}
    	th{
    		width:initial!important;
    	}
    	.del{
    		background: linear-gradient(#3ecae1,#327d7d);
    	}
    </style>
  </head>  
  <body>
  <div class="content_right">
    <div class="content_right_title">
        <div class="content_right_title_icon"></div>
        <div class="content_right_title_text">我的预约</div>
    </div>
    <div class="content">    
        <table>
            <tr>
                <th>医生</th>
                <th>科室</th>
                <th colspan="2">预约的时间段</th>
                <th>号码</th>
                <th>action</th>
            </tr>
            <c:forEach var="gh" items="${sessionScope.pghs}">
            <tr>
                <td>${gh.getDname()}</td>
               	<td>${gh.getKSno()}</td>
               	<td>${gh.getTimedate()}</td>
               	<td>${gh.getTimetime()}</td>
               	<td>${gh.getGHno()}</td>
                <td class="action ${gh.getGHno()}"><a class="but del" onclick="del(${gh.getGHno()})">取消预约</a></td>
            </tr>
            </c:forEach>
        </table>
    </div>
  </div>
    <script type="text/javascript" src="js/Jquery.js"></script>
    <script type="text/javascript">
    	function del(a){
    		$.ajax({
	    		url:"GHServlet?index=del",
			    type:"POST",
			    data:"ghno="+a,
			    success:function(result){
			    	if(result != "false"){
			        	$("."+a).parent().fadeOut("slow");
			        }
			        else{
			        	alert("删除失败");
			        }			       
			    },
			    error:function(){
			        alert("操作失败");
			    }
	    	});
    	}
    </script>
  </body>
</html>
