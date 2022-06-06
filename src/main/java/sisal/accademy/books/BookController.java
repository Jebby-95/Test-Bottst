package sisal.accademy.books;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

	@GetMapping("/example")
	public String esempio(Model model) {
		
		//Il model (ui) + una mappa
		model.addAttribute("title", "Benvenuti!");
		
		return "greetings";
	}

	@GetMapping("/example2")
	public String esempio2(Model model) {
		
		//Il model (ui) + una mappa
		model.addAttribute("title", "Ciao Mondo!");
		
		return "greetings";
	}
}
