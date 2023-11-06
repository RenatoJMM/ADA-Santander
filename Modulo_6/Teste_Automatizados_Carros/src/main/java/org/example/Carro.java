package org.example;

public class Carro {

    private String cor;
    private String marca;
    private String modelo;
    private Boolean ligado;
    private Integer velocidadeInstantanea;
    private Integer velocidadeMaxima;

    public Carro() {
        this.ligado = false;
        this.velocidadeInstantanea = 0;
    }

    public void ligar() {
        this.ligado = true;
    }

    public void desligar() {
        this.ligado = false;
    }

    public void acelerar(Integer velocidade) {

        this.velocidadeInstantanea += velocidade;
    }

    public void frear(Integer velocidade) {
        this.velocidadeInstantanea -= velocidade;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Boolean getLigado() {
        return ligado;
    }

    public void setLigado(Boolean ligado) {
        this.ligado = ligado;
    }

    public Integer getVelocidadeInstantanea() {
        return velocidadeInstantanea;
    }

    public void setVelocidadeInstantanea(Integer velocidadeInstantanea) {
        this.velocidadeInstantanea = velocidadeInstantanea;
    }

    public Integer getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public void setVelocidadeMaxima(Integer velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }
}
