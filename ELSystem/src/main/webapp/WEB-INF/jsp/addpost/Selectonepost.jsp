<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Select One Post</title>
</head>
<body>

	<form action="selectonepost.controller" method="post">
		<table>
			<tr>
				<td>想查詢的貼文號碼:</td>
			</tr>
			<tr>
				<td><input id="Q1" style="text-align: left" name="postId"
					value="${postId}" type="text"></td>
			</tr>
			<tr>
				<td height="50" colspan="2" align="left"><input type="submit"
					value="查詢"></td>
			</tr>

		</table>

	</form>
</body>
</html>