package elecshopping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component("dao")
public class CustomerDAO {

	ArrayList<CustomerVO> getCustomerList(){
		ArrayList<CustomerVO> customerlist = new ArrayList<CustomerVO>();

		try { 
			String sql = "select id, name from customer";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			PreparedStatement pt = con.prepareStatement(sql);

			ResultSet rs = pt.executeQuery();
			
			while(rs.next()) {
				CustomerVO vo = new CustomerVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				customerlist.add(vo);	
			}
			pt.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return customerlist;
	} // getCustomerList end
	
	CustomerVO getCustomer(String id) {
		CustomerVO vo = new CustomerVO();
		
		try {
			String sql = "select * from customer where id=?";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			PreparedStatement pt = con.prepareStatement(sql);

			pt.setString(1, id);
			
			ResultSet rs = pt.executeQuery();
			
			if(rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setName(rs.getString("name"));
				vo.setPhone(rs.getString("phone"));
				vo.setAdmin(rs.getInt("admin"));
			}
			pt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	} // getCustomer end
	
	boolean checkAdmin(String id, int admin) {
		boolean result = false;
		
		try {
			String sql = "select admin from user where id=?";
			Connection con = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			PreparedStatement pt = con.prepareStatement(sql);
			
			pt.setString(1, id);
			
			ResultSet rs = pt.executeQuery();
			
			if(rs.next()) {
				admin = rs.getInt("admin");
			}
			if(admin == 9) {
				result = true;
			}
			pt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	} // checkAdmin end
	
	void deleteCustomer(String id) {
		try {
			String sql = "delete customer where id=?";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			PreparedStatement pt = con.prepareStatement(sql);
			
			pt.setString(1, id);
			
			pt.executeUpdate();
			
			pt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // deleteCustomer end

}
