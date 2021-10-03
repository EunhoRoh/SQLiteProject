import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main4 {

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
			System.out.println("\n*** 새 데이터 삭제 ***");
			Statement stat4 = con.createStatement();
			String sql4 = "delete from g_artists where id=8;";
			int cnt4 = stat4.executeUpdate(sql4);
			if(cnt4>0)
				System.out.println("데이터가 삭제되었습니다!");
			else
				System.out.println("[Error] 데이터 삭제 오류!");
			stat4.close();
			
			
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

