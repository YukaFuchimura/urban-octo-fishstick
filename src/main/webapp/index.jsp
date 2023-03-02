<!-- FUCHIMURAYUKA -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FRUITSSTORE</title>
<meta name="viewport" content="width=device-width,initial-scale=1.0" />
<meta http-equipv="X-UA-Compatible" content="IE=edge" />

<link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp" />

	<div class="new-article wrapper">
		<article>
			<a href="Main?action=1"><img src="img/ichigo.jpeg" alt="a"
				width="550" height="400"></a>
			<p>STRAWBERRY ～苺～</p>
			<div class="read-more">
				<a href="Main?action=1">苺ページへ</a>
			</div>
		</article>

		<article>
			<a href="Main?action=2"><img src="img/melontop1.jpeg" alt="a"
				width="550" height="400"></a>
			<p>MELON ～メロン～</p>
			<div class="read-more">
				<a href="Main?action=2">メロンページへ</a>
			</div>
		</article>

		<article>
			<a href="Main?action=3"><img src="img/budo4.jpg" alt="a"
				width="550" height="400"></a>
			<p>GRAPES ～葡萄～</p>
			<div class="read-more">
				<a href="Main?action=3">葡萄ページへ</a>
			</div>
		</article>

	</div>

	<div class="container wrapper">
		<main>
			<article>
				<h1>季節のお便り</h1>
				<ul>
					<li>2022/01/01</li>
					<li>入荷しました！！</li>
				</ul>
				<img src="img/melontop2.jpg" alt="">
				<div class="article-intro">
					<p>究極のメロン......</p>
					<div class="read-more">
						<a href="TopControl?action=3">もっと読む</a>
					</div>
				</div>
			</article>
			<article>
				<h1>営業について</h1>
				<ul>
					<li>2022/01/01</li>
					<li>本日はお休みいただいています。</li>
				</ul>
				<img src="img/budo2.jpg" alt="">
				<div class="article-intro">
					<p>ワイナリーにやってきました。</p>
					<div class="read-more">
						<a href="TopControl?action=3">もっと読む。</a>
					</div>
				</div>
			</article>
			<article>
				<h1>取り組み</h1>
				<ul>
					<li>2022/01/01</li>
					<li>勉強会</li>
				</ul>
				<img src="img/budo.jpg" alt="">
				<div class="article-intro">
					<p>ブドウ品種の勉強会です。</p>
					<div class="read-more">
						<a href="TopControl?action=3">もっと読む。</a>
					</div>
				</div>
			</article>
		</main>

		<aside>
			<section class="author">
				<img src="img/people.jpeg" alt="a">
				<h4>WE ARE</h4>
				<p>no experience</p>
			</section>
			<section class="ranking">
				<h4>RANKING</h4>
				<div class="ranking-article">
					<a href="TopControl?action=4"> <img src="img/set.jpg" alt="a">
						<p>ランキング第一位 ￥10000</p>
					</a>
				</div>
				<div class="ranking-article">
					<a href="TopControl?action=4"> <img src="img/set2.jpg" alt="a">
						<p>ランキング第二位 ￥10000</p>
					</a>
				</div>
				<div class="ranking-article">
					<a href="TopControl?action=4"> <img src="img/set3.jpg" alt="a">
						<p>ランキング第三位 ￥10000</p>
					</a>
				</div>
			</section>
			<section class="archive">
				<h4>ARCHIVE</h4>
				<ul>
					<li><a href="TopControl?action=3">2022/1/1</a></li>
					<li><a href="TopControl?action=3">2022/1/1</a></li>
					<li><a href="TopControl?action=3">2022/1/1</a></li>
					<li><a href="TopControl?action=3">2022/1/1</a></li>
					<li><a href="TopControl?action=3">2022/1/1</a></li>
					<li><a href="TopControl?action=3">2022/1/1</a></li>
				</ul>
			</section>
		</aside>
	</div>
	<div class="bottom">
		<a href="#">TOPへ戻る</a>
	</div>
	<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>
</html>