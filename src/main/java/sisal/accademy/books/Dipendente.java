package sisal.accademy.books;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Dipendente {

	
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private int id;
    
    @OneToOne 
    private Persona persona;

    @OneToOne
    private Reparto reparto;
    
    private String dataInizio;
    private String dataFine;

    private String grado;
    private int stipendio;

    public Dipendente(){
    }

    public Dipendente(Persona persona, Reparto reparto, String dataInizio, String dataFine, String grado, int stipendio) {
        this.persona = persona;
        this.reparto = reparto;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.grado = grado;
        this.stipendio = stipendio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Reparto getreparto() {
        return reparto;
    }

    public void setreparto(Reparto reparto) {
        this.reparto = reparto;
    }

    public String getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(String dataInizio) {
        this.dataInizio = dataInizio;
    }

    
    public String getDataFine() {
        return dataFine;
    }

    public void setDataFine(String dataFine) {
        this.dataFine = dataFine;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public int getStipendio() {
        return stipendio;
    }

    public void setStipendio(int stipendio) {
        this.stipendio = stipendio;
    }

	@Override
	public String toString() {
		return "";
	}
    
    
    
}
