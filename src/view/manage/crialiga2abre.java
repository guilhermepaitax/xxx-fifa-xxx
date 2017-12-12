package view.manage;

import control.CriaLiga2Controller;
import control.CrialigaController;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Usuario;

public class crialiga2abre {
    
    private static Stage stage;

    public crialiga2abre(Usuario usu) {
        CriaLiga2Controller.setUsu(usu);
    }

    public crialiga2abre(String nome) {
        CriaLiga2Controller.setNome(nome);
    }

    
    public void abreTela() {
        try {
            start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(crialiga2abre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void fecharTela(){
        
        stage.close();
    }
    

    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/CriaLiga2.fxml"));
        
        Scene scene = new Scene(root);
         Image image = new Image("/imagens/logo - Cópia.png");
        stage.getIcons().add(image);
        stage.setTitle("XXxFIFAxXX");
        stage.setScene(scene);
        stage.show();
        crialiga2abre.stage=stage;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
