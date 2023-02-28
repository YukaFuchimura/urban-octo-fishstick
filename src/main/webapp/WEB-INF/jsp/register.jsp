<!-- FUCHIMURAYUKA -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0" />
<meta http-equipv="X-UA-Compatible" content="IE=edge" />
<link rel="stylesheet" type="text/css" href="css/contact.css">
<title>REGISTER</title>
</head>

<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp" />


	<section class="section section-secondary">
		<h1 class="section-headline">新規登録</h1>
		<form class="form" action="RegisterAccount" method="post">
			<table class="form-table">

				<tr>
					<th><label for="name"> 名前 </label></th>
					<td><input class="input" type="text" name="name"
						maxlength="50" required></td>
				</tr>
				<tr>
					<th><label for="pass"> パスワード </label></th>
					<td><input type="password" id="pass" name="pass" class="input"
						pattern="[0-9A-Za-z]{4,8}" placeholder="半角英数" required></td>
				</tr>
				<%-- <tr>
						<th>
							<label for="pass">
								パスワード再記入(確認用)
							</label>
						</th>
						<td>
							<input type="password" id="pass2" name="pass2" class="input"
							pattern="[0-9A-Za-z]{4,8}"  data-equal-to="pass" required >
						</td>
					</tr>--%>

			</table>
			<div class="form-button">
				<button class="button button-submission" type="submit">登録</button>
			</div>
		</form>
	</section>





	<!-- <h1>NEW ACCOUNT</h1>
	
	<form action ="RegisterAccount" method="post">
	
		<p>NAME:</p><br>
		<input type="text" name="name" /><br>
		<p>PASSWORD:</p><br>
		<input type="password" name="pass"/><br><br>
		<input type="submit" value="REGIST"><br>
	
	</form> -->
	<%-- 
	<div class="bottom">
	<a href="/fruitsStore/">TOPへ戻る</a>
	</div>--%>
	<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>
</html>