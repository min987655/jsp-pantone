<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/include/nav.jsp"%>

<section class="grid__section__palette">
	<article class="section__thumbnail">
		<div class="thumbnail__pattern">
			<ul class="thumbnail__list__palette">
			
				<c:forEach var="board" items="${boards}">
				<li><a href="#" class="inner">
						<div class="list__img__palette">
							<img class="img" src="/pantone/image/thumbnail.png" alt="thumbnail" />
						</div>
						<div class="list-text">
							<h4 class="list-head">${board.title}</h4>
							<p class="list-sub">${board.keyword}</p>
						</div>
				</a></li>
				</c:forEach>
<!-- 				<li><a href="#" class="inner"> -->
<!-- 						<div class="list__img__palette"> -->
<!-- 							<img class="img" src="/pantone/image/thumbnail.png" alt="thumbnail" /> -->
<!-- 						</div> -->
<!-- 						<div class="list-text"> -->
<!-- 							<h4 class="list-head">제목</h4> -->
<!-- 							<p class="list-sub">keyword</p> -->
<!-- 						</div> -->
<!-- 				</a></li> -->
<!-- 				<li><a href="#" class="inner"> -->
<!-- 						<div class="list__img__palette"> -->
<!-- 							<img class="img" src="/pantone/image/thumbnail.png" alt="thumbnail" /> -->
<!-- 						</div> -->
<!-- 						<div class="list-text"> -->
<!-- 							<h4 class="list-head">제목</h4> -->
<!-- 							<p class="list-sub">keyword</p> -->
<!-- 						</div> -->
<!-- 				</a></li> -->
<!-- 				<li><a href="#" class="inner"> -->
<!-- 						<div class="list__img__palette"> -->
<!-- 							<img class="img" src="/pantone/image/thumbnail.png" alt="thumbnail" /> -->
<!-- 						</div> -->
<!-- 						<div class="list-text"> -->
<!-- 							<h4 class="list-head">제목</h4> -->
<!-- 							<p class="list-sub">keyword</p> -->
<!-- 						</div> -->
<!-- 				</a></li> -->
<!-- 				<li><a href="#" class="inner"> -->
<!-- 						<div class="list__img__palette"> -->
<!-- 							<img class="img" src="/pantone/image/thumbnail.png" alt="thumbnail" /> -->
<!-- 						</div> -->
<!-- 						<div class="list-text"> -->
<!-- 							<h4 class="list-head">제목</h4> -->
<!-- 							<p class="list-sub">keyword</p> -->
<!-- 						</div> -->
<!-- 				</a></li> -->
<!-- 				<li><a href="#" class="inner"> -->
<!-- 						<div class="list__img__palette"> -->
<!-- 							<img class="img" src="/pantone/image/thumbnail.png" alt="thumbnail" /> -->
<!-- 						</div> -->
<!-- 						<div class="list-text"> -->
<!-- 							<h4 class="list-head">제목</h4> -->
<!-- 							<p class="list-sub">keyword</p> -->
<!-- 						</div> -->
<!-- 				</a></li> -->
<!-- 				<li><a href="#" class="inner"> -->
<!-- 						<div class="list__img__palette"> -->
<!-- 							<img class="img" src="/pantone/image/thumbnail.png" alt="thumbnail" /> -->
<!-- 						</div> -->
<!-- 						<div class="list-text"> -->
<!-- 							<h4 class="list-head">제목</h4> -->
<!-- 							<p class="list-sub">keyword</p> -->
<!-- 						</div> -->
<!-- 				</a></li> -->
<!-- 				<li><a href="#" class="inner"> -->
<!-- 						<div class="list__img__palette"> -->
<!-- 							<img class="img" src="/pantone/image/thumbnail.png" alt="thumbnail" /> -->
<!-- 						</div> -->
<!-- 						<div class="list-text"> -->
<!-- 							<h4 class="list-head">제목</h4> -->
<!-- 							<p class="list-sub">keyword</p> -->
<!-- 						</div> -->
<!-- 				</a></li> -->
<!-- 				<li><a href="#" class="inner"> -->
<!-- 						<div class="list__img__palette"> -->
<!-- 							<img class="img" src="/pantone/image/thumbnail.png" alt="thumbnail" /> -->
<!-- 						</div> -->
<!-- 						<div class="list-text"> -->
<!-- 							<h4 class="list-head">제목</h4> -->
<!-- 							<p class="list-sub">keyword</p> -->
<!-- 						</div> -->
<!-- 				</a></li> -->
			</ul>
		</div>
	</article>
</section>

<%@ include file="/include/footer.jsp"%>