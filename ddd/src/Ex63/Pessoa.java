package Ex63;

public class Pessoa {
	protected String nome;
	protected int idade;
	protected String email;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	Pessoa(){
		
	}
	
	Pessoa(String nome, int idade, String email){
		this.nome=nome;
		this.idade=idade;
		this.email=email;
	}
}
