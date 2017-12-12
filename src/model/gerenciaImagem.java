package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

public class gerenciaImagem {
    
    BufferedImage imagem;
    
    String urlOfPC = "C:\\Users\\Aluno\\Desktop\\XxfifaxX\\src\\imagens\\jogadores\\";
    String urlOfPCemblema = "C:\\Users\\Aluno\\Desktop\\XxfifaxX\\src\\imagens\\emblemas\\";
    
    public String getUrl() {
        return urlOfPC;
    }
    
    public String getNovaImagem(){
            
            String caminhoDaImagem;
            
            FileChooser telaEscolhoImagem = new FileChooser();
            telaEscolhoImagem.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imagens", "*.jpg", "*.jpeg", "*.png"));
            File arquivo = telaEscolhoImagem.showOpenDialog(new Stage());
            caminhoDaImagem = arquivo.getAbsolutePath();
            
            if (arquivo != null) {
                caminhoDaImagem = arquivo.getAbsolutePath();
            }

            return caminhoDaImagem;
        }  
            
        public String uploadUrl(String url, String text) {
            
        String newUrl = url.substring(url.length() - 3);        
        String caminhoImagem;        
        if(newUrl.equals("png")) {
            caminhoImagem = text + ".png";
        } else {
            caminhoImagem = text + ".jpg";
        }        
        try {
            BufferedImage imagem = ImageIO.read(new File(url));
            ImageIO.write(imagem, "PNG", new File(urlOfPC + caminhoImagem));
            
        } catch (IOException ex) {
            Logger.getLogger(gerenciaImagem.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return caminhoImagem;
    }
        
        public String uploadUrlEmblema(String url, String text) {
            
        String newUrl = url.substring(url.length() - 3);        
        String caminhoImagem;        
        if(newUrl.equals("png")) {
            caminhoImagem = text + ".png";
        } else {
            caminhoImagem = text + ".jpg";
        }        
        try {
            BufferedImage imagem = ImageIO.read(new File(url));
            ImageIO.write(imagem, "PNG", new File(urlOfPCemblema + caminhoImagem));
            
        } catch (IOException ex) {
            Logger.getLogger(gerenciaImagem.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return caminhoImagem;
    }
        
    
    }
