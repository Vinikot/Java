package Ex59b;

import java.util.ArrayList;

public class ContaBancaria {
    private String agencia;
    private String numero;
    private double saldo;
    private ArrayList<String> extrato;
    private double limite=75;
   
    public String getAgencia() {
        return agencia;
    }
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public double getSaldo() {
        return saldo;
    }
   
    public ContaBancaria() {
       
    }
   
    public ContaBancaria(String agencia, String numero) {
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = 0;
    }
 
    public void Depositar(double valor) {
        this.saldo = this.saldo + valor;
        //this.saldo =+ valor;
        this.extrato.add("Deposito: "+String.valueOf(valor)+"\n");
    }
   
    public Boolean Sacar(double valor) {
        if (this.saldo+this.limite >= valor) {
        	if((this.saldo-valor)<0) {
        		this.limite=this.limite+(this.saldo-valor);
        		this.saldo=this.saldo+((this.saldo-valor)*-1);
        	}
            this.saldo = this.saldo - valor;
            this.extrato.add("Saque: "+String.valueOf(valor)+"\n");
            return true;
        }
        else {
            return false;
        }
    }
   
    public void Transferir(double valorTransf, Cliente destinatario) {
        Sacar(valorTransf);
        destinatario.getConta().Depositar(valorTransf);
    }
   
    public double ConsultarSaldo() {
        return this.saldo;
    }
    
    public String ConsultarExtrato() {
    	String consEx="";
    	for(String ext:this.extrato)
    		consEx=consEx+ext;
    	return(consEx);
    }
 
}
