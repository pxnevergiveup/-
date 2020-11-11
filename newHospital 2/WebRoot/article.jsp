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
	<style type="text/css">
		p{
			white-space: pre-wrap;
		}
	</style>
	<!--主要样式-->
	<link rel="stylesheet" href="css/style.css">
	
	<script src="js/prefixfree.min.js"></script>
  </head>
<body>
	
	<div class="scene">
	  <article class="book">	  	
  		<section class="page active">
			<div class="front">
			  <header class="htmleaf-header">
			  	  <h1>${requestScope.art.getHead()}</h1>
		      </header>
		      <h1>${requestScope.art.getDno()}</h1>
			  <p>
			    ${requestScope.Text[0]}
			  </p>
			</div>			
			<div class="back">
			  <h1>– 1 –</h1>
			  <p>
			    ${requestScope.Text[1]}
			  </p>
			</div>    
		</section>
	  		
		<section class="page">
		<div class="front">
		  <h1>– 2 –</h1>
		  <p>
		    ${requestScope.Text[2]}
		  </p>
		</div>
		<div class="back">
		  <h1>– 3 –</h1>
		  <p>
		    ${requestScope.Text[3]}
		  </p>
		</div>    
		</section>
		<section class="page">
		<div class="front">
		  <h1>– 4 –</h1>
		  <p>
		    ${requestScope.Text[4]}
		  </p>
		</div>
		<div class="back">
		  <h1>– 5 –</h1>
		  <p>
		    ${requestScope.Text[5]}
		  </p>
		</div>    
		</section>
		<section class="page">
		<div class="front">
		  <h1>– 6 –</h1>
		  <p>
		    ${requestScope.Text[6]}
		  </p>
		</div>
		<div class="back">
		  <h1>– 7 –</h1>
		  <p>
		    ${requestScope.Text[7]}
		  </p>
		</div>    
		</section>
		<section class="page">
		<div class="front">
		  <h1>– 8 –</h1>
		  <p>
		    ${requestScope.Text[8]}
		  </p>
		</div>
		<div class="back">
		  <h1>– 9 –</h1>
		  <p>
		    ${requestScope.Text[9]}
		  </p>
		</div>    
		</section>
	</article>
	</div>
	
	<script src="https://www.jq22.com/jquery/jquery-1.10.2.js"></script>
	<script src='js/jquery.hammer.min.js' type="text/javascript"></script>
	<script>
		var currentPage = 0;

		$('.book')
		.on('click', '.active', nextPage)
		.on('click', '.flipped', prevPage);

		$('.book').hammer().on("swipeleft", nextPage);
		$('.book').hammer().on("swiperight", prevPage);

		function prevPage() {
		  
		  $('.flipped')
		    .last()
		    .removeClass('flipped')
		    .addClass('active')
		    .siblings('.page')
		    .removeClass('active');
		}
		function nextPage() {
		  
		  $('.active')
		    .removeClass('active')
		    .addClass('flipped')
		    .next('.page')
		    .addClass('active')
		    .siblings();
		    
		    
		}
	</script>
</body>
</html>