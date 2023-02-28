<!-- WAKABAYASHI -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.*,java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
Cart cart = (Cart) session.getAttribute("cart");
String err = (String) request.getAttribute("err");
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<title>購入確定画面</title>
</head>
<body>
	<div class="container" style="margin-top: 20px;">
		<h4>ご購入ありがとうございました！</h4>

		<table class="table table-striped mt-4">
			<tr>
				<th>商品名</th>
				<th>価格</th>
				<th>数量</th>
			</tr>
			<%
			for (Fruits v : cart.getList()) {
			%>
			<tr>
				<th><%=v.getName()%></th>
				<td><%=String.format("%d円", v.getPrice())%></td>
				<td><%=String.format("%d個", v.getQuantity())%></td>
			</tr>
			<%
			}
			%>
		</table>
		<div class="float-right" role="alert">
			<%=String.format("合計:%,d円", cart.getTotal())%>
		</div>
		<a href="/fruitsStore/Complete">TOPへ</a>
	</div>
</body>
</html>