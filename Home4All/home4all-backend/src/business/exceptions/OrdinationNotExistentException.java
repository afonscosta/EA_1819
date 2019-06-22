package business.exceptions;

public class OrdinationNotExistentException extends Exception {
    public OrdinationNotExistentException() {
        super("ERRO: Ordenação inexistente.");
    }
    public OrdinationNotExistentException(String s) {
        super(s);
    }
}
