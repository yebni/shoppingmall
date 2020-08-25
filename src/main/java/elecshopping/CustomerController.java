package elecshopping;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {

	@Autowired
	CustomerDAO dao;

	@RequestMapping("/customer/list")
	public ModelAndView getCustomerList() {
		ArrayList<CustomerVO> customerlist = dao.getCustomerList();
		ModelAndView mv = new ModelAndView();
		mv.addObject("customerlist", customerlist);
		mv.setViewName("customer/list");
		return mv;
	} // getCustomerList end

	@RequestMapping("/customer/detail")
	public ModelAndView getCustomer(String id) {
		CustomerVO vo = dao.getCustomer(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("customer", vo);
		mv.setViewName("customer/detail");
		return mv;
	}
	
	@RequestMapping("/customer/delete")
	public String deleteCustomer(String id, int admin) {
		if(admin == 9) {	// 관리자는 삭제 불가
			dao.deleteCustomer(id);
		}
		return "redirect:/customerlist";
	} // deleteCustomer end
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
//	@RequestMapping("/mypage")
//	public String mypage() {
//		return "mypage";
//	}
}
