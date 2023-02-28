<!-- FUCHIMURAYUKA -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.AccountBeans"%>
<%@ page import="model.Cart"%>
<%
AccountBeans ab = (AccountBeans) session.getAttribute("account");
%>
<%
Cart cart = (Cart) session.getAttribute("cart");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0" />
<meta http-equipv="X-UA-Compatible" content="IE=edge" />

<link rel="stylesheet" type="text/css" href="css/hf.css">
<title>HEADER</title>
</head>
<body>
	<header>
		<div class="wrap">
			<div class="top">
				<img src="img/logo.gif" width="80" height="80" alt="logo"> <a
					href="/fruitsStore/" class="out"><font color="black"><h2>FRUITS
							STORE</h2></font></a>
			</div>
			<div class="top-right">
				<%
				if (ab != null) {
				%>
				<p><%=ab.getUserName()%>さんログイン中
				</p>
				<%
				} else {
				%>
				<a href="UserLoginServlet" class="btn">Login</a> <a
					href="RegisterAccount" class="btn">New account</a>
				<%
				}
				%>
				<a href="Contact" class="btn">お問い合わせ</a> <a href="Main" class="cart"><img
					src="img/cart.png" width="60" height="60" alt=""> </a>
					<% if(cart !=null){ %>
					<%= cart.getTotalQuantity() %>
					<% }else{ %>0<% }%>
				<%
				if (ab != null) {
				%>
				<a href="Logout" class="out">Logout</a>
				<%
				}
				%>

			</div>

		</div>







		<div class="gnavi__wrap">
			<ul class="gnavi__lists">
				<li class="gnavi__list"><a href="/fruitsStore/">TOP</a></li>
				<li class="gnavi__list"><a href="#">CATEGORY</a>
					<ul class="dropdown__lists">
						<li class="dropdown__list"><a href="Main?action=1">い ち ご</a></li>
						<li class="dropdown__list"><a href="Main?action=2">め ろ ん</a></li>
						<li class="dropdown__list"><a href="Main?action=3">ぶ ど う</a></li>
					</ul></li>
				<li class="gnavi__list"><a href="#">COLUMM</a>
					<ul class="dropdown__lists">
						<li class="dropdown__list"><a href="#">2023/03/01</a></li>
						<li class="dropdown__list"><a href="#">2023/02/18</a></li>
						<li class="dropdown__list"><a href="#">2023/01/01</a></li>
					</ul></li>
				<li class="gnavi__list"><a href="#">ABOUT US</a>
					<ul class="dropdown__lists">
						<li class="dropdown__list"><a href="#">会社概要</a></li>
						<li class="dropdown__list"><a href="#">営業日</a></li>
						<li class="dropdown__list"><a href="#">アクセス</a></li>
					</ul></li>

			</ul>
		</div>

	</header>
	<div class="space"></div>
</body>
</html>