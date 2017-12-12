
package control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import model.Usuario;
import view.manage.continuarligaabre;
import view.manage.crialigaabre;
import view.manage.ligaabre;
import view.manage.principalabre;


public class LigaController implements Initializable {

    @FXML private ImageView ivfundo, ivnovaliga, ivlogo, ivcontinuar;
    @FXML private Label lbcontinuar, lbnova;

    private static Usuario usu;

    public static Usuario getUsu() {
        return usu;
    }

    public static void setUsu(Usuario usu) {
        LigaController.usu = usu;
    }
    


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ivlogo.setOnMouseClicked(value->{
            principalabre p1 = new principalabre(usu);
            ligaabre l1 = new ligaabre(usu);
            l1.fecharTela(); p1.abreTela();
        });
        
        ivcontinuar.setOnMouseEntered(value->{
            ivcontinuar.setFitWidth(357);
            ivcontinuar.setFitHeight(265); });
           
        ivcontinuar.setOnMouseExited(value->{            
            ivcontinuar.setFitWidth(252);
            ivcontinuar.setFitHeight(260); });
        
        ivnovaliga.setOnMouseEntered(value->{
            ivnovaliga.setFitWidth(479);
            ivnovaliga.setFitHeight(271); });
           
        ivnovaliga.setOnMouseExited(value->{            
            ivnovaliga.setFitWidth(474);
            ivnovaliga.setFitHeight(266); });
        
        ivcontinuar.setOnMouseClicked(value->{
            if(usu.getId_liga() != 0){
            continuarligaabre c1 = new continuarligaabre(usu);
            ligaabre l1 = new ligaabre(usu);
            l1.fecharTela(); c1.abreTela();
            }else{
                Alert erro = new Alert(Alert.AlertType.ERROR);
                erro.setHeaderText("Você nao esta presente em nenhuma liga!");
                erro.show();
            }
        });
        
        ivnovaliga.setOnMouseClicked(value->{
            if(usu.isAdm() == true){
            crialigaabre c1 = new crialigaabre(usu);
            ligaabre l1 = new ligaabre(usu);
            l1.fecharTela(); c1.abreTela();
            }else{
            Alert erro = new Alert(Alert.AlertType.ERROR);
                erro.setHeaderText("Você nao tem permissão para acessar esta função!");
                erro.show();
        }
        });
    }    
    
}
