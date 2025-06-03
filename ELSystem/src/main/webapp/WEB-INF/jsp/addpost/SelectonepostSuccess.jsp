<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success</title>
</head>
<body>
<h1>
貼文編號: ${selectone.postId}的資料</h1>


貼文分類: ${selectone.postType}<br>

貼文標題: ${selectone.postTitle}<br>

貼文內容: ${selectone.postInformation}<br>

<a href="http://localhost:8082/addpost/allaction2.controller" >回首頁</a>
</body>
</html>