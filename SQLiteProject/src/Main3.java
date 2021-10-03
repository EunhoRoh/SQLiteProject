import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main3 {

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
			System.out.println("\n*** 새 데이터 수정 ***");
			Statement stat3 = con.createStatement();
			String sql3 = "update g_artists set a_year='2000년대, 2010년대, 2020년대' "
					+ " where id=1;";
			int cnt3 = stat3.executeUpdate(sql3);
			if(cnt3>0)
				System.out.println("데이터가 수정되었습니다!");
			else
				System.out.println("[Error] 데이터 수정 오류!");
			stat3.close();
			
			
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

