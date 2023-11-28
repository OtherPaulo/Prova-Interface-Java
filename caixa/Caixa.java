package caixa;
//Paulo Vinicius Cruz Rodrigues - Matricula: 2268566
public class Caixa {
    private String modelo;
    private String tipo;
    private int tamanho;
    private double valor;

    public Caixa(String modelo, String tipo, int tamanho, double valor) {
        this.modelo = modelo;
        this.tipo = tipo;
        this.tamanho = tamanho;
        this.valor = valor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
