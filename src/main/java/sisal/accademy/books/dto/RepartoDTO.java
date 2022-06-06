package sisal.accademy.books.dto;

import java.util.*;

import sisal.accademy.books.Dipendente;

public class RepartoDTO {

	private String citta;
    private String dataFondazione;
    private String orarioApertura;
	private String orarioChiusura;
	
	List<DipendenteDTO> dipendenti=new ArrayList<>();

	public RepartoDTO() {
		
	}
	
	
	public RepartoDTO(String citta, String dataFondazione, String orarioApertura, String orarioChiusura,
			List<DipendenteDTO> dipendenti) {
		super();
		this.citta = citta;
		this.dataFondazione = dataFondazione;
		this.orarioApertura = orarioApertura;
		this.orarioChiusura = orarioChiusura;
		this.dipendenti = dipendenti;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getDataFondazione() {
		return dataFondazione;
	}

	public void setDataFondazione(String dataFondazione) {
		this.dataFondazione = dataFondazione;
	}

	public String getOrarioApertura() {
		return orarioApertura;
	}

	public void setOrarioApertura(String orarioApertura) {
		this.orarioApertura = orarioApertura;
	}

	public String getOrarioChiusura() {
		return orarioChiusura;
	}

	public void setOrarioChiusura(String orarioChiusura) {
		this.orarioChiusura = orarioChiusura;
	}

	public List<DipendenteDTO> getDipendenti() {
		return dipendenti;
	}

	public void setDipendenti(List<DipendenteDTO> dipendenti) {
		this.dipendenti = dipendenti;
	}
	
	
	
	
}
