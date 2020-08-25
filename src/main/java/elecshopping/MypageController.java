package elecshopping;

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
	} // Mypage end
	
	@RequestMapping("/mypageedit")
	public ModelAndView MypageEdit(HttpSession session) {
		MypageVO myinfo = dao.getInfo(session);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("myinfo", myinfo);
		mv.setViewName("mypageedit");
		return mv;
	} // MypageEdit end
	
	@RequestMapping("/infoEdit.do")
	public String infoEdit(HttpSession session) {
		if(dao.editMypage(session) != null) return "redirect:/mypage";
		else return "/mypageedit";
	} // infoEdit end
}