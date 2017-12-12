package view.manage;

import control.PerfilController;
import control.PremiarController;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Usuario;

public class premiarabre {

    private static Stage stage;    

    public premiarabre(Usuario usu) {
        PremiarController.setUsu(usu);
    }
    

    public premiarabre(double dinheiro, int id_usuario, String nome) {
        PremiarController.setDinheiro(dinheiro);
        PremiarController.setId_premiado(id_usuario);
        PremiarController.setNome(nome);
    }

    
    public void abreTela() {
        try {
            start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(premiarabre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void fecharTela(){
        
        stage.close();
    }
    

    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Premiar.fxml"));
        
        Scene scene = new Scene(root);
         Image image = new Image("/imagens/logo - Cópia.png");
        stage.getIcons().add(image);
        stage.setTitle("XXxFIFAxXX");
        stage.setScene(scene);
        stage.show();
        premiarabre.stage=stage;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
