package teste;

public class Vaga {
	private Usuario usuario;
	private String localizacao;
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	
	Vaga(){
		
	}
	
	Vaga(Usuario usuario, String localizacao){
		this.usuario=usuario;
		this.localizacao=localizacao;
	}
	
	public String listarVagas(Usuario usuario) {
		if(usuario==null) {
			return("Vaga Disponivel em("+this.localizacao+").");
		}else {
			return("Vaga Indisponivel em("+this.localizacao+").");
		}
		
	}
	
	public boolean verificarVaga(Usuario usuario) {
		if(usuario==null) {
			return(true);
		}else {
			return(false);
		}
	}
	public String listarUsuarioEstacionado(Usuario usuario) {
		if(usuario!=null) {
			return("Usuario("+usuario.getNome()+") Estacionado em("+this.localizacao+").");
		}else {
			return("Vaga Disponivel em("+this.localizacao+").");
			}
	}
}
