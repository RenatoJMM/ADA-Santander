package org.example;


public class Main {

    // Clean Arch | Hexagonal

    //Divide em duas partes:

    // Domain - Toda a regra de negócio - Java puro + libs

    // Infra - Tecnologias - Spring e outras libs (Mais http e etc) + DB

    // Teste -


    public static void main(String[] args) {
    }


    public void testes(){

        //Mauricio Aniche (cara foda de QA)

        // Junit - 4 e 5

        // Gherkin

        // Given (dado um certo cenário)
        // Eu tenho carro ligado

        // When (quando fizer algo)
        // acelerrar carr em 10

        // Then (espero algum cenário)
        // velocidadeInstantanea deve ser 10



        // Teste #1 - Deve iniciar desligado
        System.out.println("TESTE #1");
        Carro carro_01 = new Carro();
        System.out.println(carro_01.getLigado() == false);


        // Teste #2 - Deve iniciar com velocidade Zero
        System.out.println("TESTE #2");
        System.out.println(carro_01.getVelocidadeInstantanea() == 0);


        // Teste #3 - Deve ligar corretamente
        System.out.println("TESTE #3");
        Carro car03 = new Carro();
        car03.ligar();
        System.out.println(car03.getLigado() == true);


        // Teste #4 - Deve desligar corretamente um carro ligado
        System.out.println("TESTE #4");
        Carro car04 = new Carro();
        car04.ligar();
        car04.desligar();
        System.out.println(car04.getLigado() == false);

        // Teste #5 - Deve acelerar corretamente um caro ligado
        System.out.println("TESTE #5");
        Carro car05 = new Carro();
        car05.ligar();
        car05.acelerar(10);
        System.out.println(car05.getVelocidadeInstantanea() == 10);


    }



}