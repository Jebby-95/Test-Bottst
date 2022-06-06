package sisal.accademy.books;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import sisal.accademy.books.dto.AziendaDTO;
import sisal.accademy.books.dto.AziendeDTO;
import sisal.accademy.books.dto.DipendenteDTO;
import sisal.accademy.books.dto.PersonaDTO;
import sisal.accademy.books.dto.RepartoDTO;


@RestController
public class AziendaRestController {
	
	@Autowired
	AziendaRepository aziendaRepository;
	
	@Autowired
	RepartoRepository repRepository;
	
	@Autowired
	DipendenteRepository dipRepository;
	
	@Autowired
	PersonaRepository personaRepository;

	@GetMapping("aziende/api/azienda/{id}")
	public AziendaDTO azienda(@PathVariable("id") int id) {
		Azienda azienda = aziendaRepository.findById(id).get();
		AziendaDTO aziendaDTO = convertDto(azienda);
		return aziendaDTO;
	}
	
	private AziendaDTO convertDto(Azienda azienda) {
		AziendaDTO aziendaDto = new AziendaDTO();
		
		aziendaDto.setNome(azienda.getNome());
		aziendaDto.setSede(azienda.getSede());
		aziendaDto.setDataFondazione(azienda.getDataFondazione());
		aziendaDto.setSettore(azienda.getSettore());
		aziendaDto.setInfo(azienda.getInfo());
		aziendaDto.setReparti(getReparti(azienda.getId()));
		return aziendaDto;
	}
	
	private List<RepartoDTO> getReparti(int id) {
		
		Iterable<Reparto> reparti = repRepository.findByAziendaId(id);
		List<RepartoDTO> repartiDTO= new ArrayList<>();
		
		for(Reparto rep:reparti) {
			repartiDTO.add(convertRepartoDTO(rep));
		}
		
		
		return repartiDTO;
	}
	private RepartoDTO convertRepartoDTO(Reparto reparto) {
		RepartoDTO repartoDTO = new RepartoDTO();
		
		repartoDTO.setCitta(reparto.getCitta());
		repartoDTO.setDataFondazione(reparto.getDataFondazione());
		repartoDTO.setOrarioApertura(reparto.getOrarioApertura());
		repartoDTO.setOrarioChiusura(reparto.getOrarioChiusura());
		repartoDTO.setDipendenti(getDipendenti(reparto.getId()));
		
		return repartoDTO;
	}

	private List<DipendenteDTO> getDipendenti(int id) {
		List<Dipendente> dipendenti = dipRepository.findAllByRepartoId(id);
		List<DipendenteDTO> dipendentiDTO= new ArrayList<>();
		
		for(Dipendente dip: dipendenti) {
			dipendentiDTO.add(convertDipendenteDTO(dip));
		}
		
		
		return dipendentiDTO;
	}

	private DipendenteDTO convertDipendenteDTO(Dipendente dip) {
		DipendenteDTO dipendenteDTO= new DipendenteDTO();
		
		dipendenteDTO.setGrado(dip.getGrado());
		dipendenteDTO.setStipendio(dip.getStipendio());
		dipendenteDTO.setPersoneDTO(getPersone(dip));
		
		return dipendenteDTO;
	}

	private PersonaDTO getPersone(Dipendente dip) {
		Persona persona= dip.getPersona();
		
		return convertPersonaDTO(persona);
	}

	private PersonaDTO convertPersonaDTO(Persona persona) {
		PersonaDTO personaDTO = new PersonaDTO();
		
		personaDTO.setCongome(persona.getCognome());
		personaDTO.setEmail(persona.getEmail());
		personaDTO.setNome(persona.getNome());
		
		return personaDTO;
	}

	@GetMapping("/aziende/api/aziende")
	public AziendeDTO aziende() {
		List<Azienda> aziende = (List<Azienda>) aziendaRepository.findAll();
		return convertDto(aziende);
	}
	
	
	
	private AziendeDTO convertDto(List<Azienda> aziende) {
		List<AziendaDTO> aziendeDto = new LinkedList<>();
		
		for(Azienda azienda : aziende) {
			AziendaDTO aziendaDto = convertDto(azienda);
			aziendeDto.add(aziendaDto);
		}
		
		return new AziendeDTO(aziendeDto);
	}
	
		
	
	
	

}
