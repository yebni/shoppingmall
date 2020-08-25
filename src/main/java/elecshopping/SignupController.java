package elecshopping;

import java.io.Console;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class SignupController {
	
	@RequestMapping("signup")
	public String signup(MemberVO vo) {

		return "signup";
	}
	
	@RequestMapping(value="/signUp.do", method=RequestMethod.GET)
	public String signupExcute(MemberVO vo, MemberDAO memberDAO) {
	

		System.out.println(memberDAO.addMember(vo));
		if(memberDAO.addMember(vo) != null) return "redirect:/login.do";
		else return "signup";
	}

	@RequestMapping(value="/signUp.do", method=RequestMethod.POST)
	public String signup(MemberVO vo, MemberDAO memberDAO) {
	

		System.out.println(memberDAO.addMember(vo));
		if(memberDAO.addMember(vo) != null) return "redirect:/login.do";
		else return "signup";
	}
	
	//produces는 ajax가 데이터 넘겨받을때 깨짐 방지
	@RequestMapping(value = "/idCheck.do",method = RequestMethod.GET, produces = "application/text; charset=utf8")
	@ResponseBody
	public String idCheck(MemberVO vo, MemberDAO memberDAO, HttpServletRequest request) {
		
		String memberid = request.getParameter("memberid");
		return memberDAO.idCheck(memberid);
	}
}
