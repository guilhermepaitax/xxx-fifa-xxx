package control;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import model.JDBC.PartidaDAO;
import model.JDBC.TimeDAO;
import model.Partida;
import model.Time;
import model.Usuario;
import view.manage.criapartidaabre;
import view.manage.realprincipalabre;

public class CriaPartidaController implements Initializable {

    @FXML private JFXButton btcancelar, btconfirmar;
    @FXML private JFXTextField tfhora, tflocal;
    @FXML private DatePicker dpdata;
    private static Usuario usu;
    private ObservableList<Time> obslistatime;

    public static Usuario getUsu() {
        return usu;
    }

    public static void setUsu(Usuario usu) {
        CriaPartidaController.usu = usu;
    }
    
    public void Cria(){
        String nome = "";
        TimeDAO dao = new TimeDAO();
        PartidaDAO pdao = new PartidaDAO();
        obslistatime = dao.selectTimeespeci(usu.getId_time());
        for(int i = 0; i < obslistatime.size(); i++){
            nome = obslistatime.get(i).getNome();
        }
        Partida part = new Partida();
        part.setDia(dpdata.getValue().toString());
        part.setHora(tfhora.getText());
        part.setLocalizacao(tflocal.getText());
        part.setId_time1(usu.getId_time());
        part.setTime1(nome);
        pdao.addPartida(part);
            criapartidaabre c1 = new criapartidaabre(usu);
            realprincipalabre r1 = new realprincipalabre(usu);
            c1.fecharTela(); r1.abreTela();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tfhora.setStyle("-fx-text-fill: white");
        tflocal.setStyle("-fx-text-fill: white");
        
        btcancelar.setOnMouseClicked(value->{
            criapartidaabre c1 = new criapartidaabre(usu);
            realprincipalabre r1 = new realprincipalabre(usu);
            c1.fecharTela(); r1.abreTela();
        });
        btconfirmar.setOnMouseClicked(value->{
            Cria();
        });
    }    
    
}
