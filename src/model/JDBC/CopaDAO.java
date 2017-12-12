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

public class CopaDAO {
    
    public void addCopa(Copa copa){    
       String sql = "INSERT INTO copa ( nome, quantidade, premio, valorpartida) VALUES ( ?, ?, ?, ?)";        
       ConnectionFactory con = new ConnectionFactory();               
       try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);            
            stmt.setString(1, copa.getNome());
            stmt.setInt(2, copa.getQuantidade());
            stmt.setDouble(3, copa.getPremio());           
            stmt.setDouble(4, copa.getValorpartida());
                                  
            stmt.execute();
            stmt.close();
            con.getConnection().close();            
            System.out.println("Foi");
        } catch (Exception e) {
            System.out.println("Nao foi");
        }              
    }
    
    public ObservableList<Copa> selectCopa(){
        ObservableList<Copa> copas = FXCollections.observableArrayList();               
        String sql = "SELECT * FROM copa";    
        ConnectionFactory con = new ConnectionFactory();
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Copa copa = new Copa();
                copa.setId_copa(rs.getInt("id_copa"));
                copa.setNome(rs.getString("nome"));             
                copa.setPremio(rs.getDouble("premio"));
                copa.setQuantidade(rs.getInt("quantidade"));                           
                copa.setValorpartida(rs.getDouble("valorpartida"));
                copas.add(copa);
               // System.out.println("BOM");
            }           
            con.getConnection().close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(JogadorDAO.class.getName()).log(Level.SEVERE, null, ex);
           // System.out.println("ruim");
        }    
        return copas;
    }
    
    public void delete(int c){
        String sql = "DELETE FROM copa WHERE id_copa = ?";
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
    /////////////////////////////////////////////////////////////////////////////////////////
    public ObservableList<Copa> selectCopaPart(int id){
        ObservableList<Copa> copas = FXCollections.observableArrayList();               
        String sql = "SELECT * FROM copa WHERE id_copa = ?";    
        ConnectionFactory con = new ConnectionFactory();
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
      
            while(rs.next()){
                Copa copa = new Copa();
                copa.setId_copa(rs.getInt("id_copa"));
                copa.setNome(rs.getString("nome"));             
                copa.setPremio(rs.getDouble("premio"));
                copa.setQuantidade(rs.getInt("quantidade"));                           
                copa.setValorpartida(rs.getDouble("valorpartida"));
                copas.add(copa);
                
               // System.out.println("BOM");
            }           
            con.getConnection().close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(JogadorDAO.class.getName()).log(Level.SEVERE, null, ex);
           // System.out.println("ruim");
        }    
        return copas;
    }
    
    public ObservableList<Copa> selectCopaNome(String nome){
        ObservableList<Copa> copas = FXCollections.observableArrayList();               
        String sql = "SELECT * FROM copa WHERE nome = ?";    
        ConnectionFactory con = new ConnectionFactory();
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
      
            while(rs.next()){
                Copa copa = new Copa();
                copa.setId_copa(rs.getInt("id_copa"));
                copa.setNome(rs.getString("nome"));             
                copa.setPremio(rs.getDouble("premio"));
                copa.setQuantidade(rs.getInt("quantidade"));                           
                copa.setValorpartida(rs.getDouble("valorpartida"));
                copas.add(copa);
                
               // System.out.println("BOM");
            }           
            con.getConnection().close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(JogadorDAO.class.getName()).log(Level.SEVERE, null, ex);
           // System.out.println("ruim");
        }    
        return copas;
    }
    
}
