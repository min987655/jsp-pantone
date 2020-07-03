<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/include/nav.jsp"%>

<section class="grid__section__faq">
	<article class="section__thumbnail">
		<div class="thumbnail__pattern">
			<ul class="thumbnail__list__faq">
				<c:forEach var="faq" items="${faqs}">
					<li class="faq__item" id="faq-${faq.id}">
						<a href="#" class="list__title__faq">
							<h4>${faq.title}</h4>
						</a>
						<div class="list__content__faq">${faq.content}</div>
					</li>
				</c:forEach>
			</ul>
		</div>
	</article>
</section>

<script src="/pantone/js/faq.js"></script>
<%@ include file="/include/footer.jsp"%>