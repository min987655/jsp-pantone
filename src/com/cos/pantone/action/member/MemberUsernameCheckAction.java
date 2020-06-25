package com.cos.pantone.action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.pantone.action.Action;
import com.cos.pantone.repository.MemberRepository;
import com.cos.pantone.utill.Script;

public class MemberUsernameCheckAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		
		MemberRepository memberRepository = MemberRepository.getInstance();
		int result = memberRepository.findByUsername(username);
		
		Script.outText(result+"", response);
	}	
}
