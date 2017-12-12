package view.manage;

import control.CriaUniformeController;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Time;
import model.Usuario;

public class criauniformeabre {
    
    private static Stage stage;

   

    public criauniformeabre(String nome) {
         CriaUniformeController.setName(nome);
    }

    public criauniformeabre(Usuario usu) {
        CriaUniformeController.setUsu(usu);
    }

    
    public void abreTela() {
        try {
            start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(criauniformeabre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void fecharTela(){
        
        stage.close();
    }
    

    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/CriaUniforme.fxml"));
        
        Scene scene = new Scene(root);
         Image image = new Image("/imagens/logo - Cópia.png");
        stage.getIcons().add(image);
        stage.setTitle("XXxFIFAxXX");
        stage.setScene(scene);
        stage.show();
        criauniformeabre.stage=stage;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
