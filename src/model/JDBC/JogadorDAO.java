package model.JDBC;

import model.Jogador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class JogadorDAO {
    
   public void addJogador(Jogador jogador){    
       String sql = "INSERT INTO jogadores ( nome, posicao, foto, overall, valor) VALUES ( ?, ?, ?, ?, ?)";        
       ConnectionFactory con = new ConnectionFactory();               
       try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);            
            stmt.setString(1, jogador.getNome());
            stmt.setString(2, jogador.getPosicao());
            stmt.setString(3, jogador.getFoto());           
            stmt.setInt(4, jogador.getOveral());
            stmt.setDouble(5, jogador.getValor());                       
            stmt.execute();
            stmt.close();
            con.getConnection().close();            
            //System.out.println("Foi");
        } catch (Exception e) {
            // System.out.println("Nao foi");
        }              
    }
    
    public ObservableList<Jogador> selectJogador(){
        ObservableList<Jogador> jogadores = FXCollections.observableArrayList();               
        String sql = "SELECT * FROM jogadores";    
        ConnectionFactory con = new ConnectionFactory();
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Jogador jogador = new Jogador();
                jogador.setId_jogador(rs.getInt("id_jogador"));
                jogador.setNome(rs.getString("nome"));             
                jogador.setFoto(rs.getString("foto"));
                jogador.setValor(rs.getDouble("valor"));                           
                jogador.setId_usuario(rs.getInt("id_usuario"));
                jogador.setOveral(rs.getInt("overall"));
                jogador.setPosicao(rs.getString("posicao"));
                jogadores.add(jogador);
               // System.out.println("BOM");
            }           
            con.getConnection().close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(JogadorDAO.class.getName()).log(Level.SEVERE, null, ex);
           // System.out.println("ruim");
        }    
        return jogadores;
    }
    
    public void delete(Jogador j){
        String sql = "DELETE FROM jogadores WHERE id_jogador = ?";
        ConnectionFactory con = new ConnectionFactory();
        try{
            PreparedStatement stm = con.getConnection().prepareStatement(sql);
            stm.setInt(1, j.getId_jogador());
            stm.execute();
            stm.close();
            con.getConnection().close();
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }
   
    public void UpdateJogador(Jogador jogador){
    
       String sql = "UPDATE jogadores SET nome = ?, posicao = ?, foto = ?, id_usuario = ?, overall = ?, valor = ? WHERE id_jogador = ?;";
        
       ConnectionFactory con = new ConnectionFactory(); 
       
       
       try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);            
            stmt.setString(1, jogador.getNome());
            stmt.setString(2, jogador.getPosicao());
            stmt.setString(3, jogador.getFoto());           
            stmt.setInt(4, jogador.getId_usuario());
            stmt.setInt(5, jogador.getOveral());
            stmt.setDouble(6, jogador.getValor());
            stmt.setInt(7, jogador.getId_jogador());
            stmt.execute();
            stmt.close();
            con.getConnection().close();
            
            System.out.println("Foi");
        } catch (Exception e) {
            System.out.println("Nao foi");
        }
              
    }
    
    public ObservableList<Jogador> selectJogadorusuario(int c){
        ObservableList<Jogador> jogadores = FXCollections.observableArrayList();
        
        
        String sql = "SELECT * FROM jogadores WHERE id_usuario = ?";
     
        ConnectionFactory con = new ConnectionFactory();
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            stmt.setInt(1, c);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Jogador jogador = new Jogador();
                jogador.setId_jogador(rs.getInt("id_jogador"));
                jogador.setNome(rs.getString("nome"));             
                jogador.setFoto(rs.getString("foto"));
                jogador.setValor(rs.getDouble("valor"));                           
                jogador.setId_usuario(rs.getInt("id_usuario"));
                jogador.setOveral(rs.getInt("overall"));
                jogador.setPosicao(rs.getString("posicao"));
                jogadores.add(jogador);
               // System.out.println("BOM");
            }
            
            con.getConnection().close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(JogadorDAO.class.getName()).log(Level.SEVERE, null, ex);
           // System.out.println("ruim");
        }    
        return jogadores;
    }
    
    public void Addusuario(int u, int j){
        
        String sql = "UPDATE jogadores SET id_usuario = ? WHERE id_jogador = ?;";
        
        ConnectionFactory con = new ConnectionFactory();
        
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);            
            stmt.setInt(1, u);
            stmt.setInt(2, j);
            stmt.execute();
            stmt.close();
            con.getConnection().close();
            
            System.out.println("Foi");
        } catch (Exception e) {
            System.out.println("Nao foi");
        }
    }
    
}
