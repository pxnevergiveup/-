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
    <link type="text/css" rel="stylesheet" href="css/zhuce.css" />
    <title></title>
  </head>
  <body>
    <div class="main">
        <header>修改密码</header>
        <div class="lab lab2" id="lab2" style="top:340px">新密码不能为空或密码不一致</div>
        <div class="lab lab2" id="lab3" style="top:340px">6-16位英文数字组合密码</div>
        <form id="pwd">
            <div class="form">
                <input type="text" name="no" id="no" readonly="readonly" value="${sessionScope.doctor.getDno()}"/>
                <input type="password" name="pwd" placeholder="原密码"/>
                <input type="password" name="newpwd" placeholder="新密码" id="pwd1"/>
                <input type="password" placeholder="确认新密码" id="pwd2"/>
                <input type="submit" value="提交"/>
            </div>
        </form>
    </div>
    <script type="text/javascript" src="js/Jquery.js"></script>
    <script type="text/javascript" src="js/jiaoyan.js"></script>
    <script>
    	$("#pwd").submit(function(e){
    		e.preventDefault();
    		if(pwd()){
    			$.ajax({
		    		url:"pwdServlet?index=doctor",
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
