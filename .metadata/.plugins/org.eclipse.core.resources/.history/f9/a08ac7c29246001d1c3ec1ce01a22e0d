package Ex54;

public class Cliente {
	int id;
	int idade;
	String nome;
	String email;
	ContaBancaria conta;
	
	Cliente(){
		
	}
	
	Cliente(int id, int idade, String nome, String email, ContaBancaria conta){
		this.id=id;
		this.nome=nome;
		this.idade=idade;
		this.email=email;
		this.conta=conta;
	}
	
	public void atualizarEmail(String novoEmail){
		this.email=novoEmail;
	}
	
	public String exibirNomeIdade() {
		return("Nome: " + this.nome + " - Idade: " + this.idade);
	}
	
	public String exibirDadosConta() {
		return("Agencia: "+this.conta.agencia+" - Numero: "+this.conta.numero+" - Saldo: "+this.conta.saldo);
	}
}
