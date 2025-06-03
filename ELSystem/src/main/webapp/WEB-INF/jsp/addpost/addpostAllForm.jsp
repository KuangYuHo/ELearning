<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <!--  This file has been downloaded from bootdey.com @bootdey on twitter -->
    <!--  All snippets are MIT license http://bootdey.com/license -->
    <title>管理fun學趣-論壇</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<link rel="stylesheet" href="/css/elssystem.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
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
<!--                                             <a href="http://localhost:8082/addpost/allaction2.controller" class="nav-link nav-link-faded has-icon ">所有貼文</a> -->
                                            <a href="http://localhost:8082/addpost/allaction.controller" class="nav-link nav-link-faded has-icon">首頁</a>                                   
                                            <a href="http://localhost:8082/addpost/allpost.controller" class="nav-link nav-link-faded has-icon active">管理貼文</a>
<!--                                             <a href="http://localhost:8082/addpost/insertpost" class="nav-link nav-link-faded has-icon">新增貼文</a> -->
<!--                                             <a href="http://localhost:8082/addpost/selectonepost" class="nav-link nav-link-faded has-icon">查詢貼文</a> -->
                                            <a href="http://localhost:8082/message/elsmessageList.controller" class="nav-link nav-link-faded has-icon">管理留言</a>
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
<!--                 <a class="nav-link nav-icon rounded-circle nav-link-faded mr-3 d-md-none" href="#" data-toggle="inner-sidebar"><i class="material-icons">arrow_forward_ios</i></a> -->
<!--                 <select class="custom-select custom-select-sm w-auto mr-1"> -->
<!--                     <option selected="">Latest</option> -->
<!--                     <option value="1">Popular</option> -->
<!--                     <option value="3">Solved</option> -->
<!--                     <option value="3">Unsolved</option> -->
<!--                     <option value="3">No Replies Yet</option> -->
<!--                 </select> -->
					搜尋標題:<form action="/addpost/searchqueryByPage" method="post">
		  	  
		 	  		<input name="searchtext" type='text'>
		 	  		<input type='submit' value="查詢">
		   			 </form>
            </div>
            <!-- /Inner main header -->

            <!-- Inner main body -->

            <!-- Forum List -->
            <div class="inner-main-body p-2 p-sm-3 collapse forum-content show">
            	<div class="card mb-2">
                	<h3  style="text-align:center;">管理所有貼文</h3>
            	</div>   
            </div>   
            <div class="inner-main-body p-2 p-sm-3 collapse forum-content show">
                <div class="card mb-2">
                <table id="showpost" border="1"  style="width:100%"></table>
                    <div class="card-body p-2 p-sm-3">
                    
						<table id="showpage">
  							 <tr>
      							<td>總頁數:${totalPages} 總貼文數量:${totalElements}</td>
      							<td colspan="3" align="right">頁碼:
          				<c:forEach var="i" begin="1" end="${totalPages}" step="1">
              			<button id="myPage" value="${i}" onclick="change(${i})">${i}</button>
          				</c:forEach>
     							 </td>
   							</tr>
  
						</table>

                    </div>
                </div>
            </div>   
            <!-- /Forum List -->

            <!-- Forum Detail -->
            <div class="inner-main-body p-2 p-sm-3 collapse forum-content">
                <a href="#" class="btn btn-light btn-sm mb-3 has-icon" data-toggle="collapse" data-target=".forum-content"><i class="fa fa-arrow-left mr-2"></i>Back</a>
                <div class="card mb-2">
                    <div class="card-body">
                        <div class="media forum-item">
                            <a href="javascript:void(0)" class="card-link">
                                <img src="https://bootdey.com/img/Content/avatar/avatar1.png" class="rounded-circle" width="50" alt="User" />
                                <small class="d-block text-center text-muted">Newbie</small>
                            </a>
                            <div class="media-body ml-3">
                                <a href="javascript:void(0)" class="text-secondary">Mokrani</a>
                                <small class="text-muted ml-2">1 hour ago</small>
                                <h5 class="mt-1">Realtime fetching data</h5>
                                <div class="mt-3 font-size-sm">
                                    <p>Hellooo :)</p>
                                    <p>
                                        I'm newbie with laravel and i want to fetch data from database in realtime for my dashboard anaytics and i found a solution with ajax but it dosen't work if any one have a simple solution it will be
                                        helpful
                                    </p>
                                    <p>Thank</p>
                                </div>
                            </div>
                            <div class="text-muted small text-center">
                                <span class="d-none d-sm-inline-block"><i class="far fa-eye"></i> 19</span>
                                <span><i class="far fa-comment ml-2"></i> 3</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card mb-2">
                    <div class="card-body">
                        <div class="media forum-item">
                            <a href="javascript:void(0)" class="card-link">
                                <img src="https://bootdey.com/img/Content/avatar/avatar2.png" class="rounded-circle" width="50" alt="User" />
                                <small class="d-block text-center text-muted">Pro</small>
                            </a>
                            <div class="media-body ml-3">
                                <a href="javascript:void(0)" class="text-secondary">drewdan</a>
                                <small class="text-muted ml-2">1 hour ago</small>
                                <div class="mt-3 font-size-sm">
                                    <p>What exactly doesn't work with your ajax calls?</p>
                                    <p>Also, WebSockets are a great solution for realtime data on a dashboard. Laravel offers this out of the box using broadcasting</p>
                                </div>
                                <button class="btn btn-xs text-muted has-icon"><i class="fa fa-heart" aria-hidden="true"></i>1</button>
                                <a href="javascript:void(0)" class="text-muted small">Reply</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /Forum Detail -->

            <!-- /Inner main body -->
        </div>
        <!-- /Inner main -->
    </div>

    
</div>
</div>


<style type="text/css">
body{
    margin-top:20px;
    color: #1a202c;
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
				   table.append("<tr id='ptitle'><th>ID</th><th>分類</th><th>標題</th><th>內容</th><th>時間</th><th>動作</th><th>動作</th></tr>");
				   
				   $.each(data, function(i,n){
					   var tr = "<tr align='center'>" +
					   			"<td>" + n.postId + "</td>" +
					            "<td>" + n.postType + "</td>" + 
					            "<td>" + n.postTitle + "</td>" +
					            "<td>" + n.postInformation + "</td>" + 
					            "<td>" + n.postDate + "</td>" +
// 					            "<td>" + n.postLikeQty + "</td>" +
// 					            "<td>" + n.postViews + "</td>" +
					            "<td><a href='delete?postId=" + n.postId + "'>  刪除  </td>" +
					            "<td><a href='updatepost?postId=" + n.postId + "'> 編輯 </td>" 
					            "</tr>";
					   table.append(tr);
				   });			   
			   }
		   }
	   });
   }
</script>
</body>
</html>