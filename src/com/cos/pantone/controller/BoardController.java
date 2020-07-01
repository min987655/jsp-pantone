package com.cos.pantone.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.pantone.action.Action;
import com.cos.pantone.action.board.BoardDeleteAction;
import com.cos.pantone.action.board.BoardDetailAction;
import com.cos.pantone.action.board.BoardHomeAction;
import com.cos.pantone.action.board.BoardPaletteAction;
import com.cos.pantone.action.board.BoardUpdateAction;
import com.cos.pantone.action.board.BoardUpdateProcAction;
import com.cos.pantone.action.board.BoardWriteAction;
import com.cos.pantone.action.board.BoardWriteProcAction;
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
		HttpSession session = request.getSession();
		session.setAttribute("path", request.getContextPath());
		// http://localhost:8000/pantone/user?cmd=
		String cmd = request.getParameter("cmd");
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
		} else if(cmd.equals("write")) {
			return new BoardWriteAction();
		} else if(cmd.equals("writeProc")) {
			return new BoardWriteProcAction();
		} else if(cmd.equals("detail")) {
			return new BoardDetailAction();
		} else if(cmd.equals("delete")) {
			return new BoardDeleteAction();
		} else if(cmd.equals("update")) {
			return new BoardUpdateAction();
		} else if(cmd.equals("updateProc")) {
			return new BoardUpdateProcAction();
		}
		return null;
	}

}
