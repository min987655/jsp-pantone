package com.cos.pantone.action.palette;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.pantone.action.Action;
import com.cos.pantone.repository.PaletteRepository;
import com.cos.pantone.utill.Script;

public class PaletteDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if (session.getAttribute("principal") == null) {
			Script.getMessage("잘못된 접근입니다.", response);
			return;
		}
		
		if (
				request.getParameter("id") == null ||
				request.getParameter("id").equals("")
		   ) {
			return;
		}
		
		int paletteId = Integer.parseInt(request.getParameter("id"));
		PaletteRepository boardRepository =  PaletteRepository.getInstance();
		
		int result = boardRepository.deleteById(paletteId);
		System.out.println("BoardDeleteAction : result : " + result);
		PrintWriter out = response.getWriter();
		out.print(result);
	}
}
