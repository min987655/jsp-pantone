package com.cos.pantone.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.pantone.action.Action;
import com.cos.pantone.action.palette.PaletteDeleteAction;
import com.cos.pantone.action.palette.PaletteDetailAction;
import com.cos.pantone.action.palette.PaletteListAction;
import com.cos.pantone.action.palette.PaletteSearchAction;
import com.cos.pantone.action.palette.PaletteUpdateAction;
import com.cos.pantone.action.palette.PaletteUpdateProcAction;
import com.cos.pantone.action.palette.PaletteWriteAction;
import com.cos.pantone.action.palette.PaletteWriteProcAction;

//http://localhost:8000/pantone/palette
@WebServlet("/palette")
public class PaletteController extends HttpServlet {
	private final static String TAG = "PaletteController : ";
	private static final long serialVersionUID = 1L;

	public PaletteController() {
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
		// http://localhost:8000/pantone/palette?cmd=
		String cmd = request.getParameter("cmd");
		Action action = router(cmd);
		System.out.println(TAG + "action : " + action);
		action.execute(request, response);
	}
	
	public Action router(String cmd) {
		System.out.println(TAG + "cmd : " + cmd);
		if(cmd.equals("list")) {
			return new PaletteListAction();
		} else if(cmd.equals("write")) {
			return new PaletteWriteAction();
		} else if(cmd.equals("writeProc")) {
			return new PaletteWriteProcAction();
		} else if(cmd.equals("detail")) {
			return new PaletteDetailAction();
		} else if(cmd.equals("delete")) {
			return new PaletteDeleteAction();
		} else if(cmd.equals("update")) {
			return new PaletteUpdateAction();
		} else if(cmd.equals("updateProc")) {
			return new PaletteUpdateProcAction();
		} else if(cmd.equals("search")) {
			return new PaletteSearchAction();
		} 
		return null;
	}

}
