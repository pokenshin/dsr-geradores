package br.com.desireworld.core;

public class ValorMag {
    private int valor;
    private int mag;

    public ValorMag(int valor, int mag) {
        this.valor = valor;
        this.mag = mag;
    }

    public ValorMag(String texto) {
        if (texto != null && texto != ""){
            this.valor = Integer.parseInt(texto.split(",")[0]);
            this.mag = Integer.parseInt(texto.split(",")[1]);
        } else{
            this.valor = 0;
            this.mag = 0;
        }
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getMag() {
        return mag;
    }

    public void setMag(int mag) {
        this.mag = mag;
    }

    public String toString(){
        return this.valor + "m" + this.mag;
    }
}
