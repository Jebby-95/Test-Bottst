package sisal.accademy.books;

import java.util.Optional;

import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import sisal.accademy.books.Reparto;
import sisal.accademy.books.RepartoRepository;

@Controller
public class RepartoController {
	
	@Autowired
	RepartoRepository repository;
	@Autowired
	AziendaRepository aziendaRepository;
	@Autowired
	DipendenteRepository dipRepository;

	
	@GetMapping("/createreparto")
	public String newreparto(Model model,HttpSession session,HttpServletResponse response) {

		session.setAttribute("Template", "Creazione di un nuovo Reparto");
		 
		
		model.addAttribute("aziende", aziendaRepository.findAll() );
		return "createreparto";
	}
	
	
	
	@GetMapping("/addreparto")
	public String addReparto(
			@RequestParam(name="citta",required=true)
			String citta,
			@RequestParam(name="dataFondazione",required=true)
			String dataFondazione,
			@RequestParam(name="orarioApertura",required=true)
			String orarioApertura,
			@RequestParam(name="orarioChiusura",required=true)
			String orarioChiusura,
			@RequestParam(name="azienda",required=true)
			int aziendaID,
			@RequestParam(name="nome",required=true)
			String nome,
			Model model) {
		
		
		Optional<Azienda> azienda = aziendaRepository.findById(aziendaID);
		
		
		
		
		Reparto reparto = new Reparto(citta, dataFondazione, orarioApertura, orarioChiusura, azienda.get(), nome);
		repository.save(reparto);
		
		model.addAttribute("text","Reparto creato correttamente");
		model.addAttribute("backlink","/");
		model.addAttribute("backtext","Ritorna alla home");
		
		return "confirm";
	}
	
	
	@GetMapping("/viewazienda/view/{id}")
	public String viewAzienda(@PathVariable("id")
								int id,
								Model model) {
		
		Azienda azienda = aziendaRepository.findById(id).get(); 
		
		//Cookie
		//Cookie cookie=new Cookie("lastAzienda", azienda.getId()+"");
		//cookie.setHttpOnly(true); 
		//response.addCookie(cookie);
		
		
		
		model.addAttribute("azienda", azienda);
		
		
		Iterable<Reparto> reparti = repository.findByAziendaId(id);
		
		
		
		model.addAttribute("reparti", reparti);
		model.addAttribute("remove","Rimuovi azienda");
		
		
		return "viewazienda";	
	}
	
	
	@GetMapping("/reparto/delete")	///books/delete/11
	public String repartoDelete(@RequestParam(name="id",required=true)
	       int id,
	       Model model,   
	       HttpServletRequest request,
	       HttpServletResponse response) {

		Reparto reparto = repository.findById(id).get();  
		
		//List<Dipendente> dipendenti = dipRepository.findAllByRepartoId(id);
		List<Dipendente> dipendenti= dipRepository.findAllByRepartoId(reparto.getId());
		for(Dipendente dipendente:dipendenti) {
			dipRepository.delete(dipendente);
		}
				
		
		repository.delete(reparto);
		
		model.addAttribute("text", "Reparto eliminata correttamente");
		
		model.addAttribute("backlink","/");
		model.addAttribute("backtext","Ritorna alla home");
		return "deleteazienda";
	}
	
}
