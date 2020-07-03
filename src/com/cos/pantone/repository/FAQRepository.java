package com.cos.pantone.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.pantone.db.DBConn;
import com.cos.pantone.dto.PaletteResponseDto;
import com.cos.pantone.model.FAQ;
import com.cos.pantone.model.Palette;

// DAO
public class FAQRepository {
	// 싱글톤
	private static final String TAG = "FAQRepository : ";
	private static FAQRepository instance = new FAQRepository();
	private FAQRepository() {}
	public static FAQRepository getInstance() {
		return instance;
	}

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	

	public List<FAQ> findAll() {
		final String SQL = "SELECT id, memberId, title, content, readCount, createDate FROM faq ORDER BY id DESC";
		List<FAQ> faqs = new ArrayList<>();
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				FAQ faq = FAQ.builder()
						.id(rs.getInt("id"))
						.memberId(rs.getInt("memberId"))
						.title(rs.getString("title"))
						.content(rs.getString("content"))
						.readCount(rs.getInt("readCount"))
						.createDate(rs.getTimestamp("createDate"))
						.build();
				
				faqs.add(faq);
			};
			return faqs;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "findAll() : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt);
		}
		return null;
	}
}
