$("#img__preview").on("change", function(e) {
	console.log(e.target.files);
	console.log(e.target.files[0].type);
	var f = e.target.files[0];
	if (!f.type.match("image*")) {
		alert('이미지만 첨부할 수 있습니다.');
		$("#img__preview").val("");
		return;
	}
	
	if (f.size > 3145728) {
		alert('3MB이하의 이미지만 첨부 가능합니다.');
		return;
	}
	
	var reader = new FileReader();
	
	// 비동기 실행
	// I/O (파일을 하드에 저장) : 저장장치
	// 다른 이벤트 대기 : CPU
	reader.onload = function(e) { // 다운 완료 바인딩 타이밍 문제 때문에 reader보다 위에 있어야 함.
		$("#img__wrap").attr("src", e.target.result);
	};
	
	reader.readAsDataURL(f); // 파일 객체를 이미지 로드시킴. 로드 끝나면 e.target.result에 담김
});