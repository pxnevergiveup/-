<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>在线咨询平台</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="css/chat.css">
    <link rel="stylesheet" type="text/css" href="css/nav.css">
    <link rel="stylesheet" type="text/css" href="css/_login.css">
  </head>
  
  <body>
    <header>${requestScope.user.getMsgKsname()}咨询室</header>
    <div class="chat">
        <div class="chat-left">
            <header>在线医生</header>
            <ul id="userlist">
		   <!-- <li>张三</li>
                <li>李四</li>
                <li>王五</li>
                <li>赵六</li> -->
            </ul>
        </div>
        <div class="chat-content">
            <div class="chat-main">
                <div class="mini-main">
                <!-- 格式： -->
                    <!-- <div class="mini l">
                        <div class="line"><div class="nickname">张三</div></div>
                        <i class="fonteditor avatar"></i>                               
                        <div class="minitext">一二三四五六七八九十</div>
                    </div>
                    <div class="mini">
                        <div class="line"><div class="xitong">系统消息</div></div>                        
                    </div>
                    <div class="mini r">
                        <div class="line"><div class="nickname">张三</div></div>
                        <i class="fonteditor avatar"></i>
                        <div class="minitext">一二三四五六七八九十</div>
                    </div> -->
                </div>
            </div>
            <div class="chat-send">
                <textarea id="text"></textarea>
                <div class="send">
                    <button id="send">发送</button>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript" src="js/Jquery.js"></script>
     <script>
     	var ws;
     	var msg;
	    var ws_url="ws://localhost:8080/newHospital/chat?Name=${requestScope.user.getMsgOder()}&no=${requestScope.user.getMsgNo()}&ksno=${requestScope.user.getMsgKsno()}&type=${requestScope.user.getMsgType()}";
	    $(function () {
        	ws_connect();
            $("textarea").keydown(function () {
                if (event.keyCode == "13") {
                    event.preventDefault();
                    $('#send').click();
                }
            })            
    		$("#send").click(function(){
    			ws_sendMsg();
    		});
        })
    	function ws_connect(){
			if('WebSocket' in window){
			    ws = new WebSocket(ws_url);
			}else if('MozWebSocket' in window){
			    ws = new MozMozWebSocket(ws_url);
			}else{
			    alert("你的浏览器不支持");
			    return;
			}			
			ws.onopen = function(){
		        console.log("连接成功");
		    }		 
		    ws.onclose = function(){
		        console.log("退出连接");
		    }		
		    window.onbeforeunload = function () {
        		ws.close();
     		} 
		    ws.onmessage = function (event){
		    	msg = JSON.parse(event.data);
		    	console.info(msg);
		    	console.info(msg.userList);
		    	if(msg.msgOppo=="s"){
		    		$(".mini-main").append("<div class='mini'><div class='line'><div class='xitong'>"+msg.msgInfo+"</div></div></div>")		    		
		    		scroll();	
		    		userlist();		    		
		    	}
		    	else if(msg.msgOppo=="u")
		    	{
		    		if(msg.msgType=="doctor"){
				        if(msg.msgNo==${requestScope.user.getMsgNo()}){
				        	$(".mini-main").append("<div class='mini r'><div class='line'><div class='nickname'>医生："+msg.msgOder+"</div></div><i class='fonteditor avatar'></i><div class='minitext'>"+msg.msgInfo+"</div></div>")
				        	scroll();
				        }
				        else{
				        	$(".mini-main").append("<div class='mini l'><div class='line'><div class='nickname'>医生："+msg.msgOder+"</div></div><i class='fonteditor avatar'></i><div class='minitext'>"+msg.msgInfo+"</div></div>")
				        	scroll();
				        }
		       	 	}
		        	else if(msg.msgType=="p"){
			        	if(msg.msgNo==${requestScope.user.getMsgNo()}){
				        	$(".mini-main").append("<div class='mini r'><div class='line'><div class='nickname'>"+msg.msgOder+"</div></div><i class='fonteditor avatar'></i><div class='minitext'>"+msg.msgInfo+"</div></div>")
				        	scroll();
				        }
				        else{
				        	$(".mini-main").append("<div class='mini l'><div class='line'><div class='nickname'>"+msg.msgOder+"</div></div><i class='fonteditor avatar'></i><div class='minitext'>"+msg.msgInfo+"</div></div>")
				        	scroll();
				        }
			        }
		    	}
		    }		 
		    ws.onerror = function(){
		        console.log("连接出错");
		    }	
		    	 
    	}
    	function ws_sendMsg(){
    		ws.send($("#text").val());
    		$("#text").val("");
    	}
		
        function scroll(){
        	$(".mini-main").scrollTop($(".mini-main")[0].scrollHeight);
        }
        function userlist(){
        	var html="";
        	var users = msg.userList;
        	for(var i in users)
	       	{
	       		html+="<li>"+users[i]+"</li>";     		
	       	}
	       	$("#userlist").html(html);
        }
     </script>
  </body>
</html>
