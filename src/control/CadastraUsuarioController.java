
package control;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.JDBC.UsuarioDAO;
import model.JavaMail;
import model.Usuario;
import model.gerenciaImagem;
import view.manage.cadastrausuarioabre;



public class CadastraUsuarioController implements Initializable {

    @FXML private Label lbnomedotime, lbconfirmsenha, lblogin, lbtitulo, lbsenha, lbmens;
    @FXML private ImageView ivfundo, ivemblema;  
    @FXML private TextField tflogin, tftime, tfemail, tfcodigo;
    @FXML private PasswordField tfsenha, tfconfirmsenha;
    @FXML private Button btcadastrar, btcancelar, btemblema;
    @FXML private RadioButton  cbadm, cbusu;
    @FXML private JFXButton btcodigo;
    @FXML private Pane pane1;
    String caminho = null;
    gerenciaImagem gerencia = new gerenciaImagem();
    ToggleGroup grupo = new ToggleGroup();
    
    public void Foto(){           
           
            String camin = gerencia.getNovaImagem();            
            Image image = new Image("file:///" + camin);
            ivemblema.setImage(image);           
            caminho = camin;
        
    }
    
    public void Valida(){
        boolean adm = cbadm.isSelected(), usu = cbusu.isSelected();
        String nome = tflogin.getText(),senha = tfsenha.getText(),conf = tfconfirmsenha.getText(), time = tftime.getText();
        
        if(nome.equals("") || senha.equals("") || conf.equals("") || time.equals("") || adm == true && usu == true || adm == false && usu == false ){
            Alert concluido = new Alert(Alert.AlertType.ERROR);
            
            if(nome.equals("") || senha.equals("") || conf.equals("") || time.equals("")){
                concluido.setHeaderText("Erro no cadastro, Preencha todos os campos!!!");
                concluido.show();
            }
            
            if(adm == true && usu == true || adm == false && usu == false){
                concluido.setHeaderText("Erro no cadastro, Preencha apenas uma opção de usuario!!!");
                concluido.show();
            }
            
            if(senha.equals(conf)){
                
            }else{
                concluido.setHeaderText("Erro no cadastro, As senhas devem estar iguais!!!");
                concluido.show();
            }
            
        }
        else{
            Cadastrar();
        }
    }
    
    public void Cadastrar(){
        int codigo;
        pane1.setVisible(true);
        JavaMail j1 = new JavaMail();
        codigo = j1.Manda(tfemail.getText());
        btcodigo.setOnMouseClicked(value->{
            System.out.println("Cogigo "+codigo);
        if(tfcodigo.getText().equals(String.valueOf(codigo))){
        Usuario usuario = new Usuario();
        UsuarioDAO dao = new UsuarioDAO();
        
        usuario.setNome(tflogin.getText());
        usuario.setSenha(tfsenha.getText());
        usuario.setTime(tftime.getText());
        usuario.setAdm(cbadm.isSelected());
        usuario.setDinheiro(25000);
        if(caminho != null){
        usuario.setFoto(gerencia.uploadUrlEmblema(caminho, tftime.getText()));
        }else{
            usuario.setFoto("exemple.png");
        }
        
        dao.addUsuario(usuario);
        
        Alert concluido = new Alert(Alert.AlertType.INFORMATION);
        concluido.setHeaderText("Cadastro concluido!!!");
        concluido.show();
        cadastrausuarioabre cad = new cadastrausuarioabre();
        cad.fecharTela();
        lbmens.setVisible(false);
        }else{
            Alert concluido = new Alert(Alert.AlertType.ERROR);
            concluido.setHeaderText("Codico Incorreto!!!");
            concluido.show();
            lbmens.setVisible(true);
        }
        });
        
    }
    
    public void Limpa(){
        tfconfirmsenha.clear();
        tflogin.clear();
        tfsenha.clear();
        tftime.clear();
        cbadm.setSelected(false);
        cbusu.setSelected(false);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbadm.setToggleGroup(grupo); cbusu.setToggleGroup(grupo);
         btcancelar.setOnMouseClicked(value->{
            cadastrausuarioabre c1 = new cadastrausuarioabre();
            c1.fecharTela();
        });
         
         btcadastrar.setOnMouseClicked(value->{
             Valida();
        });
         
         btemblema.setOnMouseClicked(value->{
             Foto();
         });
    }    
    
}
