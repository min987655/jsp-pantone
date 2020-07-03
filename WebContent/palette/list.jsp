<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/include/nav.jsp"%>

<section class="grid__section__palette">
	<article class="section__thumbnail">

		<div class="thumbnail__pattern">
			<ul class="thumbnail__list__palette">
				<c:forEach var="palette" items="${palettes}">
					<li>
						<a href="/pantone/palette?cmd=detail&id=${palette.id}" class="inner">
							<div class="list__img__palette">
								<img class="img" src="${palette.content}" onerror="this.src='/pantone/image/thumbnail.png'" alt="thumbnail"  />
							</div>
							<div class="list-text">
								<h4 class="list-head">${palette.title}</h4>
							</div>
						</a>
					</li>
				</c:forEach>
			</ul>
		</div>

		<div class="palette__write">
			<ul class="page">

				<c:choose>
					<c:when test="${param.page == 0}">
						<li class="page__item__pre">
							<a class="page__link" href=""> <img
									class="page__pre__img" src="/pantone/image/page_pre.png">
							</a>
						</li>
					</c:when>
					<c:otherwise>
						<li class="page__item__pre">
							<a class="page__link" href="/pantone/palette?cmd=list&page=${param.page-1}"> <img
									class="page__pre__img" src="/pantone/image/page_pre.png">
							</a>
						</li>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${lastPage == param.page}">
						<li class="page__item__next">
							<a class="page__link" href=""> <img
									class="page__next__img" src="/pantone/image/page_next.png">
							</a>
						</li>
					</c:when>
					<c:otherwise>
						<li class="page__item__next">
							<a class="page__link" href="/pantone/palette?cmd=list&page=${param.page+1}"> <img
									class="page__next__img" src="/pantone/image/page_next.png">
							</a>
						</li>
					</c:otherwise>
				</c:choose>
			</ul>
			<div class="palette__write__button">
				<a href="/pantone/palette?cmd=write"><input type="submit" value="Write" id="palette__write__submit"></a>
			</div>
		</div>
	</article>
</section>

<%@ include file="/include/footer.jsp"%>