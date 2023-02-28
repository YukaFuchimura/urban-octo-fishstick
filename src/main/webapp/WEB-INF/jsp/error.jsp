<!-- FUCHIMURAYUKA -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String err = (String) request.getAttribute("errorMsg");
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
<link rel="stylesheet" type="text/css" href="css/contact.css">
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp" />

	<div class=section-secondary>
		<div class="size">
			<h1>新規アカウント登録に失敗しました。</h1>

			<%
			if (err != null) {
			%>
			<p><%=err%></p>
			<%
			}
			%>


			<%
			if (msg != null) {
			%>
			<p><%=msg%></p>
			<%
			}
			%>
		</div>
	</div>

	<div class="bottom">
		<a href="RegisterAccount">NEW ACCOUNT</a><br> <br> <a
			href="/fruitsStore/">BACK TO TOPPAGE</a>

	</div>

	<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>
</html>