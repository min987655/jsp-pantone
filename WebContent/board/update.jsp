<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/include/nav.jsp"%>

<%@ include file="/include/authentication.jsp"%>

<section class="grid__section__update">

	<div class="my__palette__update">My Palette Update</div>
	<form class="update__form" action="/pantone/board?cmd=updateProc" method="POST">
		
		<input type="hidden" value="${dto.board.id}" name="id">
		<div class="write__form__bar">
			<input value="${dto.board.title}" id="title" name="title" type="text" class="update__title" placeholder=" Title" />
			<input type="submit" value="Update" id="update__submit">
		</div>
		<p class="write__form__item">
			<textarea id="summernote" name="content" id="content" class="write__content" rows="5" placeholder="Content">${dto.board.content}</textarea>
		</p>
	
	</form>

</section>

<script>
	$(document).ready(function() {
		$('#summernote').summernote({
			tabsize : 2,
			height : 600
		});
	});
</script>

<%@ include file="/include/footer.jsp"%>