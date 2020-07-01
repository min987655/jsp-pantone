package com.cos.pantone.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.pantone.action.Action;
import com.cos.pantone.model.Board;
import com.cos.pantone.model.Member;
import com.cos.pantone.repository.BoardRepository;
import com.cos.pantone.utill.Script;

public class BoardUpdateProcAction implements Action {
	
	private static final String TAG = "BoardUpdateProcAction : ";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 0.인증확인
		HttpSession session = request.getSession();
		if (session.getAttribute("principal") == null) {
			Script.getMessage("잘못된 접근입니다.", response);
			return;
		}
		Member principal = (Member)session.getAttribute("principal");
		
		// 1. 유효성 검사
		if 
		(
				request.getParameter("id").equals("") ||
				request.getParameter("id")==null ||
				request.getParameter("title").equals("") ||
				request.getParameter("title")==null ||
				request.getParameter("content").equals("") ||
				request.getParameter("content")==null
		){
			return;	
		}
		
		// 2. request에 title값과 content값 받기
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		// 3. title값과 content값, principal.getId()값을 Board 오브젝트에 담기
		Board board = Board.builder()
			    .id(id)
				.title(title)
				.content(content)
				.readCount(0)
				.likeCount(0)
				.build();
		
		// 4. BoardRepository 연결해서 save(board)함수 호출
		BoardRepository boardRepository = BoardRepository.getInstance();
		int result = boardRepository.update(board);
		
		if (result == 1) {
			Script.href("글수정에 성공하였습니다.", "/pantone/board?cmd=detail&id="+id, response);
		} else {
			Script.back("글수정에 실패하였습니다.", response);
		}
		
	}
}
