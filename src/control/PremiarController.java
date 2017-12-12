package control;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.JDBC.UsuarioDAO;
import model.Usuario;
import view.manage.premiarabre;
import view.manage.usuariosabre;


public class PremiarController implements Initializable {

    @FXML private JFXButton btpremiar, btcancelar, btmultar;
    @FXML private Label lbdinheiro, lbnome;
    @FXML private TextField tfvalor;
    private static Usuario usu;
    private static Double dinheiro;
    private static int id_premiado;
    private static String nome;
    UsuarioDAO dao = new UsuarioDAO();

    public static String getNome() {
        return nome;
    }

    public static void setNome(String nome) {
        PremiarController.nome = nome;
    }
    
    
    public static Double getDinheiro() {
        return dinheiro;
    }

    public static void setDinheiro(Double dinheiro) {
        PremiarController.dinheiro = dinheiro;
    }

    public static int getId_premiado() {
        return id_premiado;
    }

    public static void setId_premiado(int id_premiado) {
        PremiarController.id_premiado = id_premiado;
    }

    
  
    
    
    public static Usuario getUsu() {
        return usu;
    }

    public static void setUsu(Usuario usu) {
        PremiarController.usu = usu;
    }

    public void Inicia(){
        lbnome.setText(nome);
        lbdinheiro.setText(String.valueOf(dinheiro));
    } 
    
    
    
    public void Premiar(){
        dinheiro = dinheiro + Double.valueOf(tfvalor.getText());
        dao.Adddinheiro(id_premiado, dinheiro);
        if(id_premiado == usu.getId_usuario()){
            usu.setDinheiro(usu.getDinheiro() + Double.valueOf(tfvalor.getText()));
        }
        tfvalor.clear();
        Inicia();
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setHeaderText("Usuario premiado com sucesso!!!");
        a.show();
    }
    
    public void Multar(){
        usu.setDinheiro(usu.getDinheiro() - Double.valueOf(tfvalor.getText()));
        dao.Adddinheiro(usu.getId_usuario(), usu.getDinheiro());
        tfvalor.clear();
        Inicia();
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setHeaderText("Usuario multado com sucesso!!!");
        a.show();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Inicia();
        
        btcancelar.setOnMouseClicked(value->{
            premiarabre p1 = new premiarabre(usu);
            usuariosabre u1 = new usuariosabre(usu);
            p1.fecharTela(); u1.abreTela();
        });
        
        btmultar.setOnMouseClicked(value->{
            Multar();
        });
        
        btpremiar.setOnMouseClicked(value->{
            Premiar();
        });
    }    
    
}
