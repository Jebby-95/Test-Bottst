package sisal.accademy.books.dto;

public class PersonaDTO {
	
	private String nome;
	private String congome;
	private String email;
	
	
	public PersonaDTO() {
		
	}
	
	public PersonaDTO(String nome, String congome, String email) {
		super();
		this.nome = nome;
		this.congome = congome;
		this.email = email;
	}
	
	
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCongome() {
		return congome;
	}


	public void setCongome(String congome) {
		this.congome = congome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}



	

}
