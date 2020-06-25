<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/include/nav.jsp" %>

    <h2>My Page</h2>
    <form action="/pantone/member?cmd=myPageProc">
        <p>
            <label class="user__id" for="username">ID</label>
            <input id="username" name="username" type="text" placeholder="ID" required readonly />
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