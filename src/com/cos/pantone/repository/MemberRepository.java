package com.cos.pantone.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cos.pantone.db.DBConn;
import com.cos.pantone.model.Member;

// DAO
public class MemberRepository {
	// 싱글톤
	private static final String TAG = "MemberRepository : ";
	private static MemberRepository instance = new MemberRepository();
	private MemberRepository() {}
	public static MemberRepository getInstance() {
		return instance;
	}
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public Member findByUsernameAndPassword(String username, String password) {
		final String SQL = "SELECT id, username, email, userProfile, userRole, createDate FROM member WHERE username = ? AND password =?";
		Member member = null;
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				member = Member.builder()
						.id(rs.getInt("id"))
						.username(rs.getString("username"))
						.email(rs.getString("email"))
						.userProfile(rs.getString("userProfile"))
						.userRole(rs.getString("userRole"))
						.createDate(rs.getTimestamp("createDate"))
						.build();
			}
			return member;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "findByUsernameAndPassword : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		return null;
	}
	
	public int findByUsername(String username) {
		final String SQL = "SELECT count(*) FROM member WHERE username = ?";
		Member member = null;
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "findByUsername : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		return -1;
	}
	
	public int save(Member member) {
		final String SQL = "INSERT INTO member(id, username, password, email, userRole, createDate) VALUES(MEMBER_SEQ.nextval, ?, ?, ?, ?, sysdate)";
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setString(1, member.getUsername());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getEmail());
			pstmt.setString(4, member.getUserRole());
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
