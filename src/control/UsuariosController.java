
package control;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.JDBC.JogadorDAO;
import model.JDBC.UsuarioDAO;
import model.Usuario;
import view.manage.perfilabre;
import view.manage.premiarabre;
import view.manage.usuariosabre;


public class UsuariosController implements Initializable {

    @FXML private ImageView ivfundo, ivlogo;
    @FXML private TableColumn<Usuario, String> tctime;
    @FXML private Button btatualizar, btpesquisar, btpdf, bteditar, btpremiar;
    @FXML  private TableColumn<Usuario, Double> tcdinheiro;
    @FXML private TableColumn<Usuario, String> tcnome;
    @FXML private TextField tfpesquisa;
    @FXML private TableView<Usuario> tvtabela;
    @FXML private TableColumn<Usuario, Integer> tcid;
    private static Usuario usu;
    private ObservableList<Usuario> obslista;
    private Usuario selecionado;

    public static Usuario getUsu() {
        return usu;
    }

    public static void setUsu(Usuario usu) {
        UsuariosController.usu = usu;
    }
    
    public void IniciaTabela(){
        tcnome.setCellValueFactory(new PropertyValueFactory("nome"));
        tcdinheiro.setCellValueFactory(new PropertyValueFactory("dinheiro"));
        tcid.setCellValueFactory(new PropertyValueFactory("id_usuario"));
        tctime.setCellValueFactory(new PropertyValueFactory("time"));
        
        UsuarioDAO dao = new UsuarioDAO();
        obslista = dao.selectUsuario();
        tvtabela.setItems(obslista);
    }
    
    private ObservableList<Usuario> busca(){
        ObservableList<Usuario> jogadorbusca = FXCollections.observableArrayList();
        for(int x = 0; x < obslista.size(); x++){
        if(obslista.get(x).getNome().toLowerCase().contains(tfpesquisa.getText().toLowerCase())){
            jogadorbusca.add(obslista.get(x));
        }
            }
        return jogadorbusca;
    }
    
     public void atualizar() {       
        try {
            UsuarioDAO dao = new UsuarioDAO();
            obslista = dao.selectUsuario();
            tvtabela.setItems(obslista);
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setHeaderText("Tabela Atualizada!");
            a.showAndWait();
        } catch (Exception ee) {
            ee.printStackTrace();
        }        
    }
     
     public void GerarPDF() throws DocumentException{
         Document doc = new Document() {};
        
        FileChooser f = new FileChooser();
        f.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF",".pdf"));
        File file = f.showSaveDialog(new Stage());
        
        if(file != null){
            try {
                PdfWriter.getInstance(doc, new FileOutputStream(file.getAbsolutePath()));
                doc.open();

                List<Usuario> usuario = new UsuarioDAO().selectUsuario();

                for(int x = 0; x < usuario.size(); x ++){
                doc.add(new Paragraph("Id: "+ usuario.get(x).getId_usuario()));
                doc.add(new Paragraph("Login: "+ usuario.get(x).getNome()));
                doc.add(new Paragraph("Time: "+ usuario.get(x).getTime()));
                doc.add(new Paragraph("Administrador: "+ usuario.get(x).isAdm()));
                doc.add(new Paragraph("Senha: "+ usuario.get(x).getSenha()));
                doc.add(new Paragraph("Caminho da Foto: "+ usuario.get(x).getFoto()));
                doc.add(new Paragraph("Velocidade: "+ usuario.get(x).getVelocidade()));
                doc.add(new Paragraph("Chute: "+ usuario.get(x).getChute()));
                doc.add(new Paragraph("Defesa: "+ usuario.get(x).getDefesa()));
                doc.add(new Paragraph("Fisico: "+ usuario.get(x).getFisico()));
                doc.add(new Paragraph("Drible: "+ usuario.get(x).getDrible()));
                doc.add(new Paragraph("Passe: "+ usuario.get(x).getPasse()));
                doc.add(new Paragraph("______________________________________________________________"));

                }
                doc.close();

                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setHeaderText("PDF gerado com sucessso!!!");
                a.show();

            } catch (FileNotFoundException ex) {
                Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else{
            Alert a = new Alert(Alert.AlertType.ERROR);
                a.setHeaderText("Defina um lugar para salvar o arquivo");
                a.show();
        }
     }
    
       
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        IniciaTabela();
        
        btatualizar.setOnMouseClicked(value->{
            atualizar();
        });
        
        ivlogo.setOnMouseClicked(value->{
            perfilabre c1 = new perfilabre(usu);
            usuariosabre u1 = new usuariosabre(usu);
            u1.fecharTela(); c1.abreTela();
        });
        
        tvtabela.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                
                selecionado = (Usuario)newValue;
            }
        });
        
        btpesquisar.setOnMouseClicked(value->{
            tvtabela.setItems(busca());
        });
        
        tfpesquisa.setOnKeyReleased(value->{
            tvtabela.setItems(busca());
        });
        
        btpremiar.setOnMouseClicked(value->{
            if(selecionado != null){
            premiarabre p1 = new premiarabre(usu);
            premiarabre p2 = new premiarabre(selecionado.getDinheiro(), selecionado.getId_usuario(), selecionado.getNome());
            usuariosabre u1 = new usuariosabre(usu);
            u1.fecharTela(); p1.abreTela();
            }else{
                 Alert a = new Alert(Alert.AlertType.WARNING);
                 a.setHeaderText("Selecione um usuario!!!");
                 a.show();
            }
        });
        btpdf.setOnMouseClicked(value->{
            try {
                GerarPDF();
            } catch (DocumentException ex) {
                Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        
        
    }    
    
}
