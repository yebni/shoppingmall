package elecshopping;

import java.io.Console;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {

	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String login(MemberVO vo) {
		vo.setMemberid("test");
		vo.setPassword("psps");
		return "login";
	}
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(MemberVO vo, MemberDAO memberDAO) {
	
		System.out.println("멤버다오 - "+memberDAO);
		System.out.println("멤버븨 -"+vo);

		System.out.println(memberDAO.getMember(vo));
		if(memberDAO.getMember(vo) != null) return "redirect:/index.do";
		else return "login";
	}
	
	
}