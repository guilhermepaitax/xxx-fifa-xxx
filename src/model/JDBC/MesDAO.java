
package model.JDBC;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MesDAO {
    
    private static ObservableList<String> meses = FXCollections.observableArrayList();
    private static int control = 0;
    
    private static void startMeses(){
        meses.addAll("Jan", "Fev", "Mar", "Abr",
                "Mai", "Jun", "Jul", "Ago", "Set", "Out",
                "Nov", "Dez");
        control = 1;
    }
    
    public static ObservableList<String> getMeses(){
        if (control == 0) {
            startMeses();
        }
        return meses;
        
    }
    
}
