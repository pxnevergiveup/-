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
    <link rel="stylesheet" type="text/css" href="css/table.css">
    <title></title>    
    <style>
    	.js{
    		cursor: pointer;
    	}
    </style>
  </head>
  
  <body>
    <div class="main">
        <header><span style="-moz-user-select:none;">预约医生</span><i style="display:inline-block;width:30px;margin-left:20px;transition:all 0.5s" class="fonteditor">&#xe04a</i></header>
        <table style="z-index: 999">
            <tr>
                <th>编号</th>
                <th>名字</th>
                <th>出生日期</th>
                <th>性别</th>
                <th>号码</th>
                <th>结束预约</th>
            </tr>
            <c:forEach var="gh" items="${sessionScope.ghsd}">
	            <tr>
	                <td>${gh.getPno()}</td>
	                <td>${gh.getPname()}</td>
	                <td>${gh.getPage()}</td>
	                <td>${gh.getPsex()}</td>
	                <td>${gh.getGHno()}</td>
	                <td class="${gh.getGHno()} js" onclick="aindex(${gh.getGHno()})" >结束预约</td>
	            </tr>  
            </c:forEach>         
        </table>
        <table style="opacity:0">
            <tr>
                <th>编号</th>
                <th>名字</th>
                <th>出生日期</th>
                <th>性别</th>
                <th>号码</th>
                <th>结束预约</th>
            </tr>
            <c:forEach var="gh" items="${sessionScope.ghsk}">
	            <tr>
	                <td>${gh.getPno()}</td>
	                <td>${gh.getPname()}</td>
	                <td>${gh.getPage()}</td>
	                <td>${gh.getPsex()}</td>
	                <td>${gh.getGHno()}</td>
	                <td class="${gh.getGHno()} js" onclick="aindex(${gh.getGHno()})" >结束预约</td>
	            </tr>  
            </c:forEach> 
        </table>
    </div>
    <script type="text/javascript" src="js/Jquery.js"></script>
    <script type="text/javascript">
    	function aindex (a){
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
        $(function () {
            var i = 0;
            $("span").click(function () {
                if (i % 2) {
                    $(this).html("预约医生");
                }
                else {
                    $(this).html("预约科室");
                }
                $("i").toggleClass("ro");
                $("table:first").toggleClass("opa1");
                $("table:last").toggleClass("opa2");
                i++;
            })
        })
    </script>
  </body>
</html>
