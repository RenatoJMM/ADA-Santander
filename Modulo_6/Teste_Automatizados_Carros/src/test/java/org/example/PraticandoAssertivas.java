//package org.example;
//
//import org.example.Carro;
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.hamcrest.CoreMatchers.not;
//import org.junit.Assert;
//import org.junit.Test;
//
//public class PraticandoAssertivas {
//
//    @Test
//    public void praticandoAssertTrue(){
//        Boolean maiorDeIdade = true;
//
//        Assert.assertTrue(maiorDeIdade);
//    }
//
//    @Test
//    public void praticandoAssertFalse(){
//        Boolean foiReprovado = false;
//
//        Assert.assertFalse(foiReprovado);
//    }
//
//    @Test
//    public void praticandoAssertNull(){
//        Boolean foiReprovado = null;
//
//        Assert.assertNull(foiReprovado);
//    }
//
//    @Test
//    public void praticandoAssertNotNull(){
//        Boolean foiReprovado = true;
//
//        Assert.assertNotNull(foiReprovado);
//    }
//
//    @Test
//    public void praticandoAssertArraysEquals(){
//        int[] nums = new int[]{1,2,3};
////        int[] nums2 = new int[]{2,1,3};
//        int[] nums2 = new int[]{1,2,3};
//
//
//        Assert.assertArrayEquals(nums,nums2);
//    }
//
//    @Test
//    public void praticandoAssertEqualsPrimitivos(){
//        int a = 1;
//        int b = 1;
//
//        Assert.assertEquals(a,b);
//
//        char c1 = 'a';
//        char c2 = 'a';
//
//        Assert.assertEquals(c1,c2);
//    }
//
//    @Test
//    public void praticandoAssertEquals_objetos(){
//        Carro carro = new Carro("azul","fiat","uno");
//        Carro carro2 = new Carro("preto","fiat","uno");
//
//        Assert.assertEquals(carro2,carro);
//    }
//
//    @Test
//    public void praticandoAssertEqualsDetalheNasStrings(){
//        String nome1 = "Renato";
//        String nome2 = "Renato";
//        String nome3 = new String("Renato");
//
//        Assert.assertEquals(nome1,nome2);
//        Assert.assertEquals(nome1,nome3);
//
//        Assert.assertTrue(nome1 == nome2);
//        Assert.assertTrue(nome1 == nome3); // ESSE DA ERRO, PQ
//
//    }
//
//    @Test
//    public void praticandoAssertNotEqualS(){
//        int a = 1;
//        int b = 2;
//
//        Assert.assertNotEquals(a,b);
//    }
//
//    @Test
//    public void praticandoAssertSame(){
//        Integer a = 1;
//        Integer b = 1;
//
//        Assert.assertSame(a,b);
//
//        Assert.assertEquals(Math.PI, 3.141592,0.000001);
//    }
//
//    @Test
//    public void praticandoAssertNotSame(){
//        Carro car1 = new Carro();
//        Carro car2 = new Carro();
//
//        Assert.assertNotSame(car1,car2);
//    }
//
//
//    @Test
//    public void praticandoAssertThat(){
//        int a = 1;
//        int b = 1;
//
////        Assert.assertThat(a, CoreMatchers.is(CoreMatchers.equalTo(b)));
//        Assert.assertThat(a, is(equalTo(b))); // Igual a fazer Assert.assetEquals(a,b)
//
//        String s1 = "Renato";
//        String s2 = "Julia";
//
//        Assert.assertThat(s1, is(not(s2)));
//    }
//}
