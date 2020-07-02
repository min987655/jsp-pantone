package com.cos.pantone.action.reply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.pantone.action.Action;
import com.cos.pantone.repository.ReplyRepository;
import com.cos.pantone.utill.Script;

public class ReplyDeleteProcAction implements Action {
	
	private static final String TAG = "ReplyDeleteProcAction : ";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// application/x-www-form-urlencoded
		if (request.getParameter("replyId") == null ||
			request.getParameter("replyId").equals("")) {
			return;
		}
		int replyId = Integer.parseInt(request.getParameter("replyId"));
		System.out.println(TAG + "replyId : " + replyId);
		
		ReplyRepository replyRepository = ReplyRepository.getInstance();
		int result = replyRepository.deleteById(replyId);
		Script.outText(result+"", response);
	}
}
