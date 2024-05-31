package so.sonya.muswebapp2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AlreadyRegistredException extends ResponseStatusException {
    private static final String MESSAGE = "User with email %s is already registered";

    public AlreadyRegistredException(String email) {
        super(HttpStatus.CONFLICT, String.format(MESSAGE, email));
    }
}
