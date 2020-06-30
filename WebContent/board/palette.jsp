<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/include/nav.jsp"%>

<section class="grid__section__palette">
	<article class="section__thumbnail">
		<div class="thumbnail__pattern">
			<ul class="thumbnail__list__palette">

				<c:forEach var="board" items="${boards}">
					<li>
						<a href="#" class="inner">
							<div class="list__img__palette">
								<img class="img" src="/pantone/image/thumbnail.png" alt="thumbnail" />
							</div>
							<div class="list-text">
								<h4 class="list-head">${board.title}</h4>
<%-- 								<p class="list-sub">${board.content}</p> --%>
							</div>
						</a>
					</li>
				</c:forEach>
			</ul>
		</div>
		<div class="palette__write">
			<ul class="page">
				<li class="page__item__pre">
					<a class="page__link" href="#"> <img class="page__pre__img" src="/pantone/image/page_pre.png">
					</a>
				</li>
				<li class="page__item__next">
					<a class="page__link" href="#"> <img class="page__next__img" src="/pantone/image/page_next.png">
					</a>
				</li>
			</ul>
			<div class="palette__write__button">
				<a href="/pantone/board?cmd=write"><input type="submit" value="Write" id="palette__write__submit"></a>
			</div>
		</div>
	</article>
</section>

<%@ include file="/include/footer.jsp"%>