package control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.image.ImageView;
import model.Usuario;
import view.manage.continuarligaabre;
import view.manage.graficoabre;

public class GraficoController implements Initializable {

    @FXML private BarChart<?, ?> barchart;
    @FXML private NumberAxis number;
    @FXML private CategoryAxis caterory;
    @FXML private ImageView ivvoltar;
    private static Usuario usu;

    public static Usuario getUsu() {
        return usu;
    }

    public static void setUsu(Usuario usu) {
        GraficoController.usu = usu;
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ivvoltar.setOnMouseClicked(value->{
            continuarligaabre c1 = new continuarligaabre(usu);
            graficoabre g1 = new graficoabre(usu);
            g1.fecharTela();c1.abreTela();
        });
    }    
    
}
