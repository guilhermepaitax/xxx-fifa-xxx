package control;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;
import model.JDBC.LigaDAO;
import model.JDBC.Participante2DAO;
import model.JDBC.UsuarioDAO;
import model.Liga;
import model.Participante2;
import model.Usuario;
import view.manage.continuarligaabre;
import view.manage.graficoabre;
import view.manage.partidaligaabre;
import view.manage.principalabre;

public class ContinuarLigaController implements Initializable {
    
    @FXML private Label lbnome, lbliga;
    @FXML private JFXButton btartilharia, btjogos;
    @FXML private ImageView ivtime, ivvoltar;
    @FXML private Pane pane;
    
    @FXML private TableColumn<Participante2, Integer> tcpontos;
    @FXML private TableColumn<Participante2, String> tctime;
    @FXML private TableColumn<Participante2, Integer> tcgols;
    @FXML private TableColumn<Participante2, Integer> tcderrotas;    
    @FXML private TableColumn<Participante2, Integer> tcpartidas;
    @FXML private TableColumn<Participante2, Integer> tcvitorias;
    @FXML private TableColumn<Participante2, Integer> tcempates;
    private static Usuario usu;
    private static Usuario usunovo;
    @FXML private TableView<Participante2> tvtabela;
    private ObservableList<Participante2> obslista;
    private ObservableList<Liga> obslistaliga;
    private ObservableList<Usuario> obslistausu;
    private Participante2 selecionado;
    int liga = 0;
    public void inicia(){
        tcderrotas.setCellValueFactory(new PropertyValueFactory("derrotas"));
        tcempates.setCellValueFactory(new PropertyValueFactory("empates"));
        tcgols.setCellValueFactory(new PropertyValueFactory("gols"));
        tcpartidas.setCellValueFactory(new PropertyValueFactory("partidas"));
        tcpontos.setCellValueFactory(new PropertyValueFactory("pontos"));
        tctime.setCellValueFactory(new PropertyValueFactory("time"));
        tcvitorias.setCellValueFactory(new PropertyValueFactory("vitorias"));
        Participante2DAO dao = new Participante2DAO();
        obslista = dao.selectPart(usunovo.getId_liga());
        tvtabela.setItems(obslista);
    }
    
    public void IniciaLiga(){
        LigaDAO c1 = new LigaDAO();
        obslistaliga = c1.selectLigaId(usunovo.getId_copa());
        for (int i = 0; i < obslistaliga.size(); i++) {
        lbnome.setText(obslistaliga.get(i).getNome());
        liga = obslistaliga.get(i).getId_liga();
        
    }
  }
       
    public void UsuNovo(){
        UsuarioDAO udao = new UsuarioDAO();
        obslistausu = udao.selectUsuario();
        for(int i = 0; i < obslistausu.size(); i++){
            if(usu.getId_usuario() == obslistausu.get(i).getId_usuario()){
                String nome, senha, foto, time, tema, fotocard, nomecard;
                double dinheiro;
                int id_usuario, id_copa, id_liga, id_time, velocidade, passe, defesa, chute, drible, fisico;
                boolean modoreal,adm;
                
                nome = obslistausu.get(i).getNome();
                senha = obslistausu.get(i).getSenha();
                foto = obslistausu.get(i).getFoto();
                time = obslistausu.get(i).getTime();
                dinheiro = obslistausu.get(i).getDinheiro();
                id_usuario = obslistausu.get(i).getId_usuario();
                id_copa = obslistausu.get(i).getId_copa();
                id_liga = obslistausu.get(i).getId_liga();
                id_time = obslistausu.get(i).getId_time();
                modoreal = obslistausu.get(i).isModoreal();
                adm = obslistausu.get(i).isAdm();
                tema = obslistausu.get(i).getTema();
                nomecard = obslistausu.get(i).getNomecard();
                fotocard = obslistausu.get(i).getFotocard();
                velocidade = obslistausu.get(i).getVelocidade();
                chute = obslistausu.get(i).getChute();
                passe = obslistausu.get(i).getPasse();
                fisico = obslistausu.get(i).getFisico();
                defesa = obslistausu.get(i).getDefesa();
                drible = obslistausu.get(i).getDrible();
                Usuario novo = new Usuario(nome, senha, foto, time, dinheiro, id_usuario, id_copa, id_liga, id_time, modoreal, adm, tema, nomecard, fotocard, defesa, velocidade, drible, chute, passe, fisico);                
                usunovo = novo;
            }
        }
    }
    
    public void Finaliza(){
        continuarligaabre c1 = new continuarligaabre(usunovo);
        graficoabre g1 = new graficoabre(usunovo);
        c1.fecharTela();g1.abreTela();
    }
    
    public static Usuario getUsu() {
        return usu;
    }

    public static void setUsu(Usuario usu) {
        ContinuarLigaController.usu = usu;
    }
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UsuNovo();
        inicia();
        IniciaLiga();
        ivvoltar.setOnMouseClicked(value->{
            continuarligaabre c1 = new continuarligaabre(usunovo);
            principalabre p1 = new principalabre(usunovo);
            c1.fecharTela(); p1.abreTela();
        });
        
        btjogos.setOnMouseClicked(value->{
            if(usunovo.isAdm() == true){
                continuarligaabre c1 = new continuarligaabre(usunovo);
                partidaligaabre p1 = new partidaligaabre(usunovo);
                c1.fecharTela(); p1.abreTela();
            }else{
                Alert erro = new Alert(Alert.AlertType.ERROR);
                erro.setHeaderText("Você não tem permissão para adicionar jogos!");
            }
        });
        
        btartilharia.setOnMouseClicked(value->{
            if(usunovo.isAdm() == true){
                Finaliza();
            }else{
                Alert erro = new Alert(Alert.AlertType.ERROR);
                erro.setHeaderText("Você não tem permissão para adicionar jogos!");
            }
        
        });
    }    
    
}
