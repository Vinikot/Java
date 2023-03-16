package model;

import java.util.HashMap;

public class Filmes {

	private int id;
	private String nome;
	private String sinopse;
	private HashMap<Integer, Comentarios> comentario;
	
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
	public String getSinopse() {
		return sinopse;
	}
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	public HashMap<Integer,Comentarios> getComentario() {
		return comentario;
	}
	public void setComentario(HashMap<Integer, Comentarios> comentario) {
		this.comentario = comentario;
	}
	
}
