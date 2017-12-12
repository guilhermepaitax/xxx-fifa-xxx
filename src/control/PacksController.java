
package control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import model.JDBC.UsuarioDAO;
import model.Usuario;
import view.manage.mercadoabre;
import view.manage.packabre;
import view.manage.packjogadoresabre;


public class PacksController implements Initializable {

    @FXML private Button btcomprar, btcancelar;
    @FXML private Label lbpreco, lbtitulo;
    @FXML private ImageView ivfundo, ivjogadores;
    private static Usuario usu;

    public static Usuario getUsu() {
        return usu;
    }

    public static void setUsu(Usuario usu) {
        PacksController.usu = usu;
    }
    
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        btcomprar.setOnMouseClicked(value->{
            UsuarioDAO dao = new UsuarioDAO();
            if(usu.getDinheiro() >= 5000){
            usu.setDinheiro(usu.getDinheiro() - 5000);
            dao.Adddinheiro(usu.getId_usuario(), usu.getDinheiro());
            packjogadoresabre p1 = new packjogadoresabre(usu);
            packabre pa = new packabre(usu);
            pa.fecharTela(); p1.abreTela();
            }else{
               Alert erro = new Alert(Alert.AlertType.WARNING);
               erro.setHeaderText("Voce não possui dinheiro suficiente!!!");
               erro.show(); 
            }
        });
        
        btcancelar.setOnMouseClicked(value->{
            packabre pa = new packabre(usu);
            mercadoabre m1 = new mercadoabre(usu);
            pa.fecharTela(); m1.abreTela();
        });
        
        btcomprar.setOnMouseEntered(value->{
            btcomprar.setPrefSize(110, 40); });
           
        btcomprar.setOnMouseExited(value->{            
            btcomprar.setPrefSize(105, 35);});
        
        btcancelar.setOnMouseEntered(value->{
            btcancelar.setPrefSize(110, 40); });
           
        btcancelar.setOnMouseExited(value->{            
            btcancelar.setPrefSize(105, 35);});
        
    }    
    
}
