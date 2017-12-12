package control;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import model.Usuario;
import view.manage.Escolheabre;
import view.manage.Videoabre;

public class VideoInicioController implements Initializable {
    String caminho = "imagens/teste.mp4";
    @FXML private MediaView mvfifa;
    private MediaPlayer mp;
    private Media me;
    private static Usuario usu;        

    public static Usuario getUsu() {
        return usu;
    }

    public static void setUsu(Usuario usu) {
        VideoInicioController.usu = usu;
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String path = new File("src/imagens/XXXFIFAVIDEO.mp4").getAbsolutePath();
        me = new Media(new File(path).toURI().toString());
        mp = new MediaPlayer(me);
        mvfifa.setMediaPlayer(mp);
        mp.setAutoPlay(true);
        DoubleProperty width = mvfifa.fitWidthProperty();
        DoubleProperty height = mvfifa.fitHeightProperty();
        width.bind(Bindings.selectDouble(mvfifa.sceneProperty(), "width"));
        height.bind(Bindings.selectDouble(mvfifa.sceneProperty(), "height"));
        
        mvfifa.setOnMouseClicked(value->{           
            Escolheabre e1 = new Escolheabre(usu);
            Videoabre v1 = new Videoabre(usu);
            v1.fecharTela();
            mp.stop();
            e1.abreTela();
            
            
        });
        
    }    
    
}
