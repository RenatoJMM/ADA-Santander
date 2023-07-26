public enum Semana_Enums {
    DOMINGO("domingo"), SEGUNDA_FEIRA("segunda-feira"), TERCA_FEIRA("terça-feira"), QUARTA_FEIRA("quarta-feira"),
    QUINTA_FEIRA("quinta-feira"), SEXTA_FEIRA("sexta-feira"), SABADO("sábado");

    final String name;

    private Semana_Enums(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Semana_Enums fromString(String diaEscrito) throws DiaInvalidoException {

        Semana_Enums[] diaVar = Semana_Enums.values();

        for (Semana_Enums var : diaVar) {
            if (var.getName() == diaEscrito) {
                return var;
            }
        }

        throw new DiaInvalidoException("Erro ao criar dia: " + diaEscrito);

    }

}
