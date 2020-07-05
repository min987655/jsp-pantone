package com.cos.pantone.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.pantone.db.DBConn;
import com.cos.pantone.dto.PaletteResponseDto;
import com.cos.pantone.model.Palette;

// DAO
public class PaletteRepository {
	// 싱글톤
	private static final String TAG = "PaletteRepository : ";
	private static PaletteRepository instance = new PaletteRepository();
	private PaletteRepository() {}
	public static PaletteRepository getInstance() {
		return instance;
	}

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public List<Palette> findAll(int page, String keyword) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT /*+ INDEX_DESC(PALETTE SYS_C0010215)*/id, ");
		sb.append("memberId, title, content, readCount, likeCount, createDate ");
		sb.append("FROM palette ");
		sb.append("WHERE title LIKE ? ");
		sb.append("OFFSET ? ROWS FETCH NEXT 9 ROWS ONLY");
		
		final String SQL = sb.toString();
		List<Palette> palettes = new ArrayList<>();
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, page*9);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Palette palette = Palette.builder()
						.id(rs.getInt("id"))
						.memberId(rs.getInt("memberId"))
						.title(rs.getString("title"))
						.content(rs.getString("content"))
						.readCount(rs.getInt("readCount"))
						.likeCount(rs.getInt("likeCount"))
						.createDate(rs.getTimestamp("createDate"))
						.build();
				
				palettes.add(palette);
			};
			return palettes;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "findAll(int page, String keyword) : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		return null;
	}

	public int count(String keyword) {
		final String SQL = "SELECT count(*) FROM palette WHERE title LIKE ? OR content LIKE ?";
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, "%" +keyword+ "%");
			pstmt.setString(2, "%" +keyword+ "%");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "count(String keyword) : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		return -1;
	}
	
	public int updateReadCount(int paletteId) {
		final String SQL = "UPDATE palette SET readCount = readCount + 1  WHERE id = ?";
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);

			pstmt.setInt(1, paletteId);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "updateReadCount : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt);
		}
		return -1;
	}
	
	public int update(Palette palette) {
		final String SQL = "UPDATE palette SET title = ?, content = ? WHERE id = ?";
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);

			pstmt.setString(1, palette.getTitle());
			pstmt.setString(2, palette.getContent());
			pstmt.setInt(3, palette.getId());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "update(Palette palette) : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt);
		}
		return -1;
	}
	
	public int deleteById(int id) {
		System.out.println(TAG + "deleteById : paletteId : " + id );
		final String SQL = "DELETE FROM palette WHERE id = ?";
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, id);
			
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "deleteById(int id) : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt);
		}
		return -1;
	}
	
	public PaletteResponseDto findById(int id) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT p.id, p.memberId, p.title, p.content, p.readcount, p.likeCount, p.createDate, m.username ");
		sb.append("FROM palette p INNER JOIN member m ");
		sb.append("ON p.memberId = m.id ");
		sb.append("WHERE p.id = ?");
		
		final String SQL = sb.toString();
		PaletteResponseDto paletteDto = null;
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				paletteDto = new PaletteResponseDto();
				Palette palette = Palette.builder()
						.id(rs.getInt(1))
						.memberId(rs.getInt(2))
						.title(rs.getString(3))
						.content(rs.getString(4))
						.readCount(rs.getInt(5))
						.likeCount(rs.getInt(6))
						.createDate(rs.getTimestamp(7))
						.build();
				
				paletteDto.setPalette(palette);
				paletteDto.setUsername(rs.getString(8));
			};
			return paletteDto;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "findById(int id) : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		return null;
	}
	
	public int count() {
		final String SQL = "SELECT count(*) FROM palette";
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
	
	public List<Palette> findAll(int page) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT /*+ INDEX_DESC(PALETTE SYS_C0010215)*/id, ");
		sb.append("memberId, title, content, readCount, likeCount, createDate ");
		sb.append("FROM palette ");
		sb.append("OFFSET ? ROWS FETCH NEXT 9 ROWS ONLY");
		
		final String SQL = sb.toString();
		List<Palette> palettes = new ArrayList<>();
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, page*9);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Palette palette = Palette.builder()
						.id(rs.getInt("id"))
						.memberId(rs.getInt("memberId"))
						.title(rs.getString("title"))
						.content(rs.getString("content"))
						.readCount(rs.getInt("readCount"))
						.likeCount(rs.getInt("likeCount"))
						.createDate(rs.getTimestamp("createDate"))
						.build();
				
				palettes.add(palette);
			};
			return palettes;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "findAll(int page) : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt);
		}
		return null;
	}
	
	public List<Palette> findAll() {
		final String SQL = "SELECT id, memberId, title, content, readCount, likeCount, createDate FROM palette ORDER BY id DESC";
		List<Palette> palettes = new ArrayList<>();
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Palette palette = Palette.builder()
						.id(rs.getInt("id"))
						.memberId(rs.getInt("memberId"))
						.title(rs.getString("title"))
						.content(rs.getString("content"))
						.readCount(rs.getInt("readCount"))
						.likeCount(rs.getInt("likeCount"))
						.createDate(rs.getTimestamp("createDate"))
						.build();
				
				palettes.add(palette);
			};
			return palettes;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "findAll() : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt);
		}
		return null;
	}

	public int save(Palette palette) {
		final String SQL = "INSERT INTO palette(id, memberId, title, content, readCount, likeCount, createDate) VALUES(PALETTE_SEQ.nextval, ?, ?, ?, ?, ?, sysdate)";
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);

			pstmt.setInt(1, palette.getMemberId());
			pstmt.setString(2, palette.getTitle());
			pstmt.setString(3, palette.getContent());
			pstmt.setInt(4, palette.getReadCount());
			pstmt.setInt(5, palette.getLikeCount());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "save(Palette palette) : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt);
		}
		return -1;
	}
}
