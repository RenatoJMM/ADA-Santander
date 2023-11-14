import org.example.Calculadora;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {

    // Red - Escrever um Test que falha

    // Green - Escrever o código MÍNIMO para o teste passar

    // Refactor - Melhorar o código

    @Test
    public void deveSomarCorretamente() {
        Calculadora calculadora = new Calculadora();

        int a = 5;
        int b = 100;

        int result = calculadora.somar(a,b);

        Assertions.assertEquals(105,result);

    }

    @Test
    public void deveDividirCorretamente() {
        Calculadora calculadora = new Calculadora();

        int a = 5;
        int b = 100;

        int result = calculadora.dividir(b,a);

        Assertions.assertEquals(20,result);

    }
}
