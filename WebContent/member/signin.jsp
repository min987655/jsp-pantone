<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@350&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/pantone/css/signin.css">
    <title>Signin</title>

</head>

<body>
	<section class="grid__section__signin">
    <h2>Sign In</h2>
    <form class="signin__form" action="/pantone/member?cmd=signinProc" method="post" class="was-validated" onsubmit="return validate();">
        <p class="signin__form__item">
            <label class="user__id" for="username">ID</label>
            <input id="username" name="username" type="text" placeholder="ID" required />
            <input id="btn" name="btn" type="button" value="ID Check" onClick="usernameCheck();" />
        </p>
        <p class="signin__form__item">
            <label class="user__email" for="email">Email</label>
            <input id="email" name="email" type="email" placeholder="Email Address" required />
        </p>
        <p class="signin__form__item">
            <label class="user__password" for="password">Password</label>
            <input class="password" id="password" name="password" type="password" placeholder="Password" required />
        </p>
        <p class="signin__form__item">
            <label class="user__confirm__password" for="confirm__password">Confirm Password</label>
            <input class="password" id="confirm__password" name="confirm__password" type="password" placeholder="Confirm Password" onclick="passwordCheck();" required />
			<div class="alert__success" id="alert__success">The passwords match.</div>
			<div class="alert__danger" id="alert__danger">Passwords do not match.</div>       
        </p>
        <p class="signin__form__item">
            <input type="submit" value="Sign In" id="submit">
        </p>
    </form>
    </section>
    <script src="/pantone/js/signin.js"></script>
    <script>
    	$(function() {
			$("#alert__success").hide();
			$("#alert__danger").hide();
			$(".password").keyup(function() {
				const pw = $("#password").val();
				const conPw = $("#confirm__password").val();
				if ( pw != "" || conPw != "") { 
					if (pw == conPw) {
						$("#alert__success").show();
						$("#alert__danger").hide();
// 						submit 비활성화 속성을 제거해주는 코드
						$("#submit").removeAttr("disabled");
					} else {
						$("#alert__success").hide();
						$("#alert__danger").show();
// 						submit을 비활성화 시키는 코드 
						$("#submit").attr("disabled", "disabled");
					}
				}
			});
		});
    
    
    
    </script>
</body>
</html>