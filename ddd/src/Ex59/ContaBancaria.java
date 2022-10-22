package Ex59;

public class ContaBancaria {
	private String agencia;
	private String num;
	private double saldo;
	
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public double getSaldo() {
		return saldo;
	}
	
	ContaBancaria(){
		
	}
	
	ContaBancaria(String agencia,String num){
		this.agencia=agencia;
		this.num=num;
		this.saldo=0;
	}
	
	public void valorDeposito(double valorDeposito) {
		this.saldo=this.saldo+valorDeposito;
	}
	
	public void Sacar(double valorSaque) {
		if(valorSaque<=this.saldo) {
			this.saldo=this.saldo-valorSaque;
		}
	}
	
	public void Transferir(double valorTransf, Cliente destinatario) {
		if(valorTransf<=this.saldo) {
			Sacar(valorTransf);
			destinatario.getConta().valorDeposito(valorTransf);
		}
	}
	
	public String ConsultarSaldo() {
		return ("Seu saldo atual é: "+saldo);
	}
}
