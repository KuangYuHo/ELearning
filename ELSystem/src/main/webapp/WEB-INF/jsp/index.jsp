<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en-US" dir="ltr">

  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">


    <!-- ===============================================-->
    <!--    Document Title-->
    <!-- ===============================================-->
    <title>After School eLearning System</title>



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
   $(document).ready(function(){	   
	   $('#dialog').hide();
	   load1();	  
   });
   
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

</head>
	

  <body>

    <!-- ===============================================-->
    <!--    Main Content-->
    <!-- ===============================================-->
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
      
      <section class="pt-6 bg-600" id="home">
        <div class="container">
          <div class="row align-items-center">
            <div class="col-md-5 col-lg-6 order-0 order-md-1 text-end"><img class="pt-7 pt-md-0 w-100" src="assets/img/gallery/hero-header.png" width="470" alt="hero-header" /></div>
            <div class="col-md-7 col-lg-6 text-md-start text-center py-6">
              <h4 class="fw-bold font-sans-serif">快樂孩子王</h4>
              <h1 class="fs-6 fs-xl-7 mb-5">
              After School.. <br>
              Keep Learning <br>
              Keep Interested
              </h1><a class="btn btn-primary me-2" href="#!" role="button">開始探索</a><a class="btn btn-outline-secondary" href="#!" role="button">加入討論</a>
            </div>
          </div>
        </div>
      </section>


      <!-- ============================================-->
      <!-- <section> begin ============================-->
      <section class="py-0" style="margin-top:-5.8rem">

        <div class="container">
          <div class="row">
            <div class="card card-span bg-secondary">
              <div class="card-body">
                <div class="row flex-center gx-0">
                  <div class="col-lg-4 col-xl-2 text-center text-xl-start"><img src="assets/img/gallery/funfacts.png" width="170" alt="..." /></div>
                  <div class="col-lg-8 col-xl-4">
                    <h1 class="text-light fs-lg-4 fs-xl-5">New Course <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-mortarboard-fill" viewBox="0 0 16 16">
  <path d="M8.211 2.047a.5.5 0 0 0-.422 0l-7.5 3.5a.5.5 0 0 0 .025.917l7.5 3a.5.5 0 0 0 .372 0L14 7.14V13a1 1 0 0 0-1 1v2h3v-2a1 1 0 0 0-1-1V6.739l.686-.275a.5.5 0 0 0 .025-.917l-7.5-3.5Z"/>
  <path d="M4.176 9.032a.5.5 0 0 0-.656.327l-.5 1.7a.5.5 0 0 0 .294.605l4.5 1.8a.5.5 0 0 0 .372 0l4.5-1.8a.5.5 0 0 0 .294-.605l-.5-1.7a.5.5 0 0 0-.656-.327L8 10.466 4.176 9.032Z"/>
</svg><br> <span class="text-primary">2022 Winter Camp</span></h1>
                  </div>
                  <div class="col-lg-12 col-xl-6">
                    <h1 class="display-1 text-light text-center text-xl-end">2022  1/21-2/10</h1>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- end of .container-->

      </section>
      <!-- <section> close ============================-->
      <!-- ============================================-->




      <!-- ============================================-->
      <!-- <section> begin ============================-->
      <section>

        <div class="container">
          <div class="row">
            <h1 class="text-center mb-5"> Top Featured Courses</h1>
            <div class="col-md-4 mb-4">
              <div class="card h-100"><img class="card-img-top w-100" src="assets/img/gallery/design.png" alt="courses" />
                <div class="card-body">
                  <h5 class="font-sans-serif fw-bold fs-md-0 fs-lg-1">User Research for User Experience Design</h5><a class="text-muted fs--1 stretched-link text-decoration-none" href="#!">The Museum of Modern Art</a>
                </div>
              </div>
            </div>
            <div class="col-md-4 mb-4">
              <div class="card h-100"><img class="card-img-top w-100" src="assets/img/gallery/psychology.png" alt="courses" />
                <div class="card-body">
                  <h5 class="font-sans-serif fw-bold fs-md-0 fs-lg-1">Buddhism and Modern Psychology</h5><a class="text-muted fs--1 stretched-link text-decoration-none" href="#!">The Museum of Modern Art</a>
                </div>
              </div>
            </div>
            <div class="col-md-4 mb-4">
              <div class="card h-100"><img class="card-img-top w-100" src="assets/img/gallery/philosophy.png" alt="courses" />
                <div class="card-body">
                  <h5 class="font-sans-serif fw-bold fs-md-0 fs-lg-1">Introduction to Philosophy</h5><a class="text-muted fs--1 stretched-link text-decoration-none" href="#!">Duke University</a>
                </div>
              </div>
            </div>
            <div class="col-md-4 mb-4">
              <div class="card h-100"><img class="card-img-top w-100" src="assets/img/gallery/photographs.png" alt="courses" />
                <div class="card-body">
                  <h5 class="font-sans-serif fw-bold fs-md-0 fs-lg-1">Advance on Seeing Through Photographs</h5><a class="text-muted fs--1 stretched-link text-decoration-none" href="#!">Duke University</a>
                </div>
              </div>
            </div>
            <div class="col-md-4 mb-4">
              <div class="card h-100"><img class="card-img-top w-100" src="assets/img/gallery/arguments.png" alt="courses" />
                <div class="card-body">
                  <h5 class="font-sans-serif fw-bold fs-md-0 fs-lg-1">Think Again I: How to Understand Arguments</h5><a class="text-muted fs--1 stretched-link text-decoration-none" href="#!">The Museum of Modern Art</a>
                </div>
              </div>
            </div>
            <div class="col-md-4 mb-4">
              <div class="card h-100"><img class="card-img-top w-100" src="assets/img/gallery/experience-design.png" alt="courses" />
                <div class="card-body">
                  <h5 class="font-sans-serif fw-bold fs-md-0 fs-lg-1">User Research for User Experience Design</h5><a class="text-muted fs--1 stretched-link text-decoration-none" href="#!">The Museum of Modern Art</a>
                </div>
              </div>
            </div>
            <div class="col-md-4 mb-4">
              <div class="card h-100"><img class="card-img-top w-100" src="assets/img/gallery/user-research.png" alt="courses" />
                <div class="card-body">
                  <h5 class="font-sans-serif fw-bold fs-md-0 fs-lg-1">User Research for User Experience Design</h5><a class="text-muted fs--1 stretched-link text-decoration-none" href="#!">The Museum of Modern Art</a>
                </div>
              </div>
            </div>
            <div class="col-md-4 mb-4">
              <div class="card h-100"><img class="card-img-top w-100" src="assets/img/gallery/critical-thinking.png" alt="courses" />
                <div class="card-body">
                  <h5 class="font-sans-serif fw-bold fs-md-0 fs-lg-1">Introduction to Logic and Critical Thinking</h5><a class="text-muted fs--1 stretched-link text-decoration-none" href="#!">Duke University</a>
                </div>
              </div>
            </div>
            <div class="col-md-4 mb-4">
              <div class="card h-100"><img class="card-img-top w-100" src="assets/img/gallery/art-design.png" alt="courses" />
                <div class="card-body">
                  <h5 class="font-sans-serif fw-bold fs-md-0 fs-lg-1">Modern and Contemporary Art and Design</h5><a class="text-muted fs--1 stretched-link text-decoration-none" href="#!">The Museum of Modern Art</a>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- end of .container-->

      </section>
      <!-- <section> close ============================-->
      <!-- ============================================-->


      <section>
        <div class="bg-holder" style="background-image:url(assets/img/gallery/funfacts-2-bg.png);background-position:center;background-size:cover;">
        </div>
        <!--/.bg-holder-->

        <div class="container">
          <div class="row">
            <div class="col-sm-6 col-lg-3 text-center mb-5"><img src="assets/img/gallery/published.png" height="100" alt="..." />
              <h1 class="my-2">768</h1>
              <p class="text-info fw-bold">COURSES PUBLISHED</p>
            </div>
            <div class="col-sm-6 col-lg-3 text-center mb-5"><img src="assets/img/gallery/instructors.png" height="100" alt="..." />
              <h1 class="my-2">120</h1>
              <p class="text-info fw-bold">EXPERT INSTRUCTORS</p>
            </div>
            <div class="col-sm-6 col-lg-3 text-center mb-5"><img src="assets/img/gallery/learners.png" height="100" alt="..." />
              <h1 class="my-2">8300</h1>
              <p class="text-info fw-bold">HAPPY LEARNERS</p>
            </div>
            <div class="col-sm-6 col-lg-3 text-center mb-5"><img src="assets/img/gallery/awards.png" height="100" alt="..." />
              <h1 class="my-2">32</h1>
              <p class="text-info fw-bold">AWARDS ACHIEVED</p>
            </div>
          </div>
        </div>
      </section>


      <!-- ============================================-->
      <!-- <section> begin ============================-->
      <section>

        <div class="container">
          <div class="row align-items-center">
            <div class="col-md-6 col-lg-4 mb-5"><img src="assets/img/gallery/cta.png" width="280" alt="cta" /></div>
            <div class="col-md-6 col-lg-5">
              <h1 class="mb-5"><font face="serif">訂閱我們</font></h1>
              <form class="row g-0 align-items-center">
                <div class="col">
                  <div class="input-group-icon">
                    <input class="form-control form-little-squirrel-control" type="email" placeholder="Enter email " aria-label="email" /><i class="fas fa-envelope input-box-icon"></i>
                  </div>
                </div>
                <div class="col-auto">
                  <button class="btn btn-primary rounded-0" type="submit">訂閱</button>
                </div>
              </form>
            </div>
          </div>
        </div>
        <!-- end of .container-->

      </section>
      <!-- <section> close ============================-->
      <!-- ============================================-->




      <!-- ============================================-->
      <!-- <section> begin ============================-->
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
    <!-- ===============================================-->
    <!--    End of Main Content-->
    <!-- ===============================================-->




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
  </body>

</html>