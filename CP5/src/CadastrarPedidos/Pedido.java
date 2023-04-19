package CadastrarPedidos;

import java.util.ArrayList;

public class Pedido {

	private String pedName;
	private ArrayList<String> nome;
	private ArrayList<Double> quantidade;
	private ArrayList<Double> preco;
	private int quantProds;
	
	public String getPedName() {
		return pedName;
	}
	public void setPedName(String pedName) {
		this.pedName = pedName;
	}
	public ArrayList<String> getNome() {
		return nome;
	}
	public void setNome(ArrayList<String> nome) {
		this.nome = nome;
	}
	public ArrayList<Double> getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(ArrayList<Double> quantidade) {
		this.quantidade = quantidade;
	}
	public ArrayList<Double> getPreco() {
		return preco;
	}
	public void setPreco(ArrayList<Double> preco) {
		this.preco = preco;
	}
	public int getQuantProds() {
		return quantProds;
	}
	public void setQuantProds(int quantProds) {
		this.quantProds = quantProds;
	}
	
}
