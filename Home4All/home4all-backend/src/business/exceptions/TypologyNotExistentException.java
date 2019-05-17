package business.exceptions;

public class TypologyNotExistentException extends Exception {
    public TypologyNotExistentException() {
        super("ERRO: Tipologia inexistente.");
    }
    public TypologyNotExistentException(String s) {
        super(s);
    }
}
