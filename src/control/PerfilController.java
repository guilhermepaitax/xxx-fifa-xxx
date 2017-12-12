
package control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Usuario;
import view.manage.cadastrajogadorabre;
import view.manage.cadastrausuarioabre;
import view.manage.editarabre;
import view.manage.jogadoresabre;
import view.manage.perfilabre;
import view.manage.principalabre;
import view.manage.usuariosabre;


public class PerfilController implements Initializable {

    @FXML private ImageView ivfoto, ivlogo, ivfundo;
    @FXML private TextField tftime, tfnome;
    @FXML private Label lbnome, lbtime;
    @FXML private Button bteditar, btusuarios, btjogadores, btcadusu, btcadjog;
    private static Usuario usu;

    public static Usuario getUsu() {
        return usu;
    }

    public static void setUsu(Usuario usu) {
        PerfilController.usu = usu;
    }
    
    public void Inicia(){
        tftime.setText(usu.getTime());
        tfnome.setText(usu.getNome());
        if(usu.getFoto() != ""){
        Image image = new Image("/imagens/emblemas/" + usu.getFoto());
        ivfoto.setImage(image);
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Inicia();
        
        ivlogo.setOnMouseClicked(value->{
            principalabre p1 = new principalabre(usu);
            perfilabre c1 = new perfilabre(usu);
            c1.fecharTela(); p1.abreTela();
        });
        
        btcadusu.setOnMouseClicked(value->{
            if(usu.isAdm() == true){
            cadastrausuarioabre c1 = new cadastrausuarioabre();
            c1.abreTela();
            }else{
                Alert erro = new Alert(Alert.AlertType.ERROR);
                erro.setHeaderText("Você nao tem permissão para acessar esta função!");
                erro.show();
            }
        });
        
        btcadjog.setOnMouseClicked(value->{
            cadastrajogadorabre c1 = new cadastrajogadorabre();
            c1.abreTela();
        });
        
        btjogadores.setOnMouseClicked(value->{
            if(usu.isAdm() == true){
            jogadoresabre j1 = new jogadoresabre(usu);
            perfilabre p1 = new perfilabre(usu);
            p1.fecharTela(); j1.abreTela();
            }else{
                Alert erro = new Alert(Alert.AlertType.ERROR);
                erro.setHeaderText("Você nao tem permissão para acessar esta função!");
                erro.show();
            }
        });
        
        btusuarios.setOnMouseClicked(value->{
            if(usu.isAdm() == true){
            usuariosabre u1 = new usuariosabre(usu);
            perfilabre p1 = new perfilabre(usu);
            p1.fecharTela(); u1.abreTela();
            }else{
                Alert erro = new Alert(Alert.AlertType.ERROR);
                erro.setHeaderText("Você nao tem permissão para acessar esta função!");
                erro.show();
            }
        });
        
        bteditar.setOnMouseClicked(value->{
            editarabre e1 = new editarabre(usu);
            perfilabre p1 = new perfilabre(usu);
            p1.fecharTela(); e1.abreTela();
        });
        
        DoubleProperty width = ivfundo.fitWidthProperty();
        DoubleProperty height = ivfundo.fitHeightProperty();
        width.bind(Bindings.selectDouble(ivfundo.sceneProperty(), "width"));
        height.bind(Bindings.selectDouble(ivfundo.sceneProperty(), "height"));
    }    
    
}
