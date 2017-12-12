package view.manage;


import control.CriaCopaController;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Usuario;


public class criarcopaabre {
    
    private static Stage stage;

    public criarcopaabre(Usuario usu) {
        CriaCopaController.setUsu(usu);
    }
 
    public void abreTela() {
        try {
            start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(criarcopaabre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void fecharTela(){
        
        stage.close();
    }
    

    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/CriaCopa.fxml"));
         Image image = new Image("/imagens/logo - Cópia.png");
        stage.getIcons().add(image);
        stage.setTitle("XXxFIFAxXX");
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        criarcopaabre.stage=stage;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    
}
