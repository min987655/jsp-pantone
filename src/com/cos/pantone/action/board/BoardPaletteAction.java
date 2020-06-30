package com.cos.pantone.action.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.pantone.action.Action;
import com.cos.pantone.model.Board;
import com.cos.pantone.repository.BoardRepository;

public class BoardPaletteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		BoardRepository boardRepository = BoardRepository.getInstance();
		List<Board> boards = boardRepository.findAll();

		// 본문 짧게 가공하기
		for (Board board : boards) {
			String preview = board.getContent();
			preview = preview.substring(0, 2) + "...";
			board.setContent(preview);
		}
		request.setAttribute("boards", boards);
		
		RequestDispatcher dis = request.getRequestDispatcher("board/palette.jsp");
		dis.forward(request, response);
		
	}
}


