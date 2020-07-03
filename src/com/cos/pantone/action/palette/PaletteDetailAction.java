package com.cos.pantone.action.palette;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.pantone.action.Action;
import com.cos.pantone.dto.PaletteResponseDto;
import com.cos.pantone.dto.DetailResponseDto;
import com.cos.pantone.dto.ReplyResponseDto;
import com.cos.pantone.repository.PaletteRepository;
import com.cos.pantone.repository.ReplyRepository;
import com.cos.pantone.utill.Script;

public class PaletteDetailAction implements Action {

	private final static String TAG = "PaletteDetailAction : ";
	
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
		ReplyRepository replyRepository = ReplyRepository.getInstance();		
		
		int result = paletteRepository.updateReadCount(paletteId);
		
		if (result != 1) {
			Script.back("서버 오류", response);
			return;
		}
		
		// 해당 게시물의 글과 작성자
		PaletteResponseDto paletteDto = paletteRepository.findById(paletteId);
		System.out.println("BoardDetailAction : paletteDto : " + paletteDto);
		
		// 해당 게시물의 댓글과 댓글작성자 (복수)
		List<ReplyResponseDto> replyDtos = replyRepository.findAll(paletteId);
		
		DetailResponseDto detailDto = DetailResponseDto.builder()
										.paletteDto(paletteDto)
										.replyDtos(replyDtos)
										.build();
		
		if (paletteDto != null) {
			request.setAttribute("detailDto", detailDto);
			RequestDispatcher dis = request.getRequestDispatcher("palette/detail.jsp");
			dis.forward(request, response);
		} else {
			Script.back("잘못된 접근입니다.", response);
		}
	}
}
