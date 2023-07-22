public class CompraInvalida extends IllegalArgumentException {

    public CompraInvalida(String msg) {
        super(msg);
    }

    public CompraInvalida() {
        super("Quantidade digitada com erro!");
    }

}
