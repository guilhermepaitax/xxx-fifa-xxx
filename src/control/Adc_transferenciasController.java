package control;

import com.jfoenix.controls.JFXButton;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.JDBC.JogadorDAO;
import model.JDBC.TransferenciasDAO;
import model.Jogador;
import model.Transferencias;
import model.Usuario;
import view.manage.adcabre;
import view.manage.transferenciasabre;

public class Adc_transferenciasController implements Initializable {

    @FXML
    private JFXButton btadd;
    @FXML
    private JFXButton btcancelar;
    @FXML
    private TableColumn<Jogador, String> tcjogador;
    @FXML
    private TableView<Jogador> tvtabela;
    @FXML
    private TableColumn<Jogador, Double> tcvalor;
    @FXML
    private ImageView ivfoto;
    @FXML
    private TextField tfvalor;
    private ObservableList<Jogador> obslista;
    private ObservableList<Transferencias> obslistatransf;
    private static Usuario usu;
    private Jogador selecionado;

    public static Usuario getUsu() {
        return usu;
    }

    public static void setUsu(Usuario usu) {
        Adc_transferenciasController.usu = usu;
    }

    public void MostraDetalhes() {
        if (selecionado != null) {
            tfvalor.setText(String.valueOf(selecionado.getValor()));
            Image image = new Image("/imagens/jogadores/" + selecionado.getFoto());
            ivfoto.setImage(image);
        } else {
            tfvalor.setText("");
        }
    }
    
    public boolean Valida(){
        TransferenciasDAO dao = new TransferenciasDAO();
            obslistatransf = dao.selectJogadores();
                for(int y = 0; y < obslistatransf.size(); y++){
                if (selecionado.getId_jogador() == obslistatransf.get(y).getId_jogador()) {
                    return false;
                }
            }
                return true;
    }

    public void Inicia() {
        tcvalor.setCellValueFactory(new PropertyValueFactory("valor"));
        tcjogador.setCellValueFactory(new PropertyValueFactory("nome"));
        JogadorDAO dao = new JogadorDAO();
        obslista = dao.selectJogadorusuario(usu.getId_usuario());
        tvtabela.setItems(obslista);
    }

    public void Adiciona() {
        if (selecionado != null) {

            Transferencias t1 = new Transferencias();
            TransferenciasDAO dao = new TransferenciasDAO();
            boolean val = Valida();
                if (val == true) {
                    t1.setId_jogador(selecionado.getId_jogador());
                    t1.setNome(selecionado.getNome());
                    t1.setValor(Double.valueOf(tfvalor.getText()));
                    t1.setId_usuario(usu.getId_usuario());
                    t1.setPosicao(selecionado.getPosicao());
                    dao.addJogador(t1);
                    Alert ad = new Alert(Alert.AlertType.WARNING);
                    ad.setHeaderText("Jogador adicionado com sucesso!!!");         
                    Cancelar();
                    ad.show();                
              }else{
                    Alert as = new Alert(Alert.AlertType.ERROR);
                    as.setHeaderText("Você não pode adicionar este jogador novamente!!!");
                    as.show();
                }
            
            

        } else {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setHeaderText("Selecione um jogador!!!");
            a.show();
        }
    }

    public void Cancelar() {
        adcabre a1 = new adcabre(usu);
        transferenciasabre t1 = new transferenciasabre(usu);
        a1.fecharTela();
        t1.abreTela();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Inicia();

        tvtabela.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                selecionado = (Jogador) newValue;
                MostraDetalhes();
            }
        });

        btadd.setOnMouseClicked(value -> {
            Adiciona();
        });

        btcancelar.setOnMouseClicked(value -> {
            Cancelar();
        });

    }

}
