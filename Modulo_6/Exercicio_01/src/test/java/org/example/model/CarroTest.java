package org.example.model;

import org.example.Carro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarroTest {


    @Test
    public void deveIniciarDesligado() {
        Carro carro = new Carro("Vermelho","Ferrari","Purosangue",310);

        Assertions.assertFalse(carro.getLigado());
    }

    @Test
    public void deveIniciarComVelocidadeInstantaneaIgualAZero() {
        Carro carro = new Carro("Vermelho","Ferrari","Purosangue",310);

        Assertions.assertEquals(carro.getVelocidadeInstantanea(),0);
    }

    @Test
    public void deveIniciarTrancado() {
        Carro carro = new Carro("Vermelho","Ferrari","Purosangue",310);

        Assertions.assertTrue(carro.getTrancadado());
    }

    @Test
    public void deveDestrancarCorretamente() {
        Carro carro = new Carro("Vermelho","Ferrari","Purosangue",310);

        carro.destrancar();
        Assertions.assertFalse(carro.getTrancadado());
    }

    @Test
    public void deveTrancarCorretamente() {
        Carro carro = new Carro("Vermelho","Ferrari","Purosangue",310);

        carro.trancar();
        Assertions.assertTrue(carro.getTrancadado());
    }

    @Test
    public void deveLigarCorretamente() {
        Carro carro = new Carro("Vermelho","Ferrari","Purosangue",310);

        carro.ligar();
        Assertions.assertTrue(carro.getLigado());
    }

    @Test
    public void deveDesligarCorretamente() {
        Carro carro = new Carro("Vermelho","Ferrari","Purosangue",310);

        carro.ligar();
        carro.desligar();
        Assertions.assertFalse(carro.getLigado());
    }

    @Test
    public void deveAcelerarCorretamente() throws Exception{
        Carro carro = new Carro("Vermelho","Ferrari","Purosangue",310);

        carro.acelerar(100);
        carro.acelerar(100);
        Assertions.assertEquals(carro.getVelocidadeInstantanea(),200);
    }

    @Test
    public void deveFrearCorretamente() throws Exception{
        Carro carro = new Carro("Vermelho","Ferrari","Purosangue",310);

        carro.acelerar(100);
        carro.frear(50);
        carro.frear(40);
        Assertions.assertEquals(carro.getVelocidadeInstantanea(),10);
    }

    @Test
    public void naoDevePassarDaVelocidadeMaxima() throws Exception{
        Carro carro = new Carro("Vermelho","Ferrari","Purosangue",310);

        carro.acelerar(200);
        carro.acelerar(200);
        Assertions.assertEquals(carro.getVelocidadeInstantanea(),310);
    }

    @Test
    public void naoPodeTerVelocidadeInstantaneaMenorQueZero() throws Exception{
        Carro carro = new Carro("Vermelho","Ferrari","Purosangue",310);

        carro.acelerar(200);
        carro.frear(210);
        Assertions.assertEquals(carro.getVelocidadeInstantanea(),0);
    }

    @Test
    public void naoDeveAceitarVelocidadeNegativa() {
        Carro carro = new Carro("Vermelho","Ferrari","Purosangue",310);

        Throwable throwable = Assertions.assertThrows(Exception.class, () -> carro.acelerar(-50));
        Assertions.assertEquals("A aceleração não aceita valores negativos!",throwable.getMessage());
    }

    @Test
    public void carrosComMarcaEModelosIguaisDevemSerIguais() {
        Carro carroRenato = new Carro("Vermelho","Ferrari","Purosangue",310);
        Carro carroJulia = new Carro("Azul","Ferrari","Purosangue",310);

        Assertions.assertEquals(carroJulia,carroRenato);
    }

    @Test
    public void carrosDeDiferentesDonosNaoDevemSerOMesmoCarro() {
        Carro carroRenato = new Carro("Vermelho","Ferrari","Purosangue",310);
        Carro carroJulia = new Carro("Azul","Ferrari","Purosangue",310);

        Assertions.assertNotSame(carroJulia,carroRenato);
    }

    @Test
    public void devePintarCarroCorretamente() {
        Carro carroRenato = new Carro("Vermelho","Ferrari","Purosangue",310);

        carroRenato.pintar("Amarelo");

        Assertions.assertEquals("Amarelo",carroRenato.getCor());
    }

    @Test
    public void deveAlterarVelocidadeMaximaCorretamenteDecorrenteDeModificacaoNoCarro() {
        Carro carroRenato = new Carro("Vermelho","Ferrari","Purosangue",310);

        carroRenato.alterarVelocidadeMaximaDevidoAModificacaoDoCarro(330);

        Assertions.assertTrue(330==carroRenato.getVelocidadeMaxima());
    }


}
