package elecshopping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CartController {

	
	@RequestMapping("/cart")
	public String cart() {
		return "cart";

	}
}
