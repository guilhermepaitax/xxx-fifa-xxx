package view.manage;

import control.EscolheTimeController;
import control.GraficoController;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Usuario;

public class graficoabre {
    
    private static Stage stage;

    public graficoabre(Usuario usunovo) {
        GraficoController.setUsu(usunovo);
    }

    

    
    public void abreTela() {
        try {
            start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(graficoabre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void fecharTela(){
        
        stage.close();
    }
    

    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Grafico.fxml"));
        
        Scene scene = new Scene(root);
         Image image = new Image("/imagens/logo - Cópia.png");
        stage.getIcons().add(image);
        stage.setTitle("XXxFIFAxXX");
        stage.setScene(scene);
        stage.show();
        graficoabre.stage=stage;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
