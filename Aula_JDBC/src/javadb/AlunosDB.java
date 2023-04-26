package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AlunosDB {

	public Connection ConexaoDB(){
        
        //try (Connection conn = DriverManager.getConnection(
                //"jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "rm96331", "???")) {
       
        Connection conn=null;
       
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
           
            conn = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "rm96331", "251203");


            if(conn!=null)
                System.out.println("Conexão estabelecida com sucesso!");
            else
                System.out.println("Falha na conexão com o Banco de Dados!");


        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        return conn;
    }
   
    public void IncluirAlunoDB(Alunos a){
       
        Connection conn = ConexaoDB();
       
        Statement statement;
       
        try {
            String query = String.format("insert into tb_alunos (id,nome,ra,curso) values(%s,'%s','%s','%s')", a.getId(), a.getNome(), a.getRa(), a.getCurso());
           
            statement = conn.createStatement();
           
            statement.executeUpdate(query);
           
            System.out.println("Registro incluído com sucesso!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
   
    public void ListarAlunosDB(){
       
        Connection conn = ConexaoDB();
       
        Statement statement;
       
        ResultSet rs=null;
       
        try {
            String query= "select * from tb_alunos";
           
            statement=conn.createStatement();
           
            rs=statement.executeQuery(query);
           
            while(rs.next()){
                System.out.print(rs.getString("id")+" ");
                System.out.println(rs.getString("nome")+" ");
                System.out.println(rs.getString("ra")+" ");
                System.out.println(rs.getString("curso"));
            }


        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    
    public ArrayList<Alunos> ReturnAlunosDB(){
        
        Connection conn = ConexaoDB();
       
        Statement statement;
       
        ResultSet rs=null;
        
        ArrayList<Alunos> listaAlunos = new ArrayList<Alunos>();
       
        try {
            String query= "select * from tb_alunos";
           
            statement=conn.createStatement();
           
            rs=statement.executeQuery(query);
           
            while(rs.next()){
            	Alunos a = new Alunos();
            	
                System.out.print(rs.getString("id")+" ");
                a.setId(Integer.parseInt(rs.getString("id")));
                System.out.println(rs.getString("nome")+" ");
                a.setNome(rs.getString("nome"));
                System.out.println(rs.getString("ra")+" ");
                a.setRa(rs.getString("ra"));
                System.out.println(rs.getString("curso"));
                a.setCurso(rs.getString("curso"));
                
                listaAlunos.add(a);
            }


        }
        catch (Exception e){
            System.out.println(e);
        }
		return listaAlunos;
    }


    public void AtualizarAlunosDB(Alunos u){
       
        Connection conn = ConexaoDB();
       
        Statement statement;
       
        try {
            String query = String.format("update tb_alunos set curso = '%s' where id = %s", u.getCurso(), u.getId());
           
            statement = conn.createStatement();
           
            statement.executeUpdate(query);
           
            System.out.println("Registro atualizado com sucesso!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
   
    public void ExcluirAlunosDB(int id){
       
        Connection conn = ConexaoDB();
       
        Statement statement;
       
        try {
            String query = String.format("delete from tb_alunos where id = %s", id);
           
            statement = conn.createStatement();
           
            statement.executeUpdate(query);
           
            System.out.println("Registro excluído com sucesso!");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
