package control;

import com.jfoenix.controls.JFXSpinner;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import model.JDBC.TimeDAO;
import model.Time;
import model.Usuario;
import view.manage.criauniformeabre;
import view.manage.montacardabre;
import view.manage.realprincipalabre;

public class CriaUniformeController implements Initializable {

    @FXML private ImageView iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8, iv9, iv10, iv11, iv12, iv13, iv14, iv15, iv16, iv17, iv18, iv19, iv20;
    @FXML private Pane pane;
    @FXML private Label lbescolha;
    @FXML private JFXSpinner spinner;  
    @FXML private AnchorPane anchor1, anchor2;    
    @FXML private Label lbuniforme;    
    @FXML private ScrollPane scroll;
    private static Usuario usu;
    private static String name;
    TimeDAO dao = new TimeDAO();
    private ObservableList<Time> obslistateam;
    int id;

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        CriaUniformeController.name = name;
    }
    

    public static Usuario getUsu() {
        return usu;
    }

    public static void setUsu(Usuario usu) {
        CriaUniformeController.usu = usu;
    }
    
    public void Inicia(){
        obslistateam = dao.selectTime();
        for(int i = 0; i < obslistateam.size(); i++){
            if(obslistateam.get(i).getNome().equals(name)){
                id = obslistateam.get(i).getId_time();
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Inicia();
        
        iv1.setOnMouseEntered(value->{
            iv1.setFitHeight(240);
            iv1.setFitWidth(220);
        });   
        iv1.setOnMouseExited(value->{
            iv1.setFitHeight(227);
            iv1.setFitWidth(201);           
        });
        
        iv2.setOnMouseEntered(value->{
            iv2.setFitHeight(240);
            iv2.setFitWidth(220);
        });   
        iv2.setOnMouseExited(value->{
            iv2.setFitHeight(227);
            iv2.setFitWidth(201);           
        });
        
        iv3.setOnMouseEntered(value->{
            iv3.setFitHeight(240);
            iv3.setFitWidth(220);
        });   
        iv3.setOnMouseExited(value->{
            iv3.setFitHeight(227);
            iv3.setFitWidth(201);           
        });
        
        iv4.setOnMouseEntered(value->{
            iv4.setFitHeight(240);
            iv4.setFitWidth(220);
        });   
        iv4.setOnMouseExited(value->{
            iv4.setFitHeight(227);
            iv4.setFitWidth(201);           
        });
        
        iv5.setOnMouseEntered(value->{
            iv5.setFitHeight(240);
            iv5.setFitWidth(220);
        });   
        iv5.setOnMouseExited(value->{
            iv5.setFitHeight(227);
            iv5.setFitWidth(201);           
        });
        
        iv6.setOnMouseEntered(value->{
            iv6.setFitHeight(240);
            iv6.setFitWidth(220);
        });   
        iv6.setOnMouseExited(value->{
            iv6.setFitHeight(227);
            iv6.setFitWidth(201);           
        });
        
        iv7.setOnMouseEntered(value->{
            iv7.setFitHeight(240);
            iv7.setFitWidth(220);
        });   
        iv7.setOnMouseExited(value->{
            iv7.setFitHeight(227);
            iv7.setFitWidth(201);           
        });
        
        iv8.setOnMouseEntered(value->{
            iv8.setFitHeight(240);
            iv8.setFitWidth(220);
        });   
        iv8.setOnMouseExited(value->{
            iv8.setFitHeight(227);
            iv8.setFitWidth(201);           
        });
        
        iv9.setOnMouseEntered(value->{
            iv9.setFitHeight(240);
            iv9.setFitWidth(220);
        });   
        iv9.setOnMouseExited(value->{
            iv9.setFitHeight(227);
            iv9.setFitWidth(201);           
        });
        
        iv10.setOnMouseEntered(value->{
            iv10.setFitHeight(240);
            iv10.setFitWidth(220);
        });   
        iv10.setOnMouseExited(value->{
            iv10.setFitHeight(227);
            iv10.setFitWidth(201);           
        });
        
        iv11.setOnMouseEntered(value->{
            iv11.setFitHeight(240);
            iv11.setFitWidth(220);
        });   
        iv11.setOnMouseExited(value->{
            iv11.setFitHeight(227);
            iv11.setFitWidth(201);           
        });
        
        iv12.setOnMouseEntered(value->{
            iv12.setFitHeight(240);
            iv12.setFitWidth(220);
        });   
        iv12.setOnMouseExited(value->{
            iv12.setFitHeight(227);
            iv12.setFitWidth(201);           
        });
        
        iv13.setOnMouseEntered(value->{
            iv13.setFitHeight(240);
            iv13.setFitWidth(220);
        });   
        iv13.setOnMouseExited(value->{
            iv13.setFitHeight(227);
            iv13.setFitWidth(201);           
        });
        
        iv14.setOnMouseEntered(value->{
            iv14.setFitHeight(240);
            iv14.setFitWidth(220);
        });   
        iv14.setOnMouseExited(value->{
            iv14.setFitHeight(227);
            iv14.setFitWidth(201);           
        });
        
        iv15.setOnMouseEntered(value->{
            iv15.setFitHeight(240);
            iv15.setFitWidth(220);
        });   
        iv15.setOnMouseExited(value->{
            iv15.setFitHeight(227);
            iv15.setFitWidth(201);           
        });
        
        iv16.setOnMouseEntered(value->{
            iv16.setFitHeight(240);
            iv16.setFitWidth(220);
        });   
        iv16.setOnMouseExited(value->{
            iv16.setFitHeight(227);
            iv16.setFitWidth(201);           
        });
        
        iv17.setOnMouseEntered(value->{
            iv17.setFitHeight(240);
            iv17.setFitWidth(220);
        });   
        iv17.setOnMouseExited(value->{
            iv17.setFitHeight(227);
            iv17.setFitWidth(201);           
        });
        
        iv18.setOnMouseEntered(value->{
            iv18.setFitHeight(240);
            iv18.setFitWidth(220);
        });   
        iv18.setOnMouseExited(value->{
            iv18.setFitHeight(227);
            iv18.setFitWidth(201);           
        });
        
        iv19.setOnMouseEntered(value->{
            iv19.setFitHeight(240);
            iv19.setFitWidth(220);
        });   
        iv19.setOnMouseExited(value->{
            iv19.setFitHeight(227);
            iv19.setFitWidth(201);           
        });
        
        iv20.setOnMouseEntered(value->{
            iv20.setFitHeight(240);
            iv20.setFitWidth(220);
        });   
        iv20.setOnMouseExited(value->{
            iv20.setFitHeight(227);
            iv20.setFitWidth(201);           
        });
        
        iv1.setOnMouseClicked(value->{
            dao.AddUniforme("20.png", id);
            montacardabre r1 = new montacardabre(usu);
            criauniformeabre c1 = new criauniformeabre(name);
            c1.fecharTela(); r1.abreTela();
        });
        iv2.setOnMouseClicked(value->{
            dao.AddUniforme("19.png", id);
            montacardabre r1 = new montacardabre(usu);
            criauniformeabre c1 = new criauniformeabre(name);
            c1.fecharTela(); r1.abreTela();
        });
        iv3.setOnMouseClicked(value->{
            dao.AddUniforme("18.png", id);
            montacardabre r1 = new montacardabre(usu);
            criauniformeabre c1 = new criauniformeabre(name);
            c1.fecharTela(); r1.abreTela();
        });
        iv4.setOnMouseClicked(value->{
            dao.AddUniforme("17.png", id);
            montacardabre r1 = new montacardabre(usu);
            criauniformeabre c1 = new criauniformeabre(name);
            c1.fecharTela(); r1.abreTela();
        });
        iv5.setOnMouseClicked(value->{
            dao.AddUniforme("15.png", id);
            montacardabre r1 = new montacardabre(usu);
            criauniformeabre c1 = new criauniformeabre(name);
            c1.fecharTela(); r1.abreTela();
        });
        iv6.setOnMouseClicked(value->{
            dao.AddUniforme("16.png", id);
            montacardabre r1 = new montacardabre(usu);
            criauniformeabre c1 = new criauniformeabre(name);
            c1.fecharTela(); r1.abreTela();
        });
        iv7.setOnMouseClicked(value->{
            dao.AddUniforme("14.png", id);
            montacardabre r1 = new montacardabre(usu);
            criauniformeabre c1 = new criauniformeabre(name);
            c1.fecharTela(); r1.abreTela();
        });
        iv8.setOnMouseClicked(value->{
            dao.AddUniforme("13.png", id);
            montacardabre r1 = new montacardabre(usu);
            criauniformeabre c1 = new criauniformeabre(name);
            c1.fecharTela(); r1.abreTela();
        });
        iv9.setOnMouseClicked(value->{
            dao.AddUniforme("12.png", id);
            montacardabre r1 = new montacardabre(usu);
            criauniformeabre c1 = new criauniformeabre(name);
            c1.fecharTela(); r1.abreTela();
        });
        iv10.setOnMouseClicked(value->{
            dao.AddUniforme("11.png", id);
            montacardabre r1 = new montacardabre(usu);
            criauniformeabre c1 = new criauniformeabre(name);
            c1.fecharTela(); r1.abreTela();
        });
        iv11.setOnMouseClicked(value->{
            dao.AddUniforme("10.png", id);
            montacardabre r1 = new montacardabre(usu);
            criauniformeabre c1 = new criauniformeabre(name);
            c1.fecharTela(); r1.abreTela();
        });
        iv12.setOnMouseClicked(value->{
            dao.AddUniforme("9.png", id);
            montacardabre r1 = new montacardabre(usu);
            criauniformeabre c1 = new criauniformeabre(name);
            c1.fecharTela(); r1.abreTela();
        });
        iv13.setOnMouseClicked(value->{
            dao.AddUniforme("8.png", id);
            montacardabre r1 = new montacardabre(usu);
            criauniformeabre c1 = new criauniformeabre(name);
            c1.fecharTela(); r1.abreTela();
        });
        iv14.setOnMouseClicked(value->{
            dao.AddUniforme("7.png", id);
            montacardabre r1 = new montacardabre(usu);
            criauniformeabre c1 = new criauniformeabre(name);
            c1.fecharTela(); r1.abreTela();
        });
        iv15.setOnMouseClicked(value->{
            dao.AddUniforme("6.png", id);
            montacardabre r1 = new montacardabre(usu);
            criauniformeabre c1 = new criauniformeabre(name);
            c1.fecharTela(); r1.abreTela();
        });
        iv16.setOnMouseClicked(value->{
            dao.AddUniforme("4.png", id);
            montacardabre r1 = new montacardabre(usu);
            criauniformeabre c1 = new criauniformeabre(name);
            c1.fecharTela(); r1.abreTela();
        });
        iv17.setOnMouseClicked(value->{
            dao.AddUniforme("3.png", id);
            montacardabre r1 = new montacardabre(usu);
            criauniformeabre c1 = new criauniformeabre(name);
            c1.fecharTela(); r1.abreTela();
        });
        iv18.setOnMouseClicked(value->{
            dao.AddUniforme("2.png", id);
            montacardabre r1 = new montacardabre(usu);
            criauniformeabre c1 = new criauniformeabre(name);
            c1.fecharTela(); r1.abreTela();
        });
        iv19.setOnMouseClicked(value->{
            dao.AddUniforme("1.png", id);
            montacardabre r1 = new montacardabre(usu);
            criauniformeabre c1 = new criauniformeabre(name);
            c1.fecharTela(); r1.abreTela();
        });
        iv20.setOnMouseClicked(value->{
            dao.AddUniforme("5.png", id);
            montacardabre r1 = new montacardabre(usu);
            criauniformeabre c1 = new criauniformeabre(name);
            c1.fecharTela(); r1.abreTela();
        });
        
    }    
    
}
