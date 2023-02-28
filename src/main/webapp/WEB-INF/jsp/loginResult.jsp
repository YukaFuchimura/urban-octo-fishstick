<!-- FUCHIMURAYUKA -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginResult</title>
<link rel="stylesheet" type="text/css" href="css/contact.css">
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp" />

	<div class="section section-secondary">
		<div class="size">
			<h1>ログイン成功しました</h1>
			<p>
				<c:out value="${account.userName }" />
				さんこんにちは
			</p>
		</div>
	</div>
	<%-- 
<div class="bottom">
<a href="/fruitsStore/" class="btn">TOPへ戻る</a><br>
--%>
	</div>
	<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>
</html>