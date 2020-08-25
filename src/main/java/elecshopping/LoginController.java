package elecshopping;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String login(MemberVO vo) {
		vo.setMemberid("test");
		vo.setPassword("psps");
		return "login";
	}
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(MemberVO vo, MemberDAO memberDAO, HttpSession session) {
	
		System.out.println(memberDAO.getMember(vo));
		if(memberDAO.getMember(vo) != null) {
			session.setAttribute("id", vo.getMemberid());
			return "redirect:/";
		}
		else return "login";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}
