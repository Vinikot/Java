package Categ_Produto;

public class Categoria {
	private int id;
	private String nome;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	Categoria(){
		
	}
	
	Categoria(int id, String nome){
		this.id = id;
		this.nome = nome;
	}
}