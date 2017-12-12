
package control;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.JDBC.JogadorDAO;
import model.JDBC.UsuarioDAO;
import model.Jogador;
import model.Usuario;
import view.manage.packabre;
import view.manage.packjogadoresabre;


public class PackjogadoresController implements Initializable{

    
    
    @FXML private Button btvender, btconcluir;
    @FXML private ImageView ivjogador1, ivfundo, ivjogador2, ivlogo, ivjogador3, ivjogador4;
    private ObservableList<Jogador> obslista;
    int j1 = 0, j2 = 0, j3 = 0, j4 = 0, cont = 0, num =0;
    private static Usuario usu;
    boolean v4 = false;
    JogadorDAO dao = new JogadorDAO();

    public static Usuario getUsu() {
        return usu;
    }

    public static void setUsu(Usuario usu) {
        PackjogadoresController.usu = usu;
    }
    
    public boolean Ajuda2(){
        boolean v1 = false, v2 = false, v3 = false;
        for (int y = 0; y < obslista.size(); y++) {
            if(j3 == obslista.get(y).getId_jogador()){
                if(obslista.get(y).getId_usuario() == 0){
                    v1 = true;
                }
            }
        }
        
        for (int x = 0; x < obslista.size(); x++) {
            if(j4 == obslista.get(x).getId_jogador()){
                if(obslista.get(x).getId_usuario() == 0){
                    v2 = true;
                }
            }
        }
        
        for (int z = 0; z < obslista.size(); z++) {
            if(j2 == obslista.get(z).getId_jogador()){
                if(obslista.get(z).getId_usuario() == 0){
                    v3 = true;
                }
            }
        }
        
        if(v1 == true && v2 == true && v3 == true){
            v4 = true;
            Chama();
        }
        return v4;
    }
    
    
    public void JogadorAleatorio(){       
            
           // Inicia do while, gera quatro numeros aleatórios até 604, que será referente ao id_jogador 
           
            while( cont == 0){               
            Random gerador = new Random();            
            j1 = gerador.nextInt(num);
            j2 = gerador.nextInt(num);
            j3 = gerador.nextInt(num);
            j4 = gerador.nextInt(num);
           
            // Verifica se não tem nenhum numero igual entre eles.
            if( j1 != j2 && j1 != j3 && j1 != j4 && j2 != j3 && j2 != j4 && j3 != j4){                
                obslista = dao.selectJogador();
        
            // Entra no for que verificará se esse jogador não possui um id_usuário(DONO,usuário que a gente cadastra)
            for (int i = 0; i < obslista.size(); i++) {
                if(j1 == obslista.get(i).getId_jogador()){
                    if(obslista.get(i).getId_usuario() == 0){
                        boolean ult = Ajuda2();
                        if(ult == true){
                            cont = 1;
                        }
                    }
                }
            
        }
            }                        
        }   
}
  
        
    public void Chama(){
        
        
        obslista = dao.selectJogador();
        
        //For abaixo percorrerá a lista de jogadores até o id do jogador for igual ao numero gerado(j1)
        for (int i = 0; i < obslista.size(); i++) {
            if(j1 == obslista.get(i).getId_jogador()){
              // Exibirá a imagem do jogador.
            Image image = new Image("/imagens/jogadores/" + obslista.get(i).getFoto());
            ivjogador1.setImage(image); 
             i = obslista.size();
             
            }                 
        }
        for (int i = 0; i < obslista.size(); i++) {
            if(j2 == obslista.get(i).getId_jogador()){
            Image image = new Image("/imagens/jogadores/" + obslista.get(i).getFoto());
            ivjogador2.setImage(image); 
             i = obslista.size();
             
            }
        } 
        for (int i = 0; i < obslista.size(); i++) {
            if(j3 == obslista.get(i).getId_jogador()){
            Image image = new Image("/imagens/jogadores/" + obslista.get(i).getFoto());
            ivjogador3.setImage(image); 
             i = obslista.size();
             
            }
        }
        for (int i = 0; i < obslista.size(); i++) {
            if(j4 == obslista.get(i).getId_jogador()){
            Image image = new Image("/imagens/jogadores/" + obslista.get(i).getFoto());
            ivjogador4.setImage(image); 
             i = obslista.size();
             
            }
        }        
    }
    
        public void Adiciona(){
            dao.Addusuario(usu.getId_usuario(), j1);
            dao.Addusuario(usu.getId_usuario(), j2);
            dao.Addusuario(usu.getId_usuario(), j3);
            dao.Addusuario(usu.getId_usuario(), j4);
            packjogadoresabre p1 = new packjogadoresabre(usu);
            packabre k1 = new packabre(usu);
            p1.fecharTela(); k1.abreTela();
        }
        
        public void Vende(){
            UsuarioDAO dao = new UsuarioDAO();
            usu.setDinheiro(usu.getDinheiro() + 2500);
            dao.Adddinheiro(usu.getId_usuario(), usu.getDinheiro());
            packjogadoresabre p1 = new packjogadoresabre(usu);
            packabre k1 = new packabre(usu);        
            p1.fecharTela(); k1.abreTela();
        }
        
        public void Inicia(){
            obslista = dao.selectJogador();
            for(int i = 0;i<obslista.size();i++){
                num++;
            }
        }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Inicia();
        JogadorAleatorio();
               
        ivjogador1.setOnMouseEntered(value->{
            ivjogador1.setFitHeight(250);
            ivjogador1.setFitWidth(172);
        });   
        ivjogador1.setOnMouseExited(value->{
            ivjogador1.setFitHeight(235);
            ivjogador1.setFitWidth(157);           
        });
        
         ivjogador2.setOnMouseEntered(value->{
            ivjogador2.setFitHeight(250);
            ivjogador2.setFitWidth(172);
        });   
        ivjogador2.setOnMouseExited(value->{
            ivjogador2.setFitHeight(235);
            ivjogador2.setFitWidth(157);           
        });
        
         ivjogador3.setOnMouseEntered(value->{
            ivjogador3.setFitHeight(250);
            ivjogador3.setFitWidth(172);
        });   
        ivjogador3.setOnMouseExited(value->{
            ivjogador3.setFitHeight(235);
            ivjogador3.setFitWidth(157);           
        });
        
         ivjogador4.setOnMouseEntered(value->{
            ivjogador4.setFitHeight(250);
            ivjogador4.setFitWidth(172);
        });   
        ivjogador4.setOnMouseExited(value->{
            ivjogador4.setFitHeight(235);
            ivjogador4.setFitWidth(157);           
        });
        
        btvender.setOnMouseEntered(value->{
            btvender.setPrefSize(98, 40); });
           
        btvender.setOnMouseExited(value->{            
            btvender.setPrefSize(92, 34);});
        
        btconcluir.setOnMouseEntered(value->{
            btconcluir.setPrefSize(98, 40); });
           
        btconcluir.setOnMouseExited(value->{            
            btconcluir.setPrefSize(92, 34);});
        
        btconcluir.setOnMouseClicked(value->{
            Adiciona();
        });
        
        btvender.setOnMouseClicked(value->{
            Vende();
        });
    }    
    
}
