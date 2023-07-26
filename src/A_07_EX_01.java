public class A_07_EX_01 {

    public static void main(String[] args) throws DiaInvalidoException {

        try {
            Semana_Enums dia = Semana_Enums.fromString("ter");
            System.out.println("Criado com sucesso! (" + dia + ")");
        } catch (DiaInvalidoException e) {
            throw new DiaInvalidoException("Erro ao criar o dia!");
        }

    }

}
