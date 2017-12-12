package control;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.JDBC.TimeDAO;
import model.JDBC.UsuarioDAO;
import model.Time;
import model.Usuario;
import model.gerenciaImagem;
import view.manage.criauniformeabre;
import view.manage.crietimeabre;
import view.manage.escolhetimeabre;

public class CriaTimeController implements Initializable {

    @FXML private JFXTextField tfnome, tffundador, tfabreviacao, tfcidade;
    @FXML private JFXPasswordField tfsenha;
    @FXML private ImageView ivsenha, ivfundador, ivestado, ivemblema, ivnome, ivabreviacao;
    @FXML private Label lbsubtitulo, lbtitulo;
    @FXML private JFXButton btcancelar, btproximo, btemblema;
    @FXML private JFXToggleButton tbprivado;
    @FXML private Pane pane; 
    @FXML private JFXSpinner spinner;
    private ObservableList<Time> obslistatime;
    String caminho = null;
    gerenciaImagem gerencia = new gerenciaImagem();
    private static Usuario usu;

    public static Usuario getUsu() {
        return usu;
    }

    public static void setUsu(Usuario usu) {
        CriaTimeController.usu = usu;
    }
    

    public void Foto(){           
           
            String camin = gerencia.getNovaImagem();            
            Image image = new Image("file:///" + camin);
            ivemblema.setImage(image);           
            caminho = camin;
        
    }
    
    public void Valida(){
        String nome, abrev, senha, cidade, fundador;
        boolean sen, valid = true;
        nome = tfnome.getText(); abrev = tfabreviacao.getText(); senha = tfsenha.getText(); cidade = tfcidade.getText(); fundador = tffundador.getText();
        sen = tbprivado.isSelected();
        
        
        if(nome.equals("") || abrev.equals("") || cidade.equals("") || fundador.equals("")){
            Alert erro = new Alert(Alert.AlertType.ERROR);
            erro.setHeaderText("As informações estão incorretas!!!");
            erro.show();
            valid = false;
        }
        
        if(sen == true && senha.equals("")){
            Alert erro = new Alert(Alert.AlertType.ERROR);
            erro.setHeaderText("Digite uma senha!!!");
            erro.show();
            valid = false;
        }
        
        if(valid == true){
            Cria();
        }
    }
    
    public void Cria(){
        String nome, abrev, senha, cidade, fundador;
        boolean sen;
        nome = tfnome.getText(); abrev = tfabreviacao.getText(); senha = tfsenha.getText(); cidade = tfcidade.getText(); fundador = tffundador.getText();
        sen = tbprivado.isSelected();
        Time time = new Time();
        time.setAbreviacao(abrev);
        if(caminho != null){
        time.setEmblema(gerencia.uploadUrlEmblema(caminho, tfnome.getText()));
        }else{
            time.setEmblema("exemple.png");
        }
        time.setEstado(cidade);
        time.setFundador(fundador);
        time.setNome(nome);
        time.setSen(sen);
        time.setSenha(senha);
        TimeDAO dao = new TimeDAO();
        dao.addTime(time);
        obslistatime = dao.selectTimeespeciNome(nome);
        int id_time = 0;
        for(int i = 0; i <obslistatime.size(); i++){
            id_time = obslistatime.get(i).getId_time();
        }
        UsuarioDAO dao2 = new UsuarioDAO();
        dao2.Addtime(id_time, usu.getId_usuario());
        criauniformeabre c1 = new criauniformeabre(nome);
        criauniformeabre c2 = new criauniformeabre(usu);
        crietimeabre t1 = new crietimeabre(usu);
        t1.fecharTela(); c1.abreTela();
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        if(tbprivado.isSelected() == true){
            tfsenha.setEditable(true);
        }else{
            tfsenha.setEditable(false);
        }
        
        tfabreviacao.setStyle("-fx-text-fill: white");
        tfcidade.setStyle("-fx-text-fill: white");
        tffundador.setStyle("-fx-text-fill: white");
        tfnome.setStyle("-fx-text-fill: white");
        tfsenha.setStyle("-fx-text-fill: white");
        btcancelar.setOnMouseClicked(value->{
            crietimeabre c1 = new crietimeabre(usu);
            escolhetimeabre e1 = new escolhetimeabre(usu);
            c1.fecharTela(); e1.abreTela();
        });
        
        btproximo.setOnMouseClicked(value->{
            Valida();
        });
        
        btemblema.setOnMouseClicked(value->{
            Foto();
        });
        
    }    
    
}
