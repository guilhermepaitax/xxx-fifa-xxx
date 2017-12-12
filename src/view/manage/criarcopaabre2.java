package view.manage;

import control.CriaCopa2Controller;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Copa;
import model.Usuario;

public class criarcopaabre2 {
    
    private static Stage stage;

    public criarcopaabre2( Usuario usu) {
        CriaCopa2Controller.setUsu(usu);
    }


    public criarcopaabre2(String nome) {
        CriaCopa2Controller.setNome(nome);
    }
 
    public void abreTela() {
        try {
            start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(criarcopaabre2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void fecharTela(){
        
        stage.close();
    }
    

    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/CriaCopa2.fxml"));
         Image image = new Image("/imagens/logo - Cópia.png");
        stage.getIcons().add(image);
        stage.setTitle("XXxFIFAxXX");
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        criarcopaabre2.stage=stage;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
