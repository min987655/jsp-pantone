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
<link rel="stylesheet" href="/pantone/css/nav.css">
<link rel="stylesheet" href="/pantone/css/body.css">
<link rel="stylesheet" href="/pantone/css/board.css">
<link rel="stylesheet" href="/pantone/css/palette.css">
<title>PANTONE</title>
<script src="js/home.js" defer></script>
</head>

<body>
	<div class="container">
		<header>
			<a href="/pantone/home.jsp"><img class="header__logo" src="/pantone/image/logo.png" alt="Logo" /></a> <a href="#" class="hamburger"><img src="/pantone/image/hamburger.png"></a>
			<nav>
				<div class="nav__bar">
					<ul class="nav__menu">
						<li class="nav__list"><a href="#">About</a></li>
						<li class="nav__list"><a href="#">Color Trend</a></li>
						<li class="nav__list"><a href="#">Palette</a></li>
						<li class="nav__list"><a href="#">FAQ</a></li>
					</ul>
					<ul class="nav__util">
<%-- 						<c:choose> --%>
<%-- 							<c:when test=""> --%>
								<li class="nav__list"><a href="/pantone/member?cmd=signin">Signin</a></li>
								<li class="nav__list"><a href="/pantone/member?cmd=login">Login</a></li>
<%-- 							</c:when> --%>
<%-- 							<c:otherwise> --%>
								<!--<li class="nav__list"><a href="/pantone/member?cmd=myPage">My Page</a></li>
                        		<li class="nav__list"><a href="/pantone/member?cmd=logout">Logout</a></li> -->
<%-- 							</c:otherwise> --%>
<%-- 						</c:choose> --%>
					</ul>
				</div>
			</nav>
		</header>
		<img class="hr" src="/pantone/image/hr.png" alt="hr">