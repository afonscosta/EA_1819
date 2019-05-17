package business.exceptions;

public class MissingPropertiesException extends Exception {
    public MissingPropertiesException() {
        super("ERRO: Propriedades em falta.");
    }
    public MissingPropertiesException(String s) {
        super(s);
    }
}
