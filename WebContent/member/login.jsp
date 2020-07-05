<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<link href="https://fonts.googleapis.com/css2?family=Heebo:wght@350&display=swap" rel="stylesheet">
<link rel="stylesheet" href="/pantone/css/login.css">
<title>Login</title>

</head>

<body>
	<section class="grid__section__login">
		<h2>Log In</h2>
		<form class="login__form" action="/pantone/member?cmd=loginProc" method="post">
			<p class="login__form__item">
				<label class="user__id" for="id">ID</label>
				<input value="${cookie.remember.value}" id="username" name="username" type="text" placeholder="ID" required />
			</p>
			<p class="login__form__item">
				<label class="user__password" for="password">Password</label>
				<input id="password" name="password" type="password" placeholder="Password" required />
			</p>
			<p class="login__form__item">
				<input type="submit" value="LogIn" id="submit">
			</p>

			<c:choose>
				<c:when test="${empty cookie.remember}">
					<input id="check_test_box" value="on" class="form__check__input" type="checkbox" name="remember">
					<label for="check_test_box"> <span></span>remember ID</label>
	      	</c:when>
				<c:otherwise>
					<input id="check_test_box" value="on" class="form__check__input" type="checkbox" name="remember" checked>
					<label for="check_test_box"> <span></span>remember ID</label>
	      	</c:otherwise>
			</c:choose>
				<div class="login__signin__link"><a href="/pantone/member?cmd=signin">Signin</a></div>
		</form>
	</section>
</body>

</html>