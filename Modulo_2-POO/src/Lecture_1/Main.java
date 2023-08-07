package Lecture_1;

public class Main {
    // public ->
    public static void main(String[] args) throws Exception { // Até as chaves chama-se assinatura do método
        // -Main -> significa o ponto de entrada para iniciar a executar. Classe public
        // com metodo main
        // -Pode ser String[] (array) ou String... (varargs)
        // -void -> tipo de retorno, neste caso não retorna nada
        // -static-> significa que não preciso instanciar esta metodo. Consegue chamar
        // o metodo sem criar o objeto, ou seja, instanciar(criar) o objeto. Chama o
        // método sem precisar criar o objeto.
        System.out.println("Hello, World!");

        Carro.teste(); // consigo chamar sem instanciar, ou seja sem criar objeto
        // Carro.imprimirAno; // Não da certo pois precisa instanciar

        Carro carro = new Carro();
        carro.ano = 1997;
        carro.modelo = "Ranger";
        carro.array = new int[2];
        carro.imprimir();
    }
}
