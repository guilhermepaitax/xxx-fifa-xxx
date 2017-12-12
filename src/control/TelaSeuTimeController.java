package control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.JDBC.TimeDAO;
import model.Time;
import model.Usuario;
import view.manage.realprincipalabre;
import view.manage.telaseutimeabre;

public class TelaSeuTimeController implements Initializable {

    @FXML private ImageView ivuniforme;
    @FXML private Label lbfundador;
    @FXML private ImageView ivemblema;
    @FXML private Label lbestado;
    @FXML private ImageView ivvoltar;
    @FXML private Label lbnome;
    @FXML private Label lbabreviacao;
    @FXML private Label lbestadio;
    private static Usuario usu;
    private ObservableList<Time> obslistatime;
    private ObservableList<Time> obslistatime2;
    
    
    public static Usuario getUsu() {
        return usu;
    }

    public static void setUsu(Usuario usu) {
        TelaSeuTimeController.usu = usu;
    }
    
    public void Inicia(){
        TimeDAO tdao = new TimeDAO();
            obslistatime = tdao.selectTimeespeci(usu.getId_time());
            for(int i = 0; i <obslistatime.size(); i++){
            lbnome.setText(obslistatime.get(i).getNome());
            lbabreviacao.setText(obslistatime.get(i).getAbreviacao());
            lbestado.setText(obslistatime.get(i).getEstado());
            lbfundador.setText(obslistatime.get(i).getFundador());
            Image image = new Image("/imagens/kits/" + obslistatime.get(i).getUniforme());
            ivuniforme.setImage(image);
            Image image2 = new Image("/imagens/emblemas/" + obslistatime.get(i).getEmblema());
            ivemblema.setImage(image2);
            }
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Inicia();
           
        ivvoltar.setOnMouseClicked(value->{
            telaseutimeabre t1 = new telaseutimeabre(usu);
            realprincipalabre r1 = new realprincipalabre(usu);
            t1.fecharTela(); r1.abreTela();
        });
        
        
    }    
    
}
