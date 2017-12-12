package model;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

public class Partida {
    
    private String time1, time2, localizacao, hora;
    private String dia;
    private int id_partida, id_time1, id_time2;

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    
    
    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    public int getId_time1() {
        return id_time1;
    }

    public void setId_time1(int id_time1) {
        this.id_time1 = id_time1;
    }

    public int getId_time2() {
        return id_time2;
    }

    public void setId_time2(int id_time2) {
        this.id_time2 = id_time2;
    }
    
    

    

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }


    public int getId_partida() {
        return id_partida;
    }

    public void setId_partida(int id_partida) {
        this.id_partida = id_partida;
    }
    
    
    
}
