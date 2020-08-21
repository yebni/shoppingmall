package elecshopping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CartController {
	@RequestMapping("/cart") // URL "/shop/cart" 로 매핑함
	public String cart() {
		return "cart"; //cart.jsp 보여줌
	}
}
