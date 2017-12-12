package view.manage;

import control.EditarJogadorController;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Jogador;
import model.Usuario;

public class editarjogadorabre {
    
    private static Stage stage;

    public editarjogadorabre(Jogador selecionado) {
        EditarJogadorController.setJ(selecionado);
    }

    public editarjogadorabre(Usuario usu) {
        EditarJogadorController.setUsu(usu);
    }

    
    public void abreTela() {
        try {
            start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(editarjogadorabre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void fecharTela(){
        
        stage.close();
    }
    

    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/EditarJogador.fxml"));
        
        Scene scene = new Scene(root);
         Image image = new Image("/imagens/logo - Cópia.png");
        stage.getIcons().add(image);
        stage.setTitle("XXxFIFAxXX");
        stage.setScene(scene);
        stage.show();
        editarjogadorabre.stage=stage;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
