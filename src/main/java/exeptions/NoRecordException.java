package exeptions;

public class NoRecordException extends Exception {
    private final String entityType;
    private final Long id;

    public NoRecordException(String entityType, Long id) {
        this.entityType = entityType;
        this.id = id;
    }

    @Override
    public String getMessage() {
        return String.format("%s was not found by this id (%d)",entityType,id);
    }
}
