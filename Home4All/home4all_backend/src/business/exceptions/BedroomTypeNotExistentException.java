package business.exceptions;

public class BedroomTypeNotExistentException extends Exception {
    public BedroomTypeNotExistentException() {
        super("ERRO: Tipo de quarto inexistente.");
    }
    public BedroomTypeNotExistentException(String s) {
        super(s);
    }
}
