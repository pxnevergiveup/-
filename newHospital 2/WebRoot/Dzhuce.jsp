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
    <title>
        	吉珠分院预约挂号平台
    </title>
    <link rel="icon" type="image/png" href="image/title_logo.png">
    <link rel="stylesheet" type="text/css" href="css/zhuce.css">
</head>
<body>
    <div class="main">
        <header>注册</header>
        <div class="lab lab0">手机号格式不正确</div>
        <div class="lab lab1">请输入2-4字的中文名</div>
        <div class="lab lab2" id="lab2">密码不能为空或密码不一致</div>
        <div class="lab lab2" id="lab3">6-16位英文数字组合密码</div>
        <form id="zhuce">
            <div class="form" id="zhuce">
                <input type="text" name="id" placeholder="手机号" id="pid" autocomplete="off" required="required"/>
                <input type="text" name="name" placeholder="姓名" id="name" autocomplete="off"/>
                <input type="password" name="pwd" placeholder="请输入密码" id="pwd1"/>
                <input type="password" placeholder="确认密码" id="pwd2"/>
                <input type="date" name="date" placeholder="出生日期" required="required"/>
                <div>
	                <select name="ksno">
	                <c:forEach var="ks" items="${requestScope.KSs}">
	                	<option value="${ks.getKsno()}">${ks.getKsname()}</option>
                	</c:forEach>
	                </select>
	                <select name="sfzj">
	                	<option value="1">医学专家</option>
	                	<option value="0">不是专家</option>
	                </select>
                </div>
                <div>
                    <input type="radio" name="sex" value="男" checked="checked"/>男
                    <input type="radio" name="sex" value="女" />女
                </div>
                <input type="submit" value="提交"/>
            </div>
        </form>
    </div>
    <script type="text/javascript" src="js/Jquery.js"></script>
    <script type="text/javascript" src="js/jiaoyan.js"></script>
    <script>
    	$("#zhuce").submit(function(e){
    		e.preventDefault();
    		if(sub()){
    			$.ajax({
		    		url:"zhuceServlet?index=doctor",
		    		async:true,
				    type:"POST",
				    data:$("#zhuce").serialize(),
				    dataType:'json',
				    success:function(result){
				    	if(result == true){
							window.alert("注册成功");
						}
						else if(result == false){
							window.alert("注册失败，手机号已存在");
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