package Lecture_6;

public enum SemanaEnum {
    DOMINGO("domingo"), SEGUNDA_FEIRA("segunda-feira"), TERCA_FEIRA("terça-feira"), QUARTA_FEIRA("quarta-feira"),
    QUINTA_FEIRA("quinta-feira"), SEXTA_FEIRA("sexta-feira"), SABADO("sábado");

    final String name;

    private SemanaEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static SemanaEnum fromString(String diaEscrito) throws DiaInvalidoException {

        SemanaEnum[] diaVar = SemanaEnum.values();

        for (SemanaEnum var : diaVar) {
            if (var.getName() == diaEscrito) {
                return var;
            }
        }

        throw new DiaInvalidoException("Erro ao criar o dia: " + diaEscrito);

    }

}
