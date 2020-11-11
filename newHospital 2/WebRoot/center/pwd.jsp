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
	<title>My JSP 'pwd.jsp' starting page</title>
    <link rel="icon" type="image/png" href="image/title_logo.png">
    <link rel="stylesheet" type="text/css" href="css/info.css">
	<link type="text/css" rel="stylesheet" href="css/zhuce.css" />
	<style type="text/css">
		.lab{
			background:linear-gradient(90deg,#84a1e6,rgb(88, 255, 231));
			top:298px;
			left:606px;
		}
		.lab::BEFORE {
			color:#84a1e6;
			border-color:transparent transparent #84a1e6 transparent;
		}
		#pwd{
			width: 650px;
			margin: 0 auto;
			height:480px;
		}
	</style>
</head>

<body>
	<div class="content_right">
		<div class="content_right_title">
			<div class="content_right_title_icon"></div>
			<div class="content_right_title_text" style="font-style: normal;">修改密码</div>
		</div>
		<div class="content_right_warp">
			<div class="clearfix" >
				<header>修改密码</header>
				
				<div class="lab lab2" id="lab3">6-16位英文数字组合密码</div>
				<div class="lab lab2" id="lab2">两次输入的密码不一致</div>
				<form id="pwd">
					<div class="form">
						<input type="text" name="no" id="no" readonly="readonly" value="${sessionScope.p.getPno()}"/> 
						<input type="password" name="pwd" placeholder="原密码" /> 
						<input type="password" name="newpwd" placeholder="新密码" id="pwd1" required="required"/>
						<input type="password" placeholder="确认新密码" id="pwd2" required="required"/> 
						<input type="submit" value="保存" />
					</div>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/Jquery.js"></script>
    <script type="text/javascript" src="js/jiaoyan.js"></script>
    <script>
    	$("#pwd").submit(function(e){
    		e.preventDefault();
    		if(pwd()){
    			$.ajax({
		    		url:"pwdServlet?index=p",
		    		async:true,
				    type:"POST",
				    data:$("#pwd").serialize(),
				    dataType:'json',
				    success:function(result){
				    	if(result == true){
							window.alert("修改成功");
						}
						else if(result == false){
							window.alert("原密码错误");
						}
				    },
				    error:function(){
				        window.alert("操作失败");
				    } 
	    		});
    		}
    	})
    </script>
</body>
</html>
