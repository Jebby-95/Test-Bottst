package sisal.accademy.books;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Azienda {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int id;
	
	private String nome;
	private String sede;
	private String dataFondazione;
	private String settore;
	private String info;
	

	
	protected Azienda() {
		
	}
	
	
	public Azienda(String nome, String sede, String dataFondazione, String settore, String info) {
		super();
		this.nome = nome;
		this.sede = sede;
		this.dataFondazione = dataFondazione;
		this.settore = settore;
		this.info = info;
	}



	public Azienda(String nome, String sede, String dataFondazione, String settore, String info, Reparto reparto) {
		super();
		this.nome = nome;
		this.sede = sede;
		this.dataFondazione = dataFondazione;
		this.settore = settore;
		this.info = info;
		//this.reparti = reparti;
	}

	public Azienda(int id, String nome, String sede, String dataFondazione, String settore, String info,
			Reparto reparto, List<Reparto> reparti) {
		super();
		this.id = id;
		this.nome = nome;
		this.sede = sede;
		this.dataFondazione = dataFondazione;
		this.settore = settore;
		this.info = info;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
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

	


	@Override
	public String toString() {
		return "Azienda []";
	}
	
	
}
