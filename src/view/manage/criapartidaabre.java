package view.manage;

import control.AjustetimeController;
import control.CriaPartidaController;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Usuario;

public class criapartidaabre {
    
    private static Stage stage;

    public criapartidaabre(Usuario usu) {
        CriaPartidaController.setUsu(usu);
    }

    
    public void abreTela() {
        try {
            start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(criapartidaabre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void fecharTela(){
        
        stage.close();
    }
    

    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/CriaPartida.fxml"));
         Image image = new Image("/imagens/logo - Cópia.png");
        stage.getIcons().add(image);
        stage.setTitle("XXxFIFAxXX");
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        criapartidaabre.stage=stage;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
