package com.cos.pantone.utill;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlParser {
	
	public static String getContentSummernote(String content) {
		 
		Document doc = Jsoup.parse(content);
		Elements imgTag = doc.select("img");
		String src = imgTag.attr("src");

		return src.toString();				
	}
}
	