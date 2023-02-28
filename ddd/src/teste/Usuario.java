package teste;

public class Usuario {
	private String nome;
	private String email;
	private String senha;
	private int idade;
	private Veiculo veiculo;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	Usuario(){
		
	}
	
	Usuario(String nome, String email, String senha, int idade, Veiculo veiculo){
		this.nome=nome;
		this.email=email;
		this.senha=senha;
		this.idade=idade;
		this.veiculo=veiculo;
	}
	
	public String listarUsuario() {
		return("Nome: "+this.nome+" -- Email: "+this.email+" -- Idade: "+this.idade);
	}
	
	public boolean verificarIdade(int idade) {
		if((idade<18)||(idade>100)) {
			return(true);
		}
		else {
			return(false);
		}
	}
	
	public String verificarVeiculo() {
		return("O Usuario("+this.nome+") nao possui um Veiculo cadastrado!");
	}
	
}
