<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/include/nav.jsp"%>

<section class="grid__section__detail">

	<article class="board__detail">
		<div class="detail__info">
			<div class="detail__boardname">Palette</div>
			<div class="info__title">${detailDto.boardDto.board.title}</div>
			<div class="info__writter">${detailDto.boardDto.username}</div>
			<div class="info__readCount">조회수 : ${detailDto.boardDto.board.readCount}</div>
			<div class="info__createDate">${detailDto.boardDto.board.createDate}</div>
			<div class="detail__content">${detailDto.boardDto.board.content}</div>
			<c:if test="${sessionScope.principal.id == detailDto.boardDto.board.memberId}">
				<button class="info__update__button" onclick="location.href = '/pantone/board?cmd=update&id=${detailDto.boardDto.board.id}';">Update</button>
				<button class="info__delete__button" onclick="deleteById(${detailDto.boardDto.board.id})">Delete</button>
			</c:if>
		</div>
	</article>

	<article class="board__reply">
		<div class="reply__pattern">
			<ul id="reply__list">
				<c:forEach var="replyDto" items="${detailDto.replyDtos}">
					<li class="reply" id="reply-${replyDto.reply.id}">
						<div class="reply__userProfile">
							<hr class="reply__hr" />
							<div class="reply__userProfile__img">
								<img src="${replyDto.userProfile}" alt="userProfile" onerror="this.src='/pantone/image/userProfile.png'" />
							</div>
							<div class="reply__username">${replyDto.username}</div>
							<div class="reply__createDate">${replyDto.reply.createDate}</div>
							<div class="reply__content">${replyDto.reply.content}</div>
							<c:if test="${replyDto.reply.memberId == sessionScope.principal.id}">
								<button class="reply__delete__button" onclick="replyDelete(${replyDto.reply.id})">Delete</button>
							</c:if>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>

		<div class="reply__write">
			<div class="reply__write__box">
				<div class="reply__write__username">${sessionScope.principal.username}</div>
				<textarea class="reply__write__form" id="reply__write__form" placeholder="reply content..." rows="4"></textarea>
				<button class="reply__write__button" onclick="replyWrite(${detailDto.boardDto.board.id}, ${sessionScope.principal.id})">Write</button>
			</div>
		</div>
	</article>
</section>

<script src="/pantone/js/reply.js"></script>
<script src="/pantone/js/detail.js"></script>
<%@ include file="/include/footer.jsp"%>