package control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Usuario;
import view.manage.perfilrealabre;
import view.manage.realprincipalabre;

public class PerfilRealController implements Initializable {
    
    @FXML private ImageView ivvoltar, ivfotocard;
    @FXML private Label lbnomecard;
    @FXML private PieChart graficopizza;
    private static Usuario usu;

    public static Usuario getUsu() {
        return usu;
    }

    public static void setUsu(Usuario usu) {
        PerfilRealController.usu = usu;
    }
    
        
    public void iniciaGrafico(){
        try{
            if(usu.getVelocidade()>0){
                graficopizza.getData().add(new PieChart.Data("Velocidade", Double.valueOf(usu.getVelocidade())));
            }
            if(usu.getDefesa()>0){
                graficopizza.getData().add(new PieChart.Data("Defesa", Double.valueOf(usu.getDefesa())));
            }
            if(usu.getPasse()>0){
                graficopizza.getData().add(new PieChart.Data("Passe", Double.valueOf(usu.getPasse())));
            }
            if(usu.getChute()>0){
                graficopizza.getData().add(new PieChart.Data("Chute", Double.valueOf(usu.getChute())));
            }
            if(usu.getDrible()>0){
                graficopizza.getData().add(new PieChart.Data("Drible", Double.valueOf(usu.getDrible())));
            }
            if(usu.getFisico()>0){
                graficopizza.getData().add(new PieChart.Data("Fisico", Double.valueOf(usu.getFisico())));
            }
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }
    
        public void Inicia(){
            lbnomecard.setText(usu.getNomecard());
            Image image = new Image("/imagens/emblemas/" + usu.getFotocard());
            ivfotocard.setImage(image);
            
        }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iniciaGrafico();
        Inicia();
        
        ivvoltar.setOnMouseClicked(value->{
            realprincipalabre r1 = new realprincipalabre(usu);
            perfilrealabre p1 = new perfilrealabre(usu);
            p1.fecharTela();r1.abreTela();
        });
    }    
    
}
