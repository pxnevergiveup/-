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
    <link rel="stylesheet" href="https://cdn.bootcss.com/fullPage.js/2.8.9/jquery.fullPage.min.css" />
    <link rel="stylesheet" type="text/css" href="css/zhuzhan.css">
    <link rel="stylesheet" type="text/css" href="css/nav.css">
    <link rel="stylesheet" type="text/css" href="css/_login.css">
    <link rel="stylesheet" type="text/css" href="css/flavr.css"/>
    <link rel="stylesheet" type="text/css" href="css/animate.css" />
  </head>
  
  <body>
    <div id="fullpage">
        <section id="s0" class="section">
            <!--我来组成头部-->
            <header id="h1">
                <div class="head_shadow"></div>
                <div class="head">
                    <div class="min_head">
                        <div class="link">
                            <ul>
                                <li><a href="#"><i class="fonteditor zhuzhan"></i>主站</a></li>
                            </ul>
                        </div>
                        <c:if test="${sessionScope.p.getPname()==null}">
	                        <div class="head_right">
		                        <div class="login getlogin">
		                           	<i class="fonteditor denglu"></i>登录
		                        </div>
		                        <div class="login">
		                           	<a href="zhuce.jsp">注册</a>
		                        </div>
	                        </div>
                        </c:if>
                        <c:if test="${sessionScope.p.getPname()!=null}">
                        	<div class="nav">
                                <ul>
                                    <li><i class="fonteditor denglu" id="denglu"></i>
                                        <ul id="hover">
                                        	<li>${sessionScope.p.getPname()}</li>
                                            <li><a href="pcenter.jsp">个人中心</a></li>
                                            <li><a href="GHServlet?index=my_reg">我的预约</a></li>
                                            <li><a class="getlogin">重新登录</a></li>
                                            <li><a href="loginServlet?index=clear">退出登录</a></li>
                                        </ul>
                                    </li>
                                    <li><i class="fonteditor" style="font-size:20px">&#xe06d</i>消息
                                        <ul>
                                            <li><a href="TextServlet">收到的赞</a></li>
                                            <li>系统消息</li>
                                            <li>我的消息</li>
                                        </ul>
                                    </li>
                                    <li style="width:200px"><i class="fonteditor" style="font-size:20px">&#xe068</i><a href="GHServlet?index=my_reg">我的预约</a></li>
                                </ul>
                            </div>
                        </c:if>
                    </div>
                    <div class="logo"><a href="#"><img src="image/logo.png" /><span class="logo_font">吉医网</span></a></div>
                </div>
            </header>

            <!--第一屏下半-->
            <section id="s1">
                <!--预约挂号-->
                <div class="nav_0">
                    <header><div class="change"><i class="fonteditor qiehuan"></i><a href="zhuzhan?index=ks">更多科室</a></div></header>
                    <div class="part">
                        <header><i class="fonteditor neike"></i><a href="GHServlet?index=ks_ser&ks=KS01">心血管内科</a></header>
                    </div>
                    <div class="part">
                        <header><i class="fonteditor">&#xe0d6</i><a href="GHServlet?index=ks_ser&ks=KS02">消化内科</a></header>
                    </div>
                    <div class="part">
                        <header><i class="fonteditor">&#xe0d5</i><a href="GHServlet?index=ks_ser&ks=KS03">感染科</a></header>
                    </div>
                    <div class="part">
                        <header><i class="fonteditor pifuke"></i><a href="GHServlet?index=ks_ser&ks=KS04">皮肤科</a></header>
                    </div>
                    <div class="part">
                        <header><i class="fonteditor">&#xe0d4</i><a href="GHServlet?index=ks_ser&ks=KS05">放射科</a></header>
                    </div>
                    <div class="part">
                        <header><i class="fonteditor" style="font-size: 15px">&#xe0d3</i><a href="GHServlet?index=ks_ser&ks=KS06">小儿外科</a></header>
                    </div>
                    <div class="part">
                        <header><i class="fonteditor">&#xe0b2</i><a href="GHServlet?index=ks_ser&ks=KS07">耳鼻喉科</a></header>
                    </div>
                    <div class="part">
                        <header><i class="fonteditor">&#xe0bd</i><a href="GHServlet?index=ks_ser&ks=KS08">骨科</a></header>
                    </div>
                </div>
                
                <!--轮播-->
                <div class="center">
                    <div class="cuboid">
                        <div><a href="https://voice.baidu.com/act/newpneumonia/newpneumonia/?from=osari_pc_3"></a></div>
                        <div><a href="http://yx.haoyisheng.com/yx/news/queryNewsDetaile?id=402854906eb62188016eb621882c0000&articleCategory=17"></a></div>
                        <div><a href="https://jinshuju.net/f/jM9FLe"></a></div>
                        <div><a href="http://www.cmechina.net/cme/qypx.jsp"></a></div>
                    </div>
                    <div class="cuboid">
                        <div><a href="https://voice.baidu.com/act/newpneumonia/newpneumonia/?from=osari_pc_3"></a></div>
                        <div><a href="http://yx.haoyisheng.com/yx/news/queryNewsDetaile?id=402854906eb62188016eb621882c0000&articleCategory=17"></a></div>
                        <div><a href="https://jinshuju.net/f/jM9FLe"></a></div>
                        <div><a href="http://www.cmechina.net/cme/qypx.jsp"></a></div>
                    </div>
                    <div class="cuboid">
                        <div><a href="https://voice.baidu.com/act/newpneumonia/newpneumonia/?from=osari_pc_3"></a></div>
                        <div><a href="http://yx.haoyisheng.com/yx/news/queryNewsDetaile?id=402854906eb62188016eb621882c0000&articleCategory=17"></a></div>
                        <div><a href="https://jinshuju.net/f/jM9FLe"></a></div>
                        <div><a href="http://www.cmechina.net/cme/qypx.jsp"></a></div>
                    </div>

                    <a href="javascript:;" class="prev">&lt;</a>
                    <a href="javascript:;" class="next">&gt;</a>
                </div>
                <!--右导航栏-->
                <div class="nav_1">
                    <div class="mini_nav">
                        <a href="#secondPage">
                            <img src="image/yuan1.png" />名医介绍
                        </a>
                    </div>
                    <div class="mini_nav">
                        <a href="#thirdPage">
                            <img src="image/yuan2.png" />健康资讯
                        </a>
                    </div>
                    <div class="mini_nav">
                        <a href="#fourthPage">
                            <img src="image/yuan3.png" />学术前沿
                        </a>
                    </div>
                    <div class="mini_nav">
                        <a href="#lastPage">
                            <img src="image/yuan4.png" />爱心公益
                        </a>
                    </div>
                </div>
            </section>
        </section>

        <!--第二屏-->
        <section id="s2" class="section">
        <c:forEach items="${sessionScope.doctors}" step="4" varStatus="slide">
        	<div class="slide">
        		<div class="yisheng">
	                <header>名医介绍</header>
	        		<c:forEach var="doctor" items="${sessionScope.doctors}" begin="${slide.index}" end="${slide.index + 3}">
	        			<div class="jieshao">
	                    <header>
	                        <img src="image/yisheng.jpg" />
	                        <span>${doctor.getDname()}</span>
	                        		${doctor.getKsname()}<br />
		                        	 珠海吉大附属医院 
	                    </header>
	                    <content>${doctor.getDjs()}</content>
	                    <div class="zixunyuyue">
	                        <a class="zixun" onclick="zixun('${doctor.getkSno()}','${doctor.getKsname()}')">在线咨询</a>
	                        <a class="yuyue" onclick="yuyue(${doctor.getDno()})">预约挂号</a>
	                    </div>
	                </div>
	        		</c:forEach>
       			</div>
        	</div>
        </c:forEach>           
        </section>
        <!--第三屏-->
        <section id="s3" class="section">
            <div class="frame">
                <div class="jkzixun">
                    <header>健康资讯</header>
                    <div class="content">
                        <ul>
                        <c:forEach var="art" items="${sessionScope.articles1}" begin="0" end="10">
                            <li><a href="ArticleServlet?index=read&add=${art.getAddress()}" target="_blank">${art.getHead()}</a></li>
                        </c:forEach>
                        </ul>                                               
                    </div>
                </div>
            </div>
            <content>
                <!--轮播二-->
                <div class="player">
                    <div class="port">
                        <div class="left"></div>
                        <div class="right" style="background-position-x:100%"></div>                        
                    </div>

                    <div class="port">
                        <div class="left"></div>
                        <div class="right" style="background-position-x:100%"></div>                        
                    </div>

                    <div class="port">
                        <div class="left"></div>
                        <div class="right" style="background-position-x:100%"></div>                        
                    </div>

                    <div class="port">
                        <div class="left"></div>
                        <div class="right" style="background-position-x:100%"></div>                        
                    </div>
 
                </div>
            </content>
        </section>
        <!--第四屏-->
        <section id="s4" class="section">
			<div class="s4_left">
                <div class="s4_left_mini">
                    <header>学术前沿</header>
                    <div class="content">
                        <ul>
                        <c:forEach var="art" items="${sessionScope.articles2}" begin="0" end="10">
                            <li><a href="ArticleServlet?index=read&add=${art.getAddress()}" target="_blank">${art.getHead()}</a></li>
                        </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="s4_player">
                <div class="s4_player_mian">
                    <div class="s4_video"></div>
                    <div class="s4_video"></div>
                    <div class="s4_video"></div>
                    <div class="s4_video"></div>
                </div>
            </div>
        </section>
        <!--第五屏-->
        <section id="s5" class="section">
            <!--轮播三-->
            <div class="player">
                <img src="image/mac.png" />
                <div class="video"><a href="https://www.sohu.com/a/130544759_456084"><img src="image/t1.png" /></a><div class="video_shadow">健康呼吸、快乐骑行“大型公益活动</div></div>
                <div class="video"><a href="https://tech.sina.com.cn/i/2020-01-26/doc-iihnzahk6435421.shtml"><img src="image/t2.png" /></a><div class="video_shadow">杏林春日暖 好医四时香“义诊活动</div></div>
                <div class="video"><a href="https://www.sohu.com/a/259049569_100268179"><img src="image/t3.png" /></a><div class="video_shadow">第二届最美志愿者演讲大赛</div></div>
                <div class="video"><a href="http://www.haoyicn.cn/info/form/index.html"><img src="image/t4.png" /></a><div class="video_shadow">湖北武汉第15个“世界献血者日”主题健步走活动</div></div>
            </div>
            <div class="gengduo">
                <header>吉大公益</header>
                <a href="http://www.haoyicn.cn/info/special/2019/09/002/index.html">抗癫痫患者援助项目</a>
                <a>“激情一夏 我是英雄”献血嘉年华活动 </a>
                <a>三医院烧伤科爱心病房学校</a>
                <a>协和爱心病房</a>
            </div>
        </section>

        <!--我来组成右臂-->
        <div class="box" id="myMenu">
            <a href="#secondPage"class="active"><span>1</span>名医介绍</a>
            <a href="#thirdPage"><span>2</span>健康资讯</a>
            <a href="#fourthPage"><span>3</span>学术前沿</a>
            <a href="#lastPage"><span>4</span>爱心公益</a>
            <a href="#firstPage"><span><i class="fonteditor fanhui"></i></span>返回顶部</a>
        </div>
        <!--登录界面-->
        <div class="login_body">
            <div class="login_main">
                <i class="fonteditor quxiao"></i>
                <div class="logins">
                    <input type="radio" name="rad" id="r1" checked="checked" />
                    <input type="radio" name="rad" id="r2" />
                    <input type="radio" name="rad" id="r3" />
                    <div class="login s1">
                        <header>登录</header>
                        <h4>输入您的账号与密码：</h4>
                        <form class="content" action="loginServlet?index=p" method="post">
                            <div class="text">
                                <input type="text" name="pno" placeholder="账号" required="required" autofocus="autofocus" />
                            </div>
                            <div class="text">
                                <input type="password" name="ppwd" placeholder="密码" required="required" />
                            </div>
                            <input type="submit" class="submit" value="登录" />
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript" src="js/Jquery.js"></script>
    <script type="text/javascript" src="js/jquery.fullPage.min.js"></script>
    <script type="text/javascript" src="js/zhuzhan.js"></script>
    <script type="text/javascript" src="js/flavr.min.js"></script>
    <script type="text/javascript">
    	function yuyue(a){
           	if(${sessionScope.p.getPno()==null}){
           		new $.flavr('预约前请先登录');
           	}
           	else{
           		location.href="GHServlet?index=search&dno="+a;
           	}
        }
        function zixun(a,b){
           	if(${sessionScope.p.getPno()==null}){
           		new $.flavr('咨询前请先登录');
           	}
           	else{
           		location.href="sToRequest?index=p&ksno="+a+"&ksname="+b;
           	}
        }
        function nolog(){
           	if(${sessionScope.p.getPno()==null}){
           		new $.flavr('请先登录');
           	}           
        }
	    $(function(){
	   		$("#hover li").mouseenter(function () {
                $("#denglu").addClass("denglu-hover");
            })
            $("#hover li").mouseleave(function () {
                $("#denglu").removeClass("denglu-hover");
            })
	    	if(${requestScope.p == "0"})
	   		{
	   			new $.flavr({
	    		 	content : '账号密码错误!',
	    			animateEntrance: 'rotateIn',
	                animateClosing: 'rotateOut',
    			});
	   		}	   	
	   		$.ajax({	   		
	            url: 'zhuzhan?index=doctor',
	            type: 'GET'
			}) 
			$.ajax({	   		
	            url: 'ArticleServlet?index=pull',
	            type: 'POST'
			})	  		
	    })
    </script>
</body>
</html>
