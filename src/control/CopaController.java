
package control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import model.Usuario;
import view.manage.continuacopaabre;
import view.manage.copaabre;
import view.manage.criarcopaabre;
import view.manage.principalabre;


public class CopaController implements Initializable {

     @FXML private ImageView ivfundo, ivtrofeu, ivnovacopa, ivlogo, ivcontinuar;
     @FXML private Label lbcontinuar, lbnovacopa;
     private static Usuario usu;

    public static Usuario getUsu() {
        return usu;
    }

    public static void setUsu(Usuario usu) {
        CopaController.usu = usu;
    }
     
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        ivlogo.setOnMouseClicked(value->{
            principalabre p1 = new principalabre(usu);
            copaabre c1 = new copaabre(usu);
            c1.fecharTela(); p1.abreTela();
        });
        
        ivnovacopa.setOnMouseEntered(value->{
            ivnovacopa.setFitWidth(324);
            ivnovacopa.setFitHeight(244); });
           
        ivnovacopa.setOnMouseExited(value->{            
            ivnovacopa.setFitWidth(319);
            ivnovacopa.setFitHeight(239); });
        
        ivcontinuar.setOnMouseEntered(value->{
            ivcontinuar.setFitWidth(324);
            ivcontinuar.setFitHeight(244); });
           
        ivcontinuar.setOnMouseExited(value->{            
            ivcontinuar.setFitWidth(319);
            ivcontinuar.setFitHeight(239); });
        
        ivcontinuar.setOnMouseClicked(value->{
            if(usu.getId_copa() != 0){
            continuacopaabre c1 = new continuacopaabre(usu);
            copaabre cp1 = new copaabre(usu);
            cp1.fecharTela(); c1.abreTela();
            }else{
                Alert erro = new Alert(Alert.AlertType.ERROR);
                erro.setHeaderText("Você não esta presente em nunhuma copa!");
                erro.show();
            }
        });
        
        ivnovacopa.setOnMouseClicked(value->{
            if(usu.isAdm() == true){
            criarcopaabre c1 = new criarcopaabre(usu);
            copaabre a1 = new copaabre(usu);
            a1.fecharTela(); c1.abreTela();
            }else{
                Alert erro = new Alert(Alert.AlertType.ERROR);
                erro.setHeaderText("Você nao tem permissão para acessar esta função!");
                erro.show();
            }
        });
    }    
    
}
