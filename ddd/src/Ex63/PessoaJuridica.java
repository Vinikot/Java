package Ex63;

public class PessoaJuridica extends Pessoa{
	private int cnpj;

	public int getCnpj() {
		return cnpj;
	}

	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}
	
	PessoaJuridica(){
		
	}
	
	PessoaJuridica(String nome, int idade, String email, int cnpj){
		super(nome,idade,email);
		
		this.cnpj=cnpj;
	}
}
