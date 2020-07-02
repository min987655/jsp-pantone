
var isCheckedUsername = false;

function validate() {
	
	if (isCheckedUsername === false) {
		alert('ID Check를 해주세요.');
	}
	return isCheckedUsername;
}

function usernameCheck() {
	
	var tfUsername = $('#username').val();
	console.log(tfUsername);
//	var usernameReg = /^[\w]{4,12}$/; //아이디와 비밀번호에 사용할 정규표현식
	
	if (tfUsername=="") {
		alert('ID를 입력 해주세요.');
		return false;
	} 
//	else if (!usernameReg.test(tfUsername)) {
//		alert();
//	}
		
	$.ajax({
		type : 'get',
		url : `/pantone/member?cmd=usernameCheck&username=${tfUsername}`
	}).done(function(result) {
		console.log(result);
		if(result == 1) {
			alert('아이디가 중복되었습니다.');
		} else if (result == 0) {
			alert('사용할 수 있는 아이디입니다.');
			isCheckedUsername = true;
		} else {
			console.log('develop : 서버 오류');
		}
		
	}).fail(function(error) {
		console.log(error);
	});
}

