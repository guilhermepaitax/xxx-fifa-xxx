package control;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import model.JDBC.LigaDAO;
import model.Liga;
import model.Usuario;
import view.manage.crialiga2abre;
import view.manage.crialigaabre;
import view.manage.ligaabre;

public class CrialigaController implements Initializable {
    
    @FXML private JFXButton btcancelar;

    @FXML private JFXTextField tfvitoria;

    @FXML private JFXTextField tfnome;

    @FXML private JFXTextField tfpremio;

    @FXML private JFXButton btproximo;
    private static Usuario usu;

    public static Usuario getUsu() {
        return usu;
    }

    public static void setUsu(Usuario usu) {
        CrialigaController.usu = usu;
    }
    
    public void Valida(){
        String nome = tfnome.getText();
        double premio;
        double valor;
        boolean val = true;
        try{
            premio = Double.valueOf(tfpremio.getText());
            valor = Double.valueOf(tfvitoria.getText());       
            if(nome != "" && tfpremio.getText() != "" && tfvitoria.getText() != ""){
            val = true;
        }else{
            Alert erro = new Alert(Alert.AlertType.ERROR);
            erro.setHeaderText("Erro no cadastro, verifique as informações!");
            erro.show();
            val = false;
        }
        }catch(Exception e){
            Alert erro = new Alert(Alert.AlertType.ERROR);
            erro.setHeaderText("Erro no cadastro, verifique as informações!");
            erro.show();
            val = false;
        }
        
        
        if(val == true){
            Cadastra();
        }
    }
    
    public void Cadastra(){
        String nome = tfnome.getText();
        double premio = Double.valueOf(tfpremio.getText());
        double valor = Double.valueOf(tfvitoria.getText());
        Liga liga = new Liga();
        liga.setNome(nome);
        liga.setPremio(premio);
        liga.setValorpartida(valor);
        LigaDAO ldao = new LigaDAO();
        ldao.addLiga(liga);
        
        crialiga2abre c1 = new crialiga2abre(usu);
        crialiga2abre c2 = new crialiga2abre(nome);
        crialigaabre cria = new crialigaabre(usu);
        cria.fecharTela(); c1.abreTela();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btcancelar.setOnMouseClicked(value->{
            crialigaabre c1 = new crialigaabre(usu);
            ligaabre l1 = new ligaabre(usu);
            c1.fecharTela(); l1.abreTela();
        });
        
        btproximo.setOnMouseClicked(value->{
            Valida();
        });
        
        tfnome.setStyle("-fx-text-fill: white");
        tfpremio.setStyle("-fx-text-fill: white");
        tfvitoria.setStyle("-fx-text-fill: white");
    }    
    
}
