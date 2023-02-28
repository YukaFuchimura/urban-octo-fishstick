<!-- YAMAMOTO -->
<!-- 今回は説明文等他WEBサイトより引用 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>めろん一覧ページ</title>
<link rel="stylesheet" type="text/css" href="css/fruits.css">
<link rel="stylesheet" type="text/css" href="css/contact.css">
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp" />
	<div class="body-container">
		<h1 class="melon_h1">Melon&emsp;List</h1>
		<div class="card-container">
			<div class="card_text">
				<a href="https://ja.wikipedia.org/wiki/%E3%83%A1%E3%83%AD%E3%83%B3"><h2>メロンとは…</h2></a>
				●DATA<br> &emsp;分類：ウリ科キュウリ属<br> &emsp;原産地：東アフリカ地方、中近東地方<br>
				&emsp;季節の分類：夏<br> &emsp;多く出回る時期：4月～9月頃<br>
				&emsp;おもな産地：茨城県（約26％）、熊本県（約14％）、北海道（約14％）<br> <br> ●歴史<br>
				&emsp;ヨーロッパにおけるメロンの歴史は古く、古代エジプトや古代ギリシャにおいてメロンの仲間が栽培されていたことが分かっています。<br>
				&emsp;しかし、メロンは暖かい地方でしか栽培できなかったため、気候のそぐわない北ヨーロッパ地域で栽培が行われるようになったのは<br>
				&emsp;14～16世紀以降といわれています。<br>
				&emsp;日本で現在のような温室メロンが生産され始めたのは大正時代になってからですが、<br>
				&emsp;少なくとも弥生時代にはすでにメロンの仲間「マクワウリ」が栽培されていたようです。<br>
				&emsp;それを裏付ける証拠として、日本各地の遺跡から土器などとともにマクワウリの種が見つかっています。<br> <br>
				●選び方<br> &emsp;熟すと甘い香りがしてお尻に少し弾力があること、<br>
				&emsp;ツル付きはツルがしなびたら完熟。熟すと果皮が少し黄色みがかるものも。<br>
				&emsp;ネットメロンは網目が細かく盛り上がっていること。<br> <br>
			</div>
			<div class="card-img">
				<img src="img/melonFruits.jpeg" alt="m">
			</div>
		</div>
		<br> <b>&emsp;---*---*---*---*---*---*---&nbsp;商品をカートに入れてください&nbsp;---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---</b>
		<table class="width-tableList" border="1">
			<c:forEach var="stock" items="${stockList2}">
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