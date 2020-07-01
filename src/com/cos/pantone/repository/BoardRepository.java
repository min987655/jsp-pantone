package com.cos.pantone.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.pantone.db.DBConn;
import com.cos.pantone.dto.DetailResponseDto;
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

	public int updateReadCount(int boardId) {
		final String SQL = "UPDATE board SET readCount = readCount + 1  WHERE id = ?";
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);

			pstmt.setInt(1, boardId);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "updateReadCount : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt);
		}
		return -1;
	}
	
	public int update(Board board) {
		final String SQL = "UPDATE board SET title = ?, content = ? WHERE id = ?";
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);

			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getId());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "update : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt);
		}
		return -1;
	}
	
	public int deleteById(int id) {
		System.out.println(TAG + "deleteById : boardId : " + id );
		final String SQL = "DELETE FROM board WHERE id = ?";
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, id);
			
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "count : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt);
		}
		return -1;
	}
	
	public DetailResponseDto findById(int id) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT b.id, b.memberId, b.title, b.content, b.readcount, b.likeCount, b.createDate, m.username ");
		sb.append("FROM board b INNER JOIN member m ");
		sb.append("ON b.memberId = m.id ");
		sb.append("WHERE b.id = ?");
		
		final String SQL = sb.toString();
		DetailResponseDto dto = null;
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new DetailResponseDto();
				Board board = Board.builder()
						.id(rs.getInt(1))
						.memberId(rs.getInt(2))
						.title(rs.getString(3))
						.content(rs.getString(4))
						.readCount(rs.getInt(5))
						.likeCount(rs.getInt(6))
						.createDate(rs.getTimestamp(7))
						.build();
				
				dto.setBoard(board);
				dto.setUsername(rs.getString(8));
			};
			return dto;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "findById : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		return null;
	}
	
	public int count() {
		final String SQL = "SELECT count(*) FROM board";
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "count : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		return -1;
	}
	
	public List<Board> findAll(int page) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT /*+ INDEX_DESC(BOARD SYS_C0010215)*/id, ");
		sb.append("memberId, title, content, readCount, likeCount, createDate ");
		sb.append("FROM board ");
		sb.append("OFFSET ? ROWS FETCH NEXT 9 ROWS ONLY");
		
		final String SQL = sb.toString();
		List<Board> boards = new ArrayList<>();
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, page*9);
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
