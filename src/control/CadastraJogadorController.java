
package control;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.JDBC.JogadorDAO;
import model.Jogador;
import model.gerenciaImagem;
import view.manage.cadastrajogadorabre;


public class CadastraJogadorController implements Initializable {

    @FXML private Button btadicionarcard, btcancelar, btcadastrar;
    @FXML private ImageView ivfundo, ivcard;
    @FXML private TextField tfoverall, tfnome, tfposicao, tfvalor;
    String camin;
    gerenciaImagem gerencia = new gerenciaImagem();   
    
    public void Valida(){
        String nome = tfnome.getText(), posicao = tfposicao.getText(), foto = camin;
        int overall = Integer.valueOf(tfoverall.getText());
        double valor = Double.valueOf(tfvalor.getText());
        
        if(nome.equals("") || posicao.equals("") || foto.equals("") || overall == 0 || valor == 0){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro: XxxFiFaxxX");
            alerta.setHeaderText("Erro: Preencha todos os campos e coloque uma foto");
            alerta.show();
        }
        else{
            JogadorDAO dao = new JogadorDAO();
            Jogador jogador = new Jogador();
            jogador.setNome(nome);
            jogador.setOveral(overall);
            jogador.setPosicao(posicao);
            jogador.setValor(valor);
            jogador.setFoto(gerencia.uploadUrl(foto, tfnome.getText()));
            dao.addJogador(jogador);
            Alert concluido = new Alert(Alert.AlertType.INFORMATION);
            concluido.setHeaderText("Cadastro concluido!!!");
            concluido.show();
            Limpa();
            
        }
        
    }
    
    public void Foto(){
        
            String caminho = gerencia.getNovaImagem();            
            Image image = new Image("file:///" + caminho);
            ivcard.setImage(image);            
            camin = caminho;
            
            
    }
    
    
         
     
    
    public void Limpa(){
        tfnome.clear();
        tfoverall.clear();
        tfposicao.clear();
        tfvalor.clear();
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        btcancelar.setOnMouseClicked(value->{
            cadastrajogadorabre c1 = new cadastrajogadorabre();
            c1.fecharTela();
        });
        
        btcadastrar.setOnMouseClicked(value->{
            Valida();            
        });
        
        btadicionarcard.setOnMouseClicked(value->{
            Foto();
        });
    }    
    
}
