<!-- WAKABAYASHI -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.AdminUser"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品登録失敗画面</title>
<link rel="stylesheet" type="text/css" href="css/contact.css">
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp" />
	<c:if test="${not empty errorMsg}">
		<br>
		<p>${errorMsg}</p>
	</c:if>
	<a href="/fruitsStore/Admin">在庫表一覧へ</a>
	<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>
</html>