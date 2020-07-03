
function replyDelete(replyId) {
	
	$.ajax({
		type: "POST",
		url: "/pantone/reply?cmd=deleteProc",
		data: "replyId="+replyId,
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		dataType: "text"
	}).done(function(result) {
		if (result == 1) {
			alert("댓글 삭제에 성공하였습니다.");
			var replyItem = $("#reply-"+replyId);
			replyItem.remove();
		} else {
			alert("댓글 삭제에 실패하였습니다.");
		}
	}).fail(function(error) {
			alert("댓글 삭제에 실패하였습니다.");
	});
}


function replyWrite(paletteId, memberId) {
	
	if (memberId === undefined) {
		alert("로그인이 필요합니다.");
		return;
	}
	
	var data = {
		paletteId: paletteId,
		memberId: memberId,
		content: $("#reply__write__form").val()
	};
	
	$.ajax({
		type: "POST",
		url: "/pantone/reply?cmd=writeProc",
		data: JSON.stringify(data),
		contentType: "application/json; charset=utf-8",
		dataType: "json"
	}).done(function(result) {
		if (result == -1 || result == 0) {
			alert("댓글 작성에 실패하였습니다.");
		} else {
			alert("댓글 작성에 성공하였습니다.");
			$("#reply__list").empty();
			console.log(result);
			renderReplyList(result, memberId);
			$("#reply__write__form").val("");
			
		}
		
	}).fail(function(error) {
		alert("댓글 작성에 실패하였습니다.");
	});
}

function renderReplyList(replyDtos, memberId) {
	for(var replyDto of replyDtos)
		$("#reply__list").append(makeReplyItem(replyDto, memberId));
}

function makeReplyItem(replyDto, memberId) {
	// reply-id 추가 시작
	var replyItem = `<li class="reply" id="reply-${replyDto.reply.id}">`; 
	// reply-id 추가 끝

	replyItem += `<div class="reply__userProfile">`;
	replyItem += `<hr class="reply__hr" />`; 
	
	if (replyDto.userProfile == null) {
		replyItem += `<div class="reply__userProfile__img">`;
		replyItem += `<img src="/pantone/image/userProfile.png" />`;
		replyItem += `</div>`; 
	} else {
		replyItem += `<div class="reply__userProfile__img">`;
		replyItem += `<img src="${replyDto.userProfile}" />`;		
		replyItem += `</div>`; 
	}
	
	replyItem += `<div class="reply__username">${replyDto.username}</div>`;
	replyItem += `<div class="reply__createDate">${replyDto.reply.createDate}</div>`; 
	replyItem += `<div class="reply__content">${replyDto.reply.content}</div>`; 
	
	// 휴지통 추가 시작
	if (replyDto.reply.memberId == memberId) {
		replyItem += `<button class="reply__delete__button" onclick="replyDelete(${replyDto.reply.id})">Delete</button>`;		
	}
	// 휴지통 추가 끝
	
	replyItem += `</div>`; 
	replyItem += `</li>`;
	
	return replyItem;
}