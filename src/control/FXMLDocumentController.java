
package control;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import model.Criptografia;
import model.JDBC.UsuarioDAO;
import model.Usuario;
import view.manage.Escolheabre;
import view.manage.Videoabre;
import view.manage.XxfifaxX;


public class FXMLDocumentController implements Initializable {
    
    
    @FXML private JFXTextField tflogin;
    @FXML private JFXPasswordField pfsenha;
    @FXML private JFXButton btentrar;
    private ObservableList<Usuario> obslista;
    
     public void Logar(){
         UsuarioDAO dao = new UsuarioDAO();
         obslista = dao.selectUsuario();
         for (int i = 0; i < obslista.size(); i++) {
             
             if(obslista.get(i).getNome().equals(tflogin.getText()) && obslista.get(i).getSenha().equals(Criptografia.Criptografando(pfsenha.getText()))){
                 
                 String nome, senha, foto, time, tema, fotocard, nomecard;
                 double dinheiro;
                 int id_usuario, id_copa, id_liga, id_time, id_partida, velocidade, passe, defesa, chute, drible, fisico;
                 boolean modoreal,adm;
                 
                 nome = obslista.get(i).getNome();
                 senha = obslista.get(i).getSenha();
                 foto = obslista.get(i).getFoto();
                 time = obslista.get(i).getTime();
                 dinheiro = obslista.get(i).getDinheiro();
                 id_usuario = obslista.get(i).getId_usuario();                
                 id_copa = obslista.get(i).getId_copa();
                 id_liga = obslista.get(i).getId_liga();
                 id_time = obslista.get(i).getId_time();
                 modoreal = obslista.get(i).isModoreal();
                 adm = obslista.get(i).isAdm();
                 tema = obslista.get(i).getTema();
                 nomecard = obslista.get(i).getNomecard();
                fotocard = obslista.get(i).getFotocard();
                velocidade = obslista.get(i).getVelocidade();
                chute = obslista.get(i).getChute();
                passe = obslista.get(i).getPasse();
                fisico = obslista.get(i).getFisico();
                defesa = obslista.get(i).getDefesa();
                drible = obslista.get(i).getDrible();
                 Usuario usuario = new Usuario(nome, senha, foto, time, dinheiro, id_usuario, id_copa, id_liga, id_time, modoreal, adm, tema, nomecard, fotocard, defesa, velocidade, drible, chute, passe, fisico);
                 XxfifaxX x = new XxfifaxX();
                 Videoabre v1 = new Videoabre(usuario);                 
                 v1.abreTela();
                 x.fecharTela();
                 i = obslista.size();
             }else{
                 if (i + 1 == obslista.size()) {
                     System.out.println("senha:"+Criptografia.Criptografando(pfsenha.getText()));
                    Alert erro = new Alert(Alert.AlertType.ERROR);
                    erro.setHeaderText("Login ou senha incorretos!!!");
                    erro.show();
                     
                }
             }
         }
         
         
         
         
     }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
       btentrar.setOnMouseClicked(value->{
           Logar();
       });
       
        tflogin.setStyle("-fx-text-fill: white");
        pfsenha.setStyle("-fx-text-fill: white");
       
    }    
    
}
