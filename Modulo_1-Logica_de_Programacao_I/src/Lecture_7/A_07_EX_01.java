package Class_7;

import Class_6.DiaInvalidoException;
import Class_6.Semana_Enums;

public class A_07_EX_01 {

    public static void main(String[] args) throws DiaInvalidoException {

        try {
            Semana_Enums dia = Semana_Enums.fromString("terc");
            System.out.println("Criado com sucesso! (" + dia + ")");
        } catch (DiaInvalidoException e) {
            throw new DiaInvalidoException("Erro ao criar dia!");
        }

    }

}
