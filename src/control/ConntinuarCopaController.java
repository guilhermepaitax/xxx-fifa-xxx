package control;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;
import model.Copa;
import model.JDBC.CopaDAO;
import model.JDBC.ParticipanteDAO;
import model.JDBC.UsuarioDAO;
import model.Participante;
import model.Usuario;
import view.manage.continuacopaabre;
import view.manage.principalabre;

public class ConntinuarCopaController implements Initializable {

    @FXML private TextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8,  tf9, tf10, tf11, tf12, tf13, tf14, tf15, tf16, tf17, tf18, tf19, tf20;
    @FXML private TextField tf21, tf22, tf23, tf24, tf25, tf26, tf27, tf28, tf29, tf30;
    @FXML private JFXButton btartilharia, btjogos, btsobre, btatualizar;
    @FXML private TextField pl1, pl2, pl3, pl4, pl5, pl6, pl7, pl8, pl9, pl10, pl11, pl12, pl13, pl14, pl15, pl16, pl17, pl18, pl19, pl20;
    @FXML private TextField pl21, pl22, pl23, pl24, pl25, pl26, pl27, pl28, pl29, pl30;      
    @FXML private Label lbsemi, lbcopa, lbquartas, lbsemi2, lbquartas2, lboitavas, lbfinal, lbnome, lboitavas2;
    @FXML private ImageView ivtrofeu, ivvoltar, ivfundo;
    @FXML private Pane pane;
    private static Usuario usu;
    private static Usuario usunovo;
    private ObservableList<Usuario> obslistausu;
    private ObservableList<Copa> obslistacopa;
    private ObservableList<Participante> obslistapart;
    int quantidade, copa;
    double premio, vitoria;
    UsuarioDAO udao = new UsuarioDAO();
    public static Usuario getUsu() {
        return usu;
    }

    public static void setUsu(Usuario usu) {
        ConntinuarCopaController.usu = usu;
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
    
    public void Inicia(){
        CopaDAO c1 = new CopaDAO();
        obslistacopa = c1.selectCopaPart(usunovo.getId_copa());
        for (int i = 0; i < obslistacopa.size(); i++) {
        lbnome.setText(obslistacopa.get(i).getNome());
        quantidade = obslistacopa.get(i).getQuantidade();
        copa = obslistacopa.get(i).getId_copa();
        premio = obslistacopa.get(i).getPremio();
        vitoria = obslistacopa.get(i).getValorpartida();
    }
        
        if(quantidade == 2){
            ParticipanteDAO pdao = new ParticipanteDAO();
            obslistapart = pdao.selectPart(copa);
            for (int i = 0; i == 0; i++) {
                tf29.setText(obslistapart.get(i).getNometime());
                pl29.setText(String.valueOf(obslistapart.get(i).getP4()));
            }
            for (int y = 1; y == 1; y++) {
                tf30.setText(obslistapart.get(y).getNometime());
                pl30.setText(String.valueOf(obslistapart.get(y).getP4()));
            }
        }
        if(quantidade == 4){
            ParticipanteDAO pdao = new ParticipanteDAO();
            obslistapart = pdao.selectPart(copa);
            for (int i = 0; i == 0; i++) {
                tf25.setText(obslistapart.get(i).getNometime());
                pl25.setText(String.valueOf(obslistapart.get(i).getP3()));
            }
            for (int y = 1; y == 1; y++) {
                tf26.setText(obslistapart.get(y).getNometime());
                pl26.setText(String.valueOf(obslistapart.get(y).getP3()));
            }
            for (int a = 2; a == 2; a++) {
                tf27.setText(obslistapart.get(a).getNometime());
                pl27.setText(String.valueOf(obslistapart.get(a).getP3()));
            }
            for (int b = 3; b == 3; b++) {
                tf28.setText(obslistapart.get(b).getNometime());
                pl28.setText(String.valueOf(obslistapart.get(b).getP3()));
            }
            /////////Fase 2
            int n1 = Integer.valueOf(pl25.getText()), n2 = Integer.valueOf(pl26.getText()), n3 = Integer.valueOf(pl27.getText()), n4 = Integer.valueOf(pl28.getText());
            
            if(n1 > n2){
                for(int i = 0; i == 0; i++){
                    tf29.setText(obslistapart.get(i).getNometime());
                    pl29.setText(String.valueOf(obslistapart.get(i).getP4()));
                    udao.Adddinheiro(obslistapart.get(i).getId_usuario(),vitoria);
                    
                }
            }
            if(n2 > n1){
                for(int i = 1; i == 1; i++){
                    tf29.setText(obslistapart.get(i).getNometime());
                    pl29.setText(String.valueOf(obslistapart.get(i).getP4()));
                    udao.Adddinheiro(obslistapart.get(i).getId_usuario(),vitoria);
                }
            }
            /////////////////////////
            if(n3 > n4){
                for(int i = 2; i == 2; i++){
                    tf30.setText(obslistapart.get(i).getNometime());
                    pl30.setText(String.valueOf(obslistapart.get(i).getP4()));
                    udao.Adddinheiro(obslistapart.get(i).getId_usuario(),vitoria);
                }
            }
            if(n4 > n3){
                for(int i = 3; i == 3; i++){
                    tf30.setText(obslistapart.get(i).getNometime());
                    pl30.setText(String.valueOf(obslistapart.get(i).getP4()));
                    udao.Adddinheiro(obslistapart.get(i).getId_usuario(),vitoria);
                }
            }
            
        }
        if(quantidade == 8){
            ParticipanteDAO pdao = new ParticipanteDAO();
            obslistapart = pdao.selectPart(copa);
            for (int i = 0; i == 0; i++) {
                tf17.setText(obslistapart.get(i).getNometime());
                pl17.setText(String.valueOf(obslistapart.get(i).getP2()));
            }
            for (int i = 1; i == 1; i++) {
                tf18.setText(obslistapart.get(i).getNometime());
                pl18.setText(String.valueOf(obslistapart.get(i).getP2()));
            }
            for (int i = 2; i == 2; i++) {
                tf19.setText(obslistapart.get(i).getNometime());
                pl19.setText(String.valueOf(obslistapart.get(i).getP2()));
            }
            for (int i = 3; i == 3; i++) {
                tf20.setText(obslistapart.get(i).getNometime());
                pl20.setText(String.valueOf(obslistapart.get(i).getP2()));
            }
            for (int i = 4; i == 4; i++) {
                tf21.setText(obslistapart.get(i).getNometime());
                pl21.setText(String.valueOf(obslistapart.get(i).getP2()));
            }
            for (int i = 5; i == 5; i++) {
                tf22.setText(obslistapart.get(i).getNometime());
                pl22.setText(String.valueOf(obslistapart.get(i).getP2()));
            }
            for (int i = 6; i == 6; i++) {
                tf23.setText(obslistapart.get(i).getNometime());
                pl23.setText(String.valueOf(obslistapart.get(i).getP2()));
            }
            for (int i = 7; i == 7; i++) {
                tf24.setText(obslistapart.get(i).getNometime());
                pl24.setText(String.valueOf(obslistapart.get(i).getP2()));
            }
            ///FASE 2
            int n1 = Integer.valueOf(pl17.getText()), n2 = Integer.valueOf(pl18.getText()), n3 = Integer.valueOf(pl19.getText()), n4 = Integer.valueOf(pl20.getText()), n5 = Integer.valueOf(pl21.getText()), n6 = Integer.valueOf(pl22.getText()), n7 = Integer.valueOf(pl23.getText()), n8 = Integer.valueOf(pl24.getText());
            
            if(n1 > n2){
                for(int i = 0; i == 0; i++){
                    tf25.setText(obslistapart.get(i).getNometime());
                    pl25.setText(String.valueOf(obslistapart.get(i).getP3()));
                    for(int s = 0; s < obslistausu.size(); s++){
                        if(obslistausu.get(s).getId_usuario() == obslistapart.get(i).getId_usuario()){
                            
                            udao.Adddinheiro(obslistapart.get(i).getId_usuario(),vitoria + obslistausu.get(s).getDinheiro());
                        }
                    }
                    
                }
            }
            if(n2 > n1){
                for(int i = 1; i == 1; i++){
                    tf25.setText(obslistapart.get(i).getNometime());
                    pl25.setText(String.valueOf(obslistapart.get(i).getP3()));
                    for(int s = 0; s < obslistausu.size(); s++){
                        if(obslistausu.get(s).getId_usuario() == obslistapart.get(i).getId_usuario()){
                            
                            udao.Adddinheiro(obslistapart.get(i).getId_usuario(),vitoria + obslistausu.get(s).getDinheiro());
                        }
                    }
                }
            }
            /////////////////////////
            if(n3 > n4){
                for(int i = 2; i == 2; i++){
                    tf26.setText(obslistapart.get(i).getNometime());
                    pl26.setText(String.valueOf(obslistapart.get(i).getP3()));
                    for(int s = 0; s < obslistausu.size(); s++){
                        if(obslistausu.get(s).getId_usuario() == obslistapart.get(i).getId_usuario()){
                            
                            udao.Adddinheiro(obslistapart.get(i).getId_usuario(),vitoria + obslistausu.get(s).getDinheiro());
                        }
                    }
                }
            }
            if(n4 > n3){
                for(int i = 3; i == 3; i++){
                    tf26.setText(obslistapart.get(i).getNometime());
                    pl26.setText(String.valueOf(obslistapart.get(i).getP3()));
                    for(int s = 0; s < obslistausu.size(); s++){
                        if(obslistausu.get(s).getId_usuario() == obslistapart.get(i).getId_usuario()){
                            
                            udao.Adddinheiro(obslistapart.get(i).getId_usuario(),vitoria + obslistausu.get(s).getDinheiro());
                        }
                    }
                }
            }
            
            if(n5 > n6){
                for(int i = 4; i == 4; i++){
                    tf27.setText(obslistapart.get(i).getNometime());
                    pl27.setText(String.valueOf(obslistapart.get(i).getP3()));
                    for(int s = 0; s < obslistausu.size(); s++){
                        if(obslistausu.get(s).getId_usuario() == obslistapart.get(i).getId_usuario()){
                            
                            udao.Adddinheiro(obslistapart.get(i).getId_usuario(),vitoria + obslistausu.get(s).getDinheiro());
                        }
                    }
                }
            }
            if(n6 > n5){
                for(int i = 5; i == 5; i++){
                    tf27.setText(obslistapart.get(i).getNometime());
                    pl27.setText(String.valueOf(obslistapart.get(i).getP3()));
                    for(int s = 0; s < obslistausu.size(); s++){
                        if(obslistausu.get(s).getId_usuario() == obslistapart.get(i).getId_usuario()){
                            
                            udao.Adddinheiro(obslistapart.get(i).getId_usuario(),vitoria + obslistausu.get(s).getDinheiro());
                        }
                    }
                }
            }
            /////////////////////////
            if(n7 > n8){
                for(int i = 6; i == 6; i++){
                    tf28.setText(obslistapart.get(i).getNometime());
                    pl28.setText(String.valueOf(obslistapart.get(i).getP3()));
                    for(int s = 0; s < obslistausu.size(); s++){
                        if(obslistausu.get(s).getId_usuario() == obslistapart.get(i).getId_usuario()){
                            
                            udao.Adddinheiro(obslistapart.get(i).getId_usuario(),vitoria + obslistausu.get(s).getDinheiro());
                        }
                    }
                }
            }
            if(n8 > n7){
                for(int i = 7; i == 7; i++){
                    tf28.setText(obslistapart.get(i).getNometime());
                    pl28.setText(String.valueOf(obslistapart.get(i).getP3()));
                    for(int s = 0; s < obslistausu.size(); s++){
                        if(obslistausu.get(s).getId_usuario() == obslistapart.get(i).getId_usuario()){
                            
                            udao.Adddinheiro(obslistapart.get(i).getId_usuario(),vitoria + obslistausu.get(s).getDinheiro());
                        }
                    }
                }
            }
            ///////FASE 3
             
        }
        if(quantidade == 16){
            ParticipanteDAO pdao = new ParticipanteDAO();
            obslistapart = pdao.selectPart(copa);
            for (int i = 0; i == 0; i++) {
                tf1.setText(obslistapart.get(i).getNometime());
                pl1.setText(String.valueOf(obslistapart.get(i).getP1()));
            }
            for (int i = 1; i == 1; i++) {
                tf2.setText(obslistapart.get(i).getNometime());
                pl2.setText(String.valueOf(obslistapart.get(i).getP1()));
            }
            for (int i = 2; i == 2; i++) {
                tf3.setText(obslistapart.get(i).getNometime());
                pl3.setText(String.valueOf(obslistapart.get(i).getP1()));
            }
            for (int i = 3; i == 3; i++) {
                tf4.setText(obslistapart.get(i).getNometime());
                pl4.setText(String.valueOf(obslistapart.get(i).getP1()));
            }
            for (int i = 4; i == 4; i++) {
                tf5.setText(obslistapart.get(i).getNometime());
                pl5.setText(String.valueOf(obslistapart.get(i).getP1()));
            }
            for (int i = 5; i == 5; i++) {
                tf6.setText(obslistapart.get(i).getNometime());
                pl6.setText(String.valueOf(obslistapart.get(i).getP1()));
            }
            for (int i = 6; i == 6; i++) {
                tf7.setText(obslistapart.get(i).getNometime());
                pl7.setText(String.valueOf(obslistapart.get(i).getP1()));
            }
            for (int i = 7; i == 7; i++) {
                tf8.setText(obslistapart.get(i).getNometime());
                pl8.setText(String.valueOf(obslistapart.get(i).getP1()));
            }
            for (int i = 8; i == 8; i++) {
                tf9.setText(obslistapart.get(i).getNometime());
                pl9.setText(String.valueOf(obslistapart.get(i).getP1()));
            }
            for (int i = 9; i == 9; i++) {
                tf10.setText(obslistapart.get(i).getNometime());
                pl10.setText(String.valueOf(obslistapart.get(i).getP1()));
            }
            for (int i = 10; i == 10; i++) {
                tf11.setText(obslistapart.get(i).getNometime());
                pl11.setText(String.valueOf(obslistapart.get(i).getP1()));
            }
            for (int i = 11; i == 11; i++) {
                tf12.setText(obslistapart.get(i).getNometime());
                pl12.setText(String.valueOf(obslistapart.get(i).getP1()));
            }
            for (int i = 12; i == 12; i++) {
                tf13.setText(obslistapart.get(i).getNometime());
                pl13.setText(String.valueOf(obslistapart.get(i).getP1()));
            }
            for (int i = 13; i == 13; i++) {
                tf14.setText(obslistapart.get(i).getNometime());
                pl14.setText(String.valueOf(obslistapart.get(i).getP1()));
            }
            for (int i = 14; i == 14; i++) {
                tf15.setText(obslistapart.get(i).getNometime());
                pl15.setText(String.valueOf(obslistapart.get(i).getP1()));
            }
            for (int i = 15; i == 15; i++) {
                tf16.setText(obslistapart.get(i).getNometime());
                pl16.setText(String.valueOf(obslistapart.get(i).getP1()));
            }
        }
    }
   
    public void Atualizar(){
        ParticipanteDAO pdao = new ParticipanteDAO();
        obslistapart = pdao.selectPart(copa);
        if(quantidade == 2){           
            for (int i = 0; i == 0; i++) {
                pdao.Addplacar4(Integer.valueOf(pl29.getText()), obslistapart.get(i).getId_participante());
            }
            for (int y = 1; y == 1; y++) {
                pdao.Addplacar4(Integer.valueOf(pl30.getText()), obslistapart.get(y).getId_participante());
            }
        }
        if(quantidade == 4){
            for (int i = 0; i == 0; i++) {
                pdao.Addplacar3(Integer.valueOf(pl25.getText()), obslistapart.get(i).getId_participante());
            }
            for (int y = 1; y == 1; y++) {
                pdao.Addplacar3(Integer.valueOf(pl26.getText()), obslistapart.get(y).getId_participante());
            }
            for (int a = 2; a == 2; a++) {
                pdao.Addplacar3(Integer.valueOf(pl27.getText()), obslistapart.get(a).getId_participante());
            }
            for (int b = 3; b == 3; b++) {
                pdao.Addplacar3(Integer.valueOf(pl28.getText()), obslistapart.get(b).getId_participante());
            }
        }
        if(quantidade == 8){
            for (int i = 0; i == 0; i++) {
                pdao.Addplacar2(Integer.valueOf(pl17.getText()), obslistapart.get(i).getId_participante());
            }
            for (int i = 1; i == 1; i++) {
                pdao.Addplacar2(Integer.valueOf(pl18.getText()), obslistapart.get(i).getId_participante());
            }
            for (int i = 2; i == 2; i++) {
                pdao.Addplacar2(Integer.valueOf(pl19.getText()), obslistapart.get(i).getId_participante());
            }
            for (int i = 3; i == 3; i++) {
                pdao.Addplacar2(Integer.valueOf(pl20.getText()), obslistapart.get(i).getId_participante());
            }
            for (int i = 4; i == 4; i++) {
                pdao.Addplacar2(Integer.valueOf(pl21.getText()), obslistapart.get(i).getId_participante());
            }
            for (int i = 5; i == 5; i++) {
                pdao.Addplacar2(Integer.valueOf(pl22.getText()), obslistapart.get(i).getId_participante());
            }
            for (int i = 6; i == 6; i++) {
                pdao.Addplacar2(Integer.valueOf(pl23.getText()), obslistapart.get(i).getId_participante());
            }
            for (int i = 7; i == 7; i++) {
                pdao.Addplacar2(Integer.valueOf(pl24.getText()), obslistapart.get(i).getId_participante());
            }
            fase2de8();
        }
        
        
        Inicia();
    }
    
    public void fase2de8(){
        ParticipanteDAO pdao = new ParticipanteDAO();
        obslistapart = pdao.selectPart(copa);
        int nb1 = Integer.valueOf(pl25.getText()), nb2 = Integer.valueOf(pl26.getText()), nb3 = Integer.valueOf(pl27.getText()), nb4 = Integer.valueOf(pl28.getText());
            
            if(nb1 > nb2){
                for(int i = 0; i == 0; i++){
                    tf29.setText(obslistapart.get(i).getNometime());
                    pl29.setText(String.valueOf(obslistapart.get(i).getP4()));
                    for(int s = 0; s < obslistausu.size(); s++){
                        if(obslistausu.get(s).getId_usuario() == obslistapart.get(i).getId_usuario()){
                            
                            udao.Adddinheiro(obslistapart.get(i).getId_usuario(),vitoria + obslistausu.get(s).getDinheiro());
                        }
                    }
                    
                }
            }
            if(nb2 > nb1){
                for(int i = 1; i == 1; i++){
                    tf29.setText(obslistapart.get(i).getNometime());
                    pl29.setText(String.valueOf(obslistapart.get(i).getP4()));
                    for(int s = 0; s < obslistausu.size(); s++){
                        if(obslistausu.get(s).getId_usuario() == obslistapart.get(i).getId_usuario()){
                            
                            udao.Adddinheiro(obslistapart.get(i).getId_usuario(),vitoria + obslistausu.get(s).getDinheiro());
                        }
                    }
                }
            }
            /////////////////////////
            if(nb3 > nb4){
                for(int i = 2; i == 2; i++){
                    tf30.setText(obslistapart.get(i).getNometime());
                    pl30.setText(String.valueOf(obslistapart.get(i).getP4()));
                    for(int s = 0; s < obslistausu.size(); s++){
                        if(obslistausu.get(s).getId_usuario() == obslistapart.get(i).getId_usuario()){
                            
                            udao.Adddinheiro(obslistapart.get(i).getId_usuario(),vitoria + obslistausu.get(s).getDinheiro());
                        }
                    }
                }
            }
            if(nb4 > nb3){
                for(int i = 3; i == 3; i++){
                    tf30.setText(obslistapart.get(i).getNometime());
                    pl30.setText(String.valueOf(obslistapart.get(i).getP4()));
                    for(int s = 0; s < obslistausu.size(); s++){
                        if(obslistausu.get(s).getId_usuario() == obslistapart.get(i).getId_usuario()){
                            
                            udao.Adddinheiro(obslistapart.get(i).getId_usuario(),vitoria + obslistausu.get(s).getDinheiro());
                        }
                    }
                }
            }
    }
    
    public void finaliza(){
        switch (JOptionPane.showConfirmDialog(null, "Deseja realmente finalizar a copa?")) {
            case 0:                
               CopaDAO cdao = new CopaDAO();
                cdao.delete(copa);
               Alert conf = new Alert(Alert.AlertType.CONFIRMATION);
               conf.setHeaderText("Copa finalizada com sucesso!");
               conf.show();
               continuacopaabre c1 = new continuacopaabre(usunovo);
                principalabre p1 = new principalabre(usunovo);
                c1.fecharTela(); p1.abreTela();
                break;
            case 1:               
                break;
            case 2:               
                break;
                }
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btartilharia.setText("Finalizar Copa");
        btartilharia.setOnMouseClicked(value->{
            if(usu.isAdm() == true){
            finaliza();
            }else{
                Alert erro = new Alert(Alert.AlertType.ERROR);
                erro.setHeaderText("Você não tem permissão para acessar esta função!");
                erro.show();
            }
        });
        UsuNovo();
        Inicia();
        if(usunovo.isAdm() == true){
            pl1.setEditable(true);
            pl2.setEditable(true);
            pl3.setEditable(true);
            pl4.setEditable(true);
            pl5.setEditable(true);
            pl6.setEditable(true);
            pl7.setEditable(true);
            pl8.setEditable(true);
            pl9.setEditable(true);
            pl10.setEditable(true);
            pl11.setEditable(true);
            pl12.setEditable(true);
            pl13.setEditable(true);
            pl14.setEditable(true);
            pl15.setEditable(true);
            pl16.setEditable(true);
            pl17.setEditable(true);
            pl18.setEditable(true);
            pl19.setEditable(true);
            pl20.setEditable(true);
            pl21.setEditable(true);
            pl22.setEditable(true);
            pl23.setEditable(true);
            pl24.setEditable(true);
            pl25.setEditable(true);
            pl26.setEditable(true);
            pl27.setEditable(true);
            pl28.setEditable(true);
            pl29.setEditable(true);
            pl30.setEditable(true);
        }
        
        ivvoltar.setOnMouseClicked(value->{
            continuacopaabre c1 = new continuacopaabre(usunovo);
            principalabre p1 = new principalabre(usunovo);
            c1.fecharTela(); p1.abreTela();
        });
        
        btatualizar.setOnMouseClicked(value->{
            if(usu.isAdm() == true){
            Atualizar();
            }else{
                Alert erro = new Alert(Alert.AlertType.ERROR);
                erro.setHeaderText("Você não tem permissão para acessar esta função!");
                erro.show();
            }
        });
    }    
    
}
