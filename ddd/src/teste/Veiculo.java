package teste;

public class Veiculo {
	private String marca;
	private String modelo;
	private String cor;
	private String placa;
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	Veiculo(){
		
	}
	
	Veiculo(String marca, String modelo, String cor, String placa){
		this.marca=marca;
		this.modelo=modelo;
		this.cor=cor;
		this.placa=placa;
	}
	
	public String VeiculoCadastrado() {
		return("Veiculo Cadastrado:\nMarca: "+this.marca+" -- Modelo: "+this.modelo+" -- Cor: "+this.cor+" -- Placa: "+this.placa);
	}
	
	public boolean validarPlaca(String placa) {
	    if ((placa.length() ==7)&&((placa.matches("[A-Z]{3}[0-9][A-Z][0-9]{2}"))||(placa.matches("[A-Z]{3}[0-9]{4}")))) {
	    	return(false);
	    }
	    else {
	    	return(true);
	    }
	}
}
