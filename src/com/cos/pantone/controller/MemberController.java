package com.cos.pantone.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.pantone.action.Action;
import com.cos.pantone.action.member.MemberLoginAction;
import com.cos.pantone.action.member.MemberSigninAction;
import com.cos.pantone.action.member.MemberSigninProcAction;
import com.cos.pantone.action.member.MemberUsernameCheckAction;

//http://localhost:8000/pantone/member
@WebServlet("/member")
public class MemberController extends HttpServlet {
	private final static String TAG = "UsersController : ";
	private static final long serialVersionUID = 1L;

	public MemberController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// http://localhost:8000/pantone/user?cmd=
		String cmd = request.getParameter("cmd");
		System.out.println(TAG + "doProcess : " + cmd);
		Action action = router(cmd);
		System.out.println(TAG + "action : " + action);
		action.execute(request, response);
	}
	
	public Action router(String cmd) {
		System.out.println(TAG + "cmd : " + cmd);
		if(cmd.equals("signin")) {
			return new MemberSigninAction();
		} else if(cmd.equals("signinProc")) {
			return new MemberSigninProcAction();
		} else if(cmd.equals("login")) {
			return new MemberLoginAction();
		} else if(cmd.equals("usernameCheck")) {
			return new MemberUsernameCheckAction();
		}    
		return null;
	}

}
