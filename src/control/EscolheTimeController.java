package control;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSpinner;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import model.Usuario;
import view.manage.crietimeabre;
import view.manage.escolhetimeabre;
import view.manage.tabeladetimesabre;

public class EscolheTimeController implements Initializable {

    @FXML private JFXButton btcrie, btescolha;
    @FXML private Label lbsubtitle, lbtitulo;
    @FXML private Pane pane;   
    @FXML private JFXSpinner spinner;
    private static Usuario usu;

    public static Usuario getUsu() {
        return usu;
    }

    public static void setUsu(Usuario usu) {
        EscolheTimeController.usu = usu;
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        btcrie.setOnMouseClicked(value->{
            crietimeabre c1 = new crietimeabre(usu);
            escolhetimeabre e1 = new escolhetimeabre(usu);
            e1.fecharTela(); c1.abreTela();
        });
        
        btescolha.setOnMouseClicked(value->{
            tabeladetimesabre t1 = new tabeladetimesabre(usu);
            escolhetimeabre e1 = new escolhetimeabre(usu);
            e1.fecharTela(); t1.abreTela();
        });
    }    
    
}
