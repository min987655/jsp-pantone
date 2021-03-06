package com.cos.pantone.action.faq;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.pantone.action.Action;
import com.cos.pantone.model.FAQ;
import com.cos.pantone.repository.FAQRepository;
import com.cos.pantone.repository.PaletteRepository;
import com.cos.pantone.utill.Script;

public class FAQListAction implements Action {

	private final static String TAG = "FAQListAction : ";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		FAQRepository faqRepository = FAQRepository.getInstance();
		
		List<FAQ> faqs = faqRepository.findAll();
		System.out.println(TAG + "faqs : " + faqs);
		
		request.setAttribute("faqs", faqs);
		
		RequestDispatcher dis = request.getRequestDispatcher("faq/list.jsp");
		dis.forward(request, response);
	}
}
