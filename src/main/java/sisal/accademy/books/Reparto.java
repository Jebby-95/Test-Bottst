package sisal.accademy.books;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Reparto {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
    private int id;
    private String citta;
    private String dataFondazione;
    private String orarioApertura;
	private String orarioChiusura;
	
    @OneToOne
    private Azienda azienda;
    
    private String nome;
    
    protected Reparto() {
    	
    }
    
    
    public Reparto(String citta, String dataFondazione, String orarioApertura, String orarioChiusura, Azienda azienda,
    		String nome) {
    	
    	this.citta = citta;
    	this.dataFondazione = dataFondazione;
    	this.orarioApertura = orarioApertura;
    	this.orarioChiusura = orarioChiusura;
    	this.azienda = azienda;
    	this.nome = nome;
    }

    public Reparto(int id, String citta,String dataFondazione, String orarioApertura, String orarioChiusura, Azienda azienda,String nome){

        this.id=id;
        this.citta=citta;
        this.dataFondazione=dataFondazione;
        this.orarioApertura=orarioApertura;
        this.orarioChiusura=orarioChiusura;
        this.azienda=azienda;
        this.nome=nome;

    }

    public Azienda getazienda() {
        return azienda;
    }
    public String getCitta() {
        return citta;
    }
    public String getDataFondazione() {
        return dataFondazione;
    }
    public int getId() {
        return id;
    }
    public String getOrarioApertura() {
        return orarioApertura;
    }
    public String getOrarioChiusura() {
        return orarioChiusura;
    }
    public String getNome() {
        return nome;
    }
    


    
}
