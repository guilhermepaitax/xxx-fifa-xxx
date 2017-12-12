
package control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.JDBC.JogadorDAO;
import model.Jogador;
import model.Usuario;
import view.manage.ajusteabre;
import view.manage.principalabre;


public class AjustetimeController implements Initializable {

    @FXML private TableView<Jogador> tvtabela;
    @FXML private TableColumn<Jogador, String> tcjogador;
    @FXML private TableColumn<Jogador, String> tcposicao;
    //////////////////////////////////////////////////////
    @FXML private ImageView ivfoto, ivlogo, ivcampo, ivjog1, ivjog2, ivjog3, ivjog4, ivjog5, ivjog6, ivjog7, ivjog8, ivjog9, ivjog10, ivjog11;    
    @FXML private TextField tfoveral, tfposicao, tfnome;
    @FXML private Label lboveral, lbposicao, lbnome;
    private static Usuario usu;
    private Jogador selecionado;    
    private ObservableList<Jogador> obslista;
    boolean i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11;
    String f1 = null,f2 = null,f3 = null,f4 = null,f5 = null,f6 = null,f7 = null,f8 = null,f9 = null,f10 = null,f11 = null;
    
    public static Usuario getUsu() {
        return usu;
    }

    public static void setUsu(Usuario usu) {
        AjustetimeController.usu = usu;
    }
    
    
    
    public void IniciaTabela(){
        tcjogador.setCellValueFactory(new PropertyValueFactory("nome"));
        tcposicao.setCellValueFactory(new PropertyValueFactory("posicao"));
        JogadorDAO dao = new JogadorDAO();
        obslista = dao.selectJogadorusuario(usu.getId_usuario());
        tvtabela.setItems(obslista);
    }
    
    public void MostraDetalhes(){
        if(selecionado != null){
            tfnome.setText(selecionado.getNome());
            tfoveral.setText(String.valueOf(selecionado.getOveral()));
            tfposicao.setText(selecionado.getPosicao());
            Image image = new Image("/imagens/jogadores/" + selecionado.getFoto());
            ivfoto.setImage(image);
        }else{
            tfnome.setText("");
            tfoveral.setText("");
            tfposicao.setText("");
        }
    }
    
    public boolean Verifica(){
        if(selecionado.getFoto() != f1 && selecionado.getFoto() != f2 && selecionado.getFoto() != f3 && selecionado.getFoto() != f4 && selecionado.getFoto() != f5 && selecionado.getFoto() != f6 && selecionado.getFoto() != f7 && selecionado.getFoto() != f8 && selecionado.getFoto() != f9 && selecionado.getFoto() != f10 && selecionado.getFoto() != f11){
            return true;
        }else{
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setHeaderText("Selecione um jogador disponivel!!!");
            a.show();
            return false;
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        IniciaTabela();
        
        tvtabela.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {               
                selecionado = (Jogador)newValue;
                MostraDetalhes();
            }
        });
        
        ivlogo.setOnMouseClicked(value->{
            principalabre p1 = new principalabre(usu);
            ajusteabre a1 = new ajusteabre(usu);
            a1.fecharTela(); p1.abreTela();
        });
       
        ivjog1.setOnMouseEntered(value->{
            ivjog1.setFitHeight(165); ivjog1.setFitWidth(215);
        });   
        ivjog1.setOnMouseExited(value->{
            ivjog1.setFitHeight(150); ivjog1.setFitWidth(200);           
        });
        
         ivjog2.setOnMouseEntered(value->{
            ivjog2.setFitHeight(165); ivjog2.setFitWidth(215);
        });   
        ivjog2.setOnMouseExited(value->{
            ivjog2.setFitHeight(150); ivjog2.setFitWidth(200);           
        });
       
         ivjog3.setOnMouseEntered(value->{
            ivjog3.setFitHeight(165); ivjog3.setFitWidth(215);
        });   
        ivjog3.setOnMouseExited(value->{
            ivjog3.setFitHeight(150); ivjog3.setFitWidth(200);           
        });
        
         ivjog4.setOnMouseEntered(value->{
            ivjog4.setFitHeight(165); ivjog4.setFitWidth(215);
        });   
        ivjog4.setOnMouseExited(value->{
            ivjog4.setFitHeight(150); ivjog4.setFitWidth(200);           
        });
        
         ivjog5.setOnMouseEntered(value->{
            ivjog5.setFitHeight(165); ivjog5.setFitWidth(215);
        });   
        ivjog5.setOnMouseExited(value->{
            ivjog5.setFitHeight(150); ivjog5.setFitWidth(200);           
        });
        
         ivjog6.setOnMouseEntered(value->{
            ivjog6.setFitHeight(165); ivjog6.setFitWidth(215);
        });   
        ivjog6.setOnMouseExited(value->{
            ivjog6.setFitHeight(150); ivjog6.setFitWidth(200);           
        });
        
         ivjog7.setOnMouseEntered(value->{
            ivjog7.setFitHeight(165); ivjog7.setFitWidth(215);
        });   
        ivjog7.setOnMouseExited(value->{
            ivjog7.setFitHeight(150); ivjog7.setFitWidth(200);           
        });
        
         ivjog8.setOnMouseEntered(value->{
            ivjog8.setFitHeight(165); ivjog8.setFitWidth(215);
        });   
        ivjog8.setOnMouseExited(value->{
            ivjog8.setFitHeight(150); ivjog8.setFitWidth(200);           
        });
        
         ivjog9.setOnMouseEntered(value->{
            ivjog9.setFitHeight(165); ivjog9.setFitWidth(215);
        });   
        ivjog9.setOnMouseExited(value->{
            ivjog9.setFitHeight(150); ivjog9.setFitWidth(200);           
        });
        
         ivjog10.setOnMouseEntered(value->{
            ivjog10.setFitHeight(165); ivjog10.setFitWidth(215);
        });   
        ivjog10.setOnMouseExited(value->{
            ivjog10.setFitHeight(150); ivjog10.setFitWidth(200);           
        });
        
         ivjog11.setOnMouseEntered(value->{
            ivjog11.setFitHeight(165); ivjog11.setFitWidth(215);
        });   
        ivjog11.setOnMouseExited(value->{
            ivjog11.setFitHeight(150); ivjog11.setFitWidth(200);           
        });
        
        ivjog1.setOnMouseClicked(value->{
            if(selecionado != null){
                boolean resp = Verifica();
                if(resp){
                Image image = new Image("/imagens/jogadores/" + selecionado.getFoto());
                ivjog1.setImage(image);
                f1 = selecionado.getFoto();
                }
            }else{
                 Alert a = new Alert(Alert.AlertType.WARNING);
                 a.setHeaderText("Selecione um jogador!!!");
                 a.show();
            }
        });
        ivjog2.setOnMouseClicked(value->{
            if(selecionado != null){
                boolean resp = Verifica();
                if(resp){
                Image image = new Image("/imagens/jogadores/" + selecionado.getFoto());
                ivjog2.setImage(image);
                f2 = selecionado.getFoto();
                }
            }else{
                Alert a = new Alert(Alert.AlertType.WARNING);
                 a.setHeaderText("Selecione um jogador!!!");
                 a.show();
            }
        });
        ivjog3.setOnMouseClicked(value->{
            if(selecionado != null){
                boolean resp = Verifica();
                if(resp){
                Image image = new Image("/imagens/jogadores/" + selecionado.getFoto());
                ivjog3.setImage(image);
                f3 = selecionado.getFoto();
                }
            }else{
                Alert a = new Alert(Alert.AlertType.WARNING);
                 a.setHeaderText("Selecione um jogador!!!");
                 a.show();
            }
        });
        ivjog4.setOnMouseClicked(value->{
            if(selecionado != null){
                boolean resp = Verifica();
                if(resp){
                Image image = new Image("/imagens/jogadores/" + selecionado.getFoto());
                ivjog4.setImage(image);
                f4 = selecionado.getFoto();
                }
            }else{
                Alert a = new Alert(Alert.AlertType.WARNING);
                 a.setHeaderText("Selecione um jogador!!!");
                 a.show();
            }
        });
        ivjog5.setOnMouseClicked(value->{
            if(selecionado != null){
                boolean resp = Verifica();
                if(resp){
                Image image = new Image("/imagens/jogadores/" + selecionado.getFoto());
                ivjog5.setImage(image);
                f5 = selecionado.getFoto();
                }
            }else{
                Alert a = new Alert(Alert.AlertType.WARNING);
                 a.setHeaderText("Selecione um jogador!!!");
                 a.show();
            }
        });
        ivjog6.setOnMouseClicked(value->{
            if(selecionado != null){
                boolean resp = Verifica();
                if(resp){
                Image image = new Image("/imagens/jogadores/" + selecionado.getFoto());
                ivjog6.setImage(image);
                f6 = selecionado.getFoto();
                }
            }else{
                Alert a = new Alert(Alert.AlertType.WARNING);
                 a.setHeaderText("Selecione um jogador!!!");
                 a.show();
            }
        });
        ivjog7.setOnMouseClicked(value->{
            if(selecionado != null){
                boolean resp = Verifica();
                if(resp){
                Image image = new Image("/imagens/jogadores/" + selecionado.getFoto());
                ivjog7.setImage(image);
                f7 = selecionado.getFoto();
                }
            }else{
                Alert a = new Alert(Alert.AlertType.WARNING);
                 a.setHeaderText("Selecione um jogador!!!");
                 a.show();
            }
        });
        ivjog8.setOnMouseClicked(value->{
            if(selecionado != null){
                boolean resp = Verifica();
                if(resp){
                Image image = new Image("/imagens/jogadores/" + selecionado.getFoto());
                ivjog8.setImage(image);
                f8 = selecionado.getFoto();
                }
            }else{
                Alert a = new Alert(Alert.AlertType.WARNING);
                 a.setHeaderText("Selecione um jogador!!!");
                 a.show();
            }
        });
        ivjog9.setOnMouseClicked(value->{
            if(selecionado != null){
                boolean resp = Verifica();
                if(resp){
                Image image = new Image("/imagens/jogadores/" + selecionado.getFoto());
                ivjog9.setImage(image);
                f9 = selecionado.getFoto();
                }
            }else{
                Alert a = new Alert(Alert.AlertType.WARNING);
                 a.setHeaderText("Selecione um jogador!!!");
                 a.show();
            }
        });
        ivjog10.setOnMouseClicked(value->{
            if(selecionado != null){
                boolean resp = Verifica();
                if(resp){
                Image image = new Image("/imagens/jogadores/" + selecionado.getFoto());
                ivjog10.setImage(image);
                f10 = selecionado.getFoto();
                }
            }else{
                Alert a = new Alert(Alert.AlertType.WARNING);
                 a.setHeaderText("Selecione um jogador!!!");
                 a.show();
            }
        });
        ivjog11.setOnMouseClicked(value->{
            if(selecionado != null){
                boolean resp = Verifica();
                if(resp){
                Image image = new Image("/imagens/jogadores/" + selecionado.getFoto());
                ivjog11.setImage(image);
                f11 = selecionado.getFoto();
                }
            }else{
                Alert a = new Alert(Alert.AlertType.WARNING);
                 a.setHeaderText("Selecione um jogador!!!");
                 a.show();
            }
        });
        
    }    
    
}
