package sisal.accademy.books.dto;

import java.util.List;

public class DipendenteDTO {
	
	private String grado;
    private int stipendio; 
    private PersonaDTO personeDTO;
    
    public DipendenteDTO() {
    	
    }
    
    public DipendenteDTO(String grado, int stipendio, PersonaDTO personeDTO){
    	this.grado = grado;
    	this.stipendio = stipendio;
    	this.personeDTO=personeDTO;
    }

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public PersonaDTO getPersoneDTO() {
		return personeDTO;
	}

	public void setPersoneDTO(PersonaDTO personeDTO) {
		this.personeDTO = personeDTO;
	}

	public int getStipendio() {
		return stipendio;
	}

	public void setStipendio(int stipendio) {
		this.stipendio = stipendio;
	}
    
    
    
    
    
}
