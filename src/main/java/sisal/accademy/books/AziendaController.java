package sisal.accademy.books;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class AziendaController {
	
	@Autowired
	AziendaRepository aziendaRepository;
	
	@Autowired
	RepartoRepository repRepository;
	
	@Autowired
	DipendenteRepository dipRepository;
	
	@GetMapping("/createazienda")
	public String createAzienda() {
		return "createazienda";
	}
	
	@GetMapping("/addazienda")
	public String addAzienda(@RequestParam(name="nome",required=true) String nome, 
			@RequestParam(name="sede",required=true)String sede, @RequestParam(name="dataFondazione",required=true)String dataFondazione,
			@RequestParam(name="settore",required=true)String settore,@RequestParam(name="info",required=true)String info,
			Model model) {
		
		Azienda azienda = new Azienda(nome,sede,dataFondazione,settore,info);
		aziendaRepository.save(azienda);
		
		model.addAttribute("text","Azienda creata correttamente");
		model.addAttribute("backlink","/");
		model.addAttribute("backtext","Ritorna alla pagina delle aziende");
		
		return "confirm";
	}
	
	@GetMapping("/")
	public String aziende(Model model) {
		

		Iterable<Azienda> aziende = aziendaRepository.findAll();
		model.addAttribute("aziende", aziende);
		model.addAttribute("title", "Aziende");
		
		
		
		
		return "aziende";
	}
	
	
	@GetMapping("/azienda/delete")	///books/delete/11
	public String aziendaDelete(@RequestParam(name="id",required=true)
	       int id,
	       Model model,   
	       HttpServletRequest request,
	       HttpServletResponse response) {

		Azienda azienda = aziendaRepository.findById(id).get();  
		List<Reparto> reparti = (List<Reparto>)repRepository.findAll();
		for(Reparto reparto:reparti) {
			if (reparto.getazienda().getId()==id) {
				List<Dipendente> dipendenti= dipRepository.findAllByRepartoId(reparto.getId());
				for(Dipendente dipendente:dipendenti) {
					dipRepository.delete(dipendente);
				}
				repRepository.delete(reparto);
			}
		}
		aziendaRepository.delete(azienda);
		
		model.addAttribute("text", "Azienda eliminata correttamente");
		model.addAttribute("backlink","/");
		model.addAttribute("backtext","Ritorna a Lista Aziende");
		return "deleteazienda";
	}
	
}
