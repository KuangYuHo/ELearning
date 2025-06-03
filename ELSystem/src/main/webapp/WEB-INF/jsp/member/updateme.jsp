<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改個人資料</title>

<!-- ===============================================-->
    <!--    JavaScripts-->
    <!-- ===============================================-->
    <script src="/vendors/@popperjs/popper.min.js"></script>
    <script src="/vendors/bootstrap/bootstrap.min.js"></script>
    <script src="/vendors/is/is.min.js"></script>
    <script src="https://polyfill.io/v3/polyfill.min.js?features=window.scroll"></script>
    <script src="/vendors/fontawesome/all.min.js"></script>
    <script src="/assets/js/theme.js"></script>

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

</head>
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
<link rel="stylesheet" href="/css/updatemember.css">

<script type="text/javascript">
	$(document).ready(function() {
		console.log(${year});
		loadBirth();
		$('#dialog').hide();
		load1();
	});

	function loadBirth() {
		for (var i = 1900; i < 2023; i++) {
			$("#birthYselect").append(new Option(i, i));
			if(i==${year}){
				$('#birthYselect option[value=${year}]').attr('selected', 'selected');
			}
		}
		
		
		var month = [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 ];
		$.each(month, function(i, item) {
			$("#birthMselect").append(new Option(item, item));
			if(item==${month}){
				$('#birthMselect option[value=${month}]').attr('selected', 'selected');
			}
		});
		
		$("#birthDselect").empty();
		var y = ${year}
		var m = ${month}
		var iy = parseInt(y, 10);
		var im = parseInt(m, 10);

		if (im < 7) {
			if (im == 2) {
				if (iy % 4 == 0 && iy % 100 != 0 || iy % 400 == 0) {
					console.log(iy + "年是閏年");
					giveSelectD(29);
				} else {
					console.log(iy + "年不是閏年");
					giveSelectD(28);
				}
			} else if (im % 2 == 0) {
				giveSelectD(30);
			} else if (im % 2 == 1) {
				giveSelectD(31);
			}
		} else {
			if (im % 2 == 0) {
				giveSelectD(30);
			} else if (im % 2 == 1) {
				giveSelectD(31);
			}
		}
	};


	function monthChange() {
		console.log("month select!");
		$("#birthDselect").empty();
		var y = $("#birthYselect").val();
		var m = $("#birthMselect").val();
		var iy = parseInt(y, 10);
		var im = parseInt(m, 10);

		console.log("y : " + y);
		console.log("M : " + m);

		if (im < 8) {
			if (im == 2) {
				if (iy % 4 == 0 && iy % 100 != 0 || iy % 400 == 0) {
					console.log(iy + "年是閏年");
					giveSelectD(29);
				} else {
					console.log(iy + "年不是閏年");
					giveSelectD(28);
				}
			} else if (im % 2 == 0) {
				giveSelectD(30);
			} else if (im % 2 == 1) {
				giveSelectD(31);
			}
		} else {
			if (im % 2 == 0) {
				giveSelectD(31);
			} else if (im % 2 == 1) {
				giveSelectD(30);
			}
		}
	}

	function giveSelectD(day) {
		var iday = parseInt(day, 10);
		for (var i = 1; i <= iday; i++) {
			$("#birthDselect").append(new Option(i, i));
		}
		$('#birthDselect option[value=${day}]').attr('selected', 'selected');

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
            <a id="logoutbtn" class="btn btn-warning order-1 order-lg-0" href="/logout">登出</a>
			</div> 
          </div>
      </nav>
  <div class="main-content">

    <!-- Header -->
    <div class="header pb-8 pt-5 pt-lg-8 d-flex align-items-center" style="min-height: 600px; background-image: url(/images/bg-01.jpg); background-size: cover; background-position: center top;">
      <!-- Mask -->
      <span class="mask bg-gradient-default opacity-8"></span>
      <!-- Header container -->
      <div class="container-fluid d-flex align-items-center">
        <div class="row">
          <div class="col-lg-7 col-md-10">
            <h1 class="display-2 text-white">Hello ${uMem.mName}</h1>
            <p class="text-white mt-0 mb-5">This is your profile page. You can see the progress you've made with your work and manage your projects or assigned tasks</p>
          </div>
        </div>
      </div>
    </div>
    <!-- Page content -->
    <div class="container-fluid mt--7">
      <div class="row">
        <div class="col-xl-4 order-xl-2 mb-5 mb-xl-0">
          <div class="card card-profile shadow" style="background-color: #E0E0E0">
            <div class="row justify-content-center">
              <div class="col-lg-3 order-lg-2">
                <div class="card-profile-image">
                  <a href="#">
                    <img src="${uMem.photo}" class="rounded-circle">
                  </a>
                </div>
              </div>
            </div>
            <div class="card-header text-center border-0 pt-8 pt-md-4 pb-0 pb-md-4" style="background-color: #E0E0E0">
              <div class="d-flex justify-content-between">
              </div>
            </div>
            <div class="card-body pt-0 pt-md-4">
              <div class="row">
                <div class="col">
                  <div class="card-profile-stats d-flex justify-content-center mt-md-5">
                    
                  </div>
                </div>
              </div>
              <div class="text-center">
                <h3>
                  ${uMem.mName}<span class="font-weight-light">,${year}</span>
                </h3>
                <div class="h5 font-weight-300">
                  <i class="ni location_pin mr-2"></i>${uMem.mAddress}
                </div>
                <div class="h5 mt-4">
                  <i class="ni business_briefcase-24 mr-2"></i>
                  <form action="/upload/${uMem.memberID}" method="post" enctype="multipart/form-data">
		   			<input type="file" name="file" />
		  			<input type="submit" value="檔案上傳" />
	    		  </form>
                </div> 
              </div>
            </div>
          </div>
        </div>
        <div class="col-xl-8 order-xl-1">
          <div class="card bg-secondary shadow">
            <div class="card-header bg-white border-0" style="background-color: #E0E0E0">
              <div class="row align-items-center">
                <div class="col-8">
                  <h3 class="mb-0">我的資料</h3>
                </div>
                
              </div>
            </div>
            <div class="card-body" style="background-color: #E0E0E0">
              <form:form action="updateOne.controller" method="post" modelAttribute="uMem">
                <h6 class="heading-small text-muted mb-4">帳戶資料</h6>
                <div class="pl-lg-4">
                  <div class="row">
                    <div class="col-lg-6">
                      <div class="form-group focused">
                        <label class="form-control-label" >帳號</label><br>
                        <label class="form-control-label">${uMem.account}</label>
                      </div>
                    </div>
                    
                  </div>
                  <div class="row">
                     <div class="col-lg-6">
                      <div class="form-group">
                        <form:label path="email" class="form-control-label" value="${email}">Email</form:label>
                        <form:input path="email" class="form-control form-control-alternative" />
                        
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group focused">
                        <form:label path="mName" class="form-control-label"  value="${mName}">姓名</form:label>
                        <form:input path="mName" class="form-control form-control-alternative" />
                      </div>
                    </div>
                  </div>
                </div>
                <hr class="my-4">
                <!-- Address -->
                <h6 class="heading-small text-muted mb-4">個人資料</h6>
                <div class="pl-lg-4">
                  <div class="row">
                    <div class="col-md-12">
                      <div class="form-group focused">
                        <form:label path="mAddress" class="form-control-label" value="${mAddress}" >地址</form:label>
                        <form:input path="mAddress"  class="form-control form-control-alternative" placeholder="台北市大安區"/>
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-lg-4">
                      <div class="form-group focused">
                        <form:label path="phone" class="form-control-label"  value="${phone}">電話</form:label>
                        <form:input path="phone" type="text"  class="form-control form-control-alternative" placeholder="09XXXXXXXX" />
                      </div>
                    </div>
                    <div class="col-lg-4">
                      <div class="form-group focused">
                        <form:label path="identityID" class="form-control-label" value="${identityID}">身分證字號</form:label>
                        <form:input path="identityID" type="text"  class="form-control form-control-alternative" placeholder="A123456789" />
                      </div>
                    </div>    
                    <div class="col-lg-4">
                      <div class="form-group focused">
                        <form:label path="gender"  class="form-control-label">性别：</form:label><br>
                 			<form:radiobutton path="gender" value="男" label="男" /> 
                	 		<form:radiobutton path="gender" value="女" label="女" />
                		 	<form:radiobutton path="gender" value="多元" label="多元" />
                      </div>
                    </div>     
                  </div>
                  <div class="row">
                    <div class="col-md-12">
                      <div class="form-group focused">
                        <label class="form-control-label" for="input-username">生日</label><br>
                        	<select id="birthYselect" name="byear"></select>年
						 	<select id="birthMselect" name="bmonth" onchange="monthChange()"></select>月
    			 	 		<select id="birthDselect" name="bday"></select>日
                      </div>
                    </div>
                  </div>
                </div>
                <form:button class="btn btn-sm btn-warning" value="send">儲存</form:button>
                <hr class="my-4">
              </form:form>
              <form action="updatepwd.controller" method="post">
              <div class="row">
                 <div class="col-lg-4">
                    <div class="form-group">
						<label class="form-control-label" >目前密碼:</label><br>
						<input class="form-control form-control-alternative" type="password" id="nowpwd" type="password" name="nowpwd" value=""><br>
					</div>
				 </div>
				<div class="col-lg-4">
                    <div class="form-group">
						<label class="form-control-label" >新密碼:</label><br>
			  			<input class="form-control form-control-alternative" type="text" id="newpwd" type="password" name="newpwd" value=""><br>
			  		</div>
				</div>
				<div class="col-lg-4">
                      <div class="form-group">
					  	<label class="form-control-label">確認新密碼:</label><br>
					  	<input class="form-control form-control-alternative" type="text" id="checknewpwd" type="password" name="checknewpwd" value=""><br>
			  		  </div>
				</div>
			  </div>
			  	<div class="row">
			  		<input class="btn btn-sm btn-warning" type="submit" style="width:67.2px;height:28px; position:relative; left:10px; top: 0px;"value="變更密碼" >
			  	</div>
			 </form>
            
          </div>
        </div>
      </div>
    </div>
  </div>
  </div>
  
  <!--  footer從這裡開始  -->

	  <section class="bg-secondary" style="background-color: #002147">

        <div class="container">
          <div class="row">
            <div class="col-12 col-sm-12 col-lg-6 mb-4 order-0 order-sm-0"><a class="text-decoration-none" href="#"><img src="/assets/img/gallery/footer-logo.png" height="51" alt="" /></a>
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