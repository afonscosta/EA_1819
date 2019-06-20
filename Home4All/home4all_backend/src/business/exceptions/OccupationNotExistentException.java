package business.exceptions;

public class OccupationNotExistentException extends Exception {
    public OccupationNotExistentException() {
        super("ERRO: Ocupação inexistente.");
    }
    public OccupationNotExistentException(String s) {
        super(s);
    }
}
