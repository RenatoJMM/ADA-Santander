package Lecture_4;

public class Teste {

    public static void main(String[] args) {
        Veiculo gol = new Carro("123", "azul", "gol", 1998, 4, "diesel");

        Veiculo cb = new Moto("456", "roxo", "cb300", 2023, 300);

        cb.exibirDados();
        System.out.println();
        gol.exibirDados();

        System.out.println();

        imprimirDados(gol);
        System.out.println();
        imprimirDados(cb);
    }

    public static void imprimirDados(Veiculo veiculo) {
        veiculo.exibirDados();
    }
}
