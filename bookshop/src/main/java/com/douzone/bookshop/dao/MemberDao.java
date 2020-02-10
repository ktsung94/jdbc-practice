package com.douzone.bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookshop.vo.MemberVo;

public class MemberDao {

	public List<MemberVo> findAll() {

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<MemberVo> list = new ArrayList<>();

		try {
			connection = getConnection();

			String sql = "select no, name, number, email, password from member";
			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while(rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				String number = rs.getString(3);
				String email = rs.getString(4);
				String password = rs.getString(5);

				MemberVo vo = new MemberVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setNumber(number);
				vo.setEmail(email);
				vo.setPassword(password);
				
				list.add(vo);
			}

		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			try {
				// 6. 자원정리
				if (connection != null)
					connection.close();
				if(pstmt != null)
					pstmt.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public boolean insert(MemberVo memberVo) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		boolean result = false;

		try {
			connection = getConnection();

			String sql = "insert into member values (null, ?, ?, ?, ?)";
			pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, memberVo.getName());
			pstmt.setString(2, memberVo.getNumber());
			pstmt.setString(3, memberVo.getEmail());
			pstmt.setString(4, memberVo.getPassword());

			int count = pstmt.executeUpdate();

			// 5. 성공 여부
			result = count == 1;

		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			try {
				// 6. 자원정리
				if (connection != null)
					connection.close();
				if(pstmt != null)
					pstmt.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	private Connection getConnection() throws SQLException {
		Connection connection = null;

		try {
			// 1. JDBC Driver(MyDriver) 로딩
			Class.forName("com.mysql.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3306/bookshop";
			connection = DriverManager.getConnection(url, "bookshop", "bookshop");
			//System.out.println("연결성공!");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 : " + e);
		} catch (SQLException e) {
			System.out.println("error : " + e);
		}
		return connection;
	}
}
