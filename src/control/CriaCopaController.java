package control;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ToggleGroup;
import model.Copa;
import model.JDBC.CopaDAO;
import model.Usuario;
import view.manage.copaabre;
import view.manage.criarcopaabre;
import view.manage.criarcopaabre2;

public class CriaCopaController implements Initializable {
    
    @FXML private JFXButton btcancelar, btproximo;
    @FXML private JFXTextField tfvitoria, tfnome, tfpremio;
    @FXML private JFXRadioButton rb16, rb8, rb4, rb2;
    private static Usuario usu;
    ToggleGroup grupo = new ToggleGroup();
    
    public static Usuario getUsu() {
        return usu;
    }

    public static void setUsu(Usuario usu) {
        CriaCopaController.usu = usu;
    }
    
    public void Valida(){
        double premio;
        double valor;
        boolean val = false;
        try{
            premio = Double.valueOf(tfpremio.getText());
            valor = Double.valueOf(tfvitoria.getText());
            val = true;
        }catch(Exception e){
            Alert erro = new Alert(Alert.AlertType.ERROR);
            erro.setHeaderText("Preencha de forma correta os valores!");
            erro.show();
            val = false;
        }        
        String nome = tfnome.getText();
        if( rb2.isSelected() == false && rb16.isSelected() == false && rb4.isSelected() == false && rb8.isSelected() == false || nome.equals("")){
            Alert erro = new Alert(Alert.AlertType.ERROR);
            erro.setHeaderText("Errro na criação da copa!");
            erro.show();
            val = false;
        }
        if(val == true){
            Cadastra();
        }
    }
    
    public void Cadastra(){
        double premio = Double.valueOf(tfpremio.getText());
        double valor = Double.valueOf(tfvitoria.getText());
        String nome = tfnome.getText();
        int quantidade = 2;
        if(rb2.isSelected()){
            quantidade = 2;
        }
        if(rb4.isSelected()){
            quantidade = 4;
        }
        if(rb8.isSelected()){
            quantidade = 8;
        }
        if(rb16.isSelected()){
            quantidade = 16;
        }
        
        Copa copa = new Copa();
        copa.setNome(nome);
        copa.setPremio(premio);
        copa.setQuantidade(quantidade);
        copa.setValorpartida(valor);
        CopaDAO dao = new CopaDAO();
        dao.addCopa(copa);
        
        criarcopaabre c1 = new criarcopaabre(usu);
        criarcopaabre2 c2 = new criarcopaabre2(usu);
        criarcopaabre2 c3 = new criarcopaabre2(nome);
        c1.fecharTela(); c2.abreTela();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rb8.setDisable(true);
        rb16.setDisable(true);
        rb2.setToggleGroup(grupo);
        rb4.setToggleGroup(grupo);
        rb8.setToggleGroup(grupo);
        rb16.setToggleGroup(grupo);
        
        btproximo.setOnMouseClicked(value->{
            Valida();
        });
        
        tfnome.setStyle("-fx-text-fill: white");
        tfpremio.setStyle("-fx-text-fill: white");
        tfvitoria.setStyle("-fx-text-fill: white");
        
        btcancelar.setOnMouseClicked(value->{
            criarcopaabre c1 = new criarcopaabre(usu);
            copaabre c2 = new copaabre(usu);
            c1.fecharTela(); c2.abreTela();
        });
        
    }    
    
   
    
}
