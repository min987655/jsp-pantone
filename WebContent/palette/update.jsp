<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/include/nav.jsp"%>

<%@ include file="/include/authentication.jsp"%>

<section class="grid__section__update">

	<form class="update__form" action="/pantone/palette?cmd=updateProc" method="POST">
		
	<div class="my__palette__update">My Palette Update</div>
		<input type="hidden" value="${paletteDto.palette.id}" name="id">
		<div class="write__form__bar">
			<input value="${paletteDto.palette.title}" id="title" name="title" type="text" class="update__title" placeholder=" Title" />
			<input type="submit" value="Update" id="update__submit">
		</div>
		<p class="write__form__item">
			<textarea id="summernote" name="content" id="content" class="write__content" rows="5" placeholder="Content">${paletteDto.palette.content}</textarea>
		</p>
	
	</form>

</section>

<script src="/pantone/js/write_summernote.js"></script>

<%@ include file="/include/footer.jsp"%>