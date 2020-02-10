package com.douzone.bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookshop.vo.CartVo;

public class CartDao {
	
	public List<CartVo> findAll() {

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<CartVo> list = new ArrayList<>();

		try {
			connection = getConnection();

			String sql = "select member_no, title, count, price from cart, book where cart.book_no = book.no";
			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while(rs.next()) {
				Long memberNo = rs.getLong(1);
				String title = rs.getString(2);
				int count = rs.getInt(3);
				int price = rs.getInt(4);

				CartVo vo = new CartVo();
				vo.setMemberNo(memberNo);
				vo.setTitle(title);
				vo.setCount(count);
				vo.setPrice(price);
				
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
	
	public boolean insert(CartVo CartVo) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		boolean result = false;

		try {
			connection = getConnection();

			String sql = "insert into cart values (?, ?, ?)";
			pstmt = connection.prepareStatement(sql);

			pstmt.setLong(1, CartVo.getMemberNo());
			pstmt.setLong(2, CartVo.getBookNo());
			pstmt.setInt(3, CartVo.getCount());
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
