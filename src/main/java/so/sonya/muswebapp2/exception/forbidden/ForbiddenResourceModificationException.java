package so.sonya.muswebapp2.exception.forbidden;

public class ForbiddenResourceModificationException extends ForbiddenException {
    public static final String MESSAGE = "you do not have permission to modify or delete this %s";

    public ForbiddenResourceModificationException(Class<?> type) {
        super(String.format(MESSAGE, type.getSimpleName()));
    }
}
