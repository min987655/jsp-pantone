$(document).ready(function() {
	$('#summernote').summernote({
		toolbar: [
			['Font Style', ['fontname']],
			['style', ['bold', 'italic', 'underline']],
			['font', ['strikethrough']],
			['fontsize', ['fontsize']],
			['color', ['color']],
			['para', ['paragraph']],
			['height', ['height']],
			['Insert', ['picture']],
			['Insert', ['link']],
			['Misc', ['fullscreen']]
		],
		tabsize: 2,
		height: 600,
		placeholder: "Content"
	});
});