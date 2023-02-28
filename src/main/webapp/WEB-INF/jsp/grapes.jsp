<!-- YAMAMOTO -->
<!-- 今回は説明文等他WEBサイトより引用 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ぶどう一覧ページ</title>
<link rel="stylesheet" type="text/css" href="css/fruits.css">
<link rel="stylesheet" type="text/css" href="css/contact.css">
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp" />
	<div class="body-container">
		<h1 class="grapes_h1">Grapes&emsp;List</h1>
		<div class="card-container">
			<div class="card_text">
				<a href="https://ja.wikipedia.org/wiki/%E3%83%96%E3%83%89%E3%82%A6"><h2>ぶどうとは…</h2></a>
				●DATA<br> &emsp;分類：ブドウ科ブドウ属<br> &emsp;原産地：中近東地方<br>
				&emsp;季節の分類：夏秋<br> &emsp;多く出回る時期：6月～10月頃<br>
				&emsp;山梨県（約24％）、長野県（約18％）、山形県（約9％）<br> <br> ●歴史<br>
				&emsp;現在栽培されている品種の多くは、ブドウの祖先といわれる「ヨーロッパブドウ」と「アメリカブドウ」を交配したものがもとになっています。<br>
				&emsp;ヨーロッパブドウの歴史は紀元前4000～3000年と古く、古代エジプトの壁画にも栽培の様子が描かれています。<br>
				&emsp;日本への渡来ルートは、中近東地方から古代ヨーロッパ、その後シルクロードを横断して中国へ、
				&emsp;そして奈良時代に中国から日本に伝わったといわれています。<br>
				&emsp;アメリカブドウは北米が原産で、これも古くから自生していました。日本で本格的に栽培が行われるようになったのは明治時代に入ってからですが<br>、
				&emsp;山梨県原産の「甲州ぶどう」は、鎌倉時代初期にはすでに栽培されていたようです。<br> <br> ●選び方<br>
				&emsp;実がふっくらとして果皮に張りがある<br>
				&emsp;果皮にブルーム（白い粉）が付着していて、軸がきれいな緑色をしていること。<br> <br>
			</div>
			<div class="card-img">
				<img src="img/grapesFruits.jpeg" alt="g">
			</div>
		</div>
		<br> <b>&emsp;---*---*---*---*---*---*---&nbsp;商品をカートに入れてください&nbsp;---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---*---</b>
		<table class="width-tableList" border="1">
			<c:forEach var="stock" items="${stockList3}">
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