<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Lesson</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" href="/css/ordersystem.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
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
<style>
body {
    color: #566787;
    background: #f5f5f5;
    font-family: 'Varela Round', sans-serif;
    font-size: 13px;
}
.table-responsive {
    margin: 30px 0;
}
.table-wrapper {
    min-width: 1000px;
    background: #fff;
    padding: 20px 25px;
    border-radius: 3px;
    box-shadow: 0 1px 1px rgba(0,0,0,.05);
}
.table-title {
    padding-bottom: 15px;
    background: #299be4;
    color: #fff;
    padding: 16px 30px;
    margin: -20px -25px 10px;
    border-radius: 3px 3px 0 0;
}
.table-title h2 {
    margin: 5px 0 0;
    font-size: 24px;
}
.table-title .btn {
    color: #566787;
    float: right;
    font-size: 13px;
    background: #fff;
    border: none;
    min-width: 50px;
    border-radius: 2px;
    border: none;
    outline: none !important;
    margin-left: 10px;
}
.table-title .btn:hover, .table-title .btn:focus {
    color: #566787;
    background: #f2f2f2;
}
.table-title .btn i {
    float: left;
    font-size: 21px;
    margin-right: 5px;
}
.table-title .btn span {
    float: left;
    margin-top: 2px;
}
table.table tr th, table.table tr td {
    border-color: #e9e9e9;
    padding: 12px 15px;
    vertical-align: middle;
}
table.table tr th:first-child {
    width: 60px;
}
table.table tr th:last-child {
    width: 100px;
}
table.table-striped tbody tr:nth-of-type(odd) {
    background-color: #fcfcfc;
}
table.table-striped.table-hover tbody tr:hover {
    background: #f5f5f5;
}
table.table th i {
    font-size: 13px;
    margin: 0 5px;
    cursor: pointer;
}	
table.table td:last-child i {
    opacity: 0.9;
    font-size: 22px;
    margin: 0 5px;
}
table.table td a {
    font-weight: bold;
    color: #566787;
    display: inline-block;
    text-decoration: none;
}
table.table td a:hover {
    color: #2196F3;
}
table.table td a.settings {
    color: #2196F3;
}
table.table td a.delete {
    color: #F44336;
}
table.table td i {
    font-size: 19px;
}
table.table .avatar {
    border-radius: 50%;
    vertical-align: middle;
    margin-right: 10px;
}
.status {
    font-size: 30px;
    margin: 2px 2px 0 0;
    display: inline-block;
    vertical-align: middle;
    line-height: 10px;
}
.text-success {
    color: #10c469;
}
.text-info {
    color: #62c9e8;
}
.text-warning {
    color: #FFC107;
}
.text-danger {
    color: #ff5b5b;
}
.pagination {
    float: right;
    margin: 0 0 5px;
}
.pagination li a {
    border: none;
    font-size: 13px;
    min-width: 30px;
    min-height: 30px;
    color: #999;
    margin: 0 2px;
    line-height: 30px;
    border-radius: 2px !important;
    text-align: center;
    padding: 0 6px;
}
.pagination li a:hover {
    color: #666;
}	
.pagination li.active a, .pagination li.active a.page-link {
    background: #03A9F4;
}
.pagination li.active a:hover {        
    background: #0397d6;
}
.pagination li.disabled i {
    color: #ccc;
}
.pagination li i {
    font-size: 16px;
    padding-top: 6px
}
.hint-text {
    float: left;
    margin-top: 10px;
    font-size: 13px;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	var indexPage = 1;
	$(document).ready(function(){
		load(indexPage);
		$('#dialog').hide();
		   load1();
	});
	
	function change(page){
		indexPage = page;
		load(indexPage);
	}
	
	function load(indexPage){
		$.ajax({
			type:'post',
			url:'/mylesson/queryByPage/'+ indexPage,
			dataType:'JSON',
			contentType:'application/json',
			success: function(data){
				console.log('success:' + data);
				var json = JSON.stringify(data,null,4);
				console.log('json:' + json);
				$("#showorder").empty("");
				if(data==null){
					$('table').prepend("<tr><td colspan='2'>暫無資料</td></tr>");
				}else{
					var table = $('#showorder');
					table.append("<thead><tr align='center'><th>課程圖片</th><th>課程名稱</th></tr></thead>");
					
					$.each(data, function(i,n){
						var tr = "<tbody><tr align='center'>" + "<td><img width='150' src='" + n.lesson.image + "'></td>" +
								 "<td>" + n.lesson.lessonName + "</td>" + "</tr></tbody>";
						table.append(tr);
					});
					
					
				}
			}
		});
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





<div class="container-xl">
    <div class="table-responsive">
        <div class="table-wrapper">
            <div class="table-title" style="background-color:#FDC800">
                <div class="row">
                    <div class="col-sm-12">
                        <h2><b><font face="serif">我的課程</font></b></h2>
                    </div>
                    
                </div>
            </div>
            <table id="showorder" class="table table-striped table-hover">
                
            </table>
            <div class="clearfix">
                <table id="showpage">
					<tr>
						<td>Total Pages:${mTotalPages } Total Records:${mTotalElements }</td>
						<td colspan="3" align="right">Previous
							<c:forEach var="i" begin="1" end="${mTotalPages }" step="1">
								<button id="myPage" class="btn btn-warning" value="${i }" onclick="change(${i})">${i }</button>
							</c:forEach>Next
						</td>
					</tr>
				</table>
            </div>
        </div>
    </div>
</div>

<!--  footer從這裡開始  -->

	  <section class="bg-secondary">

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