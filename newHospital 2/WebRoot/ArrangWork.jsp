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
    <link rel="stylesheet" type="text/css" href="css/flavr.css"/>
    <link rel="stylesheet" type="text/css" href="css/animate.css" />
    <style type="text/css">
	    body{
	    	width:100vw;
	    	height:100vh;
	    	background: linear-gradient(rgba(130, 130, 238, 0.5) ,rgba(92, 63, 63, 0.5));
	    }
    	.content_right{
    		position:initial;
    	}
    	.register_head{
    		letter-spacing: 10px;
    	}
    	.register{
    		width:80%;
    		top:43%;
    	}
    	.button{
    		bottom: 130px;
    		display: none;
    		text-align: center;
    	}
    </style>
  </head>
  
  <body>
  	<form id="yuyue"></form>
    <div class="content_right">
            <header class="register_head">${requestScope.doctor.getDname()}工作时间</header>
            <div class="register">
            <c:forEach var="week" items="${requestScope.map.keySet()}">
            	<div class="week">
                    <header class="worktime"></header>
                    	<c:forEach var="timetime" items="${requestScope.map.get(week)}" begin="0" end="3" varStatus="slide">
                        	<input form="yuyue" type="radio" name="register" class="worktime" value="${week}&${timetime}&${slide.count}"/>  
                        </c:forEach>             
                    <div class="menu">
                        <label class="time">${week}</label>
                        <c:forEach var="timetime" items="${requestScope.map.get(week)}">
                        	<label class="time">${timetime}</label>
                        </c:forEach>
                    </div>
                </div>   
            </c:forEach>
            </div>
            <div class="button" id="add">添加</div>
            <div class="button" id="del">删除</div>
        </div>
    <script type="text/javascript" src="js/Jquery.js"></script>
    <script type="text/javascript" src="js/flavr.min.js"></script>
    <script type="text/javascript">
    	$("input").click(function() {
    		let val = $(this).val();
    		let split = val.split("&");
			if(split[1]==' '){
				$('#del').css('display','none');
				$('#add').css('display','block');
			}
			else{
				$('#del').css('display','block');
				$('#add').css('display','none');
			}
    	})
    	$("#add").click(function(){
    		var dno = ${requestScope.doctor.getDno()};
    		$.ajax({
	    		url:"WorktimeServlet?index=add&dno="+dno,
	    		async:true,
			    type:"POST",
			    data:$("#yuyue").serialize(),
			    dataType:'json',
			    success:function(result){
			    	if(result==false){
			    		new $.flavr('未知错误原因');
			    	}
			    	else if(result==true){
			    		window.location.reload();
			    	}
			    },
			    error: function(){
			    	new $.flavr('请检查网络连接');
			    }
    		});
    	})
    	$("#del").click(function(){
    		var dno = ${requestScope.doctor.getDno()};
    		$.ajax({
	    		url:"WorktimeServlet?index=del&dno="+dno,
	    		async:true,
			    type:"POST",
			    data:$("#yuyue").serialize(),
			    dataType:'text',
			    success:function(result){
			    	console.log(typeof(result));
			    	if(result=="false"){
			    		new $.flavr({
			                content: '警告！已有用户预约过该时间！<br>点击确认 删除并删除所有该时间的预约！<br>是否确定？',
			                dialog : 'confirm',
			                buttons: {
			                    danger: {
			                        text: '确定',
			                        style: 'danger',
			                        action: function() {
			                           $.ajax({
								    		url:"WorktimeServlet?index=delmore&dno="+dno,
								    		async:true,
										    type:"POST",
										    data:$("#yuyue").serialize(),
										    dataType:'text',
										    success:function(result){
										    	new $.flavr(result);
										    	window.location.reload();
										    }
									    })
			                        }
			                    },
			                    cancel: {
			                        text: '取消',
			                        style: 'default'
			                    }
			                }
			            });
			    	}
			    	else{
			    		window.location.reload();
			    	}
			    },
			    error: function(){
			    	new $.flavr('请检查网络连接');
			    }
    		});
    	})
    </script>
  </body>
</html>
