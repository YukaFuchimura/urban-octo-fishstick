<!-- WAKABAYASHI -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.*,java.util.*"%>
<%
Cart cart = (Cart) session.getAttribute("cart");
String err = (String) request.getAttribute("err");
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<title>FruitsCart</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp" />

	<div class="container" style="margin-top: 20px;">
		<%
		if (err != null) {
		%>
		<div class="alert alert-danger" role="alert">
			<%=err%>
		</div>
		<%
		}
		%>
		<%
		if (msg != null) {
		%>
		<div class="alert alert-success" role="alert">
			<%=msg%>
		</div>
		<%
		}
		%>
		<table class="table table-striped mt-4">
			<tr>
				<th>商品名</th>
				<th>価格</th>
				<th>数量</th>
			</tr>
			<%
			for (Fruits v : cart.getList()) {
			%>
			<!-- 同じ商品名の時も別々に表示されるので併せたい if(){}else{}　課題　fuchimura-->
			<tr>
				<th><%=v.getName()%></th>
				<td><%=String.format("%d円", v.getPrice())%></td>
				<td><%=String.format("%d個", v.getQuantity())%></td>
				<!-- added by fuchimura  削除機能を付けたい　課題-->
				<!--<td><form action="/fruitsStore/MainCart?action=1"><input type="submit" value="削除"></form></td>-->
			</tr>

			<%
			}
			%>
		</table>
		<div class="alert alert-secondary float-right" role="alert">
			<!-- added by fuchimura 合計個数の追加 -->
			<%=String.format("合計:%d個", cart.getTotalQuantity())%><br>
			<%=String.format("合計:%d円", cart.getTotal())%>
		</div>
		<br> <br> <br>
		<div class="float-right" role="alert">
			<form action="/fruitsStore/Confirm">
				<input type="submit" value="購入確定">
			</form>
		</div>

		<!--買い物を続けるボタン機能追加したい-->

		<form action="/fruitsStore/MainCart?action=2">
			<input type="submit" value="カート内を削除">
		</form>
		<br> <a href="/fruitsStore/">TOPへ</a>
	</div>

	<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>
</html>