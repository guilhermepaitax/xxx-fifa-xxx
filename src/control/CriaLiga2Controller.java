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
import javafx.scene.control.cell.PropertyValueFactory;
import model.JDBC.LigaDAO;
import model.JDBC.Participante2DAO;
import model.JDBC.ParticipanteDAO;
import model.JDBC.UsuarioDAO;
import model.Liga;
import model.Participante2;
import model.Usuario;
import view.manage.continuarligaabre;
import view.manage.crialiga2abre;
import view.manage.criarcopaabre2;

public class CriaLiga2Controller implements Initializable {
    
    @FXML private TableView<Usuario> tbusuarios;
    @FXML private TableColumn<Participante2, String> tcparticipantes;
    @FXML private JFXButton btremover;
    @FXML private TableColumn<Usuario, String> tcusuarios;
    @FXML private JFXButton btadd;
    @FXML private JFXButton btfinalizar;
    @FXML private TableView<Participante2> tbcopa;
    private static Usuario usu;
    private ObservableList<Usuario> obslista;
    private ObservableList<Liga> obslistaliga;
    private ObservableList<Participante2> obslistapart;
    private Usuario selecionado;
    private Participante2 selecionado2;
    private static String nome;
    int id = 0;
    
    public static String getNome() {
        return nome;
    }

    public static void setNome(String nome) {
        CriaLiga2Controller.nome = nome;
    }
    

    public static Usuario getUsu() {
        return usu;
    }

    public static void setUsu(Usuario usu) {
        CriaLiga2Controller.usu = usu;
    }
    
    public void inicia(){
        tcusuarios.setCellValueFactory(new PropertyValueFactory("nome"));
        UsuarioDAO dao = new UsuarioDAO();
        obslista = dao.selectUsuario();
        tbusuarios.setItems(obslista);
    }
    
    public void comeca(){
        LigaDAO dao = new LigaDAO();
        obslistaliga = dao.selectLigaNome(nome);
        for(int i = 0; i < obslistaliga.size(); i++){
            id = obslistaliga.get(i).getId_liga();
        }
    }
    
    public void inicia2(){
        tcparticipantes.setCellValueFactory(new PropertyValueFactory("nome"));
        Participante2DAO dao2 = new Participante2DAO();
        obslistapart = dao2.selectPart(id);
        tbcopa.setItems(obslistapart);
    }
    
    public void adiciona(){       
        int id = 0;
        for (int i = 0; i < obslistaliga.size(); i++) {           
               id = obslistaliga.get(i).getId_liga();                             
        }
        boolean val = Valida();
        if(val == true){
        Participante2 part = new Participante2();
        part.setId_liga(id);
        part.setId_usuario(selecionado.getId_usuario());
        part.setTime(selecionado.getTime());
        part.setNome(selecionado.getNome());
        Participante2DAO pdao = new Participante2DAO();
        pdao.addParticipante(part);
        Atualiza();
        }else{
            Alert erro = new Alert(Alert.AlertType.ERROR);
            erro.setHeaderText("Este usuario já esta presente nesta liga!");
            erro.show();
        }
    }
    
    public boolean Valida(){
        Participante2DAO pdao = new Participante2DAO();
        obslistapart = pdao.selectPart(id);
        for(int y = 0; y < obslistapart.size(); y++){
                if (selecionado.getId_usuario() == obslistapart.get(y).getId_usuario()) {
                    return false;
                }
            }
                return true;
    }
    
    public void Atualiza(){
        try {
            Participante2DAO dao = new Participante2DAO();
            obslistapart = dao.selectPart(id);
            tbcopa.setItems(obslistapart);            
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }
    
    public void remover(){
        Participante2DAO dao = new Participante2DAO();
        dao.delete(selecionado2);
        Atualiza();
    }
    
    public void finalizar(){
        Participante2DAO dao = new Participante2DAO();
        obslistapart = dao.selectPart(id);
    
            UsuarioDAO usudao = new UsuarioDAO();
            for (int i = 0; i < obslistapart.size(); i++) {
                usudao.Addliga(id, obslistapart.get(i).getId_usuario()); 
                System.out.println("Id: "+id);
                System.out.println("Id_Usuario: "+obslistapart.get(i).getId_usuario());
            }
            crialiga2abre c = new crialiga2abre(nome);
            continuarligaabre c2 = new continuarligaabre(usu);
            c.fecharTela(); c2.abreTela();
     
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comeca();
        inicia();
        inicia2();
        tbusuarios.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                
                selecionado = (Usuario)newValue;
            }
        });
        
        tbcopa.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                
                selecionado2 = (Participante2)newValue;
            }
        });
        
        
        
        btadd.setOnMouseClicked(value->{
            adiciona();
        });
        
        btremover.setOnMouseClicked(value->{
            remover();
        });
        
        btfinalizar.setOnMouseClicked(value->{
            finalizar();
        });
    }    
    
}
