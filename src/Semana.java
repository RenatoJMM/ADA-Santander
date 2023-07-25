public enum Semana {
    DOMINGO("domingo"), SEGUNDA_FEIRA("segunda-feira"), TERCA_FEIRA("terça-feira"), QUARTA_FEIRA("quarta-feira"),
    QUINTA_FEIRA("quinta-feira"), SEXTA_FEIRA("sexta-feira"), SABADO("sábado");

    final String name;

    private Semana(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
