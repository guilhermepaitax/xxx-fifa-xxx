package model.JDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Copa;
import model.Jogador;
import model.Participante;

public class ParticipanteDAO {
    
    public void addParticipante(Participante participante){    
       String sql = "INSERT INTO participante ( id_usuario, id_copa, nome, nometime) VALUES ( ?, ?, ?, ?)";        
       ConnectionFactory con = new ConnectionFactory();               
       try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);            
            stmt.setInt(1, participante.getId_usuario());
            stmt.setInt(2, participante.getId_copa()); 
            stmt.setString(3, participante.getNome());
            stmt.setString(4, participante.getNometime());
            stmt.execute();
            stmt.close();
            con.getConnection().close();            
            System.out.println("Foi part");
        } catch (Exception e) {
            System.out.println("Nao foi");
        }              
    }
    
    public ObservableList<Participante> selectPart(int id){
        ObservableList<Participante> participantes = FXCollections.observableArrayList();               
        String sql = "SELECT * FROM participante WHERE id_copa = ?";    
        ConnectionFactory con = new ConnectionFactory();
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
      
            while(rs.next()){
                Participante part = new Participante();
                part.setId_copa(rs.getInt("id_copa"));
                part.setId_participante(rs.getInt("id_participante"));             
                part.setId_usuario(rs.getInt("id_usuario")); 
                part.setNome(rs.getString("nome"));
                part.setNometime(rs.getString("nometime"));
                part.setP1(rs.getInt("placar1"));
                part.setP2(rs.getInt("placar2"));
                part.setP3(rs.getInt("placar3"));
                part.setP4(rs.getInt("placar4"));
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
    
    public ObservableList<Participante> selecttudo(){
        ObservableList<Participante> participantes = FXCollections.observableArrayList();               
        String sql = "SELECT * FROM participante";    
        ConnectionFactory con = new ConnectionFactory();
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Participante part = new Participante();
                part.setId_copa(rs.getInt("id_copa"));
                part.setNome(rs.getString("nome"));             
                part.setId_usuario(rs.getInt("id_usuario"));
                part.setId_participante(rs.getInt("id_participante"));
                part.setNometime(rs.getString("nometime"));
                part.setP1(rs.getInt("placar1"));
                part.setP2(rs.getInt("placar2"));
                part.setP3(rs.getInt("placar3"));
                part.setP4(rs.getInt("placar4"));
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
    
    public void delete(Participante p){
        String sql = "DELETE FROM participante WHERE id_participante = ?";
        ConnectionFactory con = new ConnectionFactory();
        try{
            PreparedStatement stm = con.getConnection().prepareStatement(sql);
            stm.setInt(1, p.getId_participante());
            stm.execute();
            stm.close();
            con.getConnection().close();
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }
    
    public void Addplacar1(int u, int id){
        String sql = "UPDATE participante SET placar1 = ? WHERE id_participante = ?;";
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
    
    public void Addplacar2(int u, int id){
        String sql = "UPDATE participante SET placar2 = ? WHERE id_participante = ?;";
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
    
    public void Addplacar3(int u, int id){
        String sql = "UPDATE participante SET placar3 = ? WHERE id_participante = ?;";
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
    
    public void Addplacar4(int u, int id){
        String sql = "UPDATE participante SET placar4 = ? WHERE id_participante = ?;";
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
