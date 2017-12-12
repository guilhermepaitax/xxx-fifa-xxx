package control;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.JDBC.Participante2DAO;
import model.Participante2;
import model.Usuario;
import view.manage.continuarligaabre;
import view.manage.ligaabre;
import view.manage.partidaligaabre;

public class PartidaLigaController implements Initializable {
    
    
    @FXML private TextField tfpl1;
    @FXML private ComboBox<Participante2> cbtime2;
    @FXML private ComboBox<Participante2> cbtime1;
    @FXML private JFXButton btadd, btcancelar;
    @FXML private TextField tfpl2;
    private static Usuario usu;
    private ObservableList<Participante2> obslista;
    
    public static Usuario getUsu() {
        return usu;
    }

    public static void setUsu(Usuario usu) {
        PartidaLigaController.usu = usu;
    }
    
    public void inicia(){
        Participante2DAO pdao = new Participante2DAO();
        obslista = pdao.selectPart(usu.getId_liga());
        for(int i  = 0;i< obslista.size(); i++){
            cbtime1.setItems(obslista);
            cbtime2.setItems(obslista);
        }
    }
    
    public void Add(){
        Participante2DAO dao = new Participante2DAO();
        Participante2 time1 = new Participante2();
        Participante2 time2 = new Participante2();
        time1 = cbtime1.getValue();
        time2 = cbtime2.getValue();
        boolean valida = false;
        int p1 = 0, p2 = 0;
        
        try{
            p1 = Integer.valueOf(tfpl1.getText());
            p2 = Integer.valueOf(tfpl2.getText());
            valida = true;
            if(p1<0 || p2<0){
            valida = false;
            Alert erro = new Alert(Alert.AlertType.ERROR);
            erro.setHeaderText("Os placares não podem ser negativos");
            erro.show();
        }
            
        }catch(Exception e){
            Alert erro = new Alert(Alert.AlertType.ERROR);
            erro.setHeaderText("Os placares estão inseridos de forma incorreta");
            erro.show();
        }
        
        Alert suc = new Alert(Alert.AlertType.CONFIRMATION);
        suc.setHeaderText("Partida adicionada com sucesso!");
        
        if(time1.getId_participante2() != time2.getId_participante2() && valida == true){
            if(p1 > p2){
                
                dao.Addvitorias(time1.getVitorias() + 1, time1.getId_participante2());
                dao.Addgols(time1.getGols() + p1, time1.getId_participante2());
                dao.Addpartidas(time1.getPartidas() + 1, time1.getId_participante2());
                dao.Addpontos1(time1.getPontos() + 3, time1.getId_participante2());
                
                dao.Addderrotas(time2.getDerrotas() + 1, time2.getId_participante2());
                dao.Addgols(time2.getGols() + p2, time2.getId_participante2());
                dao.Addpartidas(time2.getPartidas() + 1, time2.getId_participante2());
                dao.Addpontos1(time2.getPontos() + 0, time2.getId_participante2());
                suc.show();
            }else if(p2>p1){
                
                dao.Addvitorias(time2.getVitorias() + 1, time2.getId_participante2());
                dao.Addgols(time2.getGols() + p1, time2.getId_participante2());
                dao.Addpartidas(time2.getPartidas() + 1, time2.getId_participante2());
                dao.Addpontos1(time2.getPontos() + 3, time2.getId_participante2());
                
                dao.Addderrotas(time1.getDerrotas() + 1, time1.getId_participante2());
                dao.Addgols(time1.getGols() + p2, time1.getId_participante2());
                dao.Addpartidas(time1.getPartidas() + 1, time1.getId_participante2());
                dao.Addpontos1(time1.getPontos() + 0, time1.getId_participante2());
                suc.show();
            }else if(p1 == p2){
                
                dao.Addempates(time2.getEmpates() + 1, time2.getId_participante2());
                dao.Addgols(time2.getGols() + p1, time2.getId_participante2());
                dao.Addpartidas(time2.getPartidas() + 1, time2.getId_participante2());
                dao.Addpontos1(time2.getPontos() + 3, time2.getId_participante2());
                
                dao.Addempates(time1.getEmpates() + 1, time1.getId_participante2());
                dao.Addgols(time1.getGols() + p2, time1.getId_participante2());
                dao.Addpartidas(time1.getPartidas() + 1, time1.getId_participante2());
                dao.Addpontos1(time1.getPontos() + 0, time1.getId_participante2());
                suc.show();
            }
        }else{
            Alert erro = new Alert(Alert.AlertType.ERROR);
            erro.setHeaderText("Os times devem ser diferentes");
            erro.show();
        }
    }
    
    public void Final(){
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       inicia();
        btcancelar.setOnMouseClicked(value->{
            continuarligaabre c1 = new continuarligaabre(usu);
            partidaligaabre p1 = new partidaligaabre(usu);
            p1.fecharTela(); c1.abreTela();
            
        });
        
        btadd.setOnMouseClicked(value->{
            Add();
        });
    }    
    
}
