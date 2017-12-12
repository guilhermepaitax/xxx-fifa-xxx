package model.JDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Jogador;
import model.Transferencias;

public class TransferenciasDAO {
    
    public ObservableList<Transferencias> selectJogadores(){
        ObservableList<Transferencias> transferencias = FXCollections.observableArrayList();               
        String sql = "SELECT * FROM transferencias";    
        ConnectionFactory con = new ConnectionFactory();
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Transferencias jogador = new Transferencias();
                jogador.setId_jogador(rs.getInt("id_jogador"));
                jogador.setId_usuario(rs.getInt("id_usuario"));
                jogador.setPosicao(rs.getString("posicao"));
                jogador.setNome(rs.getString("nome"));             
                jogador.setValor(rs.getDouble("valor"));
                transferencias.add(jogador);
               // System.out.println("BOM");
            }           
            con.getConnection().close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(TransferenciasDAO.class.getName()).log(Level.SEVERE, null, ex);
           // System.out.println("ruim");
        }    
        return transferencias;
    }
    
    public void addJogador(Transferencias transferencias){    
       String sql = "INSERT INTO Transferencias ( nome, valor, id_jogador, id_usuario, posicao) VALUES ( ?, ?, ?, ?, ?)";        
       ConnectionFactory con = new ConnectionFactory();               
       try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);            
            stmt.setString(1, transferencias.getNome());
            stmt.setDouble(2, transferencias.getValor());
            stmt.setInt(3, transferencias.getId_jogador());
            stmt.setInt(4, transferencias.getId_usuario());
            stmt.setString(5, transferencias.getPosicao());
            stmt.execute();
            stmt.close();
            con.getConnection().close();            
            //System.out.println("Foi");
        } catch (Exception e) {
            // System.out.println("Nao foi");
        }              
    }
    
    public void delete(Transferencias t){
        String sql = "DELETE FROM transferencias WHERE id_jogador = ?";
        ConnectionFactory con = new ConnectionFactory();
        try{
            PreparedStatement stm = con.getConnection().prepareStatement(sql);
            stm.setInt(1, t.getId_jogador());
            stm.execute();
            stm.close();
            con.getConnection().close();
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }
    
}
