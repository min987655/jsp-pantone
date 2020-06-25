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
    <h2>Sign In</h2>
    <form action="/pantone/member?cmd=signinProc" method="post" onsubmit="return validate()">
        <p>
            <label class="user__id" for="username">ID</label>
            <input id="username" name="username" type="text" placeholder="ID" required />
            <input id="btn" name="btn" type="button" value="ID Check" onclick="usernameCheck();" />
        </p>
        <p>
            <label class="user__email" for="email">Email</label>
            <input id="email" name="email" type="email" placeholder="Email Address" required />
        </p>
        <p>
            <label class="user__password" for="password">Password</label>
            <input id="password" name="password" type="password" placeholder="Password" required />
        </p>
        <p>
            <label class="user__confirm__password" for="confirm__password">Confirm Password</label>
            <input id="confirm__password" name="confirm__password" type="password" placeholder="Confirm Password" onclick="passwordCheck();" required />
        </p>
        <p>
            <input type="submit" value="Sign In" id="submit">
        </p>
    </form>
    <script src="/pantone/js/signin.js"></script>
</body>
</html>