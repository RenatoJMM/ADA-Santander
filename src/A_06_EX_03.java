public class A_06_EX_03 {

    public static void main(String[] args) throws DiaInvalidoException {

        try {
            Semana_Enums dia = Semana_Enums.fromString("terça-feira");
            System.out.println("Criado com sucesso! (" + dia + ")");
        } catch (DiaInvalidoException e) {
            throw new DiaInvalidoException("Erro!");
        }

    }

}
