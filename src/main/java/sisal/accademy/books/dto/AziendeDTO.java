package sisal.accademy.books.dto;

import java.util.List;

public class AziendeDTO {

	private List<AziendaDTO> aziende;
	
	public AziendeDTO() {
		
	}
	
	public AziendeDTO(List<AziendaDTO> aziende) {
		this.aziende = aziende;
	}
	
	public List<AziendaDTO> getAziende(){
		return aziende;
	}
	
	public void setAziende(List<AziendaDTO>aziende) {
		this.aziende = aziende;
	}
	
	
}
