
package control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.JDBC.JogadorDAO;
import model.JDBC.TransferenciasDAO;
import model.JDBC.UsuarioDAO;
import model.Jogador;
import model.Transferencias;
import model.Usuario;
import view.manage.adcabre;
import view.manage.mercadoabre;
import view.manage.transferenciasabre;


public class TransferenciasController implements Initializable {

    
    @FXML private Button btcomprar, btpesquisa, btremover, btadicionar;   
    @FXML private ImageView ivfundo, ivlogo, ivfoto;
    @FXML private TextField tfnome, tfposicao, tfpesquisa, tfvalor;
    @FXML private TableColumn<Transferencias, String> tcjogador;
    @FXML private TableView<Transferencias> tvtabela;
    @FXML private TableColumn<Transferencias, Double> tcvalor;
    private static Usuario usu;
    private ObservableList<Transferencias> obslista;
    private Transferencias selecionado;
    private ObservableList<Usuario> obslistausu;
    
    public static Usuario getUsu() {
        return usu;
    }

    public static void setUsu(Usuario usu) {
        TransferenciasController.usu = usu;
    }
    
    public void Compra(){
        if(selecionado != null){
        UsuarioDAO dao = new UsuarioDAO();
        JogadorDAO dao2 = new JogadorDAO();
        TransferenciasDAO dao3 = new TransferenciasDAO();
        if(usu.getDinheiro() >= selecionado.getValor() && selecionado.getId_usuario() != usu.getId_usuario()){
            double retorno = 0;
            obslistausu = dao.selectUsuario();
            for (int i = 0; i < obslistausu.size(); i++) {
                if(obslistausu.get(i).getId_usuario() == selecionado.getId_usuario()){
                    retorno = obslistausu.get(i).getDinheiro() + selecionado.getValor();
                    i = obslista.size();
                }
            }
            usu.setDinheiro(usu.getDinheiro() - selecionado.getValor());
            dao.Adddinheiro(selecionado.getId_usuario(), retorno);
            dao.Adddinheiro(usu.getId_usuario(), usu.getDinheiro());
            dao2.Addusuario(usu.getId_usuario(), selecionado.getId_jogador());
            dao3.delete(selecionado);
             Alert erro = new Alert(Alert.AlertType.CONFIRMATION);
            erro.setHeaderText("Jogador comprado com sucesso!!!");
            erro.show();
            Atualiza();
        }else{
            Alert erro = new Alert(Alert.AlertType.WARNING);
            erro.setHeaderText("Voce não pode comprar este jogador!!!");
            erro.show(); 
        }
        }else{
            Alert erro = new Alert(Alert.AlertType.WARNING);
            erro.setHeaderText("Selecione um jogador!!!");
            erro.show(); 
        }
    }
    
    public void IniciaTabela(){
        tcjogador.setCellValueFactory(new PropertyValueFactory("nome"));
        tcvalor.setCellValueFactory(new PropertyValueFactory("valor"));
        TransferenciasDAO dao = new TransferenciasDAO();
        obslista = dao.selectJogadores();
        tvtabela.setItems(obslista);
    }
    
    public void MostraDetalhes(){
        if(selecionado != null){
            tfnome.setText(selecionado.getNome());
            tfvalor.setText(String.valueOf(selecionado.getValor()));
            tfposicao.setText(selecionado.getPosicao());
            Image image = new Image("/imagens/jogadores/" + selecionado.getNome()+".png");
            ivfoto.setImage(image);
        }else{
            tfnome.setText(""); 
            tfvalor.setText("");
            tfposicao.setText("");
        }
    }
    
    private ObservableList<Transferencias> busca(){
        ObservableList<Transferencias> jogadorbusca = FXCollections.observableArrayList();
        for(int x = 0; x < obslista.size(); x++){
        if(obslista.get(x).getNome().toLowerCase().contains(tfpesquisa.getText().toLowerCase())){
            jogadorbusca.add(obslista.get(x));
        }
            }
        return jogadorbusca;
    }
    
    public void remover(){
        if(selecionado != null){
            if(selecionado.getId_usuario() == usu.getId_usuario()){
                TransferenciasDAO dao3 = new TransferenciasDAO();
                dao3.delete(selecionado);
                Alert erro = new Alert(Alert.AlertType.CONFIRMATION);
                erro.setHeaderText("Jogador removido com sucesso!!!");
                erro.show(); 
                Atualiza();
            }else{
                Alert erro = new Alert(Alert.AlertType.WARNING);
                erro.setHeaderText("Você não pode remover este jogador!!!");
                erro.show(); 
            }
        }else{
            Alert erro = new Alert(Alert.AlertType.WARNING);
            erro.setHeaderText("Selecione um jogador!!!");
            erro.show(); 
        }
    }
    
    public void Atualiza(){
        TransferenciasDAO dao = new TransferenciasDAO();
        obslista = dao.selectJogadores();
        tvtabela.setItems(obslista);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        IniciaTabela();
        
        ivlogo.setOnMouseClicked(value->{
            mercadoabre m1 = new mercadoabre(usu);
            transferenciasabre t1 = new transferenciasabre(usu);
            t1.fecharTela(); m1.abreTela();
        });
        DoubleProperty width = ivfundo.fitWidthProperty();
        DoubleProperty height = ivfundo.fitHeightProperty();
        width.bind(Bindings.selectDouble(ivfundo.sceneProperty(), "width"));
        height.bind(Bindings.selectDouble(ivfundo.sceneProperty(), "height"));
     
        btadicionar.setOnMouseReleased(value->{
            adcabre a1 = new adcabre(usu);
            transferenciasabre t1 = new transferenciasabre(usu);
            t1.fecharTela(); a1.abreTela();
        });
        
        tvtabela.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {               
                selecionado = (Transferencias)newValue;
                MostraDetalhes();
            }
        });
        
        btpesquisa.setOnMouseClicked(value->{
            tvtabela.setItems(busca());
        });
        
        tfpesquisa.setOnKeyReleased(value->{
            tvtabela.setItems(busca());
        });
        
        btcomprar.setOnMouseClicked(value->{
            Compra();
        });
        btremover.setOnMouseClicked(value->{
            remover();
        });
    }    
    
}
