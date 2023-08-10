public abstract class Veiculo { // O ABSTRACT QUER DIZER Q N PODE INSTANCIAR ESTA CLASSE, APENAS HERDA-LA

    private String placa;
    private String cor;
    private String modelo;
    private int ano;

    public Veiculo(String placa, String cor, String modelo, int ano) {
        this.placa = placa;
        this.cor = cor;
        this.modelo = modelo;
        this.ano = ano;
    }

    public void exibirDados() { // SE EU COLOCAR abstract no método significa que todas as classes filhas tem
                                // que implementar esse metodo. porém n pode ter corpo o metodo, somente a
                                // assinatura do metodo.
        System.out.println("Placa:" + this.placa);
        System.out.println("Cor:" + this.cor);
        System.out.println("Modelo:" + this.modelo);
        System.out.println("Ano:" + this.ano);
    }

}
