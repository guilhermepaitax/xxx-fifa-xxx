package model.JDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Criptografia;
import model.Jogador;
import model.Time;

public class TimeDAO {
    
    public void addTime(Time time){    
       String sql = "INSERT INTO time ( nome, fundador, abreviacao, senha, emblema, estado, sen) VALUES ( ?, ?, ?, ?, ?, ?, ?)";        
       ConnectionFactory con = new ConnectionFactory();               
       try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);            
            stmt.setString(1, time.getNome());
            stmt.setString(2, time.getFundador());
            stmt.setString(3, time.getAbreviacao());           
            stmt.setString(4, Criptografia.Criptografando(time.getSenha()));
            stmt.setString(5, time.getEmblema());
            stmt.setString(6, time.getEstado());
            stmt.setBoolean(7, time.isSen());
            stmt.execute();
            stmt.close();
            con.getConnection().close();            
            //System.out.println("Foi");
        } catch (Exception e) {
            // System.out.println("Nao foi");
        }              
    }
    
    public ObservableList<Time> selectTime(){
        ObservableList<Time> times = FXCollections.observableArrayList();               
        String sql = "SELECT * FROM time";    
        ConnectionFactory con = new ConnectionFactory();
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Time time = new Time();
                time.setId_time(rs.getInt("id_time"));
                time.setNome(rs.getString("nome"));             
                time.setAbreviacao(rs.getString("abreviacao"));
                time.setEmblema(rs.getString("emblema"));
                time.setUniforme(rs.getString("uniforme"));
                time.setFundador(rs.getString("fundador"));
                time.setSenha(rs.getString("senha"));
                time.setSen(rs.getBoolean("sen"));
                time.setEstado(rs.getString("estado"));
                times.add(time);
                System.out.println("BOM");
            }           
            con.getConnection().close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(JogadorDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ruim");
        }    
        return times;
    }
    
    public ObservableList<Time> selectTimeespeci(int id){
        ObservableList<Time> times = FXCollections.observableArrayList();               
        String sql = "SELECT * FROM time WHERE id_time = ?";    
        ConnectionFactory con = new ConnectionFactory();
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Time time = new Time();
                time.setId_time(rs.getInt("id_time"));
                time.setNome(rs.getString("nome"));             
                time.setAbreviacao(rs.getString("abreviacao"));
                time.setEmblema(rs.getString("emblema"));
                time.setUniforme(rs.getString("uniforme"));
                time.setFundador(rs.getString("fundador"));
                time.setSenha(rs.getString("senha"));
                time.setSen(rs.getBoolean("sen"));
                time.setEstado(rs.getString("estado"));
                times.add(time);
                System.out.println("BOM");
            }           
            con.getConnection().close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(JogadorDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ruim");
        }    
        return times;
    }
    
    public void delete(Time t){
        String sql = "DELETE FROM time WHERE id_time = ?";
        ConnectionFactory con = new ConnectionFactory();
        try{
            PreparedStatement stm = con.getConnection().prepareStatement(sql);
            stm.setInt(1, t.getId_time());
            stm.execute();
            stm.close();
            con.getConnection().close();
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }
   
    public void AddUniforme(String u, int id){
        String sql = "UPDATE time SET uniforme = ? WHERE id_time = ?;";
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
    
    public ObservableList<Time> selectTimeespeciNome(String nome){
        ObservableList<Time> times = FXCollections.observableArrayList();               
        String sql = "SELECT * FROM time WHERE nome = ?";    
        ConnectionFactory con = new ConnectionFactory();
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Time time = new Time();
                time.setId_time(rs.getInt("id_time"));
                time.setNome(rs.getString("nome"));             
                time.setAbreviacao(rs.getString("abreviacao"));
                time.setEmblema(rs.getString("emblema"));
                time.setUniforme(rs.getString("uniforme"));
                time.setFundador(rs.getString("fundador"));
                time.setSenha(rs.getString("senha"));
                time.setSen(rs.getBoolean("sen"));
                time.setEstado(rs.getString("estado"));
                times.add(time);
                System.out.println("BOM");
            }           
            con.getConnection().close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(JogadorDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ruim");
        }    
        return times;
    }
    
}
