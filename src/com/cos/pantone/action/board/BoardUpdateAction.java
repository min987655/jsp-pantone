package com.cos.pantone.action.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.pantone.action.Action;
import com.cos.pantone.dto.DetailResponseDto;
import com.cos.pantone.repository.BoardRepository;
import com.cos.pantone.utill.Script;

public class BoardUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (
				request.getParameter("id") == null ||
				request.getParameter("id").equals("")
		   ) {
			Script.back("잘못된 접근입니다.", response);
			return;
		}
		
		int boardId = Integer.parseInt(request.getParameter("id"));
		BoardRepository boardRepository =  BoardRepository.getInstance();
		
		DetailResponseDto dto = boardRepository.findById(boardId);
		System.out.println("BoardUpdateAction : dto : " + dto);
		
		if (dto != null) {
			request.setAttribute("dto", dto);
			RequestDispatcher dis = request.getRequestDispatcher("board/update.jsp");
			dis.forward(request, response);
		}
			Script.back("잘못된 접근입니다.", response);
	}
}
