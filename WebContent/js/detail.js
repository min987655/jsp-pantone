
function deleteById(boardId) {
	
	$.ajax({
			type : "POST",
			url : "/pantone/board?cmd=delete&id="+boardId,
			dataType : "text"
	}).done(function(result) {
		console.log(result);
		if (result == 1) {
			alert("게시글을 삭제하였습니다.");
			location.href="/pantone/board?cmd=palette&page=0";
		} else {
			alert("게시글 삭제에 실패하였습니다.");
		}
	}).fail(function(error) {
		console.log(error);
		console.log(error.responseText);
		console.log(error.status);
		alert("서버 오류");
	});
	
}