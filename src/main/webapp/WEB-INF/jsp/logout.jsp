<!-- WAKABAYASHI -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログアウト画面(決定)</title>
<link rel="stylesheet" type="text/css" href="css/contact.css">
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp" />

	<div class="section-secondary">
		<div class="size">
			<h1>お疲れ様です。</h1>
			<h2>ログアウトしました。</h2>
		</div>
	</div>

	<%-- 
<div class="bottom">
<p><a href="/fruitsStore/">TOPへ</a></p>
--%>
	</div>
	<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>
</html>