package com.cos.pantone.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.pantone.db.DBConn;
import com.cos.pantone.dto.PaletteResponseDto;
import com.cos.pantone.dto.DetailResponseDto;
import com.cos.pantone.dto.ReplyResponseDto;
import com.cos.pantone.model.Palette;
import com.cos.pantone.model.Member;
import com.cos.pantone.model.Reply;

// DAO
public class ReplyRepository {
	// 싱글톤
	private static final String TAG = "ReplyRepository : ";
	private static ReplyRepository instance = new ReplyRepository();

	private ReplyRepository() {
	}

	public static ReplyRepository getInstance() {
		return instance;
	}

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public int deleteById(int id) {
		final String SQL = "DELETE FROM reply WHERE id = ?";
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, id);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "deleteById : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt);
		}
		return -1;
	}
	
	public int save(Reply reply) {
		final String SQL = "INSERT INTO reply(id, memberId, paletteId, content, createDate) VALUES(REPLY_SEQ.nextval, ?, ?, ?, sysdate)";
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);

			pstmt.setInt(1, reply.getMemberId());
			pstmt.setInt(2, reply.getPaletteId());
			pstmt.setString(3, reply.getContent());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "save : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt);
		}
		return -1;
	}
	
	public List<ReplyResponseDto> findAll(int paletteId) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT r.id, r.memberId, r.paletteId, r.content, r.createDate, m.username, m.userProfile ");
		sb.append("FROM reply r INNER JOIN member m ON r.memberId = m.id ");
		sb.append("WHERE paletteId = ? ");
		sb.append("ORDER BY r.id DESC");

		final String SQL = sb.toString();
		List<ReplyResponseDto> replyDtos = new ArrayList<>();

		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, paletteId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Reply reply = Reply.builder()
						.id(rs.getInt(1))
						.memberId(rs.getInt(2))
						.paletteId(rs.getInt(3))
						.content(rs.getString(4))
						.createDate(rs.getTimestamp(5))
						.build();
				ReplyResponseDto replyDto = ReplyResponseDto.builder()
						.reply(reply)
						.username(rs.getString(6))
						.userProfile(rs.getString(7))
						.build();
				replyDtos.add(replyDto);
			};
			return replyDtos;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "findAll(int boardId) : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		return null;
	}

}
