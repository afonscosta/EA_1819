package business.exceptions;

public class GenderNotExistentException extends Exception {
    public GenderNotExistentException() {
        super("ERRO: Género inexistente.");
    }
    public GenderNotExistentException(String s) {
        super(s);
    }
}
