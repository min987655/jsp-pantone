<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/include/nav.jsp"%>

<section class="grid__section__myPage">
	<h2>My Page</h2>
	<form class="myPage__form" action="/pantone/member?cmd=myPageProc" method="POST">
		
		<input type="hidden" name="id" value="${sessionScope.principal.id}" />
		<p class="myPage__form__item">
			<label class="user__id" for="username">ID</label> 
			<input value="${sessionScope.principal.username}" id="username" name="username" type="text" placeholder="ID" required readonly /> 
		</p>
		<p class="myPage__form__item">
			<label class="user__email" for="email">Email</label> 
			<input value="${sessionScope.principal.email}" id="email" name="email" type="email" placeholder="Email Address" required />
		</p>
		<p class="myPage__form__item">
			<label class="user__password" for="password">Password</label> 
			<input id="password" name="password" type="password" placeholder="Password" required />
		</p>
		<p class="myPage__form__item">
			<label class="user__confirm__password" for="confirm__password">Confirm Password</label> 
			<input id="confirm__password" name="confirm__password" type="password" placeholder="Confirm Password" onclick="passwordCheck();" required />
		</p>
		<p class="myPage__form__item">
			<input type="submit" value="Amend" id="submit__amend">
		</p>
	</form>
</section>

<%@ include file="/include/footer.jsp"%>