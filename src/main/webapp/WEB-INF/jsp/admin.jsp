<!-- WAKABAYASHI -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ page import="model.User" %>
    <%@ page import="model.User,model.Mutter,java.util.List" %>
    <% 
    User loginUser = (User) session.getAttribute("loginUser");
    
    List<Mutter> mutterList = (List<Mutter>) application.getAttribute("mutterList");
    
    String errorMsg = (String) request.getAttribute("errorMsg");
    %> --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String deleted = (String) request.getAttribute("deleted");
%>
<%
String fixed = (String) request.getAttribute("fixed");
%>

<link rel="stylesheet" type="text/css" href="css/contact.css">

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者専用画面</title>
</head>
<link rel="stylesheet" href="././css/main.css" type="text/css">
<body>


	<div class="admin">
		<p>
			<%-- <%= loginUser.getName() %>さん、ログイン中 --%>
			<c:out value="${loginUser.name}" />
			さん、ログイン中
		<p>
			<a href="/fruitsStore/Logout">ログアウト</a>
		</p>
	</div>

	<div class="box">
		<li>【在庫新規登録】
			<form action="/fruitsStore/Admin" method="post">
				種類：<label><input type="radio" name="type" value="1">いちご</label>
				<label><input type="radio" name="type" value="2">めろん</label>
				<label><input type="radio" name="type" value="3">ぶどう</label><br>
				URL：<input type="file" accept="image/png, image/jpeg"><br>
				品種：<input type="text" name="name" required><br> 値段：<input
					type="text" name="price" maxlength="7" required>円<br>
				特徴：<input type="text" name="feature" required><br> 数量：<input
					type="number" name="quantity" maxlength="2" required><br>
				<input type="submit" value="登録">
			</form>
		</li>
		</p>
		<p>
		<li>【在庫削除】<%
		if (deleted != null) {
		%><p><%=deleted%></p>
			<%
			}
			%>
			<form action="/fruitsStore/DeleteStock" method="post">
				商品ID：<input type="text" name="no" maxlength="3" required><br>
				<input type="submit" value="削除">
			</form>
		</li>
		</p>
		<p>
		<li>【在庫修正】<%
		if (fixed != null) {
		%><p><%=fixed%></p>
			<%
			}
			%>
			<form action="/fruitsStore/FixStock" method="post">
				商品ID：<input type="text" name="no" maxlength="3" required><br>
				修正数量：<input type="number" name="quantity" maxlength="2" required><br>
				<input type="submit" value="修正">
			</form>
		</li>
		</p>

	</div>
	<br>
	<p>
		<a href="/fruitsStore/Message">!!!メッセージ!!!</a>
	</p>
	<br>

	<h2>フルーツ在庫一覧</h2>
	<table border="1">
		<tr>
			<th>商品ID</th>
			<th>種類</th>
			<th>URL</th>
			<th>品種</th>
			<th>値段</th>
			<th>特徴</th>
			<th>数量</th>
		</tr>
		<c:forEach var="stock" items="${stockList}">
			<tr>
				<td><c:out value="${stock.id}" /></td>
				<td><c:out value="${stock.type}" /></td>
				<td><img src="<c:out value="${stock.url}" />" width="100dp"
					height="100dp"></td>
				<td><c:out value="${stock.name}" /></td>
				<td><c:out value="${stock.price}" /></td>
				<td><c:out value="${stock.feature}" /></td>
				<td><c:out value="${stock.quantity}" /></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	</div>

	</section>
	<%-- <% if(errorMsg != null){%>
<p><%= errorMsg %></p>
<% } %>
<% for(Mutter mutter : mutterList) {%>
    <p><%= mutter.getUserName() %>:<%= mutter.getText() %></p>
<% } %> --%>

</body>
</html>