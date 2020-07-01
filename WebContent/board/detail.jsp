<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/include/nav.jsp"%>

<section class="grid__section__detail">

	<article class="board__detail">
		<div class="detail__boardname">Palette</div>
		<div class="detail__info">
			<h3 class="info__title">${dto.board.title}</h3>
			<div class="info__writter">${dto.username}</div>
			<div class="info__readCount">${dto.board.readCount}</div>
			<div class="info__createDate">${dto.board.createDate}</div>

			<c:if test="${sessionScope.principal.id == dto.board.memberId}">
				<button class="info__update__button" onclick="location.href = '/pantone/board?cmd=update&id=${dto.board.id}';">수정</button>
				<button class="info__delete__button" onclick="deleteById(${dto.board.id})">삭제</button>
			</c:if>
		</div>
		<hr />
		<div class="detail__content">${dto.board.content}</div>
		<hr />
	</article>
</section>

<script src="/pantone/js/detail.js"></script>
<%@ include file="/include/footer.jsp"%>