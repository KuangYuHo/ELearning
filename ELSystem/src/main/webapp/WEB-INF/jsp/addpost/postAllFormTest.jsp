<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- <!DOCTYPE html> -->
<!-- <html> -->
<!-- <head> -->
<!-- <script src="/ckeditor/ckeditor.js"></script> -->
<%-- <link rel='stylesheet' href="<c:url value='/css/style.css' />" type="text/css" /> --%>

<!-- <meta charset="UTF-8"> -->
<!-- <body> -->
<!-- <a href="http://localhost:8082/addpost/allpost.controller">所有貼文&刪除貼文&編輯貼文</a><p/> -->
<!-- <a href="http://localhost:8082/addpost/insertpost">新增貼文</a><p/> -->
<!-- <a href="http://localhost:8082/addpost/selectonepost">查詢貼文</a><p/> -->


<!-- <a href="http://localhost:8082/message/elsmessageList.controller">留言</a><p/> -->
<!-- <a href="http://localhost:8082/addpost/allaction.controller">測試</a><p/> -->
<!-- </body> -->

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <!--  This file has been downloaded from bootdey.com @bootdey on twitter -->
    <!--  All snippets are MIT license http://bootdey.com/license -->
    <title>fun學趣-論壇</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.bundle.min.js"></script>
	
</head>
<body>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.0-2/css/all.min.css" integrity="sha256-46r060N2LrChLLb5zowXQ72/iKKNiw/lAmygmHExk/o=" crossorigin="anonymous" />
<div class="container">
<div class="main-body p-0">
    <div class="inner-wrapper">
        <!-- Inner sidebar -->
        <div class="inner-sidebar">
            <!-- Inner sidebar header -->
            <div class="inner-sidebar-header justify-content-center">
               <img src="/assets/img/gallery/logo3.png" height="40" width="200" alt="logo" />
            </div>
           
            <!-- /Inner sidebar header -->

            <!-- Inner sidebar body -->
            <div class="inner-sidebar-body p-0">
                <div class="p-3 h-100" data-simplebar="init">
                    <div class="simplebar-wrapper" style="margin: -16px;">
                        <div class="simplebar-height-auto-observer-wrapper"><div class="simplebar-height-auto-observer"></div></div>
                        <div class="simplebar-mask">
                            <div class="simplebar-offset" style="right: 0px; bottom: 0px;">
                                <div class="simplebar-content-wrapper" style="height: 100%; overflow: hidden scroll;">
                                    <div class="simplebar-content" style="padding: 16px;">
                                        <nav class="nav nav-pills nav-gap-y-1 flex-column">
                                            <a href="http://localhost:8082/index" class="nav-link nav-link-faded has-icon">首頁</a>                                   
                                            <a href="http://localhost:8082/addpost/allaction1.controller" class="nav-link nav-link-faded has-icon active">所有貼文</a>

                                        </nav>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="simplebar-placeholder" style="width: 234px; height: 292px;"></div>
                    </div>
                    <div class="simplebar-track simplebar-horizontal" style="visibility: hidden;"><div class="simplebar-scrollbar" style="width: 0px; display: none;"></div></div>
                    <div class="simplebar-track simplebar-vertical" style="visibility: visible;"><div class="simplebar-scrollbar" style="height: 151px; display: block; transform: translate3d(0px, 0px, 0px);"></div></div>
                </div>
            </div>
            <!-- /Inner sidebar body -->
        </div>
        <!-- /Inner sidebar -->

        <!-- Inner main -->
        <div class="inner-main">
            <!-- Inner main header -->
            <div class="inner-main-header">

                
<!-- 	            <div class="custom-select custom-select-sm w-auto mr-1"> -->
					搜尋標題:<form action="/addpost/searchqueryByPage" method="post">
		  	  
		 	  		<input name="searchtext" type='text'>
		 	  		<input type='submit' value="查詢">
		   			 </form>
		   			 
		   	<span class="input-icon input-icon-sm ml-auto w-auto">
                    <input type="hidden" class="form-control form-control-sm bg-gray-200 border-gray-200 shadow-none mb-4 mt-4" placeholder="登入" />
                </span>
		   	 <div align="right">
               <h6><a href="http://localhost:8082/addpost/login.controller">登入</a></h6>
            </div>		 
		   	
<!-- 				</div> -->
            </div>
           
            <!-- /Inner main header -->

            <!-- Inner main body -->

            <!-- Forum List -->
            <div id="showpost" class="inner-main-body p-2 p-sm-3 collapse forum-content show">
                
             </div>
             <div>
                <ul id="showpage" class="pagination pagination-sm pagination-circle justify-content-center mb-0">
<!--                     <li class="page-item disabled" > -->
<%--                         <span class="page-link has-icon"><i class="material-icons">總頁數:${totalPages}</i></span> --%>
<!--                     </li>                   -->
						<li class="page-item">
						<a class="page-link has-icon" href="javascript:void(0)"><i class="material-icons">頁碼:
				          <c:forEach  var="i" begin="1" end="${totalPages}" step="1">
				              <button id="myPage" value="${i}" onclick="change(${i})">${i}</button>
				          </c:forEach>
				        </i></a>
				      	</li>               
                  </ul>
	           
	           </div>
            
            
         

            <!-- /Inner main body -->
        </div>
        <!-- /Inner main -->
    </div>

    <!-- New Thread Modal -->  

</div>

<style type="text/css">
body{
    margin-top:20px;
    color: #3c8bb5;
    text-align: left;
    background-color: #e2e8f0;    
}
.inner-wrapper {
    position: relative;
    height: calc(100vh - 3.5rem);
    transition: transform 0.3s;
}
@media (min-width: 992px) {
    .sticky-navbar .inner-wrapper {
        height: calc(100vh - 3.5rem - 48px);
    }
}

.inner-main,
.inner-sidebar {
    position: absolute;
    top: 0;
    bottom: 0;
    display: flex;
    flex-direction: column;
}
.inner-sidebar {
    left: 0;
    width: 235px;
    border-right: 1px solid #cbd5e0;
    background-color: #fff;
    z-index: 1;
}
.inner-main {
    right: 0;
    left: 235px;
}
.inner-main-footer,
.inner-main-header,
.inner-sidebar-footer,
.inner-sidebar-header {
    height: 3.5rem;
    border-bottom: 1px solid #cbd5e0;
    display: flex;
    align-items: center;
    padding: 0 1rem;
    flex-shrink: 0;
}
.inner-main-body,
.inner-sidebar-body {
    padding: 1rem;
    overflow-y: auto;
    position: relative;
    flex: 1 1 auto;
}
.inner-main-body .sticky-top,
.inner-sidebar-body .sticky-top {
    z-index: 999;
}
.inner-main-footer,
.inner-main-header {
    background-color: #fff;
}
.inner-main-footer,
.inner-sidebar-footer {
    border-top: 1px solid #cbd5e0;
    border-bottom: 0;
    height: auto;
    min-height: 3.5rem;
}
@media (max-width: 767.98px) {
    .inner-sidebar {
        left: -235px;
    }
    .inner-main {
        left: 0;
    }
    .inner-expand .main-body {
        overflow: hidden;
    }
    .inner-expand .inner-wrapper {
        transform: translate3d(235px, 0, 0);
    }
}

.nav .show>.nav-link.nav-link-faded, .nav-link.nav-link-faded.active, .nav-link.nav-link-faded:active, .nav-pills .nav-link.nav-link-faded.active, .navbar-nav .show>.nav-link.nav-link-faded {
    color: #3367b5;
    background-color: #c9d8f0;
}

.nav-pills .nav-link.active, .nav-pills .show>.nav-link {
    color: #fff;
    background-color: #467bcb;
}
.nav-link.has-icon {
    display: flex;
    align-items: center;
}
.nav-link.active {
    color: #467bcb;
}
.nav-pills .nav-link {
    border-radius: .25rem;
}
.nav-link {
    color: #4a5568;
}
.card {
    box-shadow: 0 1px 3px 0 rgba(0,0,0,.1), 0 1px 2px 0 rgba(0,0,0,.06);
}

.card {
    position: relative;
    display: flex;
    flex-direction: column;
    min-width: 0;
    word-wrap: break-word;
    background-color: #fff;
    background-clip: border-box;
    border: 0 solid rgba(0,0,0,.125);
    border-radius: .25rem;
}

.card-body {
    flex: 1 1 auto;
    min-height: 1px;
    padding: 1rem;
}
</style>

<script type="text/javascript">
var indexPage=1;
$(document).ready(function(){
	   load(indexPage);
});

function change(page){
	   indexPage = page;
	   load(indexPage);
}
//22-26行是上傳跟下載json的動作
function load(indexPage){
	   $.ajax({
		   type:'post',
		   url:'/addpost/queryByPage/' + indexPage,
		   dataType:'JSON',
		   contentType:'application/json',
		   success: function(data){
			   
			   console.log('success:' + data);
			   var json = JSON.stringify(data,null,4);
			   console.log('json:' + json);
			   
			   $('#showpost').empty("");
			   
			   if(data==null){
				   $('table').prepend("<tr><td colspan='2'>暫無資料</td></tr>");
			   }else{
				   var table = $('#showpost');
// 				   table.append("<tr id='ptitle'><th>ID</th><th>分類</th><th>標題</th><th>內容</th><th>時間</th><th>愛心數</th><th>瀏覽數</th><th>動作</th><th>動作</th></tr>");
				   
				   $.each(data, function(i,n){
					  
					   var tr = "<div class='card mb-2'>" +
					   			"<div class='card-body p-2 p-sm-3'>"+
					   				"<div class='media forum-item'>"+
					   					"<a href='#' data-toggle='collapse' data-target='.forum-content'><img src='"+n.photo+"' class='mr-3 rounded-circle' width='50' alt='User' /></a>"+
					   					"<div class='media-body'>"+
					   		 				"<h5><a href='#' data-toggle='collapse' data-target='.forum-content' class='text-body' ><a href='elsmessagefindbyid2.controller?postId=" + n.postId + "'>"+ n.postTitle + "</a></h5>"+
					   		 				"<p class='text-secondary'>"+ n.postType + "</p>"+				   		 			 	
					   		 				"<p class='text-muted'><a href='javascript:void(0)'>"+ n.mName +"</a> 發布 <span class='text-secondary font-weight-bold'>"+ n.postDate + "</span></p>"+
					   		 			 "</div >"+					   		 			
 					   					"<div class='text-muted small text-center align-self-center'>"+
// 					   		 			 	"<span class='d-none d-sm-inline-block'><i class='far fa-eye'></i>"+ n.postViews + "</span>"+
//                                 			"<span><i class='far fa-comment ml-2'></i>"+ n.postLikeQty +"</span>"+      
                                		"</div >"+	 
                                	"</div >"+
                                	"</div>"+
                                	"</div>"
                               	;
					  
					   table.append(tr);
					   
						   
					   
				   });
				   
// 				   $.each(data, function(i,n){
// 					   var td = "<div>333</div>"
// 					   if(n.memberId = memberId){
// 						   table.append(td);
// 					   }
// 				   }
			   }
		   }
	   });
}
</script>
<script type="text/javascript">

   function load2(postId){
	   $.ajax({
		   type:'post',
		   url:'/message/queryByPage/' + ${postId} + '/' + indexPage,
		   dataType:'JSON',
		   contentType:'application/json',
		   success: function(data){
			   
			   console.log('success:' + data);
			   var json = JSON.stringify(data,null,4);
			   console.log('json:' + json);
			   
			   $('#showmsg').empty("");
			   
			   if(data==null){
				   $('table').prepend("<tr><td colspan='2'>暫無資料</td></tr>");
			   }else{
				   var table = $('#showmsg');
				   //table.append("<tr id='ptitle'><th>ID</th><th>時間</th><th>留言</th><th>動作</th><th>動作</th></tr>");
				   
				   $.each(data, function(i,n){
					   var mtr = " <div class='card mb-2'>" +
					   			" <div class='card-body'>" +
					   			" <div class='media forum-item'>" +
					   			" <a href='javascript:void(0)' class='card-link'>" +
					   			" <img src='n.photo' class='rounded-circle' width='50' alt='User' />" +
					   			" </a>" +
					   			" <div class='media-body ml-3'>" +
					   			"  <a href='javascript:void(0)' class='text-secondary'>"+ n.mName +"</a>" +
					   			" <small class='text-muted ml-2'>"+ n.messageDate + "</small>" +
					   			" <div class='mt-3 font-size-sm'>" +
					   			" <p>" + n.messageinformation +" </p>"
					   			"  </div>" +
					   			" </div>" +
					   			"  <div class='text-muted small text-center'>" +
					   			" <span><i class='far fa-comment ml-2'></i>"n.messageLikeQty"</span>" +
					   			" </div>" +
					   			" </div>" +
					   			" </div>" +
					   			" </div>" +					   		
					            "</tr>";
			               
					   table.append(mtr);
				   });			   
			   }
		   }
	   });
   }
</script>

</body>
</html>
</head>
</html>