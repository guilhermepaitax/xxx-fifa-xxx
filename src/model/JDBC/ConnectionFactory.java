
package model.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    
    private String bancoDeDados = "xxxfifa";
    private String usuario = "postgres";
    private String senha = "aluno";
    
    public Connection getConnection(){
        Connection connect = null;
        
        try {
            connect = DriverManager.getConnection("jdbc:postgresql://localhost/" + bancoDeDados, usuario, senha);
            System.out.println("Deu Certo!");
            
            
        } catch (Exception e) {
            System.out.println("Nao deu certo!");
        } 
        
        
        
        return connect;
    }
    
}
