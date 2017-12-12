package control;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.JDBC.UsuarioDAO;
import model.Usuario;
import model.gerenciaImagem;
import view.manage.montacardabre;
import view.manage.realprincipalabre;
import view.manage.temaabre;

public class MontaCardController implements Initializable {

    @FXML private JFXTextField tfdef, tfpace, tfdrib, tfnome, tfshoot, tfpassing, tfphy;
    @FXML private ImageView ivfotojogador;
    @FXML private JFXButton btcontinuar, btfoto;
    private static Usuario usu;
    String caminho = null;
    gerenciaImagem gerencia = new gerenciaImagem();
    
    public static Usuario getUsu() {
        return usu;
    }

    public static void setUsu(Usuario usu) {
        MontaCardController.usu = usu;
    }
    
    public void Cadastra(){
        if(tfnome.getText() != ""){
        Usuario usuu = new Usuario();
        UsuarioDAO dao = new UsuarioDAO();
        usuu.setChute(Integer.valueOf(tfshoot.getText()));
        usuu.setDefesa(Integer.valueOf(tfdef.getText()));
        usuu.setDrible(Integer.valueOf(tfdrib.getText()));
        usuu.setNomecard(tfnome.getText());
        usuu.setVelocidade(Integer.valueOf(tfpace.getText()));
        usuu.setPasse(Integer.valueOf(tfpassing.getText()));
        usuu.setFisico(Integer.valueOf(tfphy.getText()));
        if(caminho != null){
        usuu.setFotocard(gerencia.uploadUrlEmblema(caminho, tfnome.getText()));
        }else{
        usuu.setFotocard("alam.png");
    }
        usuu.setId_usuario(usu.getId_usuario());
        dao.AddCard(usuu);
        temaabre r1 = new temaabre(usu);
        montacardabre m1 = new montacardabre(usu);
        m1.fecharTela(); r1.abreTela();
        }else{
            Alert erro = new Alert(Alert.AlertType.ERROR);
            erro.setHeaderText("Informações inseridas de forma incorreta!!!");
            erro.show();           
        }
    }
    
    public void Valida(){
        boolean valid = false;
        int chut =0,def =0,drib =0,velo =0,fisi =0,passe =0;
        try{
            chut = Integer.valueOf(tfshoot.getText());
            def = Integer.valueOf(tfdef.getText());
            drib = Integer.valueOf(tfdrib.getText());
            velo = Integer.valueOf(tfpace.getText());
            fisi = Integer.valueOf(tfphy.getText());
            passe = Integer.valueOf(tfpassing.getText());
            valid = true;
        }catch(Exception e){
            Alert erro = new Alert(Alert.AlertType.ERROR);
            erro.setHeaderText("Informações inseridas de forma incorreta!!!");
            erro.show();
            valid = false;
        }
        
        if(valid == true){
            Cadastra();
        }
    }
    
    public void Foto(){           
           
            String camin = gerencia.getNovaImagem();            
            Image image = new Image("file:///" + camin);
            ivfotojogador.setImage(image);           
            caminho = camin;
        
    }
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btcontinuar.setOnMouseClicked(value->{
            Valida();
        });
        btfoto.setOnMouseClicked(value->{
            Foto();
        });
    }    
    
}
