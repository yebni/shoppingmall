package elecshopping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	public MemberVO getMember(MemberVO vo) {
		MemberVO member = null;
		String sql = "select * from customer where (id=? and pw=?)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			PreparedStatement pt = con.prepareStatement(sql);
			
			pt.setString(1, vo.getMemberid());
			pt.setString(2, vo.getPassword());
			
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
	
	public MemberVO addMember(MemberVO vo) {
		MemberVO member = null;
		String sql = "insert into member (id, pw, name, phone, admin) values(?, ?, ?, ?, ?)";

		try { 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			PreparedStatement pt = con.prepareStatement(sql);

			pt.setString(1, vo.getMemberid());
			pt.setString(2, vo.getPassword());
			pt.setString(3, vo.getName());
			pt.setString(4, vo.getPhone());
			pt.setInt(5, 0);


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
	public String idCheck(String memberid) {
		MemberVO member = null;

		
		String sql = "select * from customer where id=?";


		try { 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			PreparedStatement pt = con.prepareStatement(sql);

			pt.setString(1, memberid);


			ResultSet rs = pt.executeQuery();
			
			while(rs.next()) {

				member = new MemberVO();
				member.setMemberid(rs.getString("ID"));
			}
			pt.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}

		if(member != null)
			return "1";
		else
			return "0";

	}
	
}

