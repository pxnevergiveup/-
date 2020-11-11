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
	    form,input{
	    	display: none;
	    }
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
            <c:forEach var="yd" items="${requestScope.YDS}">
            <form id="${yd.getYdid()}">
            	<input type="text" name="name" value="${yd.getYdname()}">
            	<input type="text" name="did" value="${yd.getYdid()}">
            	<input type="text" name="date" value="${yd.getYdate()}">
            	<input type="text" name="ksno" value="${yd.getYdKsno()}">
            	<input type="text" name="pwd" value="${yd.getYdpwd()}">
            	<input type="text" name="sex" value="${yd.getYdsex()}">
            	<input type="text" name="sfzj" value="${yd.getYdsfzj()}">
            </form>
            <tr>
                <td>${yd.getYdname()}</td>
               	<td>${yd.getYdid()}</td>
               	<td>${yd.getYdate()}</td>
               	<td>${yd.getYdKsno()}</td>
               	<td>${yd.getYdsex()}</td>
               	<c:if test="${yd.getYdsfzj()==1}">
               		<td>是</td>
               	</c:if>
               	<c:if test="${yd.getYdsfzj()==0}">
               		<td>否</td>
               	</c:if>
                <td class="action ${yd.getYdid()}"><a class="but del" onclick="agree(${yd.getYdid()})">同意</a></td>
                <td class="action ${yd.getYdid()}"><a class="but ref" onclick="refuse(${yd.getYdid()})">拒绝</a></td>
            </tr>
            </c:forEach>
        </table>
    </div>
    <script type="text/javascript" src="js/Jquery.js"></script>
    <script type="text/javascript">
    	function agree(a){
    		$.ajax({
	    		url:"zhuceServlet?index=agree",
			    type:"POST",
			    data:$('#'+a).serialize(),
			   	success:function(result){
			    	if(result == "true"){
						window.alert("同意申请");
						$("."+a).parent().fadeOut("slow");
					}
					else if(result == "false"){
						window.alert("同意失败");
					}
			    },
			    error:function(){
			        window.alert("预期之外的错误");
			    }
	    	});
    	}
    	function refuse(a){
    		$.ajax({
	    		url:"zhuceServlet?index=refuse",
			    type:"POST",
			    data:"did="+a,
			   	success:function(result){
			    	if(result == "true"){
						window.alert("拒绝申请");
						$("."+a).parent().fadeOut("slow");
					}
					else if(result == "false"){
						window.alert("拒绝失败");
					}
			    },
			    error:function(){
			        window.alert("预期之外的错误");
			    }
	    	});
    	}
    </script>
  </body>
</html>
