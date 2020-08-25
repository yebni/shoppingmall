package elecshopping;


import java.util.ArrayList;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MypageController {
	

	@Autowired
	MypageDAO dao;
	
	@RequestMapping("/mypage")
	public ModelAndView Mypage(HttpSession session) {
		MypageVO myinfo = dao.getInfo(session);

		ModelAndView mv = new ModelAndView();
		mv.addObject("myinfo", myinfo);
		mv.setViewName("mypage");
		return mv;

	}

	
	@RequestMapping("/mypageedit")
	public ModelAndView MypageEdit(HttpSession session) {
		MypageVO myinfo = dao.getInfo(session);

		ModelAndView mv = new ModelAndView();
		mv.addObject("myinfo", myinfo);
		mv.setViewName("mypageedit");
		return mv;

	}
	
	@RequestMapping("/infoEdit.do")
	public String infoEdit(HttpSession session, MemberVO vo) {
		session.setAttribute("pw", vo.getPassword());
		session.setAttribute("name", vo.getName());
		session.setAttribute("phone", vo.getPhone());
		if(dao.editMypage(session) > 0) return "redirect:/mypage";
		else return "/mypageedit";	
		}
	

}
