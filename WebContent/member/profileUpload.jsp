<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/include/nav.jsp"%>

<section class="grid__section__profileUpload">
	<h2>Profile Upload</h2>
	<form class="profileUpload__form" action="/pantone/member?cmd=profileUploadProc" method="POST" enctype="multipart/form-data">
		
		<p class="profileUpload__form__item">
			<img id="img__wrap" onerror="this.src='/pantone/image/userProfile.png'" src="${sessionScope.principal.userProfile}" />
		</p>
		<p class="profileUpload__form__item">
			<input type="file" name="userProfile" id="img__preview" />
		</p>
		<input type="hidden" name="id" value="${sessionScope.principal.id}" />
		<p class="profileUpload__form__item">
			<input type="submit" value="Amend" id="submit__amend">
		</p>
	</form>
</section>

<script src="/pantone/js/imgPreview.js"></script>
<%@ include file="/include/footer.jsp"%>