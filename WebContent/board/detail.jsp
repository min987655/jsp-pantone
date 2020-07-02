<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/include/nav.jsp"%>

<section class="grid__section__detail">

	<article class="board__detail">
		<div class="detail__info">
			<div class="detail__boardname">Palette</div>
			<div class="info__title">${detailDto.board.title}</div>
			<div class="info__writter">${detailDto.username}</div>
			<div class="info__readCount">조회수 : ${detailDto.board.readCount}</div>
			<div class="info__createDate">${detailDto.board.createDate}</div>
			<div class="detail__content">${detailDto.board.content}</div>
			<c:if test="${sessionScope.principal.id == detailDto.board.memberId}">
				<button class="info__update__button" onclick="location.href = '/pantone/board?cmd=update&id=${detailDto.board.id}';">Update</button>
				<button class="info__delete__button" onclick="deleteById(${detailDto.board.id})">Delete</button>
			</c:if>
		</div>
	</article>

	<article class="board__reply">
		<div class="reply__pattern">
			<ul class="reply__list">
				<li class="reply">
					<div class="reply__userProfile">
						<hr class="reply__hr" />
						<div class="reply__userProfile__img">
							<img src="#" alt="userProfile" onerror="this.src='/pantone/image/userProfile.png'" />
						</div>
						<div class="reply__username">username</div>
						<div class="reply__createDate">createDate</div>
						<div class="reply__content">content</div>
						<button class="reply__delete__button" onclick="#">Delete</button>
					</div>
				</li>
			</ul>
			<ul class="reply__list">
				<li class="reply">
					<div class="reply__userProfile">
						<hr class="reply__hr" />
						<div class="reply__userProfile__img">
							<img src="#" alt="userProfile" onerror="this.src='/pantone/image/userProfile.png'" />
						</div>
						<div class="reply__username">username</div>
						<div class="reply__createDate">createDate</div>
						<div class="reply__content">content</div>
						<button class="reply__delete__button" onclick="#">Delete</button>
					</div>
				</li>
			</ul>
		</div>
		<div class="reply__write">
			<div class="reply__write__box">
				<div class="reply__write__username">username</div>
				<textarea class="reply__write__form" id="reply__write__form" placeholder="reply content..." rows="3"></textarea>
				<button class="reply__write__button" onclick="#">Write</button>
			</div>
		</div>
	</article>
</section>

<script src="/pantone/js/detail.js"></script>
<%@ include file="/include/footer.jsp"%>