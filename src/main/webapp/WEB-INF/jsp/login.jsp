<!-- FUCHIMURAYUKA -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%
String errorMsg = (String) request.getAttribute("errorMsg");
%>
<%
String aleart = (String) request.getAttribute("aleart");
%>

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0" />
<meta http-equipv="X-UA-Compatible" content="IE=edge" />
<link rel="stylesheet" type="text/css" href="css/contact.css">
<title>LOGIN</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp" />



	<section class="section section-secondary">
		<h1 class="section-headline">ログイン</h1>
		<%
		if (errorMsg != null) {
		%>
		<p><%=errorMsg%></p>
		<%
		}
		%>
		<%
		if (aleart != null) {
		%>
		<p><%=aleart%></p>
		<%
		}
		%>
		<form class="form" action="UserLoginServlet" method="post">
			<table class="form-table">

				<tr>
					<th><label for="name"> 名前 </label></th>
					<td><input class="input" type="text" name="name"
						maxlength="50" required></td>
				</tr>
				<tr>
					<th><label for="pass"> パスワード </label></th>
					<td><input type="password" name="pass" class="input"
						pattern="[0-9A-Za-z]{4,8}" required></td>
				</tr>

			</table>
			<div class="form-button">
				<button class="button button-submission" type="submit">ログイン</button>
			</div>
		</form>
	</section>

	<!-- <form action ="UserLoginServlet" method="post">
	
		<p>NAME:</p><br>
		<input type="text" name="name" /><br>
		<p>PASSWORD:</p><br>
		<input type="password" name="pass"/><br><br>
		<input type="submit" value="LOGIN"><br>
</form> -->
	<div class="bottom">
		<a href="RegisterAccount">新規アカウント登録</a><br> <br> <a
			href="AdminLogin">管理者ログインページ</a><br> <br> <a
			href="/fruitsStore/">TOPへ戻る</a>
	</div>


	<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>
</html>