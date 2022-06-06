package sisal.accademy.books;


import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PersonaController {
	
	@Autowired
	PersonaRepository repository;
	
	
	@GetMapping("/persona")
	public String esempio(Model model) {
		
		//Il model (ui) + una mappa
		model.addAttribute("nome", "Benvenuti!");
		model.addAttribute("cognome", "Bvenvenuti!");
		model.addAttribute("email", "Benvenuti!");
		model.addAttribute("nascita", "Benvenuti!");
		model.addAttribute("citta", "Benvenuti!");
		
		return "persona";
	}

	@GetMapping("/createpersona")
	public String createPersona() {
		return "createpersona";	
	}
	
	@GetMapping("/personaAdd")
	public String personaAdd(@RequestParam(name="nome",required=true)String nome,
							@RequestParam(name="cognome",required=true)String cognome,
							@RequestParam(name="dataNascita",required=true)String dataNascita,
							@RequestParam(name="email",required=true)String email,
							@RequestParam(name="citta",required=true)String citta,
							@RequestParam(name="genere",required=true)String genere,
							Model model) {
	
		Persona p= new Persona(nome,cognome,dataNascita,email,citta,genere);
		
		repository.save(p);
		
		model.addAttribute("text","Persona creata correttamente");
		model.addAttribute("backlink","/");
		model.addAttribute("backtext","Torna alla home");
		
		
		
		return "confirm";
	}
	
}
