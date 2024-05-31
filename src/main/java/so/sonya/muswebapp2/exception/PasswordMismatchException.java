package so.sonya.muswebapp2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class PasswordMismatchException extends ResponseStatusException {
    public PasswordMismatchException() {
        super(HttpStatus.BAD_REQUEST, "Password mismatch");
    }
}
