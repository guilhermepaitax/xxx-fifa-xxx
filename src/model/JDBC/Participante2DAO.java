package model.JDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Participante;
import model.Participante2;

public class Participante2DAO {
    
    public void addParticipante(Participante2 participante){    
       String sql = "INSERT INTO participante2 ( id_liga, id_usuario, nometime, nome) VALUES ( ?, ?, ?, ?)";        
       ConnectionFactory con = new ConnectionFactory();               
       try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);            
            stmt.setInt(1, participante.getId_liga());
            stmt.setInt(2, participante.getId_usuario()); 
            stmt.setString(3, participante.getTime());
            stmt.setString(4, participante.getNome());
            stmt.execute();
            stmt.close();
            con.getConnection().close();            
            System.out.println("Foi part");
        } catch (Exception e) {
            System.out.println("Nao foi");
        }              
    }
    
    public ObservableList<Participante2> selectPart(int id){
        ObservableList<Participante2> participantes = FXCollections.observableArrayList();               
        String sql = "SELECT * FROM participante2 WHERE id_liga = ?";    
        ConnectionFactory con = new ConnectionFactory();
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
      
            while(rs.next()){
                Participante2 part = new Participante2();
                part.setId_liga(rs.getInt("id_liga"));
                part.setId_participante2(rs.getInt("id_participante2"));             
                part.setId_usuario(rs.getInt("id_usuario")); 
                part.setNome(rs.getString("nome"));
                part.setTime(rs.getString("nometime"));
                part.setDerrotas(rs.getInt("derrotas"));
                part.setEmpates(rs.getInt("empates"));
                part.setGols(rs.getInt("gols"));
                part.setVitorias(rs.getInt("vitorias"));
                part.setPontos(rs.getInt("pontos"));
                part.setPartidas(rs.getInt("partidas"));
                participantes.add(part);
                
               // System.out.println("BOM");
            }           
            con.getConnection().close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(JogadorDAO.class.getName()).log(Level.SEVERE, null, ex);
           // System.out.println("ruim");
        }    
        return participantes;
    }
    
    public void delete(Participante2 p){
        String sql = "DELETE FROM participante2 WHERE id_participante2 = ?";
        ConnectionFactory con = new ConnectionFactory();
        try{
            PreparedStatement stm = con.getConnection().prepareStatement(sql);
            stm.setInt(1, p.getId_participante2());
            stm.execute();
            stm.close();
            con.getConnection().close();
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }
    
    public void Addpontos1(int u, int id){
        String sql = "UPDATE participante2 SET pontos = ? WHERE id_participante2 = ?;";
        ConnectionFactory con = new ConnectionFactory();
        
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);                        
            stmt.setInt(1, u);    
            stmt.setInt(2, id);
            stmt.execute();
            stmt.close();
            con.getConnection().close();
            System.out.println("foi pra copa");
        } catch (Exception e) {
            System.out.println("Nao foi copa");
        }
    }
    
    public void Addgols(int u, int id){
        String sql = "UPDATE participante2 SET gols = ? WHERE id_participante2 = ?;";
        ConnectionFactory con = new ConnectionFactory();
        
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);                        
            stmt.setInt(1, u);    
            stmt.setInt(2, id);
            stmt.execute();
            stmt.close();
            con.getConnection().close();
            System.out.println("foi pra copa");
        } catch (Exception e) {
            System.out.println("Nao foi copa");
        }
    }
    
    public void Addpartidas(int u, int id){
        String sql = "UPDATE participante2 SET partidas = ? WHERE id_participante2 = ?;";
        ConnectionFactory con = new ConnectionFactory();
        
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);                        
            stmt.setInt(1, u);    
            stmt.setInt(2, id);
            stmt.execute();
            stmt.close();
            con.getConnection().close();
            System.out.println("foi pra copa");
        } catch (Exception e) {
            System.out.println("Nao foi copa");
        }
    }
    
    public void Addderrotas(int u, int id){
        String sql = "UPDATE participante2 SET derrotas = ? WHERE id_participante2 = ?;";
        ConnectionFactory con = new ConnectionFactory();
        
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);                        
            stmt.setInt(1, u);    
            stmt.setInt(2, id);
            stmt.execute();
            stmt.close();
            con.getConnection().close();
            System.out.println("foi pra copa");
        } catch (Exception e) {
            System.out.println("Nao foi copa");
        }
        
    }
    
    public void Addvitorias(int u, int id){
        String sql = "UPDATE participante2 SET vitorias = ? WHERE id_participante2 = ?;";
        ConnectionFactory con = new ConnectionFactory();
        
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);                        
            stmt.setInt(1, u);    
            stmt.setInt(2, id);
            stmt.execute();
            stmt.close();
            con.getConnection().close();
            System.out.println("foi pra copa");
        } catch (Exception e) {
            System.out.println("Nao foi copa");
        }
    }
    
    public void Addempates(int u, int id){
        String sql = "UPDATE participante2 SET empates = ? WHERE id_participante2 = ?;";
        ConnectionFactory con = new ConnectionFactory();
        
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);                        
            stmt.setInt(1, u);    
            stmt.setInt(2, id);
            stmt.execute();
            stmt.close();
            con.getConnection().close();
            System.out.println("foi pra copa");
        } catch (Exception e) {
            System.out.println("Nao foi copa");
        }
    }
}
