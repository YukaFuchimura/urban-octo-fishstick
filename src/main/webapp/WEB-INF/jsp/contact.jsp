<!-- FUCHIMURAYUKA -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Date,java.text.SimpleDateFormat"%>
<%
Date date = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH時mm分");
String time = sdf.format(date);
%>
<%
String error = (String) request.getAttribute("error");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CONTACT</title>
<meta name="viewport" content="width=device-width,initial-scale=1.0" />
<meta http-equipv="X-UA-Compatible" content="IE=edge" />

<link rel="stylesheet" type="text/css" href="css/contact.css">
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp" />

	<div class="contact">

		<section class="section section-secondary">
			<h3 class="section-headline">お問い合わせ</h3>
			<%
			if (error != null) {
			%>
			<p><%=error%></p>
			<%
			}
			%>
			<form class="form" action="Contact" method="post">
				<table class="form-table">
					<tr>
						<th><label for="menu">お問い合わせ内容</label></th>
						<td><select class="select" name="type" id="menu">
								<option value="0" selected>選択してください</option>
								<option value="1">いちごについて</option>
								<option value="2">メロンについて</option>
								<option value="3">葡萄について</option>
						</select></td>
					</tr>
					<tr>
						<th><label for="name"> 名前 </label></th>
						<td><input class="input" type="text" id="name" name="name"
							maxlength="50" required></td>
					</tr>
					<tr>
						<th><label for="email"> Email </label></th>
						<td><input class="input" type="email" id="email" name="email"
							size="30" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$"
							required></td>
					</tr>
					<tr>
						<th><label for="email"> Email 再入力(確認用)</label></th>
						<td><input class="input" type="email" id="email2"
							name="email2" size="30"
							pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$"
							data-equal-to="email" required></td>
					</tr>
					<tr>
						<th>性別</th>
						<td><label class="radio"> <input type="radio"
								name="gender" value="1" required>男性
						</label> <label class="radio"> <input type="radio" name="gender"
								value="2">女性
						</label></td>
					</tr>
					<tr>
						<th><label for="detail">お問い合わせ内容</label></th>
						<td><textarea class="textarea" name="text" id="detail"
								cols="30" rows="10" maxlength="1000"
								placeholder="1000文字以内で記入してください" required></textarea></td>
					</tr>
				</table>
				<input type="hidden" name="time" value=" <%=time%> ">
				<div class="form-button">
					<button class="button button-submission" type="submit">送信</button>
				</div>
			</form>

		</section>

		<br>

	</div>

	<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>
</html>