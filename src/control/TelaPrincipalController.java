
package control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;
import model.Usuario;
import view.manage.Escolheabre;
import view.manage.XxfifaxX;
import view.manage.ajusteabre;
import view.manage.copaabre;
import view.manage.ligaabre;
import view.manage.mercadoabre;
import view.manage.perfilabre;
import view.manage.principalabre;



public class TelaPrincipalController implements Initializable {

    
    @FXML private ImageView ivmbape, ivneymar, ivcoutinho, ivsair, ivemblema, ivlogo;
    @FXML private Pane btmercado, btcopa, btliga, btperfil, btajuste;
    @FXML private Label lbtexto, lbtime, lbdinheiro;
    @FXML private Hyperlink hyperyoutube, hyperface, hyperinsta;
    
     private static Usuario usu;

    public static Usuario getUsu() {
        return usu;
    }

    public static void setUsu(Usuario usu) {
        TelaPrincipalController.usu = usu;
    }
     
     
    
      public void Sair(){                         
                switch (JOptionPane.showConfirmDialog(null, "Deseja realmente sair?")) {
            case 0:                
                principalabre t1 = new principalabre(usu);
                t1.fecharTela();
               
                break;
            case 1:               
                break;
            case 2:               
                break;
                }          
            
    }
     
      public void foto(){
          Image image = new Image("/imagens/emblemas/" + usu.getFoto());
            ivemblema.setImage(image);         
      }
      
      
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        ivsair.setOnMouseExited(value->{
            ivsair.setFitHeight(71);
            ivsair.setFitWidth(70);
        });
        
        ivsair.setOnMouseEntered(value->{
            ivsair.setFitHeight(81);
            ivsair.setFitWidth(80);
        });
        
        btajuste.setOnMouseClicked(value->{
            ajusteabre a1 = new ajusteabre(usu);
            principalabre p1 = new principalabre(usu);
            p1.fecharTela(); a1.abreTela();                              
        });
        
        btperfil.setOnMouseClicked(value->{
            perfilabre p1 = new perfilabre(usu);
            principalabre t1 = new principalabre(usu);
            t1.fecharTela(); p1.abreTela();           
        });
        
        btcopa.setOnMouseClicked(value->{
            copaabre c1 = new copaabre(usu);
            principalabre t1 = new principalabre(usu);
            t1.fecharTela(); c1.abreTela();           
        });
        
        btliga.setOnMouseClicked(value->{
            ligaabre l1 = new ligaabre(usu);
            principalabre p1 = new principalabre(usu);
            p1.fecharTela(); l1.abreTela();            
        });
        
        btmercado.setOnMouseClicked(value->{
            mercadoabre m1 = new mercadoabre(usu);
            principalabre p1 = new principalabre(usu);
            p1.fecharTela(); m1.abreTela();
        });
        
        ivsair.setOnMouseClicked(value->{
            Sair();
        });
        
        lbdinheiro.setText(String.valueOf(usu.getDinheiro())); 
        lbtime.setText(usu.getTime());
        
        btajuste.setOnMouseEntered(value->{
            ivmbape.setVisible(true);
            btajuste.setOpacity(0);
        });
        btajuste.setOnMouseExited(value->{
            ivmbape.setVisible(false);
            btajuste.setOpacity(100);
        });
        btcopa.setOnMouseEntered(value->{
            btcopa.setOpacity(0);
        });
        btcopa.setOnMouseExited(value->{
            btcopa.setOpacity(100);
        });
        btliga.setOnMouseEntered(value->{
            btliga.setOpacity(0);
        });
        btliga.setOnMouseExited(value->{
            btliga.setOpacity(100);
        });
        btmercado.setOnMouseEntered(value->{
            ivneymar.setVisible(true);
            btmercado.setOpacity(0);
        });
        btmercado.setOnMouseExited(value->{
            ivneymar.setVisible(false);
            btmercado.setOpacity(100);
        });
        btperfil.setOnMouseEntered(value->{
            ivcoutinho.setVisible(true);
            btperfil.setOpacity(0);
        });
        btperfil.setOnMouseExited(value->{
            ivcoutinho.setVisible(false);
            btperfil.setOpacity(100);
        });
        foto();
        
        hyperyoutube.setOnAction(value->{
            try {
                Runtime.getRuntime().exec("cmd.exe /C start chrome.exe https://www.youtube.com/channel/UCBE8fEsIqG34P7c4DPELGfA");
            } catch (IOException ex) {
                Logger.getLogger(TelaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        hyperface.setOnAction(value->{
           try {
                Runtime.getRuntime().exec("cmd.exe /C start chrome.exe https://www.facebook.com/XFIFAOficial/");
            } catch (IOException ex) {
                Logger.getLogger(TelaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
            }  
        });
        
        hyperinsta.setOnAction(value->{
           try {
                Runtime.getRuntime().exec("cmd.exe /C start chrome.exe https://www.instagram.com/x.x.x_fifa_x.x.x/");
            } catch (IOException ex) {
                Logger.getLogger(TelaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
            }  
        });
        
        ivlogo.setOnMouseClicked(value->{          
                Escolheabre m1 = new Escolheabre(usu);
                principalabre p1 = new principalabre(usu);
                p1.fecharTela(); m1.abreTela();
                
        });
        
    }    
    
}
