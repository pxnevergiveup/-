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
    <link rel="icon" type="image/png" href="image/title_logo.png">
    <link rel="stylesheet" type="text/css" href="css/info.css">
    <style>
        .content_right {
            width:100%;
        }
        .js, textarea {
	        height: 280px;
        }
        .button {
            text-indent:initial;
            letter-spacing:initial;
        }
    </style>
    <title></title>
</head>
<body>
    <div class="content_right">
        <div class="content_right_title">
            <div class="content_right_title_icon"></div>
            <div class="content_right_title_text">文章投稿</div>
        </div>
        <div class="content_right_warp">
            <form class="clearfix" id="sub">
                <div class="row">
                    <label class="form_label">id:</label>
                    <div class="line-height">
                        <div class="el-input">
                            <span class="id">${sessionScope.doctor.getDno()}</span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <label class="form_label">文章标题:</label>
                    <div class="line-height">
                        <div class="el-input">
                            <select name="part" class="input name">
                            	<option value="1">健康咨询</option>
                            	<option value="2">学术前沿</option>
                            </select>
                        </div>
                        <div class="lab lab0">手机号格式错误</div>
                    </div>
                </div>
                <div class="row">
                    <label class="form_label">文章标题:</label>
                    <div class="line-height">
                        <div class="el-input">
                            <input name="head" id="name" autocomplete="off" required="required" placeholder="你的标题" type="text" maxlength="10" class="input">
                        </div>
                        <div class="lab lab0">手机号格式错误</div>
                    </div>
                </div>
                <div class="row">
                    <label class="form_label">文章内容:</label>
                    <div class="line-height">
                        <div class="js">
                            <textarea name="text" placeholder="你的正文"></textarea>
                            <div class="after">此处发表您的文章</div>
                        </div>
                    </div>
                </div>                
                <div class="row">
                    <div class="line-height">
                        <div class="padding-dom"></div>
                        <div class="user-my-btn-warp">
                            <input id="sub" type="submit" value="保存" class="button">
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <script type="text/javascript" src="js/Jquery.js"></script>
    <script>
		$("#sub").submit(function(e){
    		e.preventDefault();
    		if(true){
    			$.ajax({
		    		url:"ArticleServlet?index=push",
		    		async:true,
				    type:"POST",
				    data:"dno="+${sessionScope.doctor.getDno()}+"&"+$("#sub").serialize(),
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