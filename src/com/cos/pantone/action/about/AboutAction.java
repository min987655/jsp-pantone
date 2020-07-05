package com.cos.pantone.action.about;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.pantone.action.Action;

public class AboutAction implements Action {

	private final static String TAG = "AboutAction : ";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("about/about.jsp");
		dis.forward(request, response);
	}
}
