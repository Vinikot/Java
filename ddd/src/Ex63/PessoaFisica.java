package Ex63;

public class PessoaFisica extends Pessoa{
	private int cpf;

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	
	PessoaFisica(){
		
	}
	
	PessoaFisica(String nome, int idade, String email, int cpf){
		super(nome,idade,email);
		
		this.cpf=cpf;
	}
}
