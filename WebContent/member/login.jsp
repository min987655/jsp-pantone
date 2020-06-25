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
    <h2>Log In</h2>
    <form action="#" method="post">
        <p>
            <label class="user__id" for="id">ID</label>
            <input id="id" name="id" type="text" placeholder="ID" required />
        </p>
        <p>
            <label class="user__password" for="password">Password</label>
            <input id="password" name="password" type="password" placeholder="Password" required />
        </p>
        <p>
            <input type="submit" value="LogIn" id="submit">
        </p>
    </form>
</body>

</html>