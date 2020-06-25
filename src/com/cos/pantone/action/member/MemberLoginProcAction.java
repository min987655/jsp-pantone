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

public class MemberLoginProcAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0. 유효성 검사
		if 
		(
				request.getParameter("username").equals("") ||
				request.getParameter("username")==null ||
				request.getParameter("password").equals("") ||
				request.getParameter("password")==null
		){
			return;	
		}
		String username = request.getParameter("username");
		
		String rawPassword = request.getParameter("password");
		String password = SHA256.encodeSha256(rawPassword);
		
		MemberRepository memberRepository = MemberRepository.getInstance();
		Member member = memberRepository.findByUsernameAndPassword(username, password);
		
		if (member != null) {
			HttpSession session = request.getSession();
			session.setAttribute("principal", member);
			
			Script.href("로그인에 성공하였습니다.", "/pantone/index.jsp", response);
		} else {
			Script.back("로그인에 실패하였습니다.", response);
		}
		
	}
}
