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

	private final static String TAG = "BoardPaletteAction : ";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int page = Integer.parseInt(request.getParameter("page"));
		
		BoardRepository boardRepository = BoardRepository.getInstance();
		
		List<Board> boards = boardRepository.findAll(page);
		System.out.println(TAG + " boards : " + boards.toString());

		request.setAttribute("boards", boards);
		
		int count = boardRepository.count();
		System.out.println(TAG + "pageCount : " + count);
		int lastPage = (count-1)/9;
		
		request.setAttribute("lastPage", lastPage);
		
		RequestDispatcher dis = request.getRequestDispatcher("board/palette.jsp");
		dis.forward(request, response);
		
	}
}


