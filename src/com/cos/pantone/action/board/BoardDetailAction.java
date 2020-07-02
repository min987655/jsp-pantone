package com.cos.pantone.action.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.pantone.action.Action;
import com.cos.pantone.dto.BoardResponseDto;
import com.cos.pantone.dto.DetailResponseDto;
import com.cos.pantone.dto.ReplyResponseDto;
import com.cos.pantone.repository.BoardRepository;
import com.cos.pantone.repository.ReplyRepository;
import com.cos.pantone.utill.Script;

public class BoardDetailAction implements Action {

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
		ReplyRepository replyRepository = ReplyRepository.getInstance();		
		
		int result = boardRepository.updateReadCount(boardId);
		
		if (result != 1) {
			Script.back("서버 오류", response);
			return;
		}
		
		// 해당 게시물의 글과 작성자
		BoardResponseDto boardDto = boardRepository.findById(boardId);
		System.out.println("BoardDetailAction : boardDto : " + boardDto);
		
		// 해당 게시물의 댓글과 댓글작성자 (복수)
		List<ReplyResponseDto> replyDtos = replyRepository.findAll(boardId);
		
		DetailResponseDto detailDto = DetailResponseDto.builder()
										.boardDto(boardDto)
										.replyDtos(replyDtos)
										.build();
		
		if (boardDto != null) {
			request.setAttribute("detailDto", detailDto);
			RequestDispatcher dis = request.getRequestDispatcher("board/detail.jsp");
			dis.forward(request, response);
		} else {
			Script.back("잘못된 접근입니다.", response);
		}
	}
}
