<%--FUCHIMURAYUKA --%>
<%-- 練習のためJSTLとSESSIONと利用 --%>
<%-- ContactBeansListを表示--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ page import="java.util.Date,java.text.SimpleDateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.ContactBeans"%>
<%@ page import="model.AdminUser"%>
<%
AdminUser loginUser = (AdminUser) session.getAttribute("loginUser");
%>
<%
ContactBeans ct = (ContactBeans) session.getAttribute("contact");
%>
<%
String info = (String) request.getAttribute("info");
%>
<% Date date = new Date();
	  SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH時mm分");
	  String time = sdf.format(date);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MESSAGE</title>
</head>
<body>

	<p>
		<%=loginUser.getName()%>さん、ログイン中
		<%--　Coreタグの場合
		<c:out value="${loginUser.name}" />
		<c:out>はhtmlにとっての特殊な記号を無効化してくれる
		ページ改ざんなどのクロスサイトスクリプティング(XSS)攻撃を防ぐ
		セキュリティ対策
		--%>
	</p>
	<p><%= time %></p>

	<%
	if (ct == null) {
	%>
	<p><%=info%></p>
	<%
	} else {
	%>

	<h1>メッセージが届いています。</h1>

	<table border="1">
		<tr>
			<th>ID</th>
			<th><h3>メニュー</h3></th>
			<th><h3>名前</h3></th>
			<th><h3>Email</h3></th>
			<th><h3>性別</h3></th>
			<th><h3>お問い合わせ内容</h3></th>
			<th><h3>TIME</h3></th>
		</tr>
		<c:if test="${cbList !=0}">
			<c:forEach var="contact" items="${cbList }">
				<tr>
					<td><c:out value="${contact.id}" /></td>
					<td><c:out value="${contact.type}" /></td>
					<td>	<c:out value="${contact.name}" /></td>
  					<td><c:out value="${contact.email}" /></td>
					<td>
					<c:choose>
						<c:when test="${contact.gender == 1}">
						男性
						</c:when>
						<c:otherwise>
						女性
						</c:otherwise>
					</c:choose>
					</td>
					<td><c:out value="${contact.text}" /></td>
					<td><%= time %></td>
					<td><form action="/fruitsStore/DeleteMessage?id=<c:out value="${contact.id}" />" method="post"><input type="submit" value="削除"></form></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
<% }%>
	<p>
		<a href="/fruitsStore/Admin">管理者画面へ</a>
	</p>
	<p>
		<a href="/fruitsStore/Logout">ログアウト</a>
	</p>
</body>
</html>