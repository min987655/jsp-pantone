package com.cos.pantone.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.pantone.action.Action;
import com.cos.pantone.model.Member;
import com.cos.pantone.model.RoleType;
import com.cos.pantone.repository.MemberRepository;
import com.cos.pantone.utill.SHA256;
import com.cos.pantone.utill.Script;

public class MemberMyPageProcAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0. 인증 확인
		HttpSession session = request.getSession();
		if (session.getAttribute("principal") == null) {
			Script.getMessage("잘못된 접근입니다.", response);
			return;
		}
		
		// 1. 유효성 검사
		if 
		(
				request.getParameter("id").equals("") ||
				request.getParameter("id")==null ||
				request.getParameter("password").equals("") ||
				request.getParameter("password")==null ||
				request.getParameter("confirm__password").equals("") ||
				request.getParameter("confirm__password")==null ||
				request.getParameter("email").equals("") ||
				request.getParameter("email")==null
		){
			Script.back("입력되지 않은 필드가 있습니다.", response);
			return;	
		}
		// 1. 파라메터 받기
		int id = Integer.parseInt(request.getParameter("id"));
		String rawPassword = request.getParameter("password");
		String password = SHA256.encodeSha256(rawPassword);
		String email = request.getParameter("email");
		
				// 2. Member 오브젝트 변환
		Member member = Member.builder()
				.id(id)
				.password(password)
				.email(email)
				.build();
		
		// 3. DB연결  - MemberRepository
		MemberRepository memberRepository = MemberRepository.getInstance();
		int result = memberRepository.update(member);
		
		// 4. login 페이지로 이동
		if (result == 1) {
			Member principal = memberRepository.findById(id);
			session.setAttribute("principal", principal);
			Script.href("회원정보 수정에 성공하였습니다.", "/pantone/index.jsp", response);
		} else {
			Script.back("회원정보 수정에 실패하였습니다.", response);
		}
		
	}
}
