//package org.example;
//
//import org.junit.rules.ExpectedException;
//import org.junit.runners.MethodSorters;
//
//@FixMethodOrder(MethodSorters.DEFAULT) // Com isso conseguimos ordenar. Default = sem ordem. ASCENDING = roda na ordem alfabetica
//public class CarroTestJUnit4 {
//
//
//    //ANOTAÇÕES IMPORTANTES PARA OS TESTES: MAIS ÚTEIS QUANDO UTILIZAR STRING E ALGUMAS LIBS
//
//    //@Before @BeforeClass @After @AfterClass (JUnit4)
//
//    @Before //ACONTECE SEMPRE ANTES DE TODO TESTE
//    public void before(){
//        System.out.println("Antes de cada teste!");
//    }
//
//    @BeforeClass // RODA ANTES MESMO DA INSTANCIA DA PROPRIA CLASSE, OU SEJA, TEM QUE SER ESTATICO
//    public static void beforeClass() {
//        System.out.println("Before class");
//    }
//
//    @AfterClass // RODA depois DA INSTANCIA DA PROPRIA CLASSE SER DESTRUIDA, OU SEJA, TEM QUE SER ESTATICO
//    public static void afterClass() {
//        System.out.println("After class");
//    }
//
//    @After
//    public void after() {
//        System.out.println("Depois de cada teste!");
//    }
//
//    @Test
//    public void deveIniciarDesligado(){
//        Carro carro = new Carro();
//
//        Assert.assertTrue(carro.getLigado() == false);
//
//    }
//
//    @Test
//    public void deveIniciarComVelZero(){
//        // Teste #2 - Deve iniciar com velocidade Zero
//        Carro carro = new Carro();
//
//        Assert.assertTrue(carro.getVelocidadeInstantanea() == 0);
//    }
//
//    @Test
//    public void deveLigarCorretamente(){
//        // Teste #2 - Deve iniciar com velocidade Zero
//        Carro carro = new Carro();
//        carro.ligar();
//        Assert.assertEquals(true, carro.getLigado());
//    }
//
//    @Test
//    public void deveDesligarCorretamente(){
//        // Teste #2 - Deve iniciar com velocidade Zero
//        Carro carro = new Carro();
//        carro.ligar();
//        carro.desligar();
//        Assert.assertFalse(carro.getLigado());
//
//
//    }
//
//    @Test
//    public void deveAcelerarCorretamente() throws Exception{
//        // Teste #2 - Deve iniciar com velocidade Zero
//        Carro carro = new Carro();
//        carro.ligar();
//        carro.acelerar(10);
//        Assert.assertEquals((Integer) 10, carro.getVelocidadeInstantanea());
//    }
//
//    @Test
//    public void naoDeveUltrapassarVelocidadeMaxima()throws Exception{
//        // Teste #2 - Deve iniciar com velocidade Zero
//        Carro carro = new Carro();
//        carro.ligar();
//        carro.acelerar(1000);
//        Assert.assertEquals((Integer) 200, carro.getVelocidadeInstantanea());
//    }
//
//    @Test
//    public void naoDeveTerVelocidadeNegativa()throws Exception {
//        // Teste #2 - Deve iniciar com velocidade Zero
//        Carro carro = new Carro();
//        carro.ligar();
//        carro.acelerar(100);
//        carro.frear(1000);
//        Assert.assertEquals((Integer) 0, carro.getVelocidadeInstantanea());
//    }
//
//    @Test
//    @Ignore
//    public void test(){
//
//    }
//
//
//
//    @Test
//    public void deveLancarExceptionEmCasoDeAcelerarNegativo() throws Exception{
//        Carro carro = new Carro();
//        carro.ligar();
//        carro.acelerar(-10);
//    }
//
//
//    @Test(expected = Exception.class) //Perigoso usar ese metodo pois a exception pode vir de outro lugar, n do objetivo do teste. Por exemplo o ligar pode lançar uma exception no lugar do acelerar e o este vai continuar passando
//    public void deveLancarExceptionEmCasoDeAcelerarNegativo01() throws Exception{
//        Carro carro = new Carro();
//        carro.ligar();
//        carro.acelerar(-10);
//    }
//
//
//    @Rule
//    public ExpectedException expectedException = ExpectedException.none();
//    @Test(expected = Exception.class) //Não usar tb
//    public void deveLancarExceptionEmCasoDeAcelerarNegativo02() throws Exception{
//        Carro carro = new Carro();
//        carro.ligar();
//
//        expectedException.expect((Exception.class));
//        //expectedException.expectMessage("A aceleracao pode ser negativa");
//        expectedException.expectMessage("A aceleração não aceita valores negativos!");
//
//        carro.acelerar(-10);
//    }
//
//
//
//    @Test
//    public void deveLancarExceptionEmCasoDeAcelerarNegativo03(){
//        Carro carro = new Carro();
//        carro.ligar();
//
//        try{
//            carro.acelerar(-10);
//            Assert.fail(); // Para impedir que passe o teste sem pegar a exception
//        } catch (Exception e){
//            Assert.assertEquals("A aceleração não aceita valores negativos!",e.getMessage());
////            Assert.assertThrows();
//        }
//    }
//
//    @Test
//    public void deveLancarExceptionEmCasoDeAcelerarNegativo04(){
//
//        //SOMENTE JUnit 4.13 ou JUnit 5 em diante
//        Carro carro = new Carro();
//        carro.ligar();
//        Assert.assertThrows(Exception.class, () -> carro.acelerar(-10)); // Com a lambda estou passando um runnable
//
//    }
//
//    @Test
//    public void deveLancarExceptionEmCasoDeAcelerarNegativo05(){
//        Carro carro = new Carro();
//        carro.ligar();
//
//        Throwable throwable = Assert.assertThrows(Exception.class, () -> carro.acelerar(-10)); // Com a lambda estou passando um runnable
//        Assert.assertEquals("A aceleração não aceita valores negativos!",throwable.getMessage());
//    }
//
//    @Test
//    public void testeSemAssertiva() {
//        //Teste sem assertiva passa!
//    }
//
//
//    //PRINCIPIO F.I.R.S.T -> SERVE PARA TODOS OS TESTES MAS FOCO EM TESTE UNITÁRIO. Define um bom teste
//
//    // F -> FAST.
//
//    // I -> Independente/Isolado, Não deve depender de outro teste!
//
//    // R -> Repetable. Pode rodar infinitas vezes sem dar problema
//
//    // S -> Self-Vaidating. O teste sabe quando sua execição passou e quando falhou
//
//    // T -> Timely. Tem que ser escrito em um momento oportuno. Melhor quando esta escrevendo a funcionalidade. !!! Famoso TDD !!! -> Escrever o teste antes de ser criado.
//    // Thorough -> Outro nome
//
//}
