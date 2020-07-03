package com.cos.pantone.action.palette;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.pantone.action.Action;
import com.cos.pantone.model.Palette;
import com.cos.pantone.repository.PaletteRepository;
import com.cos.pantone.utill.HtmlParser;

public class PaletteListAction implements Action {

	private final static String TAG = "PaletteListAction : ";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int page = Integer.parseInt(request.getParameter("page"));
		
		PaletteRepository paletteRepository = PaletteRepository.getInstance();
		
		List<Palette> palettes = paletteRepository.findAll(page);
		System.out.println(TAG + " palettes : " + palettes.toString());

		for (Palette palette : palettes) {
			String summernoteImg = HtmlParser.getContentSummernote(palette.getContent());
			palette.setContent(summernoteImg);
		}
		
		request.setAttribute("palettes", palettes);
		
		int count = paletteRepository.count();
		System.out.println(TAG + "pageCount : " + count);
		int lastPage = (count-1)/9;
		
		request.setAttribute("lastPage", lastPage);
		
		RequestDispatcher dis = request.getRequestDispatcher("palette/list.jsp");
		dis.forward(request, response);
		
	}
}


