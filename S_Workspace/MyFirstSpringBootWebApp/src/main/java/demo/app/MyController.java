package demo.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	@RequestMapping("/")
	public String homehandler(Model model) {
		model.addAttribute("msg", "Hello from the controller");
		return "index";
	}
}
