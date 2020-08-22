package elecshopping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component("mypagedao")
public class MypageDAO {
	
	MypageVO getInfo() {
		MypageVO vo  = new MypageVO();
		vo.setName("jimin");
		
//		try { 
//			String sql = "select * from customer where username=?";
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection con = DriverManager.getConnection
//					("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
//			PreparedStatement pt = con.prepareStatement(sql);
//
//			pt.setString(1, username);
//			ResultSet rs = pt.executeQuery();
//
//			while(rs.next()) {
//				vo.setId(rs.getString("id"));
//				vo.setPw(rs.getString("pw"));
//				vo.setName(rs.getString("name"));
//				vo.setPhone(rs.getString("phone"));
//				vo.setAdmin(rs.getInt("admin"));	
//			}
//			pt.close();
//			con.close();
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
		return vo;
		
		
	}
	
	

}
