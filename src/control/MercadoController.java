
package control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import model.Usuario;
import view.manage.mercadoabre;
import view.manage.packabre;
import view.manage.principalabre;
import view.manage.transferenciasabre;


public class MercadoController implements Initializable {

    @FXML private ImageView ivfundo, ivpack, ivlogo, ivtransf;
    @FXML private Button btpack, bttransf;
    @FXML private Label lbmercado;
    private static Usuario usu;

    public static Usuario getUsu() {
        return usu;
    }

    public static void setUsu(Usuario usu) {
        MercadoController.usu = usu;
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btpack.setTooltip(new Tooltip("Abrir Pack"));
        
        ivlogo.setOnMouseClicked(value->{
            principalabre p1 = new principalabre(usu);
            mercadoabre m1 = new mercadoabre(usu);
            m1.fecharTela(); p1.abreTela();
        });
    
        btpack.setOnMouseClicked(value->{
            packabre p1 = new packabre(usu);
            mercadoabre m1 = new mercadoabre(usu);
            m1.fecharTela(); p1.abreTela();
        });
    
        btpack.setOnMouseEntered(value->{
            btpack.setPrefSize(110, 40); });
           
        btpack.setOnMouseExited(value->{            
            btpack.setPrefSize(105, 36);});
        
        bttransf.setOnMouseEntered(value->{
            bttransf.setPrefSize(110, 40); });
           
        bttransf.setOnMouseExited(value->{            
            bttransf.setPrefSize(105, 36);});
    
        bttransf.setOnMouseClicked(value->{
            transferenciasabre t1 = new transferenciasabre(usu);
            mercadoabre m1 = new mercadoabre(usu);
            m1.fecharTela(); t1.abreTela();
            
        });
    }
}