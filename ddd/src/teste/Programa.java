package teste;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) throws IOException {
		Scanner ler=new Scanner(System.in);
		
		ArrayList<Usuario> listaUsuario=new ArrayList<>();
		ArrayList<Vaga> listaVaga=new ArrayList<>();
		
		boolean x=false,x2;
		String usuEmail, usuSenha, v;
		int opcMenu, opcLogin, indexUsu;
		Usuario usu=null;
		
		do {
			System.out.println("1 - Cadastrar Usuario\n2 - Login\n3 - Listar Usuarios\n4 - Listar Usuarios Estacionados\n5 - Sair\n\nDigite a opcao desejada: ");
			opcMenu=ler.nextInt();
			
			//CADASTRAR USUARIOS
			if(opcMenu==1) {
				Usuario a=new Usuario();
				
				System.out.println("Digite seu Nome: ");
				a.setNome(ler.next());
				
				System.out.println("Digite seu Email: ");
				a.setEmail(ler.next());
				for(Usuario b:listaUsuario) {
						while(b.getEmail().equals(a.getEmail())) {
							System.out.println("Email já cadastrado!\nPor Favor insira outro Email: ");
							a.setEmail(ler.next());
					}
				}
				
				System.out.println("Digite sua Senha: ");
				a.setSenha(ler.next());
				
				System.out.println("Digite sua Idade: ");
				a.setIdade(ler.nextInt());
				while(a.verificarIdade(a.getIdade())) {
					System.out.println("É necessario ser maior de 18 e menor que 100!\nDigite sua Idade: ");
					a.setIdade(ler.nextInt());
				}
				
				a.setVeiculo(null);
				
				listaUsuario.add(a);
				
				System.out.println("Usuario cadastrado com sucesso!");
				System.in.read();
			}
			//FAZER LOGIN
			else if(opcMenu==2) {
				if(listaUsuario.size()==0) {
					System.out.println("Não existem usuarios cadastrados!\n");
					continue;
				}
				System.out.println("..:: LOGIN ::..\n\nDigite seu email: ");
				usuEmail=ler.next();
				System.out.println("Digite sua senha: ");
				usuSenha=ler.next();
				//VERIFICA EMAIL E SENHA
				for(Usuario u: listaUsuario) {
					if((u.getSenha().equals(usuSenha))&&(u.getEmail().equals(usuEmail))) {
						usu=u;
						break;
					}
				}
				if(usu==null) {
					System.out.println("EMAIL OU SENHA INCORRETO!");
				}
				else {
					//ENTRA NO LOOP DO LOGIN
					System.out.printf("Bem Vindo %s!", usu.getNome());
					do {
						System.out.println("\n1 - Cadastrar Veiculo\n2 - Veiculo Cadastrado\n3 - Atualizar Veiculo\n4 - Estacionar\n5 - Sair da Vaga\n6 - Buscar Vagas\n7 - Logout");
						opcLogin=ler.nextInt();
						
						//CADASTRAR VEICULO
						if(opcLogin==1) {
							if(usu.getVeiculo()!=null) {
								System.out.println("O Usuario já possui um Veiculo cadastrado!");
								continue;
							}
							
							Veiculo a=new Veiculo();
							
							System.out.println("Digite a Marca do seu carro: ");
							a.setMarca(ler.next().toUpperCase());
							
							System.out.println("Digite o Modelo do seu carro: ");
							a.setModelo(ler.next().toUpperCase());
							
							System.out.println("Digite a Cor do seu carro: ");
							a.setCor(ler.next().toUpperCase());
							
							System.out.println("Digite a Placa do seu carro: ");
							a.setPlaca(ler.next().toUpperCase());
							while(a.validarPlaca(a.getPlaca())) {
								System.out.println("Digite uma placa valida! Ex:(ABC1D23)\nDigite a Placa do seu carro: ");
								a.setPlaca(ler.next().toUpperCase());
							}
							
							usu.setVeiculo(a);
							System.out.println("Veiculo cadastrado com sucesso!");
							System.in.read();
						}
						//VERIFICA VEICULO CADASTRADO
						else if(opcLogin==2) {
							if(usu.getVeiculo()==null) {
								System.out.println(usu.verificarVeiculo());
								continue;
							}
							System.out.print(usu.getVeiculo().VeiculoCadastrado());
							System.in.read();
							
						}
						//ATUALIZA VEICULO
						else if(opcLogin==3) {
							if(usu.getVeiculo()==null) {
								System.out.println(usu.verificarVeiculo());
								continue;
							}
							
							Veiculo a=new Veiculo();
							
							System.out.println("Digite a nova Marca do seu carro: ");
							a.setMarca(ler.next().toUpperCase());
							
							System.out.println("Digite o novo Modelo do seu carro: ");
							a.setModelo(ler.next().toUpperCase());
							
							System.out.println("Digite a nova Cor do seu carro: ");
							a.setCor(ler.next().toUpperCase());
							
							System.out.println("Digite a nova Placa do seu carro: ");
							a.setPlaca(ler.next().toUpperCase());
							while(a.validarPlaca(a.getPlaca())) {
								System.out.println("Digite uma placa valida! Ex:(ABC1D23)\nDigite a nova Placa do seu carro: ");
								a.setPlaca(ler.next().toUpperCase());
							}
							
							usu.setVeiculo(a);
							System.out.println("Veiculo cadastrado com sucesso!");
							System.in.read();
						}
						//ESTACIONAR VEICULO
						else if(opcLogin==4) {
							if(usu.getVeiculo()==null) {
								System.out.println(usu.verificarVeiculo());
								continue;
							}
							for(Vaga vaga:listaVaga) {
								if(usu.equals(vaga.getUsuario())) {
									System.out.println("O Usuario já esta Estacionado!");
									x=true;
								}
								else {
									x=false;
								}
							}
							if(x) {
								continue;
							}
							x2=false;
							
							System.out.println("Digite a Localizacao da Vaga: ");
							v=ler.next().toUpperCase();
							if(listaVaga.size()==0) {
								Vaga v2=new Vaga(usu,v);
								listaVaga.add(v2);
								System.out.printf("O usuario(%s) estacionou em(%s).",usu.getNome(),v);
							}
							else {
								for(Vaga vaga:listaVaga) {
								if((v.equals(vaga.getLocalizacao())&&(vaga.verificarVaga(vaga.getUsuario())))) {
									vaga.setUsuario(usu);
									System.out.printf("O usuario(%s) estacionou em(%s).",usu.getNome(),v);
									break;
								}
								else if((v.equals(vaga.getLocalizacao())&&(vaga.getUsuario()!=null))) {	
										System.out.println("Essa Localizacao já esta ocupada!");
										break;
								}
								else {
									x2=true;
								}
							}
								if(x2) {
									Vaga v2=new Vaga(usu,v);
									listaVaga.add(v2);
									System.out.printf("O usuario(%s) estacionou em(%s).",usu.getNome(),v);
								}
							}
							System.in.read();
						}
						//SAIR DA VAGA
						else if(opcLogin==5) {
							if(usu.getVeiculo()==null) {
								System.out.println(usu.verificarVeiculo());
								continue;
							}
							for(Vaga vaga:listaVaga) {
								if(vaga.getUsuario().equals(usu)) {
									vaga.setUsuario(null);
									System.out.println("O Usuario saiu da Vaga!");
								}
							}
							if(listaVaga.size()==0) 
								System.out.println("O Usuario nao Estacionou o Veiculo ainda!");
							
						}
						//LISTAR VAGAS
						else if(opcLogin==6) {
							for(Vaga vaga:listaVaga) 
								System.out.println(vaga.listarVagas(vaga.getUsuario()));
							if(listaVaga.size()==0) {
								System.out.println("Nao ha vagas disponiveis ainda.");
							}
							System.in.read();
						}
						//LOGOUT
						else if(opcLogin==7) {
							usu=null;
							System.out.println("O Usuario efetuou Logout!");
							System.in.read();
						}
						else if((opcLogin<1)||(opcLogin>7)) {
							System.out.println("DIGITE UMA OPCAO VALIDA!\n");
						}
					}while(opcLogin!=7);
				}
				
				System.in.read();
			}
			//LISTAR USUARIOS
			else if(opcMenu==3) {
				if(listaUsuario.size()==0) {
					System.out.println("Não existem usuarios cadastrados!\n");
					continue;
				}
				for(Usuario usua:listaUsuario)
				System.out.println(usua.listarUsuario());
				
				System.in.read();
			}
			//LISTAR USUARIOS ESTACIONADOS
			else if(opcMenu==4) {
				if(listaUsuario.size()==0) {
					System.out.println("Não existem usuarios cadastrados!\n");
					continue;
				}
				for(Vaga va:listaVaga)
				System.out.println(va.listarUsuarioEstacionado(va.getUsuario()));
				if(listaVaga.size()==0)
					System.out.println("Nao ha Usuarios Estacionados!");
				
				System.in.read();
			}
			else if((opcMenu<1)||(opcMenu>5)) {
				System.out.println("DIGITE UMA OPCAO VALIDA!\n");
				System.in.read();
			}
		}while(opcMenu!=5);

	}

}
