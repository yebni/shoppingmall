package elecshopping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Component;


//productDAO 모음

@Component("productdao")
public class ProductDAO{
	
String insertProduct(ProductVO vo) {
	String result ="";
	try {
		String sql =
				"insert into product values"
				+"(?,?,?,?,?,?)";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection
		("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		PreparedStatement pt = con.prepareStatement(sql);
		//2-3. setter - 값 설정
		pt.setInt(1, vo.getPnum());
		pt.setString(2, vo.getPname());
		pt.setInt(3, vo.getPrice());
		pt.setInt(4, vo.getStack());
		pt.setInt(5, vo.getCategory());
		pt.setInt(6, vo.getPassword());
		//2-4. db 전송
		int insertRow = pt.executeUpdate();//1
		//2-5. sql 실행 결과 검색
		if(insertRow == 1 ) {
			result ="글쓰기 성공했습니다.";
		}
		else {
			result ="글쓰기 오류 발생했습니다.";
		}
		pt.close();
		con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;	
	
	}
//home화면에서 보여주는 상품 리스트
ArrayList<ProductVO> getProductList() {
	ArrayList<ProductVO> productlist = 
			new ArrayList<ProductVO>();
	try {
	String sql = "SELECT pnum,pname,price FROM product";
	//2-2. PreparedStatement 정의
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection
	("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
	PreparedStatement pt = con.prepareStatement(sql);
	//2-4. db 전송
	ResultSet rs = pt.executeQuery();
	//2-5. sql 실행 결과 검색
	while(rs.next()) {
		ProductVO vo = new ProductVO();
		vo.setPnum(rs.getInt("pnum"));
		vo.setPname(rs.getString("pname"));
		vo.setPrice(rs.getInt("price"));
		productlist.add(vo); //vo:2개변수저장
	}
	pt.close();
	con.close();
	}catch(Exception e) {
		e.printStackTrace();
	}
	return productlist;	
}//getBoardList end


ProductVO getProduct(int pnum) {//상세조회시마다 viewcount 컬럼 1증가
	ProductVO vo = new ProductVO();
	try {
	String sql = "SELECT * FROM product where pnum=?";
			
    //String sql2 = "update product set viewcount = viewcount+1 where pnum=?";
			 
	//2-2. PreparedStatement 정의
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection
	("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
	PreparedStatement pt = con.prepareStatement(sql);
			
	//PreparedStatement pt2 = con.prepareStatement(sql2);
			 
	pt.setInt(1, pnum);
	//pt2.setInt(1, seq);
	
	//2-4. db 전송
	//pt2.executeUpdate();
	ResultSet rs = pt.executeQuery();
	//2-5. sql 실행 결과 검색
	if(rs.next()) {
	 vo.setPnum(rs.getInt("pnum"));
	 vo.setPname(rs.getString("pname"));	
	 vo.setPrice(rs.getInt("price"));
	 vo.setStack(rs.getInt("stack"));
	 vo.setCategory(rs.getInt("category"));
	}

	pt.close();
	con.close();
	}catch(Exception e) {
		e.printStackTrace();
	}
	return vo;	
}//getBoard end

void updateProduct(ProductVO vo) { 

    try { 
       String sql = "update product set pname=? where pnum=?";
       Class.forName("oracle.jdbc.driver.OracleDriver");
       Connection con = DriverManager.getConnection
             ("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
       PreparedStatement pt = con.prepareStatement(sql);

       pt.setString(1, vo.getPname());
       pt.setInt(2, vo.getPnum());
//       pt.setInt(3, vo.getPrice());
//       pt.setInt(4, vo.getStack());
//       pt.setInt(5, vo.getCategory());

       pt.executeUpdate();	

       pt.close();
       con.close();
    } catch(Exception e) {
       e.printStackTrace();
    }
 } // updateBoard end

void deleteProduct(int pnum) { 

    try { 
       String sql = "delete product where pnum=?";
       Class.forName("oracle.jdbc.driver.OracleDriver");
       Connection con = DriverManager.getConnection
             ("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
       PreparedStatement pt = con.prepareStatement(sql);

       pt.setInt(1, pnum);

       pt.executeUpdate();

       pt.close();
       con.close();
    } catch(Exception e) {
       e.printStackTrace();
    }
 } // deleteProduct end


}
