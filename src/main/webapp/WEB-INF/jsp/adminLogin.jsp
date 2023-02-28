<!-- WAKABAYASHI -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者ログイン画面</title>
<link rel="stylesheet" type="text/css" href="css/contact.css">
</head>
<body>


	<section class="section section-secondary">

		<h1 class="section-headline">管理者ログイン画面</h1>

		<form class="form" action="/fruitsStore/AdminLogin" method="post">
			<table class="form-table">
				<tr>
					<th><label for="name"> ユーザー名 </label></th>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<th><label for="pass"> パスワード </label></th>
					<td><input type="password" name="pass"><br></td>
				</tr>
			</table>
			<div class="form-button">
				<input type="submit" value="ログイン"><br
			</div>
			<br>
			<br>
			<p>
				<a href="/fruitsStore/">TOP</a>
			</p>


		</form>
	</section>


</body>
</html>