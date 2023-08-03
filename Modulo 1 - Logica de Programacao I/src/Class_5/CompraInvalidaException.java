package Class_5;

public class CompraInvalidaException extends IllegalArgumentException {

    public CompraInvalidaException(String msg) {
        super(msg);
    }

    public CompraInvalidaException() {
        super("Quantidade digitada com erro!");
    }

}
