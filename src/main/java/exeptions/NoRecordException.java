package exeptions;

public class NoRecordException extends Exception {
    private String entityType;
    private Long id;

    @Override
    public String getMessage() {
        return String.format("%s was not fount by this id (%d)",entityType,id);
    }
}
