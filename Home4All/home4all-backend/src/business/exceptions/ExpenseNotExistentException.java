package business.exceptions;

public class ExpenseNotExistentException extends Exception {
    public ExpenseNotExistentException() {
        super("ERRO: Despesa inexistente.");
    }
    public ExpenseNotExistentException(String s) {
        super(s);
    }
}
