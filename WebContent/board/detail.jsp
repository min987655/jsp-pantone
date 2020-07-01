<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/include/nav.jsp"%>

<section class="grid__section__detail">

	<article class="board__detail">
		<div class="detail__info">
			<div class="detail__boardname">Palette</div>
			<div class="info__title">${dto.board.title}</div>
			<div class="info__writter">${dto.username}</div>
			<div class="info__readCount">조회수 : ${dto.board.readCount}</div>
			<div class="info__createDate">${dto.board.createDate}</div>
			<div class="detail__content">${dto.board.content}</div>
			<c:if test="${sessionScope.principal.id == dto.board.memberId}">
				<button class="info__update__button" onclick="location.href = '/pantone/board?cmd=update&id=${dto.board.id}';">Update</button>
				<button class="info__delete__button" onclick="deleteById(${dto.board.id})">Delete</button>
			</c:if>
		</div>
	</article>
</section>

<script src="/pantone/js/detail.js"></script>
<%@ include file="/include/footer.jsp"%>