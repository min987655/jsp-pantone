<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/include/nav.jsp"%>

<%@ include file="/include/authentication.jsp"%>

<section class="grid__section__write">

	<div class="my__palette">My Palette</div>
	<form class="write__form" action="/pantone/palette?cmd=writeProc" method="POST">

		<div class="write__form__bar">
			<input id="title" name="title" type="text" class="write__title" placeholder=" Title" /> <input type="submit" value="Write" id="write__submit">
		</div>
		<p class="write__form__item">
			<textarea id="summernote" name="content" id="content" class="write__content" rows="5" placeholder="Content"></textarea>
		</p>
	</form>

</section>

<script>
	$(document).ready(function() {
		$('#summernote').summernote({
			tabsize : 2,
			height : 600,
		});
	});
	
</script>

<%@ include file="/include/footer.jsp"%>