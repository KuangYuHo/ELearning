<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	<script type="text/javascript">
	
	  $(document).ready(function(){
		  	var postId = $('#postId').val();
		  	load(postId);
		  });
		  
		  function load(postId){
		  	$.ajax({
		  	   type:'post',
				   url:'/addpost/querybyid/' + postId,
				   dataType:'JSON',
				   contentType:'application/json',
				   success: function(data){
					   
					   console.log('success:' + data);
					   var json = JSON.stringify(data,null,4);
					   console.log('json:' + json);
					   
		 			   $('#insertmsg').empty("");
					   
					  
				    	 var table = $('#insertmsg');
				    	
				    	 <%
							Object currentuser = session.getAttribute("loginID");
				    	    
						   %>
						   var loginUser  = "<%=currentuser%>" ;
						   var loginID = parseInt(loginUser,10);
				    	   console.log(loginUser);
				    	 if (loginUser != 'null'){
				    		 
				    		 var mmtr = "<div class='card mb-2'>" + 		    	 			    	        
				    	 		  "<div class='card-body'>" + 		    	 			    	        
				    	 		  "<div class='media forum-item'>" + 		    	 			    	        
				    	 		  "<a href='javascript:void(0)' class='card-link'></a>" + 		    	 			    	        		    	 		  	    	 			    	        
				    	 		  "<div class='media-body ml-3'>" + 		    	 			    	        
				    	 		  "<h5 class='mt-1'>新增留言: "+ 		    	 			    	        
				    	 		  "<textarea  id='message' ></textarea>" + 		    	 			    	        
				    	 		  "<input id='order' type='button' value='新增' onclick='sendMsg(" + data.postId + ")'>" + 		    	 			    	        
				    	 		  " <input id='postId' type='hidden' value='${postId}'> </h5>" + 		    	 			    	        		    	 			    	 			    	        
				    	 		  "<div id='feedback' align='center'></div>" + 		    	 			    	        
				    	 		  
				    	         
				    	         "</div>"+
				    	         "</div>"+
				    	         "</div>"+
				    	         "</div>";
				    	 }else{
				    		 var mmtr = "";
				    	 }
				    	 
				    	 
				    	        
				    	
		 		    	 table.append(mmtr);
		 		    	 
		 		    	 
				    	 		    	
				    	 
				      
				   }
		  	});
		  }
	
	 function sendMsg(postId){
	    	var message = $('#message').val();
	    	
	    	
	    	if($.trim(message)==''){
	    		alert('message is empty(空的)');
	    		return;
	    	}
	    	

	    	
	    	var params = {
	    	    "messageinformation":message,
	    		
	    		"postId":postId,
	    		"messageLikeQty":5
	        }
	    	
	    	$.ajax({
	    	   type:'post',
	    	   url:'/addpost/elsmessageinsert.controller',
	    	   dataType:'JSON',
	    	   contentType:'application/json',
	    	   data:JSON.stringify(params),
	    	   success: function(data){
	    		   console.log(data);
	    		   $('#feedback').html("新增成功");
	    		   //window.reload();
	    		   window.location.reload(); 
	    	   }
	    	
	    	
	    	});
	    	
	 }
	</script>
</head>
<body>
<input type='hidden' id='postId' value='${postId }'>
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
                                            <a href="http://localhost:8082/addpost/allaction.controller" class="nav-link nav-link-faded has-icon">首頁</a>                                   
                                            <a href="http://localhost:8082/addpost/allaction2.controller" class="nav-link nav-link-faded has-icon">所有貼文</a>                                   
                                            <a href="#" class="nav-link nav-link-faded has-icon active">貼文</a>

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

                

					搜尋標題:<form action="/addpost/searchqueryByPage" method="post">
		  	  
		 	  		<input name="searchtext" type='text'>
		 	  		<input type='submit' value="查詢">
		   			 </form>
<!-- 				</div> -->
            </div>
            
            <!-- /Inner main header -->

            <!-- Inner main body -->

            <!-- Forum List -->
            <div  class="inner-main-body p-2 p-sm-3 collapse forum-content show">
             
            
                <div class="card mb-2">
                    <div class="card-body">
                        <div class="media forum-item">
                            <a href="javascript:void(0)" class="card-link">
                                <img src="${addPost.photo}" class="rounded-circle" width="50" alt="User" />
                                <small class="d-block text-center text-muted">${addPost.mName}</small>
                            </a>
                            <div class="media-body ml-3">
                                <a href="javascript:void(0)" class="text-secondary">${addPost.mName}</a>
                                <small class="text-muted ml-2">${addPost.postDate}</small>
                                <h3 class="mt-1">${addPost.postTitle}</h3>
                                <div class="mt-3 font-size-sm">                                  
                                    <p>
                                       ${addPost.postInformation}
                                    </p>                                   
                                </div>
                            </div>
                            
                            <c:set var="m1" scope="session" value="${loginID}"/>
                            <c:set var="m2" scope="session" value="${addPost.memberId}"/>
                            
                            <c:choose>
                            	<c:when test="${m1 == m2}">
                            	
                            		<div><form action="/addpost/updatepost2" method="get"><input type="hidden" name="postId" value="${addPost.postId }"><input type="submit" value="編輯"></form></div>
                            		<div><form action="/addpost/delete2" method="get"><input type="hidden" name="postId" value="${addPost.postId }"><input type="submit" value="刪除"></form></div>
                            		
                            	</c:when>
                            	<c:otherwise>
                            		<div></div>
                            	</c:otherwise>
                            </c:choose>

                        </div>
                    </div>
             </div>
                
                 
                  <div id="insertmsg" class="inner-main-body p-2 p-sm-3 collapse forum-content show">
                                  

                </div>
           
                  <small class="d-block text-left text-muted">所有留言</small>
                 
                <c:forEach var="message"   items="${addPost.messages}" >
                <input type="hidden" class="mId" value="${message.memberId}">
                <div class="card mb-2" >
                    <div class="card-body">
                        <div class="media forum-item">
                            <a href="javascript:void(0)" class="card-link">
                                <img src="${message.photo}" class="rounded-circle" width="50" alt="User" />
                                <small class="d-block text-center text-muted">${message.mName}</small>
                            </a>
                            <div class="media-body ml-3">
                                <a href="javascript:void(0)" class="text-secondary">${message.mName}</a>
                                <small class="text-muted ml-2">${message.messageDate}</small>                               
                                <div class="mt-3 font-size-sm">                                  
                                    <p>
                                      ${message.messageinformation}
                                    </p>                                   
                                </div>
                            </div>
                            <c:set var="m1" scope="session" value="${loginID}"/>
                            <c:set var="m2" scope="session" value="${message.memberId}"/>
                            
                            <c:choose>
                            	<c:when test="${m1 == m2}">                            		
                            		<div><form action="/message/updatemessage2" method="get"><input type="hidden" name="messageId" value="${message.messageId}"><input type="submit" value="編輯"></form></div>
                            		<div><form action="/message/deletemessage2" method="get"><input type="hidden" name="messageId" value="${message.messageId}"><input type="submit" value="刪除"></form></div>
                            	</c:when>
                            	<c:otherwise>
                            		<div></div>
                            	</c:otherwise>
                            </c:choose>
                            
                            	          
                            
                        </div>
                    </div>
                </div>
                </c:forEach>
                
<!--                  <div><a href="http://localhost:8082/addpost/allaction1.controller" >回上頁</a></div> -->
               
                   
            <!-- /Inner main body -->
        
        <!-- /Inner main -->
    </div>

    <!-- New Thread Modal -->  
</div>
</div>




<style type="text/css">
body{
    margin-top:20px;
    color:  #11141c;
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


</body>
</html>

