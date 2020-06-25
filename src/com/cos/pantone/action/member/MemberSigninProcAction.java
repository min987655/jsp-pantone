package com.cos.pantone.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.pantone.action.Action;
import com.cos.pantone.model.Member;
import com.cos.pantone.model.RoleType;
import com.cos.pantone.repository.MemberRepository;
import com.cos.pantone.utill.SHA256;
import com.cos.pantone.utill.Script;

public class MemberSigninProcAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0. 유효성 검사
		if 
		(
				request.getParameter("username").equals("") ||
				request.getParameter("username")==null ||
				request.getParameter("password").equals("") ||
				request.getParameter("password")==null ||
				request.getParameter("confirm__password").equals("") ||
				request.getParameter("confirm__password")==null ||
				request.getParameter("email").equals("") ||
				request.getParameter("email")==null
		){
			return;	
		}
		// 1. 파라메터 받기
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String userRole = RoleType.MEMBER.toString();
		
		String rawPassword = request.getParameter("password");
		String password = SHA256.encodeSha256(rawPassword);
		
		// 2. Member 오브젝트 변환
		Member member = Member.builder()
				.username(username)
				.email(email)
				.userRole(userRole)
				.password(password)
				.build();
		
		// 3. DB연결  - MemberRepository의 save() 호출
		MemberRepository memberRepository = MemberRepository.getInstance();
		int result = memberRepository.save(member);
		
		// 4. login 페이지로 이동
		if (result == 1) {
			Script.href("회원가입에 성공하였습니다.", "/pantone/member?cmd=login", response);
		} else {
			Script.back("회원가입에 실패하였습니다.", response);
		}
		
	}
}
