package model;

public class Time {
    
    private String nome, fundador, abreviacao, senha, emblema, estado, uniforme;
    private boolean sen;
    private int id_time;

    public Time(String nome, String fundador, String abreviacao, String senha, String emblema, String estado, String uniforme, boolean sen, int id_time) {
        this.nome = nome;
        this.fundador = fundador;
        this.abreviacao = abreviacao;
        this.senha = senha;
        this.emblema = emblema;
        this.estado = estado;
        this.uniforme = uniforme;
        this.sen = sen;
        this.id_time = id_time;
    }

    public Time() {

    }
    
    
    
///////////////////////////////////////////////////////////////////////////////

    public int getId_time() {
        return id_time;
    }

    public void setId_time(int id_time) {
        this.id_time = id_time;
    }        
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFundador() {
        return fundador;
    }

    public void setFundador(String fundador) {
        this.fundador = fundador;
    }

    public String getAbreviacao() {
        return abreviacao;
    }

    public void setAbreviacao(String abreviacao) {
        this.abreviacao = abreviacao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmblema() {
        return emblema;
    }

    public void setEmblema(String emblema) {
        this.emblema = emblema;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isSen() {
        return sen;
    }

    public void setSen(boolean sen) {
        this.sen = sen;
    }

    public String getUniforme() {
        return uniforme;
    }

    public void setUniforme(String uniforme) {
        this.uniforme = uniforme;
    }

    @Override
    public String toString() {
        return getNome();
    }
    
    
    
}
