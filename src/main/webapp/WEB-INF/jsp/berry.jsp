<!-- YAMAMOTO -->
<!-- 今回は説明文等他WEBサイトより引用 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>いちご一覧ページ</title>
<link rel="stylesheet" type="text/css" href="css/fruits.css">
<link rel="stylesheet" type="text/css" href="css/contact.css">
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp" />
	<div class="body-container">
		<h1 class="berry_h1">Strawberry&emsp;List</h1>
		<div class="card-container">
			<div class="card_text">
				<a href="https://ja.wikipedia.org/wiki/%E3%82%A4%E3%83%81%E3%82%B4"><h2>イチゴとは…</h2></a>
				●DATA<br> &emsp;分類：バラ科オランダイチゴ属<br>
				&emsp;原産地：北アメリカ地方、南アメリカ地方<br> &emsp;季節の分類：冬春<br>
				&emsp;多く出回る時期：12月～5月頃<br>
				&emsp;おもな産地：栃木県（約15％）、福岡県（約10％）、熊本県（約7％）<br> <br> ●歴史<br>
				&emsp;野生のイチゴは石器時代からヨーロッパ、アジア一帯で食べられていましたが、現在のようなイチゴが栽培されはじめたのは<br>
				&emsp;200年ほど前のことです。<br>
				&emsp;南アメリカから持ち込まれた品種と、北アメリカから持ち込まれた品種が自然交雑したものといわれています。<br>
				&emsp;日本には江戸時代の終わり頃に伝わりましたが、そのときには定着せず、その後明治32年頃にフランスの品種が導入されたことで<br>
				&emsp;本格的な栽培が始まりました。<br> <br> ●選び方<br>
				&emsp;果実全体が赤く染まっていて、果皮に張りとツヤがあること。
				&emsp;果実の先端に白色や緑色が残っていない、へたがピンとしてツブツブがくっきりしていて、いちご特有の甘い香りがする。<br>
				<br>
			</div>
			<div class="card-img">
				<img src="img/berryFruits.jpeg" alt="b">
			</div>
		</div>
		<br> <b>&emsp;---*---*---*---*---*---*---&nbsp;商品をカートに入れてください&nbsp;---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---</b>
		<table class="width-tableList" border="1">
			<c:forEach var="stock" items="${stockList1}">
				<tr>
					<td class="width-tableListphoto"><img
						src="<c:out value="${stock.url}" />" width="400dp" height="250dp"><br>
					</td>
					<td class="width-tableListtext">
						<h2>
							品種名：
							<c:out value="${stock.name}" />
						</h2> <b>&emsp;<c:out value="${stock.feature}" /></b> <br>
					<br>
						<h3>
							価格：
							<c:out value="${stock.price}" />
							円<br>
							<form
								action="/fruitsStore/Main?name=<c:out value="${stock.name}"/>&price=<c:out value="${stock.price}"/>"
								method="post">
								数量<input type="number" name="quantity" style="width: 50px"
									maxlength="1" required>&nbsp;<input type="submit"
									value="カートに追加">
						</h3>
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
		<br>
	</div>
	<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>
</html>