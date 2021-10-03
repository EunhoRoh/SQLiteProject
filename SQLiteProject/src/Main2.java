import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con =null;
		try {
			//SQLite JDBC 체크
			Class.forName("org.sqlite.JDBC");
			
			//SQLite 데이터베이스 파일에 연결
			String dbFile = "myfirst.db";
			con = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
			
			//데이터 조회
			System.out.println("\n*** 새 데이터 추가 ***");
			Statement stat2 = con.createStatement();
			String sql2 = "insert into g_artists (name, a_type, a_year, debut, regdate)"
					+ " values ('이적', '남성', '1990년대', '2000년대', datetime('now','localtime'));";
			int cnt = stat2.executeUpdate(sql2);
			if(cnt>0)
				System.out.println("새로운 데이터가 추가되었습니다!");
			else
				System.out.println("[Error] 데이터 추가 오류!");
			stat2.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(con!=null) {
				try {
					con.close();
					
				} catch (Exception e) {// TODO: handle exception}
			}
		}

	}
	}
}

