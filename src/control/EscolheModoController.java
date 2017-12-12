package control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.Usuario;
import view.manage.Escolheabre;
import view.manage.escolhetimeabre;
import view.manage.principalabre;
import view.manage.realprincipalabre;

public class EscolheModoController implements Initializable {

    @FXML private Label lbreal, lbtexto1, lbvirtual, lbtitulo, lbtexto2;
    @FXML private Button btreal, btvirtual;
    @FXML private ImageView ivfundo, ivreal, ivvirtual;
    @FXML private Pane panefrente, panefundo, panefrente2, panefundo2;
    private static Usuario usu;

    public static Usuario getUsu() {
        return usu;
    }

    public static void setUsu(Usuario usu) {
        EscolheModoController.usu = usu;
    }
    
    
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        btvirtual.setOnMouseEntered(value->{
            panefrente.setOpacity(0);
            ivvirtual.setOpacity(0);
        });   
        btvirtual.setOnMouseExited(value->{
            panefrente.setOpacity(100);
            ivvirtual.setOpacity(100);           
        });
        
        btreal.setOnMouseEntered(value->{
            panefrente2.setOpacity(0);
            ivreal.setOpacity(0);
        });   
        btreal.setOnMouseExited(value->{
            panefrente2.setOpacity(100);
            ivreal.setOpacity(100);           
        });
        
        btvirtual.setOnMouseClicked(value->{
            principalabre p1 = new principalabre(usu);
            Escolheabre e1 = new Escolheabre(usu);
            e1.fecharTela(); p1.abreTela();
        });
        
        btreal.setOnMouseClicked(value->{
            if(usu.isModoreal() == true){
                realprincipalabre r1 = new realprincipalabre(usu);
                Escolheabre m1 = new Escolheabre(usu);
                m1.fecharTela();
                r1.abreTela();
            }else{
                escolhetimeabre e1 = new escolhetimeabre(usu);
                Escolheabre m1 = new Escolheabre(usu);
                m1.fecharTela(); e1.abreTela();
            }
           
        });
        
    }    
    
}
