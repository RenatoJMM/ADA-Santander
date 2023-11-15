package org.example;

import java.util.Objects;

public class Carro {

    private String cor;
    private String marca;
    private String modelo;
    private Boolean ligado;
    private Integer velocidadeInstantanea;
    private Integer velocidadeMaxima;

    private Boolean trancadado;

    public Carro(String cor, String marca, String modelo, Integer velocidadeMaxima) {
        this.cor = cor;
        this.marca = marca;
        this.modelo = modelo;
        this.ligado = false;
        this.velocidadeInstantanea = 0;
        this.velocidadeMaxima = velocidadeMaxima;
        this.trancadado = true;
    }

    public void trancar(){

        if(this.trancadado){
            System.out.println("Ja esta trancado!");
        }
        setTrancadado(true);
    }

    public void destrancar(){

        if(this.trancadado){
            System.out.println("Ja esta destrancado!");
        }
        setTrancadado(false);
    }

    public void ligar() {
        setLigado(true);
    }

    public void desligar() {
        setLigado(false);
    }

    public void frear(Integer velocidade) {
        if(0 > this.velocidadeInstantanea - velocidade){
            this.velocidadeInstantanea = 0;
        } else{
            this.velocidadeInstantanea -= velocidade;
        }
    }

    public void acelerar(Integer velocidade) throws Exception {

        if(velocidade < 0){
            throw new Exception("A aceleração não aceita valores negativos!");
        }
        if(this.velocidadeMaxima > this.velocidadeInstantanea + velocidade){
            this.velocidadeInstantanea += velocidade;
        } else {
            setVelocidadeInstantanea(getVelocidadeMaxima());
        }

    }

    public void pintar(String cor) {
        setCor(cor);
    }

    public void alterarVelocidadeMaximaDevidoAModificacaoDoCarro(Integer velocidadeMaxima) {
        setVelocidadeMaxima(velocidadeMaxima);
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

    public Boolean getTrancadado() {
        return trancadado;
    }

    public void setTrancadado(Boolean trancadado) {
        this.trancadado = trancadado;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carro carro = (Carro) o;
        return Objects.equals(marca, carro.marca) && Objects.equals(modelo, carro.modelo);
    }


}
