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
</head>
<body>
   <div class="content">    
        <table>
            <tr>
                <th>文章标题</th>
                <th>投稿栏目</th>
                <th colspan="2">action</th>
            </tr>
            <c:forEach var="art" items="${sessionScope.articles}">
            <form id="sub${art.getAddress()}"></form>
            <tr>
                <td><input name="head" form="sub${art.getAddress()}" type="text" maxlength="10" placeholder="请输入你的标题" required="required" value="${art.getHead()}"/></td>
                <td>
                    <select name="part" form="sub${art.getAddress()}">
                    <c:if test="${art.getPart()==1}">
                        <option value="1" selected="selected">健康咨询</option>
                        <option value="2" >学术前沿</option>
                    </c:if>
                    <c:if test="${art.getPart()==2}">
                        <option value="1">健康咨询</option>
                        <option value="2" selected="selected">学术前沿</option>
                    </c:if>
                    </select>
                </td>
                <td class="action"><a class="but mod" onclick="mod(${art.getAddress()})">修改</a></td>
                <td class="action ${art.getAddress()}"><a class="but del" onclick="del(${art.getAddress()})">删除</a></td>
            </tr>
            </c:forEach>
        </table>
    </div>
    <script type="text/javascript" src="js/Jquery.js"></script>
    <script type="text/javascript">
    	function mod(address){
    	var s = "#sub"+address;
    		$.ajax({
	    		url:"ArticleServlet?index=mod",
	    		async:true,
			    type:"POST",
			    data:"add="+address+"&"+$(s).serialize(),
			    dataType:'json',
			    success:function(result){
			    	if(result == true){
						window.alert("修改成功");
					}
					else{
						window.alert("修改失败");
					}
			    }
    		});
    	}
    	function del(address){
    		$.ajax({
		    		url:"ArticleServlet?index=del",
		    		async:true,
				    type:"POST",
				    data:"add="+address,
				    dataType:'json',
				    success:function(result){
				    	if(result == true){
							$("."+address).parent().fadeOut("slow");
						}
						else{
							window.alert("删除失败");
						}
				    }
	    		});
    	}
    </script>
</body>
</html>
