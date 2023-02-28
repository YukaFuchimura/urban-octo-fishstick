<!-- WAKABAYASHI -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.AdminUser"%>

<!-- セッションスコープからユーザー情報を取得 -->
<%
AdminUser loginUser = (AdminUser) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン結果画面</title>
<link rel="stylesheet" type="text/css" href="css/contact.css">
</head>


<body>

	<div class="adminLoginResult">
		<%
		if (loginUser != null) {
		%>
		<h2>管理者ログインに成功しました</h2>
	</div>
	<br>
	<div class="admin-headline">
		<p>
			ようこそ、<%=loginUser.getName()%>さん
		</p>
		<br> <a href="/fruitsStore/Admin">管理者画面へ</a>
		<%
		} else {
		%>
		<h2>管理者ログインに失敗しました</h2>
		<br>
		<p>
			<a href="/fruitsStore/AdminLogin">管理者専用画面へ</a>
		</p>
		<br>
		<p>
			<a href="/fruitsStore/">TOP</a>
		</p>
		<%
		}
		%>
	</div>

</body>
</html>