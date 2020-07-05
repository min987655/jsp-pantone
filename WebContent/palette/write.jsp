<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/include/nav.jsp"%>

<%@ include file="/include/authentication.jsp"%>

<section class="grid__section__write">

	<form class="write__form" action="/pantone/palette?cmd=writeProc" method="POST">

		<div class="write__form__bar">
		<div class="write__boardname">Palette</div>
			<input id="title" name="title" type="text" class="write__title" placeholder=" Title" required /> <input type="submit" value="Write" id="write__submit">
		</div>
		<p class="write__form__item">
			<textarea id="summernote" name="content" id="content" class="write__content" rows="5" required></textarea>
		</p>
	</form>

</section>

<script src="/pantone/js/write_summernote.js"></script>

<%@ include file="/include/footer.jsp"%>