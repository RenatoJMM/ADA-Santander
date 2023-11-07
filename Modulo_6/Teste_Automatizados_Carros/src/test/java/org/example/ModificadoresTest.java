package org.example;

import org.example.Modificadores;
import org.junit.Test;

public class ModificadoresTest {


    @Test
    public void testandoModificadores(){
        Modificadores modificadores = new Modificadores();

        modificadores.publicTest();
        modificadores.defaultTest(); //SÓ CONSIGO ACESSAR PQ TA NA MESMA ESTRUTURA DE PACKAGES
        modificadores.protectedTest(); //SÓ CONSIGO ACESSAR PQ TA NA MESMA ESTRUTURA DE PACKAGES

    }
}
