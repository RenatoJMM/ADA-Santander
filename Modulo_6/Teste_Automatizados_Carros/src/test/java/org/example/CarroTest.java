package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*; // FAZ ISSO PARA PEGAR TUDO DO ASSERTIONS SEM PRECISAR TODA HORA CHAMAR ASSERTIONS


public class CarroTest {
    //PRINCIPIO F.I.R.S.T -> SERVE PARA TODOS OS TESTES MAS FOCO EM TESTE UNITÁRIO. Define um bom teste

    // F -> FAST.

    // I -> Independente/Isolado, Não deve depender de outro teste!

    // R -> Repetable. Pode rodar infinitas vezes sem dar problema

    // S -> Self-Vaidating. O teste sabe quando sua execição passou e quando falhou

    // T -> Timely. Tem que ser escrito em um momento oportuno. Melhor quando esta escrevendo a funcionalidade. !!! Famoso TDD !!! -> Escrever o teste antes de ser criado.
    // Thorough -> Outro nome



    // Before e BeforeClass muda para BerofeEach e BeforeAll. Mesma lógica para o After

    @BeforeEach //ACONTECE SEMPRE ANTES DE TODO TESTE
    public void before(){
        System.out.println("Antes de cada teste!");
    }

    @BeforeAll // RODA ANTES MESMO DA INSTANCIA DA PROPRIA CLASSE, OU SEJA, TEM QUE SER ESTATICO
    public static void beforeClass() {
        System.out.println("Before All");
    }


    // @Ignore virou @Disabled
    // @Test
    @Test
    @Disabled
    public void deveIniciarDesligado(){
        Carro carro = new Carro();

        Assertions.assertTrue(carro.getLigado() == false);

        //Com as novas assertions só nao existe assertThat.
    }


    @Test
    @DisplayName("Teste com nome Bonitinho, frufru") // Mudar nome do teste para florear
    public void deveIniciarComVelZero(){
        // Teste #2 - Deve iniciar com velocidade Zero
        Carro carro = new Carro();

        Assertions.assertTrue(carro.getVelocidadeInstantanea() == 0);
    }

    // COM O JUnit 5 tem duas novas assertivas:

    // !!!! assertAll e assertThrows !!!!

    @Test
    public void deveCriarUmCarroComTodosOsCampos() {
        Carro carro = new Carro("Verde","Ford","Ranger",true,0,300,true);


        Assertions.assertAll( "Testando atributos do carro criado!",
                () -> Assertions.assertEquals("Verd",carro.getCor()),
                () -> Assertions.assertEquals("For",carro.getMarca()),
                () -> Assertions.assertEquals("Ranger",carro.getModelo()),
                () -> Assertions.assertEquals(300,carro.getVelocidadeMaxima())

        );
//        Fazendo desse jeito abaixo, só testa um de cada vez. Se der erro só mostra o primeiro que errou

//        Assertions.assertEquals("Verde",carro.getCor());
//        Assertions.assertEquals("Ford",carro.getMarca());
//        Assertions.assertEquals("Ranger",carro.getModelo());
//        Assertions.assertEquals(300,carro.getVelocidadeMaxima());

    }

    @Test
    public void deveCriarUmCarroComTodosOsCampos2() {
        Carro carro = new Carro("Verde","Ford","Ranger",true,0,300,true);


        Assertions.assertAll( "Testando atributos do carro criado!",
                () -> Assertions.assertEquals("Verd",carro.getCor()),
                () -> Assertions.assertEquals("For",carro.getMarca()),
                () -> Assertions.assertEquals("Ranger",carro.getModelo()),
                () -> Assertions.assertEquals(300,carro.getVelocidadeMaxima())

        );

    }

    // Teste Unitário (caixa branca) - Teste de Integração (integração de modulos) (caixa branca) - Teste E2E (End to End) (todo o ciclo de vida) (caixa preta)

    // mais barato - - Mais caro
    // mais rapido - - Mais lento
    // menos integrado - - Mais integrado

}
