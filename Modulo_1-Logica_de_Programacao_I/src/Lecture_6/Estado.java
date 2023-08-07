package Lecture_6;

public enum Estado {
    MG("MG", 0.07), SP("SP", 0.12), RJ("RJ", 0.15);

    final String estado;
    final double taxa;

    private Estado(String estado, double taxa) {
        this.estado = estado;
        this.taxa = taxa;
    }

    public double getTax() {
        return taxa;

    }

}
