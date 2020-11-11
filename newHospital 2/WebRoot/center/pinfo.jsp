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
    <title></title>
    <link rel="icon" type="image/png" href="image/title_logo.png">
    <link rel="stylesheet" type="text/css" href="css/info.css">
</head>
<body>
    <div class="content_right">
            <div class="content_right_title">
                <div class="content_right_title_icon"></div>
                <div class="content_right_title_text">个人信息</div>
            </div>
            <div class="content_right_warp">
                <form class="clearfix" id="psub">
                    <div class="row">
                        <label class="form_label">id:</label>
                        <div class="line-height">
                            <div class="el-input">
                                <span class="id">${sessionScope.p.getPno()}</span>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <label class="form_label">姓名:</label>
                        <div class="line-height">
                            <div class="el-input name">
                                <input name="name" id="name" value="${sessionScope.p.getPname()}" autocomplete="off" placeholder="你的名字" type="text"  maxlength="4"  class="input name">
                            </div>
                            <div class="lab lab1">四位以下的中文名</div>
                        </div>
                    </div>
                    <div class="row">
                        <label class="form_label">手机号:</label>
                        <div class="line-height">
                            <div class="el-input">
                                <input name="id" id="pid" value="${sessionScope.p.getPid()}" autocomplete="off" placeholder="你的手机号" type="text"  maxlength="11" class="input">
                            </div>
                            <div class="lab lab0">手机号格式错误</div>
                        </div>
                    </div>
                    <div class="row">
                        <label class="form_label">我的签名:</label>
                        <div class="line-height">
                            <div class="js">
                                <textarea name="js"  placeholder="设置您的签名" maxlength="50">${sessionScope.p.getPjs()}</textarea>
                            	<div class="after">上限五十字</div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <label class="form_label">性别:</label>
                        <div class="line-height">
                            <div class="el-radio-group">
                                <label class="sex">
                                	
                                    <input type="radio" name="sex"  value="男"<c:if test="${sessionScope.p.getPsex()=='男'}">checked="checked"</c:if>>
                                    <span class="sex-span">男</span>
                                </label>
                                <label class="sex">
                                    <input type="radio" name="sex" value="女"<c:if test="${sessionScope.p.getPsex()=='女'}">checked="checked"</c:if>>
                                    <span class="sex-span">女</span>
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <label class="form_label">出生日期:</label>
                        <div class="line-height">
                            <div class="date">
                                <input type="date" value="${sessionScope.p.getPage()}" name="date" class="input"/>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="line-height">
                            <div class="padding-dom"></div>
                            <div class="user-my-btn-warp">
                                <input type="submit" value="保存" class="button">
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    <script type="text/javascript" src="js/Jquery.js"></script>
    <script type="text/javascript" src="js/jiaoyan.js"></script>
    <script>
		$("#psub").submit(function(e){
    		e.preventDefault();
    		if(psub()){
    			$.ajax({
		    		url:"infoServlet?index=Psub",
		    		async:true,
				    type:"POST",
				    data:"no="+${sessionScope.p.getPno()}+"&"+$("#psub").serialize(),
				    dataType:'json',
				    success:function(result){
				    	if(result == true){
							window.alert("保存成功");
						}
						else{
							window.alert("保存失败");
						}
				    }
	    		});
    		}
    	})
    </script>
</body>
</html>