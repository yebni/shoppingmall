package elecshopping;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
	
	@Autowired
	MypageDAO dao;
	
	@RequestMapping("/")
	public ModelAndView Index(String id) {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	

}
