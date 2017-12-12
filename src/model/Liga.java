
package model;

public class Liga {
    
    private String nome;
    private int quantidade, id_liga;
    private double premio, valorpartida;
    /////////////////////////////////////

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPremio() {
        return premio;
    }

    public void setPremio(double premio) {
        this.premio = premio;
    }

    public double getValorpartida() {
        return valorpartida;
    }

    public void setValorpartida(double valorpartida) {
        this.valorpartida = valorpartida;
    }

    public int getId_liga() {
        return id_liga;
    }

    public void setId_liga(int id_liga) {
        this.id_liga = id_liga;
    }

    
    
    
}
