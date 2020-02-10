package test.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTest {

	public static void main(String[] args) {
		DeptVo vo = new DeptVo();
		vo.setNo(4L);
		vo.setName("기획운영팀");
		
		Boolean result = update(vo);
		if(result)
			System.out.println("성공");
		else 
			System.out.println("실패");
	}

//	public static boolean update(Long no, String name) {
//		return false;
//	}
	
	public static boolean update(DeptVo vo) {
		Connection connection = null;
		Statement stmt = null;
		Boolean result = false;
		
		try {
			// 1. JDBC Driver(MyDriver) 로딩
			Class.forName("com.mysql.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3306/webdb";
			connection = DriverManager.getConnection(url, "webdb", "webdb");
			System.out.println("연결성공!");

			// 3. Statement 객체 생성
			stmt = connection.createStatement();

			// 4. SQL문 실행
			// executeQuery : select문
			// executeUpdate : update, insert, delete
			// resultSet에는 row들이 저장되어 있는 것이다.
			String sql = "update dept set name='" + vo.getName() + "' where no = " + vo.getNo();
			int count = stmt.executeUpdate(sql);
			
			// 5. 성공 여부
			result = count == 1;
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 : " + e);
		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			try {
				// 6. 자원정리
				if (connection != null)
					connection.close();
				if(stmt != null)
					stmt.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
