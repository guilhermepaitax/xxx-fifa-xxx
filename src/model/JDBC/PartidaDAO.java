package model.JDBC;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Partida;
import model.Time;

public class PartidaDAO {
    
    public void addPartida(Partida partida){    
       String sql = "INSERT INTO partida ( time1, localizacao, dia, id_time1, hora) VALUES ( ?, ?, ?, ?, ?)";        
       ConnectionFactory con = new ConnectionFactory();               
       try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);            
            stmt.setString(1, partida.getTime1());
            stmt.setString(2, partida.getLocalizacao());
            stmt.setString(3, partida.getDia());           
            stmt.setInt(4, partida.getId_time1());
            stmt.setString(5, partida.getHora());
            stmt.execute();
            stmt.close();
            con.getConnection().close();            
            //System.out.println("Foi");
        } catch (Exception e) {
            // System.out.println("Nao foi");
        }              
    }
    
    public ObservableList<Partida> selectPartida(){
        ObservableList<Partida> partidas = FXCollections.observableArrayList();               
        String sql = "SELECT * FROM partida";    
        ConnectionFactory con = new ConnectionFactory();
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Partida part = new Partida();
                part.setId_partida(rs.getInt("id_partida"));
                part.setDia(rs.getString("dia"));
                part.setId_time1(rs.getInt("id_time1"));
                part.setId_time2(rs.getInt("id_time2"));
                part.setLocalizacao(rs.getString("localizacao"));
                part.setTime1(rs.getString("time1"));
                part.setTime2(rs.getString("time2"));
                part.setHora(rs.getString("hora"));
                partidas.add(part);
                System.out.println("BOM");
            }           
            con.getConnection().close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(JogadorDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ruim");
        }    
        return partidas;
    }
    
    public void AddTime2(String u, int id){
        String sql = "UPDATE partida SET time2 = ? WHERE id_partida = ?;";
        ConnectionFactory con = new ConnectionFactory();
        
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);                        
            stmt.setString(1, u);    
            stmt.setInt(2, id);
            stmt.execute();
            stmt.close();
            con.getConnection().close();
            System.out.println("Uniforme: "+u);
            System.out.println("Id_team: "+id);
            System.out.println("foi pra copa");
        } catch (Exception e) {
            System.out.println("Nao foi copa");
        }
    }
    
    public void AddTime2Id(int u, int id){
        String sql = "UPDATE partida SET id_time2 = ? WHERE id_partida = ?;";
        ConnectionFactory con = new ConnectionFactory();
        
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);                        
            stmt.setInt(1, u);    
            stmt.setInt(2, id);
            stmt.execute();
            stmt.close();
            con.getConnection().close();
            System.out.println("Uniforme: "+u);
            System.out.println("Id_team: "+id);
            System.out.println("foi pra copa");
        } catch (Exception e) {
            System.out.println("Nao foi copa");
        }
    }
    
    public void delete(Partida j){
        String sql = "DELETE FROM partida WHERE id_partida = ?";
        ConnectionFactory con = new ConnectionFactory();
        try{
            PreparedStatement stm = con.getConnection().prepareStatement(sql);
            stm.setInt(1, j.getId_partida());
            stm.execute();
            stm.close();
            con.getConnection().close();
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }
}
