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
import com.cos.pantone.action.reply.ReplyDeleteProcAction;
import com.cos.pantone.action.reply.ReplyWriteProcAction;

//http://localhost:8000/pantone/reply
@WebServlet("/reply")
public class ReplyController extends HttpServlet {
	private final static String TAG = "ReplyController : ";
	private static final long serialVersionUID = 1L;

	public ReplyController() {
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
		// http://localhost:8000/pantone/reply?cmd=
		String cmd = request.getParameter("cmd");
		Action action = router(cmd);
		System.out.println(TAG + "action : " + action);
		action.execute(request, response);
	}
	
	public Action router(String cmd) {
		System.out.println(TAG + "cmd : " + cmd);
		if(cmd.equals("writeProc")) {
			return new ReplyWriteProcAction();
		} else if (cmd.equals("deleteProc")) {
			return new ReplyDeleteProcAction();
		}
		return null;
	}

}
