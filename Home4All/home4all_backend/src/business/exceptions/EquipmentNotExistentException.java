package business.exceptions;

public class EquipmentNotExistentException extends Exception {
    public EquipmentNotExistentException() {
        super("ERRO: Equipamento inexistente.");
    }
    public EquipmentNotExistentException(String s) {
        super(s);
    }
}
