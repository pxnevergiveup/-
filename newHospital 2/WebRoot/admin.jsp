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
    <link rel="stylesheet" type="text/css" href="css/mad.css">
    <title>吉珠分院预约挂号平台</title>
  </head>
  <body>
    <div class="head">
    	<div class="logo">吉林大学附属医院</div>
        <div class="min_head">
            <div class="yonghu">用户名 <!-- 待开发 --><i class="fonteditor login"></i></div>
        </div>
        <div id="time"></div>
    </div>
    <div class="content">
        <div class="nav">
        	
            <div class="info">
                <header><span id="fly">你好,</span><div id="opa">管理员</div></header>
                <div class="mess">
                    <div class="first">
                        <span><i class="fonteditor zj"></i><!-- 待开发 --></span>
                        <div class="sfzj"><!-- 待开发 --></div>
                    </div>
                    <div class="second"><!-- 待开发 --></div>
                </div>
            </div>
            <div id="slide">
            	<div class="third">
                    <div><a href="javascript:;"><i class="fonteditor zhuzhan"></i><span>主站</span></a></div>
                    <div><a href="javascript:;"><i class="fonteditor xiaoxi"></i><span>消息</span><i class="fonteditor after"></i></a></div>
                    <div><a href="javascript:;" target="_iframe"><i class="fonteditor xinxi"></i><span>个人信息</span></a></div>
                </div>
                <ul>
                    <li><a href="zhuceServlet?index=adminSearch" target="_iframe"><i class="fonteditor guahao"></i>医生审核</a></li>
                    <li><a href="zhuzhan?index=control_doctor" target="_iframe"><i class="fonteditor fabiao"></i>工作安排</a></li>
                    <li><a href="javascript:;" target="_iframe"><i class="fonteditor wode"></i>文章审核</a></li>
                    <li><a href="javascript:;" target="_iframe"><i class="fonteditor mima"></i><!-- 待开发 --></a></li>
                </ul>
            </div>
        </div>
        <div class="main">
            <iframe name="_iframe" src="zhuceServlet?index=adminSearch"></iframe>
        </div>
    </div>
    <script type="text/javascript" src="js/Jquery.js"></script>
    <script type="text/javascript">
	    function gettime(){
	    	void((function(t){ 	
		    var time = '星期'+(['天','一','二','三','四','五','六'])[t.getDay()]+'&nbsp;&nbsp;&nbsp;'+t.toLocaleString();
		    $("#time").html(time);
		    })
		    (new Date())
		    );
		    setTimeout('gettime()',1000);
	    }
        $(function () {
        	gettime();
            $("#fly").addClass("fly");
            $("#opa").addClass("opa");
            $(".mess").addClass("opa");
            setTimeout(function () {
                $("#slide").slideDown("slow");
            }, 3000);
        })
    </script>
  </body>
</html>
