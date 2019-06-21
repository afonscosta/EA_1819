package business.exceptions;

public class PropertyNotExistentException extends Exception {
    public PropertyNotExistentException() {
        super("ERRO: Imóvel inexistente.");
    }
    public PropertyNotExistentException(String s) {
        super(s);
    }
}
