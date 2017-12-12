package control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import model.JDBC.UsuarioDAO;
import model.Usuario;
import view.manage.realprincipalabre;
import view.manage.temaabre;

public class TemaController implements Initializable {

    @FXML private ImageView ivunited, ivbarca, ivpsg, ivcity, ivreal, ivadidas, ivnike;
    private static Usuario usu;
    UsuarioDAO dao = new UsuarioDAO();

    public static Usuario getUsu() {
        return usu;
    }

    public static void setUsu(Usuario usu) {
        TemaController.usu = usu;
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        ivunited.setOnMouseEntered(value->{
            ivunited.setFitHeight(149);
            ivunited.setFitWidth(153);
        });   
        ivunited.setOnMouseExited(value->{
            ivunited.setFitHeight(139);
            ivunited.setFitWidth(143);           
        });
        
        ivbarca.setOnMouseEntered(value->{
            ivbarca.setFitHeight(149);
            ivbarca.setFitWidth(153);
        });   
        ivbarca.setOnMouseExited(value->{
            ivbarca.setFitHeight(139);
            ivbarca.setFitWidth(143);           
        });
        
        ivpsg.setOnMouseEntered(value->{
            ivpsg.setFitHeight(149);
            ivpsg.setFitWidth(153);
        });   
        ivpsg.setOnMouseExited(value->{
            ivpsg.setFitHeight(139);
            ivpsg.setFitWidth(143);           
        });
        
        ivcity.setOnMouseEntered(value->{
            ivcity.setFitHeight(149);
            ivcity.setFitWidth(153);
        });   
        ivcity.setOnMouseExited(value->{
            ivcity.setFitHeight(139);
            ivcity.setFitWidth(143);           
        });
        
        ivreal.setOnMouseEntered(value->{
            ivreal.setFitHeight(149);
            ivreal.setFitWidth(153);
        });   
        ivreal.setOnMouseExited(value->{
            ivreal.setFitHeight(139);
            ivreal.setFitWidth(143);           
        });
        
        ivadidas.setOnMouseEntered(value->{
            ivadidas.setFitHeight(149);
            ivadidas.setFitWidth(153);
        });   
        ivadidas.setOnMouseExited(value->{
            ivadidas.setFitHeight(139);
            ivadidas.setFitWidth(143);           
        });
        
        ivnike.setOnMouseEntered(value->{
            ivnike.setFitHeight(149);
            ivnike.setFitWidth(153);
        });   
        ivnike.setOnMouseExited(value->{
            ivnike.setFitHeight(139);
            ivnike.setFitWidth(143);           
        });
        
        ivadidas.setOnMouseClicked(value->{
            dao.AddTema("adidas.jpg", usu.getId_usuario());
            dao.Addmodoreal(true, usu.getId_usuario());
            temaabre t1 = new temaabre(usu);
            realprincipalabre r1 = new realprincipalabre(usu);
            t1.fecharTela(); r1.abreTela();
        });
        
        ivbarca.setOnMouseClicked(value->{
            dao.AddTema("barca.jpg", usu.getId_usuario());
            dao.Addmodoreal(true, usu.getId_usuario());
            temaabre t1 = new temaabre(usu);
            realprincipalabre r1 = new realprincipalabre(usu);
            t1.fecharTela(); r1.abreTela();
        });
        
        ivcity.setOnMouseClicked(value->{
            dao.AddTema("city.png", usu.getId_usuario());
            dao.Addmodoreal(true, usu.getId_usuario());
            temaabre t1 = new temaabre(usu);
            realprincipalabre r1 = new realprincipalabre(usu);
            t1.fecharTela(); r1.abreTela();
        });
        ivnike.setOnMouseClicked(value->{
            dao.AddTema("nike1.jpg", usu.getId_usuario());
            dao.Addmodoreal(true, usu.getId_usuario());
            temaabre t1 = new temaabre(usu);
            realprincipalabre r1 = new realprincipalabre(usu);
            t1.fecharTela(); r1.abreTela();
        });
        ivpsg.setOnMouseClicked(value->{
            dao.AddTema("psg.jpg", usu.getId_usuario());
            dao.Addmodoreal(true, usu.getId_usuario());
            temaabre t1 = new temaabre(usu);
            realprincipalabre r1 = new realprincipalabre(usu);
            t1.fecharTela(); r1.abreTela();
        });
        ivreal.setOnMouseClicked(value->{
            dao.AddTema("real.jpg", usu.getId_usuario());
            dao.Addmodoreal(true, usu.getId_usuario());
            temaabre t1 = new temaabre(usu);
            realprincipalabre r1 = new realprincipalabre(usu);
            t1.fecharTela(); r1.abreTela();
        });
        ivunited.setOnMouseClicked(value->{
            dao.AddTema("united.jpg", usu.getId_usuario());
            dao.Addmodoreal(true, usu.getId_usuario());
            temaabre t1 = new temaabre(usu);
            realprincipalabre r1 = new realprincipalabre(usu);
            t1.fecharTela(); r1.abreTela();
        });
    }    
    
}
