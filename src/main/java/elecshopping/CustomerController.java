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

	@RequestMapping("/customerlist")
	public ModelAndView getCustomerList() {
		ArrayList<CustomerVO> customerlist = dao.getCustomerList();
		ModelAndView mv = new ModelAndView();
		mv.addObject("customerlist", customerlist);
		mv.setViewName("customer/list");
		return mv;
	} // getCustomerList end

	@RequestMapping("/customerdetail")
	public ModelAndView getCustomer(String id) {
		CustomerVO vo = dao.getCustomer(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("customer", vo);
		mv.setViewName("customer/detail");
		return mv;
	}
	
	@RequestMapping("/customerdelete")
	public String deleteCustomer(String id, int admin) {
		if(admin != 9) {	// 관리자는 삭제 불가
			dao.deleteCustomer(id);
		}
		return "redirect:/customerlist";
	} // deleteCustomer end
}
