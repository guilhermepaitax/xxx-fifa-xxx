package model.JDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Liga;

public class LigaDAO {
    
    public void addLiga(Liga liga){    
       String sql = "INSERT INTO liga ( nome, premio, valorpartida) VALUES ( ?, ?, ?)";        
       ConnectionFactory con = new ConnectionFactory();               
       try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);            
            stmt.setString(1, liga.getNome());
            stmt.setDouble(2, liga.getPremio());           
            stmt.setDouble(3, liga.getValorpartida());
                                  
            stmt.execute();
            stmt.close();
            con.getConnection().close();            
            System.out.println("Foi");
        } catch (Exception e) {
            System.out.println("Nao foi");
        }              
    }
    
    public ObservableList<Liga> selectLiga(){
        ObservableList<Liga> ligas = FXCollections.observableArrayList();               
        String sql = "SELECT * FROM liga";    
        ConnectionFactory con = new ConnectionFactory();
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Liga liga = new Liga();
                liga.setId_liga(rs.getInt("id_liga"));
                liga.setNome(rs.getString("nome"));             
                liga.setPremio(rs.getDouble("premio"));                           
                liga.setValorpartida(rs.getDouble("valorpartida"));
                ligas.add(liga);
               // System.out.println("BOM");
            }           
            con.getConnection().close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(LigaDAO.class.getName()).log(Level.SEVERE, null, ex);
           // System.out.println("ruim");
        }    
        return ligas;
    }
    
    public void delete(int c){
        String sql = "DELETE FROM liga WHERE id_liga = ?";
        ConnectionFactory con = new ConnectionFactory();
        try{
            PreparedStatement stm = con.getConnection().prepareStatement(sql);
            stm.setInt(1, c);
            stm.execute();
            stm.close();
            con.getConnection().close();
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }
    
    public ObservableList<Liga> selectLigaNome(String nome){
        ObservableList<Liga> ligas = FXCollections.observableArrayList();               
        String sql = "SELECT * FROM liga WHERE nome = ?";    
        ConnectionFactory con = new ConnectionFactory();
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
      
            while(rs.next()){
                Liga liga = new Liga();
                liga.setId_liga(rs.getInt("id_liga"));
                liga.setNome(rs.getString("nome"));             
                liga.setPremio(rs.getDouble("premio"));                           
                liga.setValorpartida(rs.getDouble("valorpartida"));
                ligas.add(liga);
                
               // System.out.println("BOM");
            }           
            con.getConnection().close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(LigaDAO.class.getName()).log(Level.SEVERE, null, ex);
           // System.out.println("ruim");
        }    
        return ligas;
    }
    
    public ObservableList<Liga> selectLigaId(int id){
        ObservableList<Liga> ligas = FXCollections.observableArrayList();               
        String sql = "SELECT * FROM liga WHERE id_liga = ?";    
        ConnectionFactory con = new ConnectionFactory();
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
      
            while(rs.next()){
                Liga liga = new Liga();
                liga.setId_liga(rs.getInt("id_liga"));
                liga.setNome(rs.getString("nome"));             
                liga.setPremio(rs.getDouble("premio"));                           
                liga.setValorpartida(rs.getDouble("valorpartida"));
                ligas.add(liga);
                
               // System.out.println("BOM");
            }           
            con.getConnection().close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(LigaDAO.class.getName()).log(Level.SEVERE, null, ex);
           // System.out.println("ruim");
        }    
        return ligas;
    }
    
}
