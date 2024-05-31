package so.sonya.muswebapp2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NotFoundException extends ResponseStatusException {
    private static final String SIMPLE_MESSAGE = "%s not found";
    private static final String COMPLEX_MESSAGE = "%s not found: %s";
    private Class<?> type;

    public NotFoundException(Class<?> type) {
        super(HttpStatus.NOT_FOUND, String.format(SIMPLE_MESSAGE, type.getSimpleName()));
    }

    public NotFoundException(Class<?> type, String message) {
        super(HttpStatus.NOT_FOUND, String.format(COMPLEX_MESSAGE, type.getSimpleName(), message));
    }

    public NotFoundException(Class<?> type, String format, Object... args) {
        super(HttpStatus.NOT_FOUND, String.format(COMPLEX_MESSAGE, type.getSimpleName(), String.format(format, args)));
    }
}
