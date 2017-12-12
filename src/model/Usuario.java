
package model;

public class Usuario {
    
    String nome, senha, foto, time, tema, fotocard, nomecard;
    double dinheiro;
    int id_usuario, id_copa, id_liga, id_time, defesa, velocidade, drible, chute, passe, fisico;
    boolean modoreal,adm;
    
    // modoreal,, idcopa,liga,time,partida
    
 /////////////////////////////////////////////////////////////////////   

    public Usuario(String nome, String senha, String foto, String time, double dinheiro, int id_usuario, int id_copa, int id_liga, int id_time, boolean modoreal, boolean adm, String tema, String nomecard, String fotocard, int defesa, int velocidade, int drible, int chute, int passe, int fisico) {
        this.nome = nome;
        this.senha = senha;
        this.foto = foto;
        this.time = time;
        this.dinheiro = dinheiro;
        this.id_usuario = id_usuario;
        this.id_copa = id_copa;
        this.id_liga = id_liga;
        this.id_time = id_time;
        this.modoreal = modoreal;
        this.adm = adm;
        this.tema = tema;
        this.nomecard = nomecard;
        this.fotocard = fotocard;
        this.defesa = defesa;
        this.velocidade = velocidade;
        this.drible = drible;
        this.passe = passe;
        this.chute = chute;
        this.fisico = fisico;
    }

    public String getFotocard() {
        return fotocard;
    }

    public void setFotocard(String fotocard) {
        this.fotocard = fotocard;
    }

    public String getNomecard() {
        return nomecard;
    }

    public void setNomecard(String nomecard) {
        this.nomecard = nomecard;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getDrible() {
        return drible;
    }

    public void setDrible(int drible) {
        this.drible = drible;
    }

    public int getChute() {
        return chute;
    }

    public void setChute(int chute) {
        this.chute = chute;
    }

    public int getPasse() {
        return passe;
    }

    public void setPasse(int passe) {
        this.passe = passe;
    }

    public int getFisico() {
        return fisico;
    }

    public void setFisico(int fisico) {
        this.fisico = fisico;
    }
    
    
    
    public Usuario() {

    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
    

    public boolean isAdm() {
        return adm;
    }

    public void setAdm(boolean adm) {
        this.adm = adm;
    }
    
    
    
    public int getId_copa() {
        return id_copa;
    }

    public void setId_copa(int id_copa) {
        this.id_copa = id_copa;
    }

    public int getId_liga() {
        return id_liga;
    }

    public void setId_liga(int id_liga) {
        this.id_liga = id_liga;
    }

    public int getId_time() {
        return id_time;
    }

    public void setId_time(int id_time) {
        this.id_time = id_time;
    }

    public boolean isModoreal() {
        return modoreal;
    }

    public void setModoreal(boolean modoreal) {
        this.modoreal = modoreal;
    }
    
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(double dinheiro) {
        this.dinheiro = dinheiro;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    

    
    
    
}
