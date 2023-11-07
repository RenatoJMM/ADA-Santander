package org.example;

import org.example.Carro;
import org.junit.*;

public class CarroTest {


    //ANOTAÇÕES IMPORTANTES PARA OS TESTES: MAIS ÚTEIS QUANDO UTILIZAR STRING E ALGUMAS LIBS

    //@Before @BeforeClass @After @AfterClass (JUnit4)

    @Before //ACONTECE SEMPRE ANTES DE TODO TESTE
    public void before(){
        System.out.println("Antes de cada teste!");
    }

    @BeforeClass // RODA ANTES MESMO DA INSTANCIA DA PROPRIA CLASSE, OU SEJA, TEM QUE SER ESTATICO
    public static void beforeClass() {
        System.out.println("Before class");
    }

    @AfterClass // RODA depois DA INSTANCIA DA PROPRIA CLASSE SER DESTRUIDA, OU SEJA, TEM QUE SER ESTATICO
    public static void afterClass() {
        System.out.println("After class");
    }

    @After
    public void after() {
        System.out.println("Depois de cada teste!");
    }

    @Test
    public void deveIniciarDesligado(){
        Carro carro = new Carro();

        Assert.assertTrue(carro.getLigado() == false);

    }

    @Test
    public void deveIniciarComVelZero(){
        // Teste #2 - Deve iniciar com velocidade Zero
        Carro carro = new Carro();

        Assert.assertTrue(carro.getVelocidadeInstantanea() == 0);
    }

    @Test
    public void deveLigarCorretamente(){
        // Teste #2 - Deve iniciar com velocidade Zero
        Carro carro = new Carro();
        carro.ligar();
        Assert.assertEquals(true, carro.getLigado());
    }

    @Test
    public void deveDesligarCorretamente(){
        // Teste #2 - Deve iniciar com velocidade Zero
        Carro carro = new Carro();
        carro.ligar();
        carro.desligar();
        Assert.assertFalse(carro.getLigado());
    }

    @Test
    public void deveAcelerarCorretamente(){
        // Teste #2 - Deve iniciar com velocidade Zero
        Carro carro = new Carro();
        carro.ligar();
        carro.acelerar(10);
        Assert.assertEquals((Integer) 10, carro.getVelocidadeInstantanea());
    }

    @Test
    public void naoDeveUltrapassarVelocidadeMaxima(){
        // Teste #2 - Deve iniciar com velocidade Zero
        Carro carro = new Carro();
        carro.ligar();
        carro.acelerar(1000);
        Assert.assertEquals((Integer) 200, carro.getVelocidadeInstantanea());
    }

    @Test
    public void naoDeveTerVelocidadeNegativa(){
        // Teste #2 - Deve iniciar com velocidade Zero
        Carro carro = new Carro();
        carro.ligar();
        carro.acelerar(100);
        carro.frear(1000);
        Assert.assertEquals((Integer) 0, carro.getVelocidadeInstantanea());
    }
}
