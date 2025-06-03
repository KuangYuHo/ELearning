<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>留言</title>
<link rel="stylesheet" href="/css/elssystem.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
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
 			   
 			   $('#showpost').empty("");
 			   
 			  if(data==null){
 				 $('table').prepend("<tr><td colspan='2'>暫無資料</td></tr>");
 		      }else{
 		    	 var table = $('#showpost');
 		    	 table.append("<tr id='ptitle'><th>ID</th><th>分類</th><th>貼文名稱</th><th>內容</th><th>時間</th><th>留言</th><th>新增留言</th></tr>");
 		    	 var tr = "<tr align='center'>" + 
 		    	 		 "<td>" + data.postId + "</td>" +
 		    	         "<td>" + data.postType + "</td>" + 
 		    	         "<td>" + data.postTitle + "</td>" +
 		    	         "<td>" + data.postInformation + "</td>" +
 		    	         "<td>" + data.postDate + "</td>" + 		    	        
 		                 "<td ><textarea  id='message' ></textarea></td>" +
 		    	         "<td><button id='order' type='button' value='order' onclick='sendMsg(" + data.postId + ")'>新增</button></td>" +
 		    	         "</tr>";
 		    	
 		    	 table.append(tr);
 		    	 
 		    	 
 		    	 var mtable = $('#showmessages');
 		    	 mtable.append("<tr id='ptitle'><th>留言</th><th>時間</th></tr>");
 		   		
// //  		    	 var mtr = "<tr align='center'>" + 
// //  		    	         "<td>" + data.messages[0].messageinformation+ "</td>"+   		    	          		   	        
// //  		    	 		 "<td>" + data.messages[0].messageDate +"</td>" +
// //  		    	         "</tr>";
// //  		    	 mtable.append(mtr);
 		    	 $.each(data.messages,function(i,n){
 		    	 
 		    	 var mtr = "<tr align='center'>" + 
 		    	         "<td>" + n.messageinformation+ "</td>"+   		    	          		   	        
 		    	 		 "<td>" + n.messageDate +"</td>" +
 		    	         "</tr>";
 		    	 mtable.append(mtr);
 		    	});
 		      }
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
    		"memberID":1000,
    		"postId":postId,
    		"messageLikeQty":5
        }
    	
    	$.ajax({
    	   type:'post',
    	   url:'elsmessageinsert.controller',
    	   dataType:'JSON',
    	   contentType:'application/json',
    	   data:JSON.stringify(params),
    	   success: function(data){
    		   console.log(data);
    		   $('#feedback').html("新增成功");
    	   }
    	
    	
    	});
    }
</script>
</head>
<body>
<div id="allpost">新增留言</div>
<table id="showpost" border="1"></table>
<table id="showmessages" border="1"></table>
<input id="postId" type="hidden" value="${postId}">
<div id="feedback" align="center"></div>
<table>
<tr>

<td align="center"><a href="http://localhost:8082/message/elsmessageList.controller" >回前頁</a></td>
</tr>
</table>
</body>
</html>