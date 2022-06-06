package sisal.accademy.books.dto;

import java.util.*;

import sisal.accademy.books.Reparto;

public class AziendaDTO {
	
    
	private String nome;
	private String sede;
	private String dataFondazione;
	private String settore;
	private String info;
	
	private List<RepartoDTO> reparti;
	
	public AziendaDTO() {
		
	}
	
	public AziendaDTO(String nome, String sede,String dataFondazione,String settore,String info,List<RepartoDTO> reparti) {
	
		this.reparti=reparti;
		this.nome = nome;
		this.sede = sede;
		this.dataFondazione = dataFondazione;
		this.settore = settore;
		this.info = info;
	}


	public String getNome() {
		return nome;
	}

	public List<RepartoDTO> getReparti() {
		return reparti;
	}

	public void setReparti(List<RepartoDTO> reparti) {
		this.reparti = reparti;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public String getDataFondazione() {
		return dataFondazione;
	}

	public void setDataFondazione(String dataFondazione) {
		this.dataFondazione = dataFondazione;
	}

	public String getSettore() {
		return settore;
	}

	public void setSettore(String settore) {
		this.settore = settore;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	
	
	
	

}
