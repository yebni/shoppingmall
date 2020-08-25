package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class JDBCUtil {
	
	
	public static Connection getConnection() {
		
		String driver="oracle.jdbc.driver.OracleDriver";
//		String url="jdbc:oracle:thin:@70.12.113.179:1521:xe";
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user="hr";
		String pw="hr";
		
		Connection con = null;
		
		try {
			//1. 드라이버 로딩
			Class.forName(driver); // 클래스 동적
			//2. 커넥션
			con = DriverManager.getConnection(url, user, pw);
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 확인하세요 ^^;;");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(Exception e){

		}
		
		return con;
	}

	public static Connection getConnection(File f) {
		
		String driver = "";
		String url = "";
		String user = "";
		String pw = "";
		
		Scanner sc = null;
		
		try {
			sc = new Scanner(new FileInputStream(f));
			
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				String key = "";
				String value = "";
				int index = line.indexOf("=");
				if (index > -1) {
					key = line.substring(0, index);
					value = line.substring(index + 1);
					switch(key) {
					case "driver":
						driver = value;
						break;
					case "url":
						url = value;
						break;
					case "user":
						user = value;
						break;
					case "pw":
						pw = value;
						break;
					default:
						System.out.println(
								"db 연결 파일에 키 " + key + "가 없습니다.");
					}
				}
			}
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}finally {
			sc.close();
		}
		
		Connection con = null;
		
		try {
			//1. 드라이버 로딩
			Class.forName(driver); // 클래스 동적
			//2. 커넥션
			con = DriverManager.getConnection(url, user, pw);
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 확인하세요 ^^;;");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(Exception e){

		}
		
		return con;
	}
	
	public static void close(Connection con, Statement st, ResultSet rs) {
		//6. 자원 반납
		try {
			if(rs!=null) {rs.close();}
			if(st!=null) {st.close();}
			if(con!=null) {con.close();}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
