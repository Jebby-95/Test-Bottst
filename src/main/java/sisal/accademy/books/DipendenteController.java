package sisal.accademy.books;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class DipendenteController {

    @Autowired
    DipendenteRepository dipRepository;
    
    @Autowired
    PersonaRepository personaRepository;
    
    @Autowired
    RepartoRepository repRepository;

    @GetMapping("/createdipendente")
    public String esempio(Model model){
    	
    	//model.setAttribute("Template", "Creazione di un nuovo Dipendente");
    	
		model.addAttribute("reparti", repRepository.findAll() );
		model.addAttribute("persone",personaRepository.findAll());
		return "createdipendente";
    }

    
    @GetMapping("/createspecificdipendente/{id}")
    public String createSpecificDipendente(@PathVariable("id")
	int id,Model model){
    	
    	//model.setAttribute("Template", "Creazione di un nuovo Dipendente");
    	
		model.addAttribute("reparti", repRepository.findById(id).get());
		model.addAttribute("persone",personaRepository.findAll());
		return "createdipendente";
    }
    
    
    
    
    
    @GetMapping("/adddipendente")
	public String addDipendente(
				
				@RequestParam(name="persona",required=true)
				int personaID,
				@RequestParam(name="reparto",required=true)
				int repartoID,
				@RequestParam(name="dataInizio",required=true)
				String dataInizio,
				@RequestParam(name="dataFine",required=true)
				String dataFine,
				@RequestParam(name="grado",required=true)
				String grado,
				@RequestParam(name="stipendio",required=true)
				int stipendio,
				Model model) {
			
			
		
			
			Reparto reparto=repRepository.findById(repartoID).get();
			Persona persona = personaRepository.findById(personaID).get();
			
			Dipendente dipendente = new Dipendente(persona,reparto,dataInizio,dataFine,grado,stipendio);
			dipRepository.save(dipendente);
			
			model.addAttribute("text","Dipendente creato correttamente");
			model.addAttribute("backlink","/");
			model.addAttribute("backtext","Torna alla home");
			
			
			
			return "confirm";
		}

    
    @GetMapping("/viewreparto/view/{id}")
	public String viewAzienda(@PathVariable("id")
								int id,
								Model model) {
    	
    	Reparto reparto= repRepository.findById(id).get();
    	
    	
    	
		//List<Dipendente> dipendente = (List<Dipendente>) dipRepository.findAllOrderByIdDesc(); 
		
    	List<Dipendente> dipendenti =(List<Dipendente>) dipRepository.findAllByRepartoId(id);
		List<Persona> persone = new ArrayList<Persona>();
		
		//dipendenti.stream().forEach(x->persone.add(personaRepository.findById(x.getId()).get()));
		
		for(Dipendente e: dipendenti) {
			persone.add(e.getPersona());
		}
		
		model.addAttribute("dipendenti", dipendenti);
		model.addAttribute("persone", persone);
		model.addAttribute("reparto", reparto);
		model.addAttribute("back","/");
		model.addAttribute("createdipendente","/createspecificdipendente/"+id);
		model.addAttribute("remove","rimuovi reparto");
		return "viewreparto";	
	}


}
