
package control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.JDBC.UsuarioDAO;
import model.Usuario;
import model.gerenciaImagem;
import view.manage.editarabre;
import view.manage.perfilabre;


public class EditarPerfilController implements Initializable {

    @FXML private TextField tflogin, tfsenha, tftime, tfconfirmsenha;
    @FXML private Label lbnomedotime, lblogin, lbconfirmsenha, lbtitulo, lbsenha;   
    @FXML private ImageView ivfundo, ivfoto;   
    @FXML private Button btcancelar, bteditar, btfoto;
    String caminho;
    gerenciaImagem gerencia = new gerenciaImagem();
    private static Usuario usu;
    
    public static Usuario getUsu() {
        return usu;
    }

    public static void setUsu(Usuario usu) {
        EditarPerfilController.usu = usu;
    }
    
    public void Inicia(){
        tflogin.setText(usu.getNome());
        tftime.setText(usu.getTime());
        caminho = usu.getFoto();
        Image image = new Image("/imagens/emblemas/" + caminho);
        ivfoto.setImage(image);
    }
    
    public void Foto(){                      
            String camin = gerencia.getNovaImagem();            
            Image image = new Image("file:///" + camin);
            ivfoto.setImage(image);           
            caminho = camin;
    }
    
    public void Atualiza(){
        String time = tftime.getText();
        String login = tflogin.getText();
        String senha = tfsenha.getText();
        String senha2 = tfconfirmsenha.getText();
        boolean val = valida();
        if(val == true){
            Usuario u = new Usuario();
            UsuarioDAO dao = new UsuarioDAO();
            if(caminho != usu.getFoto()){
              u.setFoto(gerencia.uploadUrlEmblema(caminho, tftime.getText()));
            }else{
              u.setFoto(caminho);
            }
            u.setId_usuario(usu.getId_usuario());
            u.setNome(login);
            u.setSenha(senha);
            u.setTime(time);
            dao.AtualizaPerfil(u);
            editarabre e1 = new editarabre(usu);
            perfilabre p1 = new perfilabre(usu);
            e1.fecharTela(); p1.abreTela();
        }else{
            Alert erro = new Alert(Alert.AlertType.ERROR);
            erro.setHeaderText("Erro nas informações!!!");
            erro.show();
        }
    }
    public boolean valida(){
        boolean val = true;
        if(tfsenha.getText().equals(tfconfirmsenha.getText())){
            val = true;
        }else{
            val = false;
        }
        if(tflogin.getText().equals("") || tftime.getText().equals("") || tfsenha.getText().equals("") || tfconfirmsenha.getText().equals("")){
            val = false;
        }
        return val;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Inicia();
        btcancelar.setOnMouseClicked(value->{
            editarabre e1 = new editarabre(usu);
            perfilabre p1 = new perfilabre(usu);
            e1.fecharTela(); p1.abreTela();
        });
        
        bteditar.setOnMouseClicked(value->{
            Atualiza();
        });
        
        btfoto.setOnMouseClicked(value->{
            Foto();
        });
    }    
    
}
