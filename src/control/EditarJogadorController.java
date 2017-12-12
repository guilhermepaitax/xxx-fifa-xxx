package control;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.JDBC.JogadorDAO;
import model.Jogador;
import model.Usuario;
import model.gerenciaImagem;
import view.manage.editarjogadorabre;
import view.manage.jogadoresabre;

public class EditarJogadorController implements Initializable {

    @FXML private Button btadicionarcard, btcancelar, bteditar;
    @FXML private ImageView ivfundo, ivcard;   
    @FXML private TextField tfoverall, tfnome, tfposicao, tfvalor;    
    @FXML private Label lbtitulo;
    private static Jogador j;
    private Jogador alterado;
    String camin;
    gerenciaImagem gerencia = new gerenciaImagem();
    String urlOfPC = "/imagens/jogadores/";
    private static Usuario usu;

    public static Usuario getUsu() {
        return usu;
    }

    public static void setUsu(Usuario usu) {
        EditarJogadorController.usu = usu;
    }
    

    
    public static Jogador getJ() {
        return j;
    }

    public static void setJ(Jogador j) {
        EditarJogadorController.j = j;
    }

    public Jogador getAlterado() {
        return alterado;
    }

    public void setAlterado(Jogador alterado) {
        this.alterado = alterado;
    }
    
    public void IniJogador(){
        tfnome.setText(j.getNome());
        tfoverall.setText(String.valueOf(j.getOveral()));
        tfposicao.setText(j.getPosicao());
        tfvalor.setText(String.valueOf(j.getValor()));
        String caminho = j.getFoto();
        Image image = new Image("/imagens/jogadores/" + caminho);
        ivcard.setImage(image);
        
    }
    
    public void Foto(){
            btadicionarcard.setOnMouseClicked(event -> {
            
            String caminho = gerencia.getNovaImagem();
            
            Image image = new Image("file:///" + caminho);
            ivcard.setImage(image);                
            camin = caminho;
            
    });
    }
    
         
    public void Cancelar(){
        editarjogadorabre e1 = new editarjogadorabre(j);
        jogadoresabre j1 = new jogadoresabre(usu);
        e1.fecharTela(); j1.abreTela();
    }
    
    public void Atualizar(){
        String nome = tfnome.getText(), posicao = tfposicao.getText(), foto = camin;
        int overall = Integer.valueOf(tfoverall.getText());
        double valor = Double.valueOf(tfvalor.getText());
        
        if(nome.equals("") || posicao.equals("") || overall == 0 || valor == 0){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro: XxxFiFaxxX");
            alerta.setHeaderText("Erro: Preencha todos os campos e coloque uma foto");
            alerta.show();
        }
        else{
            JogadorDAO dao = new JogadorDAO();
            Jogador jogador = new Jogador();
            jogador.setNome(nome);
            jogador.setFoto(gerencia.uploadUrl(foto, tfnome.getText()));
            jogador.setOveral(overall);
            jogador.setPosicao(posicao);
            jogador.setValor(valor);
            dao.UpdateJogador(jogador);
            
            alterado = jogador;
            setJ(alterado);
                Cancelar();
                Alert confirma = new Alert(Alert.AlertType.INFORMATION);
            confirma.setHeaderText("Cadastro Atualizado!!!");
            confirma.show();
            
        }
        
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        IniJogador();
        Foto();
        
        btcancelar.setOnMouseClicked(value->{
            Cancelar();
        });
        
        bteditar.setOnMouseClicked(value->{
            Atualizar();
        });
    }    
    
}
