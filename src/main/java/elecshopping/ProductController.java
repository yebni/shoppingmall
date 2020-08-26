package elecshopping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//product 관련 Controller
@Controller
public class ProductController {
	
	@Autowired
	ProductDAO dao ;
	
	@RequestMapping(value="/productcontroll", method=RequestMethod.GET)
	String productcontroll() {
		return "productcontroll";
	}

	@RequestMapping(value="/productcontroll", method=RequestMethod.POST)
	ModelAndView writeprocess(@ModelAttribute("vo") ProductVO vo) {
		String result = dao.insertProduct(vo);
		ModelAndView mv = new ModelAndView();
		if(result.indexOf("성공")<0) {
			mv.addObject("result", result);
		}
		mv.setViewName("redirect:/home");
	
		return mv;
	}
	
	@RequestMapping("/home")
	public ModelAndView getProductList() {
		ArrayList<ProductVO> productlist = dao.getProductList();
		System.out.println(productlist.size());
		ModelAndView mv = new ModelAndView();
		mv.addObject("productlist", productlist);
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping("/productdetail")
	public ModelAndView getProduct(int pnum) {
		System.out.println(pnum);
		ProductVO vo = dao.getProduct(pnum);
		System.out.println(vo.getPname());
		ModelAndView mv = new ModelAndView();
		mv.addObject("product", vo);
		mv.setViewName("productdetail");
		return mv;	
	}
	

	
	@RequestMapping
	(value="/productupdate", method=RequestMethod.GET)
	public ModelAndView updateProduct(int pnum, int admin) {
		//boolean check = dao.checkPassword(pnum, pw);
		ModelAndView mv = new ModelAndView();
		mv.addObject("pnum", pnum);
		//System.out.println(check);
		if(admin == admin) {
			mv.setViewName("/productupdateform");
		}
		else {
			mv.setViewName("redirect:/home");
		}
		return mv;
	}

	@RequestMapping
	(value="/productupdate", method=RequestMethod.POST)
	public String updateProductSuccess(ProductVO vo) {
		System.out.println(1);
		//seq title contents writer - vo.setXXXXX() 자동 저장
		dao.updateProduct(vo);
	    return "redirect:/home";
	}

	@RequestMapping("/productdelete")
	public String deleteProduct(int pnum, int admin) {
	 if(admin == 9) {   // 관리자는 삭제 불가
         dao.deleteProduct(pnum);
      }
      return "redirect:/home";
	}
	
}

