package com.cos.pantone.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.pantone.db.DBConn;
import com.cos.pantone.model.Board;
import com.cos.pantone.model.Member;

// DAO
public class BoardRepository {
	// 싱글톤
	private static final String TAG = "BoardRepository : ";
	private static BoardRepository instance = new BoardRepository();
	private BoardRepository() {}
	public static BoardRepository getInstance() {
		return instance;
	}

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public List<Board> findAll() {
		final String SQL = "SELECT id, memberId, title, content, readCount, likeCount, createDate FROM board ORDER BY id DESC";
		List<Board> boards = new ArrayList<>();
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Board board = Board.builder()
						.id(rs.getInt("id"))
						.memberId(rs.getInt("memberId"))
						.title(rs.getString("title"))
						.content(rs.getString("content"))
						.readCount(rs.getInt("readCount"))
						.likeCount(rs.getInt("likeCount"))
						.createDate(rs.getTimestamp("createDate"))
						.build();
				
				boards.add(board);
			};
			return boards;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "findAll : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt);
		}
		return null;
	}

	public int save(Board board) {
		final String SQL = "INSERT INTO board(id, memberId, title, content, readCount, likeCount, createDate) VALUES(BOARD_SEQ.nextval, ?, ?, ?, ?, ?, sysdate)";
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);

			pstmt.setInt(1, board.getMemberId());
			pstmt.setString(2, board.getTitle());
			pstmt.setString(3, board.getContent());
			pstmt.setInt(4, board.getReadCount());
			pstmt.setInt(5, board.getLikeCount());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "save : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt);
		}
		return -1;
	}
}
