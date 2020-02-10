package com.douzone.bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookshop.vo.OrdersVo;

public class OrderDao {
	public List<OrdersVo> findAll() {

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<OrdersVo> list = new ArrayList<>();

		try {
			connection = getConnection();

			String sql = "select a.book_no, a.title, a.count, b.order_no, b.info, b.price, b.location" + 
					"		from (select order_book.orders_no, book_no, title, count" + 
					"				from book, order_book" + 
					"				where book.no = order_book.book_no) a, (select orders.no, order_no, concat(name, '/', email) as info, price, location" + 
					"														from member, orders" + 
					"														where member.no = orders.member_no) b" + 
					"		where a.orders_no = b.no";
			
			pstmt = connection.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while(rs.next()) {
				Long bookNo = rs.getLong(1);
				String title = rs.getString(2);
				int count = rs.getInt(3);
				String orderNo = rs.getString(4);
				String info = rs.getString(5);
				int price = rs.getInt(6);
				String location = rs.getString(7);
				
				OrdersVo vo = new OrdersVo();
				vo.setBookNo(bookNo);
				vo.setTitle(title);
				vo.setCount(count);
				vo.setOrderNo(orderNo);
				vo.setInfo(info);
				vo.setPrice(price);
				vo.setLocation(location);
				
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
	
	public boolean insertOrder(OrdersVo OrdersVo) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		boolean result = false;

		try {
			connection = getConnection();

			String sql = "insert into orders values (null, ?, ?, ?, ?)";
			pstmt = connection.prepareStatement(sql);

			pstmt.setInt(1, OrdersVo.getPrice());
			pstmt.setString(2, OrdersVo.getLocation());
			pstmt.setString(3, OrdersVo.getOrderNo());
			pstmt.setLong(4, OrdersVo.getMemberNo());

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
	
	public boolean insertOrderBook(OrdersVo vo) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		boolean result = false;

		try {
			connection = getConnection();

			String sql = "insert into order_book values (?, ?, ?)";
			pstmt = connection.prepareStatement(sql);

			pstmt.setLong(1, vo.getOrdersNo());
			pstmt.setLong(2, vo.getBookNo());
			pstmt.setInt(3, vo.getCount());

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
