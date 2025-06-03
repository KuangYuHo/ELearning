<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>註冊</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">


<!-- ===============================================-->
    <!--    JavaScripts-->
    <!-- ===============================================-->
    <script src="vendors/@popperjs/popper.min.js"></script>
    <script src="vendors/bootstrap/bootstrap.min.js"></script>
    <script src="vendors/is/is.min.js"></script>
    <script src="https://polyfill.io/v3/polyfill.min.js?features=window.scroll"></script>
    <script src="vendors/fontawesome/all.min.js"></script>
    <script src="assets/js/theme.js"></script>

    <link href="https://fonts.googleapis.com/css2?family=DM+Serif+Display&amp;family=Rubik:wght@300;400;500;600;700;800&amp;display=swap" rel="stylesheet">
	
	
	
    <!-- ===============================================-->
    <!--    Favicons-->
    <!-- ===============================================-->
    <link rel="apple-touch-icon" sizes="180x180" href="/assets/img/favicons/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="/assets/img/favicons/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="/assets/img/favicons/favicon-16x16.png">
    <link rel="shortcut icon" type="image/x-icon" href="/assets/img/favicons/favicon.ico">
    <link rel="manifest" href="/assets/img/favicons/manifest.json">
    <meta name="msapplication-TileImage" content="/assets/img/favicons/mstile-150x150.png">
    <meta name="theme-color" content="#ffffff">


    <!-- ===============================================-->
    <!--    Stylesheets-->
    <!-- ===============================================-->
    <link href="/assets/css/theme.css" rel="stylesheet" />

	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>

<style>
	/* ----------------------------------- 以下是下拉式選單的CSS*/
.main-menu { color:#000000; background-color:transparent; padding:10px; margin:0px 0px 0px 0px; cursor:pointer; display:inline-block; } /* 主選單的樣式 */
.main-menu:hover { background-color:#FFD306; }
.sub-menu { color:#0000FF; background-color:#FFFF93; opacity:0.8; margin:10px -10px; padding:0px 1px; list-style-type:none; position:absolute; } /* 下拉清單的樣式 */
.sub-menu li { padding: 0px 10px; margin: 10px 0px; text-align:left; } /* 下拉清單每一列的樣式 */
.sub-menu li:hover { color:#FFFFFF; background-color:#FFD306;  }
.sub-menu a { text-align:left; display:block; text-decoration:none; color:#000000; }
.sub-menu a:hover { color:#000000; background-color:#FFD306; text-decoration:none; }
</style>


<script type="text/javascript">

	var accounti = 'kevin06026';
	var namei = '何寬猷';
	var emaili ='kuangyuho626@gmail.com';
	var addressi = '新竹市光復路5號';
	var phonei = '0988635179';
	var identityi = 'O100685431';
	var passwordi = 'kevin123';

	
	$(document).ready(function(){
		$('#dialog').hide();
		load1();	 
		loadYear();
		loadmonth();
		 $("#onebtnreg").click(function(){
			 	//var rnd = Math.floor(Math.random()*2);
			 	//console.log(rnd);
		    	$("#accountinput").val(accounti);
		    	$("#nameinput").val(namei);
		    	$("#emailinput").val(emaili);
		    	$("#addressinput").val(addressi);
		    	$("#phoneinput").val(phonei);
		    	$("#identityinput").val(identityi);
				$("#passwordinput").val(passwordi);

		    })
	});
		
	function loadYear(){
		for(var i = 1900;i<2023;i++){
			$("#birthYselect").append(new Option(i,i));
		};
	};
	
	function loadmonth(){
		var month = [1,2,3,4,5,6,7,8,9,10,11,12];
		$.each(month,function(i,item){
			console.log(i, item);
			$("#birthMselect").append(new Option(item,item));
		});
	};


    function yearChange(){
    	console.log("year select!");
    	$("#birthMselect").removeAttr("disabled");
    }
	
    function monthChange(){
    	console.log("month select!");
    	$("#birthDselect").empty();
    	$("#birthDselect").removeAttr("disabled");
    	var y= $("#birthYselect").val();
    	var m= $("#birthMselect").val();
    	var iy= parseInt(y,10);
    	var im= parseInt(m,10);

    	console.log("y : " + y);
    	console.log("M : " + m);
    	
    	if(im<8){
    		if(im==2){
    			if(iy%4==0&&iy%100!=0||iy%400==0){
    	    		console.log(iy + "年是閏年");
    	    		giveSelectD(29);
    	    	}
    	    	else{
    	    		console.log(iy + "年不是閏年");
    	    		giveSelectD(28);
    	    	}
    		}
    		else if(im%2==0){
    			giveSelectD(30);
    		}
    		else if(im%2==1){
    			giveSelectD(31);
    		}
    	}
    	else{
    		 if(im%2==0){
     			giveSelectD(31);
     		}
     		else if(im%2==1){
     			giveSelectD(30);
     		}
    	}
    		
    }
    
    function giveSelectD(day){
    	var iday=parseInt(day,10);
    	for(var i = 1;i<=iday;i++){
			$("#birthDselect").append(new Option(i,i));
		};
    }
    
    function load1(){
 	   <%
 		Object currentuser = session.getAttribute("LoginOK");
 		Object currentAuth = session.getAttribute("loginAuth");
 	   %>
 	   var loginUser  = "<%=currentuser%>" ;
 	   var loginAuth  = "<%=currentAuth%>" ;

 	   if(loginUser == 'null'){
 		   console.log(loginUser);
 		   
 		   $('#loginmenu').hide();
 		   $('#logoutbtn').hide();
 		   $('#post2').hide();
 		   $('#managemenu').hide();

 		   
 		   console.log("未登入");
 		   } 
 	   else{
  
 		   if(loginAuth!=3){
 			   $('#managemenu').hide();
 		   }
     	   $('#loginbtn').hide();
     	   $('#registerbtn').hide();
     	   $('#post1').hide();
     	   document.getElementById("post").href = "http://localhost:8082/addpost/allaction2.controller";
 		   console.log(loginUser);
 		   console.log("已登入");	  
 	   }
 	 }
 		var VisibleMenu = ''; // 記錄目前顯示的子選單的 ID

 		// 顯示或隱藏子選單
 		function switchMenu( theMainMenu, theSubMenu, theEvent ){
 		    var SubMenu = document.getElementById( theSubMenu );
 		    if( SubMenu.style.display == 'none' ){ // 顯示子選單
 		        SubMenu.style.minWidth = theMainMenu.clientWidth; // 讓子選單的最小寬度與主選單相同 (僅為了美觀)
 		        SubMenu.style.display = 'block';
 		        hideMenu(); // 隱藏子選單
 		        VisibleMenu = theSubMenu;
 		    }
 		    else{ // 隱藏子選單
 		        if( theEvent != 'MouseOver' || VisibleMenu != theSubMenu ){
 		            SubMenu.style.display = 'none';
 		            VisibleMenu = '';
 		        }
 		    }
 		}

 		// 隱藏子選單
 		function hideMenu(){
 		    if( VisibleMenu != '' ){
 		        document.getElementById( VisibleMenu ).style.display = 'none';
 		    }
 		    VisibleMenu = '';
 		}
  
    
</script>
</head>
<body>
<main class="main" id="top">

<section class="bg-primary py-2 d-none d-sm-block">

        <div class="container">
          <div class="row align-items-center">
            <div class="col-auto d-none d-lg-block">
               <p class="my-2 fs--1"><i class="fas fa-map-marker-alt me-3"></i><span>106台北市大安區復興南路一段390號2樓 </span></p>           </div>
            <div class="col-auto ms-md-auto order-md-2 d-none d-sm-block">
              <ul class="list-unstyled list-inline my-2">
                <li class="list-inline-item"><a class="text-decoration-none" href="#!"><i class="fab fa-facebook-f text-900"></i></a></li>
                <li class="list-inline-item"><a class="text-decoration-none" href="#!"><i class="fab fa-pinterest text-900"></i></a></li>
                <li class="list-inline-item"><a class="text-decoration-none" href="#!"><i class="fab fa-twitter text-900"></i></a></li>
                <li class="list-inline-item"><a class="text-decoration-none" href="#!"><i class="fab fa-instagram text-900"> </i></a></li>
              </ul>
            </div>
            <div class="col-auto">
              <p class="my-2 fs--1"><i class="fas fa-envelope me-3"></i><a class="text-900">service@afterschool.com</a></p>
            </div>
          </div>
        </div>
        <!-- end of .container-->

      </section>
      <!-- <section> close ============================-->
      <!-- ============================================-->


      <nav class="navbar navbar-expand-lg navbar-light sticky-top py-3 d-block" data-navbar-on-scroll="data-navbar-on-scroll">
        <div class="container"><a class="navbar-brand" href="/index"><img src="/assets/img/gallery/logo-n.png" height="45" alt="logo" /></a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"> </span></button>
          <div class="collapse navbar-collapse border-top border-lg-0 mt-4 mt-lg-0" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto pt-2 pt-lg-0 font-base">
              <li class="main-menu" onmouseover="switchMenu( this, 'SubMenu5', 'MouseOver' )" onmouseout="hideMenu()">開始探索 <span style="font-size:9px;">&#9660;</span>
              	<ul id="SubMenu5" class="sub-menu" style="display:none;">
			        <li><a href="<c:url value='/lesson/lessonlist.controller'/>">搜尋課程</a></li>
			        <li><a href="<c:url value='/article/articlelist.controller'/>">好文分享</a></li>
			        <li id="post1"><a href="<c:url value='/addpost/allaction1.controller'/>">論壇</a></li>
			        <li id="post2"><a href="<c:url value='/addpost/allaction2.controller'/>">論壇</a></li>
			        
			    </ul>
              </li>
              
              <li id="loginmenu" class="main-menu" onmouseover="switchMenu( this, 'SubMenu2', 'MouseOver' )" onmouseout="hideMenu()">會員中心<span style="font-size:9px;">&#9660;</span>
              	<ul id="SubMenu2" class="sub-menu" style="display:none;">
			        <li><a href="<c:url value='/member/goupdateme'/>">會員資料</a></li>
			        <li><a href="<c:url value='/orders/ordersmain.controller'/>">我的課程</a></li>	        
			        <li><a href="<c:url value='/orders/orderspage'/>">購物明細</a></li>
			        <li><a href="<c:url value='/shoppingcart/shoppingcartmain.controller'/>">我的購物車</a></li>
			        
			    </ul>
              </li>
              <li id= "managemenu" class="main-menu" onmouseover="switchMenu( this, 'SubMenu1', 'MouseOver' )" onmouseout="hideMenu()">管理中心 <span style="font-size:9px;">&#9660;</span>
              	<ul id="SubMenu1" class="sub-menu" style="display:none;">
			        <li><a href="<c:url value='/manage/membermanage1'/>">會員管理</a></li>
			        <li><a href="<c:url value='/article/showarticle.controller'/>">文章管理</a></li>
			        <li><a href="<c:url value='/orders/findallorders'/>">訂單總表</a></li>
			        <li><a href="<c:url value='/addpost/allaction3.controller'/>">論壇管理</a></li>
			        <li><a href="<c:url value='/lesson/showlesson.controller'/>">課程管理</a></li>
			        
			    </ul>
              </li>
             
            </ul>
            <a id="loginbtn"  class="btn btn-primary order-1 order-lg-0" href="/login/page">登入</a>		
            <a id="registerbtn" class="btn btn-primary order-1 order-lg-0" href="/goRegister">註冊</a>
            <a id="logoutbtn" class="btn btn-primary order-1 order-lg-0" href="/logout">登出</a>
			</div> 
          </div>
      </nav>


<div class="row justify-content-center">
<div class="col-md-6">
<div class="card" >
<header class="card-header" style="background-color:#FDC800">
	<button id="onebtnreg" class="float-right btn btn-outline-primary mt-1">一鍵註冊</button>
	<h4 class="card-title mt-2"><b><font face="serif">註冊</font></b></h4>
</header>
<article class="card-body">
<form:form action="memberRegister.controller" method="post" modelAttribute="registerMem">
	<div class="form-row">
		<div class="col form-group">
			<form:label path="account" value="">帳號:</form:label>   
		  	<form:input id="accountinput" path="account" type="text" class="form-control" placeholder=""/>
		</div> <!-- form-group end.// -->
		<div class="col form-group">
			<form:label path="mName" value="">姓名:</form:label>
		  	<form:input id="nameinput" path="mName"  type="text" class="form-control" placeholder=" "/>
		</div> <!-- form-group end.// -->
	</div> <!-- form-row end.// -->
	<div class="form-group">
		<form:label path="email" value="">Email:</form:label>
		<form:input id="emailinput" path="email" type="email" class="form-control" placeholder=""/>
		<small class="form-text text-muted">We'll never share your email with anyone else.</small>
	</div> <!-- form-group end.// -->
	<div class="form-group">
		<form:label path="gender">性别：</form:label>
			<form:radiobutton path="gender" checked="checked" value="男" label="男" /> 
            <form:radiobutton path="gender" value="女" label="女" />
            <form:radiobutton path="gender" value="多元" label="多元" />
	</div> <!-- form-group end.// -->
	<div class="form-group">
		<form:label path="mAddress" value="">地址:</form:label>
		<form:input id="addressinput" path="mAddress" type="text" class="form-control" placeholder=""/>
	</div>
	<div class="form-row">
		<div class="form-group col-md-6">
		  <form:label path="phone" value="">電話:</form:label>
		  <form:input id="phoneinput" path="phone" type="text" class="form-control"/>
		</div> <!-- form-group end.// -->
		<div class="form-group col-md-6">
		  <form:label path="identityID" value="">身份證字號:</form:label>
		  <form:input id="identityinput" path="identityID" type="text" class="form-control"/>
		</div>
		
	</div> <!-- form-row.// -->
	<div class="form-row">
	<label>生日:</label>
	</div>
	<div class="form-row">
		  
		  
		  <div class="form-group col-md-3">
		  
		  <select class="form-control" id="birthYselect" name="byear" onchange="yearChange()"></select>
		  </div>
		  <div>年</div>
		  <div class="form-group col-md-3">
			  <select class="form-control" id="birthMselect" name="bmonth" disabled="disabled" onchange="monthChange()"></select>
    	  </div>
    	  <div>月</div>
    	  <div class="form-group col-md-3">
    		  <select class="form-control" id="birthDselect" name="bday" disabled="disabled"></select>
	      </div>
	      <div>日</div>
	</div> <!-- form-group end.// -->
	<div class="form-group">
		<form:label path="mPassword" value="">密碼:</form:label>
	    <form:input id="passwordinput" path="mPassword" class="form-control" type="password"/>
	</div> <!-- form-group end.// -->  
    <div class="form-group">
        <button type="submit" class="btn btn-primary btn-block"> Register  </button>
    </div> <!-- form-group// -->      
    <small class="text-muted">By clicking the 'Sign Up' button, you confirm that you accept our <br> Terms of use and Privacy Policy.</small>                                          
</form:form>
</article> <!-- card-body end .// -->
</div> <!-- card.// -->
</div> <!-- col.//-->

</div> <!-- row.//-->


<!--container end.//-->
	
	<section class="bg-secondary">

        <div class="container">
          <div class="row">
            <div class="col-12 col-sm-12 col-lg-6 mb-4 order-0 order-sm-0"><a class="text-decoration-none" href="#"><img src="assets/img/gallery/footer-logo.png" height="51" alt="" /></a>
              <p class="text-light my-4"> <i class="fas fa-map-marker-alt me-3"></i><span class="text-light">106台北市大安區復興南路一段390號2樓</span>
              <p class="text-light"> <i class="fas fa-envelope me-3"> </i><a class="text-light" href="service@afterschool.com">service@afterschool.com</a></p>
              <p class="text-light"> <i class="fas fa-phone-alt me-3"></i><a class="text-light"> 02-01230009</a></p>
            </div>
            
          </div>
        </div>
        <!-- end of .container-->

      </section>
      <!-- <section> close ============================-->
      <!-- ============================================-->


      <section class="py-0" style="margin-top: -5.8rem;">
        <div class="container bg-primary">
          <div class="row justify-content-md-between justify-content-evenly py-4">
            <div class="col-12 col-sm-8 col-md-6 col-lg-auto text-center text-md-start">
              <p class="fs--1 my-2 fw-bold">All rights Reserved &copy; After Shool e-learning System   2021</p>
            </div>
           
          </div>
        </div>
      </section>
	
</main>	
</body>
</html>