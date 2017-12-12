package control;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Criptografia;
import model.JDBC.TimeDAO;
import model.JDBC.UsuarioDAO;
import model.Jogador;
import model.Time;
import model.Usuario;
import view.manage.escolhetimeabre;
import view.manage.montacardabre;
import view.manage.realprincipalabre;
import view.manage.tabeladetimesabre;

public class TabeladetimesController implements Initializable {

    @FXML private TableColumn<Time, Boolean> tcsenha;
    @FXML private TextField tfsenha;
    @FXML private TableColumn<Time, String> tctime;
    @FXML private ImageView ivtime, ivvoltar;
    @FXML private TableView<Time> tvtabela;
    @FXML private JFXButton btentrar;
    private Time selecionado;
    private ObservableList<Time> obslista;
    private static Usuario usu;

    public static Usuario getUsu() {
        return usu;
    }

    public static void setUsu(Usuario usu) {
        TabeladetimesController.usu = usu;
    }
    
    
    public void IniciaTabela(){
        tctime.setCellValueFactory(new PropertyValueFactory("nome"));
        tcsenha.setCellValueFactory(new PropertyValueFactory("sen"));
        TimeDAO dao = new TimeDAO();
        obslista = dao.selectTime();
        tvtabela.setItems(obslista);
    }
    
    public void MostraDetalhes(){
        if(selecionado != null){
            Image image = new Image("/imagens/emblemas/" + selecionado.getEmblema());
            ivtime.setImage(image);
            if(selecionado.isSen()){
                tfsenha.setEditable(true);
                tfsenha.setOpacity(1);
            }else{
                tfsenha.setEditable(false);
                tfsenha.setOpacity(0);
            }
        }else{
            
        }
    }
    
    public void Entar(){
        if(selecionado.isSen() != false){
            if(Criptografia.Criptografando(tfsenha.getText()).equals(selecionado.getSenha())){
                UsuarioDAO dao = new UsuarioDAO();
                dao.Addtime(selecionado.getId_time(), usu.getId_usuario());
                montacardabre r1 = new montacardabre(usu);
                tabeladetimesabre t1 = new tabeladetimesabre(usu);
                t1.fecharTela();
                r1.abreTela();
            }else{
                Alert erro = new Alert(Alert.AlertType.ERROR);
                erro.setHeaderText("Senha incorreta");
                erro.show();
            }
        }else{
                UsuarioDAO dao = new UsuarioDAO();
                dao.Addtime(selecionado.getId_time(), usu.getId_usuario());
                montacardabre r1 = new montacardabre(usu);
                tabeladetimesabre t1 = new tabeladetimesabre(usu);
                t1.fecharTela();
                r1.abreTela();
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        IniciaTabela();
        ivvoltar.setOnMouseClicked(value->{
            tabeladetimesabre t1 = new tabeladetimesabre(usu);
            escolhetimeabre e1 = new escolhetimeabre(usu);
            t1.fecharTela(); e1.abreTela();
        });
        
        tvtabela.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {               
                selecionado = (Time)newValue;
                MostraDetalhes();
            }
        });
        
        btentrar.setOnMouseClicked(value->{
            Entar();
        });
    }    
    
}
