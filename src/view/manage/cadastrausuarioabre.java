
package view.manage;

import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class cadastrausuarioabre {
    
    private static Stage stage;

    
    public void abreTela() {
        try {
            start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(cadastrausuarioabre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void fecharTela(){
        
        stage.close();
    }
    

    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/CadastraUsuario.fxml"));
        
        Scene scene = new Scene(root);
         Image image = new Image("/imagens/logo - Cópia.png");
        stage.getIcons().add(image);
        stage.setTitle("XXxFIFAxXX");
        stage.setScene(scene);
        stage.show();
        cadastrausuarioabre.stage=stage;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
