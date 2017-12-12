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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import model.Copa;
import model.JDBC.CopaDAO;
import model.JDBC.ParticipanteDAO;
import model.JDBC.UsuarioDAO;
import model.Participante;
import model.Usuario;
import view.manage.continuacopaabre;
import view.manage.copaabre;
import view.manage.criarcopaabre2;

public class CriaCopa2Controller implements Initializable {

    
    @FXML private Label lbqtd;
    @FXML private TableView<Participante> tbcopa;
    @FXML private TableView<Usuario> tbusuarios;
    @FXML private JFXButton btremover, btadd, btfinalizar;
    @FXML private TableColumn<Participante, String> tcparticipantes;
    @FXML private TableColumn<Usuario, String> tcusuarios;
    private ObservableList<Usuario> obslista;
    private ObservableList<Participante> obslistapart;
    private ObservableList<Copa> obslistacopa;
    private static String nome;
    private static Usuario usu;
    private Usuario selecionado;
    private Participante selecionado2;
    int qtd2, id;

    public static Usuario getUsu() {
        return usu;
    }

    public static void setUsu(Usuario usu) {
        CriaCopa2Controller.usu = usu;
    }

    public static String getNome() {
        return nome;
    }

    public static void setNome(String nome) {
        CriaCopa2Controller.nome = nome;
    }

    public void Comeca(){
        CopaDAO dao = new CopaDAO();
        obslistacopa = dao.selectCopaNome(nome);
        for(int i = 0; i < obslistacopa.size(); i++){
            lbqtd.setText(String.valueOf(obslistacopa.get(i).getQuantidade()));
            qtd2 = obslistacopa.get(i).getQuantidade();
            id = obslistacopa.get(i).getId_copa();
        }
    }  
    
    
    public void inicia(){
        tcusuarios.setCellValueFactory(new PropertyValueFactory("nome"));
        UsuarioDAO dao = new UsuarioDAO();
        obslista = dao.selectUsuario();
        tbusuarios.setItems(obslista);
    }
    public void inicia2(){
        tcparticipantes.setCellValueFactory(new PropertyValueFactory("nome"));
        ParticipanteDAO dao2 = new ParticipanteDAO();
        obslistapart = dao2.selectPart(id);
        tbcopa.setItems(obslistapart);
    }
    
    public void adiciona(){  
        if(selecionado != null){
        int id = 0;
        for (int i = 0; i < obslistacopa.size(); i++) {           
               id = obslistacopa.get(i).getId_copa();                             
        }
        boolean val = Valida();
        if(val == true){
        Participante part = new Participante();
        part.setId_copa(id);
        part.setId_usuario(selecionado.getId_usuario());
        part.setNometime(selecionado.getTime());
        part.setNome(selecionado.getNome());
        ParticipanteDAO pdao = new ParticipanteDAO();
        pdao.addParticipante(part);
        Atualiza();
        }else{
            Alert erro = new Alert(Alert.AlertType.ERROR);
            erro.setHeaderText("Este usuario já esta presente nesta copa!");
            erro.show();
        }
        }else{
            Alert erro = new Alert(Alert.AlertType.ERROR);
            erro.setHeaderText("Selecione um usuario!");
            erro.show();
        }
    }
    
    public boolean Valida(){
        ParticipanteDAO pdaoo = new ParticipanteDAO();
        obslistapart = pdaoo.selectPart(id);
        for(int y = 0; y < obslistapart.size(); y++){
                if (selecionado.getId_usuario()== obslistapart.get(y).getId_usuario()) {
                    return false;
                }
            }
                return true;
    }
    
    public void Atualiza(){
        try {
            ParticipanteDAO dao = new ParticipanteDAO();
            obslistapart = dao.selectPart(id);
            tbcopa.setItems(obslistapart);            
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }
    
    public void remover(){
        if(selecionado2 != null){
        ParticipanteDAO dao = new ParticipanteDAO();
        dao.delete(selecionado2);
        Atualiza();
        }else{
            Alert erro = new Alert(Alert.AlertType.ERROR);
            erro.setHeaderText("Selecione um participante!");
            erro.show();
        }
    }
    
    public void finalizar(){
        ParticipanteDAO dao = new ParticipanteDAO();
        obslistapart = dao.selectPart(id);
        int qtd = 0;
        for (int i = 0; i < obslistapart.size(); i++) {
                qtd++;
            }
        
        if(qtd == qtd2){
            UsuarioDAO usudao = new UsuarioDAO();
            for (int i = 0; i < obslistapart.size(); i++) {
                usudao.Addcopa(id, obslistapart.get(i).getId_usuario()); 
                System.out.println("Id: "+id);
                System.out.println("Id_Usuario: "+obslistapart.get(i).getId_usuario());
            }
            criarcopaabre2 c = new criarcopaabre2(nome);
            continuacopaabre c2 = new continuacopaabre(usu);
            c.fecharTela(); c2.abreTela();
            
        }else{
            Alert erro = new Alert(Alert.AlertType.WARNING);
            erro.setHeaderText("A quantidade de usuarios no torneio não esta correta!!!");
            erro.show();
            
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Comeca();
        
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
                
                selecionado2 = (Participante)newValue;
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
