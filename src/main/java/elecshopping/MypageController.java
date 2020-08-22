package elecshopping;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class MypageController {
	
	@Autowired
	MypageDAO dao;
	
	@RequestMapping("/mypage")
	public ModelAndView Mypage() {
		ArrayList<MypageVO> myinfo = dao.getInfo();

		ModelAndView mv = new ModelAndView();
		mv.addObject("myinfo", myinfo);
		mv.setViewName("mypage");
	}
	

}
