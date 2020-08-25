package elecshopping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class MemberDAO {
	public static final String sql = "select * from members where id=?";


	public MemberVO getMember(MemberVO vo) {
		MemberVO member = null;
		try { 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			PreparedStatement pt = con.prepareStatement(sql);

			pt.setString(1, vo.getMemberid());
			ResultSet rs = pt.executeQuery();
			

			while(rs.next()) {
				member = new MemberVO();
				member.setMemberid(rs.getString("ID"));
				member.setPassword(rs.getString("PW"));
				member.setName(rs.getString("NAME"));

			}
			pt.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return member;
		
	}
	
}