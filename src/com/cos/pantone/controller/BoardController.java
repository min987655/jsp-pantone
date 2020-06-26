package com.cos.pantone.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.pantone.action.Action;
import com.cos.pantone.action.board.BoardHomeAction;
import com.cos.pantone.action.board.BoardPaletteAction;
import com.cos.pantone.action.member.MemberSigninAction;

//http://localhost:8000/pantone/board
@WebServlet("/board")
public class BoardController extends HttpServlet {
	private final static String TAG = "BoardController : ";
	private static final long serialVersionUID = 1L;

	public BoardController() {
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
		if(cmd.equals("home")) {
			return new BoardHomeAction();
		} else if(cmd.equals("palette")) {
			return new BoardPaletteAction();
		}
		return null;
	}

}
