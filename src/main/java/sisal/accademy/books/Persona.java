package sisal.accademy.books;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Persona {

	
	@Id	
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int id;
	
	private String nome;
	private String cognome;
	private String dataNascita;
	private String email;
	private String citta;
	private String genere;
	
	
	//@OneToMany
	//private List<Dipendente> dip_per;
	
	protected Persona() {
		
	}
	
	
	public Persona(int id,String nome,String cognome,String dataNascita,String email,String citta,String genere) {
		this.id=id;
		this.nome=nome;
		this.cognome=cognome;
		this.dataNascita=dataNascita;
		this.email=email;
		this.citta=citta;
		this.genere=genere;
		//this.dip_per=dip_per;
	}
	public Persona(String nome,String cognome,String dataNascita,String email,String citta,String genere) {
		this.nome=nome;
		this.cognome=cognome;
		this.dataNascita=dataNascita;
		this.email=email;
		this.citta=citta;
		this.genere=genere;
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

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	
	@Override
	public String toString() {
		return "";
	}
}
