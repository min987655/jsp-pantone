package com.cos.pantone.action.colorTrend;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.pantone.action.Action;

public class ColorTrendAction implements Action {

	private final static String TAG = "ColorTrendAction : ";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("colorTrend/colorTrend.jsp");
		dis.forward(request, response);
	}
}
