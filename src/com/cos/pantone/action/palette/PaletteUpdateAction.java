package com.cos.pantone.action.palette;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.pantone.action.Action;
import com.cos.pantone.dto.PaletteResponseDto;
import com.cos.pantone.dto.DetailResponseDto;
import com.cos.pantone.repository.PaletteRepository;
import com.cos.pantone.utill.Script;

public class PaletteUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (
				request.getParameter("id") == null ||
				request.getParameter("id").equals("")
		   ) {
			Script.back("잘못된 접근입니다.", response);
			return;
		}
		
		int paletteId = Integer.parseInt(request.getParameter("id"));
		PaletteRepository paletteRepository =  PaletteRepository.getInstance();
		
		PaletteResponseDto paletteDto = paletteRepository.findById(paletteId);
		System.out.println("PaletteUpdateAction : paletteDto : " + paletteDto);
		
		if (paletteDto != null) {
			request.setAttribute("paletteDto", paletteDto);
			RequestDispatcher dis = request.getRequestDispatcher("palette/update.jsp");
			dis.forward(request, response);
		}
			Script.back("잘못된 접근입니다.", response);
	}
}
