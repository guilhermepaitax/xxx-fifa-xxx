package view.manage;

import control.TemaController;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Usuario;

public class temaabre {
    
    private static Stage stage;

    public temaabre(Usuario usu) {
        TemaController.setUsu(usu);
    }

    
    public void abreTela() {
        try {
            start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(temaabre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void fecharTela(){
        
        stage.close();
    }
    

    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Tema.fxml"));
        
        Scene scene = new Scene(root);
         Image image = new Image("/imagens/logo - Cópia.png");
        stage.getIcons().add(image);
        stage.setTitle("XXxFIFAxXX");
        stage.setScene(scene);
        stage.show();
        temaabre.stage=stage;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
