
package model;

public class Copa {
    
    private String nome;
    private int quantidade, id_copa;
    private double premio, valorpartida;
    ///////////////////////////////////////////////////////
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

    public int getId_copa() {
        return id_copa;
    }

    public void setId_copa(int id_copa) {
        this.id_copa = id_copa;
    }

    
    
    
}
