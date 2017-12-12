package model.JDBC;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Criptografia;
import model.Usuario;

public class UsuarioDAO {
    
    public void addUsuario(Usuario usuario){
    
       String sql = "INSERT INTO usuario ( nome, senha, foto, nome_time, adm, dinheiro) VALUES ( ?, ?, ?, ?, ?, ?)";
        
       ConnectionFactory con = new ConnectionFactory(); 
              
       try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);            
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, Criptografia.Criptografando(usuario.getFoto()));           
            stmt.setString(4, usuario.getTime());
            stmt.setBoolean(5, usuario.isAdm());
            stmt.setDouble(6, usuario.getDinheiro());
            stmt.execute();
            stmt.close();
            con.getConnection().close();
            
            System.out.println("Foi");
        } catch (Exception e) {
            System.out.println("Nao foi");
        }             
    }
    
    public ObservableList<Usuario> selectUsuario(){
        ObservableList<Usuario> usuarios = FXCollections.observableArrayList();
                
        String sql = "SELECT * FROM usuario";
        Date ota;
        ConnectionFactory con = new ConnectionFactory();
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setId_usuario(rs.getInt("id_usuario"));
                usuario.setNome(rs.getString("nome"));             
                usuario.setSenha(rs.getString("senha"));                           
                usuario.setAdm(rs.getBoolean("adm"));               
                usuario.setFoto(rs.getString("foto"));
                usuario.setDinheiro(rs.getDouble("dinheiro"));
                usuario.setId_copa(rs.getInt("id_copa"));
                usuario.setId_liga(rs.getInt("id_liga"));
                usuario.setId_time(rs.getInt("id_time"));
                usuario.setModoreal(rs.getBoolean("modoreal"));              
                usuario.setTime(rs.getString("nome_time"));
                usuario.setTema(rs.getString("tema"));
                usuario.setChute(rs.getInt("chute"));
                usuario.setDefesa(rs.getInt("defesa"));
                usuario.setDrible(rs.getInt("drible"));
                usuario.setVelocidade(rs.getInt("velocidade"));
                usuario.setFisico(rs.getInt("fisico"));
                usuario.setPasse(rs.getInt("passe"));
                usuario.setFotocard(rs.getString("fotocard"));
                usuario.setNomecard(rs.getString("nomecard"));
                usuarios.add(usuario);
               // System.out.println("BOM");
            }            
            con.getConnection().close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
           // System.out.println("ruim");
        }           
        return usuarios;
    }
    
     public void Adddinheiro(int u, double d){
        
        String sql = "UPDATE usuario SET dinheiro = ? WHERE id_usuario = ?;";
        
        ConnectionFactory con = new ConnectionFactory();
        
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);                        
            stmt.setDouble(1, d);
            stmt.setInt(2, u);
            stmt.execute();
            stmt.close();
            con.getConnection().close();
            
            System.out.println("Dinheiro");
        } catch (Exception e) {
            System.out.println("Nao foi dinh");
        }
    }
    
    public void Addcopa(int u, int c){
        String sql = "UPDATE usuario SET id_copa = ? WHERE id_usuario = ?;";
        ConnectionFactory con = new ConnectionFactory();
        
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);                        
            stmt.setInt(1, u);    
            stmt.setInt(2, c);
            stmt.execute();
            stmt.close();
            con.getConnection().close();
            
            System.out.println("foi pra copa");
        } catch (Exception e) {
            System.out.println("Nao foi copa");
        }
    }
    
    public void Addtime(int u, int c){
        String sql = "UPDATE usuario SET id_time = ? WHERE id_usuario = ?;";
        ConnectionFactory con = new ConnectionFactory();
        
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);                        
            stmt.setInt(1, u);    
            stmt.setInt(2, c);
            stmt.execute();
            stmt.close();
            con.getConnection().close();
            
            System.out.println("foi pra copa");
        } catch (Exception e) {
            System.out.println("Nao foi copa");
        }
    }
    
    public void Addmodoreal(boolean u, int c){
        String sql = "UPDATE usuario SET modoreal = ? WHERE id_usuario = ?;";
        ConnectionFactory con = new ConnectionFactory();
        
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);                        
            stmt.setBoolean(1, u);    
            stmt.setInt(2, c);
            stmt.execute();
            stmt.close();
            con.getConnection().close();
            
            System.out.println("foi pra copa");
        } catch (Exception e) {
            System.out.println("Nao foi copa");
        }
    }
     
    public void AddTema(String u, int id){
        String sql = "UPDATE usuario SET tema = ? WHERE id_usuario = ?;";
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
    
    public void AddCard(Usuario usu){
        String sql = "UPDATE usuario SET passe = ?, velocidade = ?, drible = ?, fisico = ?, chute = ?, defesa = ?, nomecard = ?, fotocard = ? WHERE id_usuario = ?;";
        ConnectionFactory con = new ConnectionFactory();
        
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);                        
            stmt.setInt(1, usu.getPasse());    
            stmt.setInt(2, usu.getVelocidade());
            stmt.setInt(3, usu.getDrible());
            stmt.setInt(4, usu.getFisico());
            stmt.setInt(5, usu.getChute());
            stmt.setInt(6, usu.getDefesa());
            stmt.setString(7, usu.getNomecard());
            stmt.setString(8, usu.getFotocard());
            stmt.setInt(9, usu.getId_usuario());
            stmt.execute();
            stmt.close();
            con.getConnection().close();
            System.out.println("Consegui jjjj");
        } catch (Exception e) {
            System.out.println("Nao foi copa");
        }
    }
        public void delete(Usuario u){
        String sql = "DELETE FROM usuario WHERE id_usuario = ?";
        ConnectionFactory con = new ConnectionFactory();
        try{
            PreparedStatement stm = con.getConnection().prepareStatement(sql);
            stm.setInt(1, u.getId_usuario());
            stm.execute();
            stm.close();
            con.getConnection().close();
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }
        
        public void Addliga(int u, int c){
        String sql = "UPDATE usuario SET id_liga = ? WHERE id_usuario = ?;";
        ConnectionFactory con = new ConnectionFactory();
        
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);                        
            stmt.setInt(1, u);    
            stmt.setInt(2, c);
            stmt.execute();
            stmt.close();
            con.getConnection().close();
            
            System.out.println("foi pra copa");
        } catch (Exception e) {
            System.out.println("Nao foi copa");
        }
    }
    
        
        public void AtualizaPerfil(Usuario usu){
        String sql = "UPDATE usuario SET login = ?, senha = ?, time = ? , foto = ? WHERE id_usuario = ?;";
        ConnectionFactory con = new ConnectionFactory();
        
        try {
            PreparedStatement stmt = con.getConnection().prepareStatement(sql);                        
            stmt.setString(1, usu.getNome());    
            stmt.setString(2, Criptografia.Criptografando(usu.getSenha()));
            stmt.setString(3, usu.getTime());
            stmt.setString(4, usu.getFoto());
            stmt.setInt(5, usu.getId_usuario());
            stmt.execute();
            stmt.close();
            con.getConnection().close();
            System.out.println("Consegui jjjj");
        } catch (Exception e) {
            System.out.println("Nao foi copa");
        }
    }
}
