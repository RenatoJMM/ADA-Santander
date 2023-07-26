import java.util.Arrays;

public enum Semana_Enums {
    DOMINGO(new String[] { "domingo", "d", "dm" }), SEGUNDA_FEIRA(new String[] { "segunda-feira", "seg", "segunda" }),
    TERCA_FEIRA(new String[] { "terça-feira", "ter", "terça" }),
    QUARTA_FEIRA(new String[] { "quarta-feira", "quar", "quarta" }),
    QUINTA_FEIRA(new String[] { "quinta-feira", "quinta", "quin" }),
    SEXTA_FEIRA(new String[] { "sexta-feira", "sex", "sexta" }), SABADO(new String[] { "sábado", "sabado", "sab" });

    final String[] keywords;

    Semana_Enums(String[] keywords) {
        this.keywords = keywords;
    }

    public String[] getKeys() {
        return this.keywords;
    }

    public static Semana_Enums fromString(String diaEscrito) throws DiaInvalidoException {

        Semana_Enums[] diaVar = Semana_Enums.values();

        for (Semana_Enums var : diaVar) {
            for (String key : var.getKeys()) {
                if (key.equalsIgnoreCase(diaEscrito)) {
                    return var;
                }
            }

        }

        throw new DiaInvalidoException("Erro ao criar o dia!");

    }

}
