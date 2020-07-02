package com.cos.pantone.action.reply;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.pantone.action.Action;
import com.cos.pantone.dto.ReplyResponseDto;
import com.cos.pantone.model.Board;
import com.cos.pantone.model.Member;
import com.cos.pantone.model.Reply;
import com.cos.pantone.repository.BoardRepository;
import com.cos.pantone.repository.ReplyRepository;
import com.cos.pantone.utill.Script;
import com.google.gson.Gson;

public class ReplyWriteProcAction implements Action {
	
	private static final String TAG = "ReplyWriteProcAction : ";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// application/json
		BufferedReader br = request.getReader();
		StringBuffer sb = new StringBuffer();
		String input = null;
		
		while ((input = br.readLine()) != null) {
			sb.append(input);
		}
		
		System.out.println(TAG + "sb.toString() : " + sb.toString());
		
		Gson gson = new Gson();
		Reply reply = gson.fromJson(sb.toString(), Reply.class);
		
		ReplyRepository replyRepository = ReplyRepository.getInstance();
		int result = replyRepository.save(reply);
		
		if (result == 1) {
			List<ReplyResponseDto> replyDtos = replyRepository.findAll(reply.getBoardId());
			String replyDtosJson = gson.toJson(replyDtos);
			Script.outJson(replyDtosJson, response);
		} else {
			Script.outJson(result + "", response);
		}
	}
}
