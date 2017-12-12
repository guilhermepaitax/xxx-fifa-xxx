package control;

import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaView;
import javax.swing.JOptionPane;
import model.JDBC.PartidaDAO;
import model.JDBC.TimeDAO;
import model.JDBC.UsuarioDAO;
import model.Jogador;
import model.Partida;
import model.Time;
import model.Usuario;
import view.manage.Escolheabre;
import view.manage.XxfifaxX;
import view.manage.criapartidaabre;
import view.manage.perfilrealabre;
import view.manage.principalabre;
import view.manage.realprincipalabre;
import view.manage.telaseutimeabre;

public class RealPrincipalController implements Initializable {

    @FXML private ImageView ivsair, ivmenu, ivpartida, ivfundo, ivperfil, ivfotojogador;
    @FXML private Label lbperfil, lbsair, lbpartida, lbmenu, lbtime, lbnome, lbnometime, lbpxpartida;
    @FXML private JFXButton bttime, btsair, btperfil, btpartida;    
    @FXML private JFXButton bttime2, btsair2, btperfil2, btpartida2, btadd, btremove, btconfitmar;
    @FXML private Pane panemenu;
    @FXML private MediaView mediaview;
    private static Usuario usu;
    private ObservableList<Usuario> obslistausu;
    private ObservableList<Time> obslistatime;
    private static Usuario usunovo;
    
    @FXML private TableColumn<Partida, LocalDate> tcdata;
    @FXML private TableColumn<Partida, String> tctime;
    @FXML private TableColumn<Partida, String> tcadversario;
    @FXML private TableColumn<Partida, String> tclocal;
    @FXML private TableView<Partida> tvtabela;
    private ObservableList<Partida> obslistapart;
    private Partida selecionado;
    public static Usuario getUsu() {
        return usu;
    }

    public static void setUsu(Usuario usu) {
        RealPrincipalController.usu = usu;
    }
    
    public void UsuNovo(){
        UsuarioDAO udao = new UsuarioDAO();
        obslistausu = udao.selectUsuario();
        for(int i = 0; i < obslistausu.size(); i++){
            if(usu.getId_usuario() == obslistausu.get(i).getId_usuario()){
                String nome, senha, foto, time, tema,fotocard, nomecard;
                double dinheiro;
                int id_usuario, id_copa, id_liga, id_time, id_partida, velocidade, passe, defesa, chute, drible, fisico;
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
    
    public void fundo(){
            Image image = new Image("/imagens/wallpaper/" + usunovo.getTema());
            ivfundo.setImage(image);
            TimeDAO tdao = new TimeDAO();
            obslistatime = tdao.selectTimeespeci(usunovo.getId_time());
            for(int i = 0; i <obslistatime.size(); i++){
            lbnometime.setText(obslistatime.get(i).getNome());
            }  
            
      }
    
    public void IniciaTabela(){
        tcadversario.setCellValueFactory(new PropertyValueFactory("time2"));
        tctime.setCellValueFactory(new PropertyValueFactory("time1"));
        tcdata.setCellValueFactory(new PropertyValueFactory("dia"));
        tclocal.setCellValueFactory(new PropertyValueFactory("localizacao"));
        PartidaDAO dao = new PartidaDAO();
        obslistapart = dao.selectPartida();
        tvtabela.setItems(obslistapart);
    }
    
    public void Sair(){                         
                switch (JOptionPane.showConfirmDialog(null, "Deseja realmente sair?")) {
            case 0:                
                realprincipalabre t1 = new realprincipalabre(usunovo);
                t1.fecharTela();
                break;
            case 1:               
                break;
            case 2:               
                break;
                }          
            
    }
    
    public void Presenca(){
        if( selecionado.getId_time1() != usunovo.getId_time() && selecionado.getId_time2() == 0){
            PartidaDAO pdao = new PartidaDAO();
            TimeDAO dao = new TimeDAO();
            String nome = "";
            int id = 0;
            obslistatime = dao.selectTimeespeci(usunovo.getId_time());
            for(int i = 0; i < obslistatime.size(); i++){
                nome = obslistatime.get(i).getNome();
                id = obslistatime.get(i).getId_time();
            }
            pdao.AddTime2(nome, selecionado.getId_partida());
            pdao.AddTime2Id(id, selecionado.getId_partida());
            Atualiza();
        }else{
            
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("Imposssivel confirmar presença nesta partida");
            a.show();
        }
    }
    
    public void Remove(){
        if(selecionado.getId_time1() == usunovo.getId_time()){
            PartidaDAO dao = new PartidaDAO();
            dao.delete(selecionado);
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setHeaderText("Partida removida com sucesso!");
            a.show();
            Atualiza();
        }else{
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("Você não pode remover esta partida!");
            a.show();
        }
    }
    
    public void Atualiza(){
        try {
            PartidaDAO dao = new PartidaDAO();
            obslistapart = dao.selectPartida();
            tvtabela.setItems(obslistapart);
         
        } catch (Exception ee) {
            ee.printStackTrace();
        }     
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UsuNovo();
        fundo();
        IniciaTabela();
        
        tvtabela.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {               
                selecionado = (Partida)newValue;                
            }
        });
        
        panemenu.setOnMouseEntered(value->{
            panemenu.setPrefWidth(282);
            lbmenu.setOpacity(100);
            lbpartida.setOpacity(100);
            lbperfil.setOpacity(100);
            lbsair.setOpacity(100);
            lbtime.setOpacity(100);
            btpartida.setPrefWidth(282);
            btperfil.setPrefWidth(282);
            btsair.setPrefWidth(282);
            bttime.setPrefWidth(282);
            btpartida2.setPrefWidth(282);
            btperfil2.setPrefWidth(282);
            btsair2.setPrefWidth(282);
            bttime2.setPrefWidth(282);
            
        });
        panemenu.setOnMouseExited(value->{            
            lbmenu.setOpacity(0);
            lbpartida.setOpacity(0);
            lbperfil.setOpacity(0);
            lbsair.setOpacity(0);
            lbtime.setOpacity(0);
            btpartida.setPrefWidth(61);
            btperfil.setPrefWidth(61);
            btsair.setPrefWidth(61);
            bttime.setPrefWidth(61);
            panemenu.setPrefWidth(61);
            btpartida2.setPrefWidth(61);
            btperfil2.setPrefWidth(61);
            btsair2.setPrefWidth(61);
            bttime2.setPrefWidth(61);                        
        });
        btpartida.setOnMouseEntered(value->{
            btpartida2.setOpacity(100);});
        btperfil.setOnMouseEntered(value->{
            btperfil2.setOpacity(100);});
        btsair.setOnMouseEntered(value->{
            btsair2.setOpacity(100);});
        bttime.setOnMouseEntered(value->{
            bttime2.setOpacity(100);});
        
        btpartida.setOnMouseExited(value->{
            btpartida2.setOpacity(0);});
        btperfil.setOnMouseExited(value->{
            btperfil2.setOpacity(0);});
        btsair.setOnMouseExited(value->{
            btsair2.setOpacity(0);});
        bttime.setOnMouseExited(value->{
            bttime2.setOpacity(0);});
        
        DoubleProperty width = ivfundo.fitWidthProperty();
        DoubleProperty height = ivfundo.fitHeightProperty();
        width.bind(Bindings.selectDouble(ivfundo.sceneProperty(), "width"));
        height.bind(Bindings.selectDouble(ivfundo.sceneProperty(), "height"));
        
        bttime.setOnMouseClicked(value->{
            telaseutimeabre t1 = new telaseutimeabre(usunovo);
            realprincipalabre r1 = new realprincipalabre(usunovo);
            r1.fecharTela(); t1.abreTela();
        });
        
        btsair.setOnMouseClicked(value->{
            Sair();
        });
        
        btadd.setOnMouseClicked(value->{
            criapartidaabre c1 = new criapartidaabre(usunovo);
            realprincipalabre r1 = new realprincipalabre(usunovo);
            r1.fecharTela(); c1.abreTela();
        });
        
        btconfitmar.setOnMouseClicked(value->{
            Presenca();
        });
        
        btremove.setOnMouseClicked(value->{
            Remove();
        });
        
        btperfil.setOnMouseClicked(value->{
            realprincipalabre r1 = new realprincipalabre(usunovo);
            perfilrealabre p1 = new perfilrealabre(usunovo);
            r1.fecharTela(); p1.abreTela();
        });
        
        btpartida.setOnMouseClicked(value->{
                realprincipalabre r1 = new realprincipalabre(usunovo);
                Escolheabre m1 = new Escolheabre(usunovo);
                r1.fecharTela(); m1.abreTela();
        });
    }    
    
}
