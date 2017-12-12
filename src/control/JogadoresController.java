
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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
import model.Jogador;
import model.Usuario;
import view.manage.editarjogadorabre;
import view.manage.jogadoresabre;
import view.manage.perfilabre;


public class JogadoresController implements Initializable {

    
    @FXML private ImageView ivfundo, ivlogo;
    @FXML private Button btexcluir, btatualizar, btpesquisar, btpdf, bteditar;
    @FXML private TableColumn<Jogador, String> tcposicao;
    @FXML private TableColumn<Jogador, String> tcnome;
    @FXML private TableColumn<Jogador, Integer> tcoverall;
    @FXML private TextField tfpesquisa;
    @FXML private TableView<Jogador> tvtabela;
    @FXML private TableColumn<Jogador, Double> tcvalor;
    private Jogador selecionado;
    private ObservableList<Jogador> obslista;
    private static Usuario usu;

    public static Usuario getUsu() {
        return usu;
    }

    public static void setUsu(Usuario usu) {
        JogadoresController.usu = usu;
    }
    
   
    public void IniciaTabela(){
        tcnome.setCellValueFactory(new PropertyValueFactory("nome"));
        tcoverall.setCellValueFactory(new PropertyValueFactory("overal"));
        tcposicao.setCellValueFactory(new PropertyValueFactory("posicao"));
        tcvalor.setCellValueFactory(new PropertyValueFactory("valor"));
        
        JogadorDAO dao = new JogadorDAO();
        obslista = dao.selectJogador();
        tvtabela.setItems(obslista);
    }
    
    private ObservableList<Jogador> busca(){
        ObservableList<Jogador> jogadorbusca = FXCollections.observableArrayList();
        for(int x = 0; x < obslista.size(); x++){
        if(obslista.get(x).getNome().toLowerCase().contains(tfpesquisa.getText().toLowerCase())){
            jogadorbusca.add(obslista.get(x));
        }
            }
        return jogadorbusca;
    }
    
    public void atualizar() {       
        try {
            JogadorDAO dao = new JogadorDAO();
            obslista = dao.selectJogador();
            tvtabela.setItems(obslista);
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setHeaderText("Tabela Atualizada!");
            a.showAndWait();
        } catch (Exception ee) {
            ee.printStackTrace();
        }        
    }
    
    public void Excluir(){
        if(selecionado != null){                    
                    switch (JOptionPane.showConfirmDialog(null, "Deseja realmente excluir este jogador?")) {
            case 0:                    
             JogadorDAO dao = new JogadorDAO();
             dao.delete(selecionado);
             Alert a = new Alert(AlertType.INFORMATION);
                 a.setHeaderText("Jogador deletado com sucesso!");
                 a.show();                               
                 break;
            case 1:               
                break;
            case 2:                
                break;
                }}
                 else{
                 Alert a = new Alert(AlertType.WARNING);
                 a.setHeaderText("Selecione um jogador!!!");
                 a.show();
             }
        }
    
        public void Editar(){
        bteditar.setOnMouseClicked(value->{
            if(selecionado != null){
            editarjogadorabre e1 = new editarjogadorabre(selecionado);
            editarjogadorabre e = new editarjogadorabre(usu);
            jogadoresabre l1 = new jogadoresabre(usu);
            l1.fecharTela();
            e1.abreTela();
            }else{
                 Alert a = new Alert(AlertType.WARNING);
                 a.setHeaderText("Selecione um jogador!!!");
                 a.show();
            }
        });
    }
        
        public void GerarPDF(){
        Document doc = new Document();
        
        FileChooser f = new FileChooser();
        f.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF",".pdf"));
        File file = f.showSaveDialog(new Stage());
        
        if(file != null){
            try {
                PdfWriter.getInstance(doc, new FileOutputStream(file.getAbsolutePath()));
                doc.open();

                List<Jogador> jogador = new JogadorDAO().selectJogador();

                for(int x = 0; x < jogador.size(); x ++){
                doc.add(new Paragraph("Id_Jogador: "+ jogador.get(x).getId_jogador()));
                doc.add(new Paragraph("Id_Usuario: "+ jogador.get(x).getId_usuario()));
                doc.add(new Paragraph("Nome: "+ jogador.get(x).getNome()));
                doc.add(new Paragraph("Posição: "+ jogador.get(x).getPosicao()));
                doc.add(new Paragraph("Overall: "+ jogador.get(x).getOveral()));
                doc.add(new Paragraph("Valor: "+ jogador.get(x).getValor()));
                doc.add(new Paragraph("                                                  "));

                }
                doc.close();

                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setHeaderText("PDF gerado com sucessso!!!");
                a.show();

            } catch (FileNotFoundException ex) {
                Logger.getLogger(JogadoresController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DocumentException ex) {
                Logger.getLogger(JogadoresController.class.getName()).log(Level.SEVERE, null, ex);
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
        
        ivlogo.setOnMouseClicked(value->{
            jogadoresabre j1 = new jogadoresabre(usu);
            perfilabre c1 = new perfilabre(usu);
            j1.fecharTela(); c1.abreTela();
        });
        
        tvtabela.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                
                selecionado = (Jogador)newValue;
            }
        });
        
        btpesquisar.setOnMouseClicked(value->{
            tvtabela.setItems(busca());
        });
        
        tfpesquisa.setOnKeyReleased(value->{
            tvtabela.setItems(busca());
        });
        
        btatualizar.setOnMouseClicked(value->{
            atualizar();
        });
        btexcluir.setOnMouseClicked(value->{
            Excluir();
        });
        
        bteditar.setOnMouseClicked(value->{
            Editar();
        });
        btpdf.setOnMouseClicked(value->{
            GerarPDF();
        });
    }    
    
}
