package so.sonya.muswebapp2.exception;

import org.springframework.security.core.AuthenticationException;
import so.sonya.muswebapp2.model.AuthProvider;

public class AuthProviderMismatchException extends AuthenticationException {
    private static final String MESSAGE = "Authentication provider mismatch: expected %s but got %s";

    public AuthProviderMismatchException(AuthProvider expected, AuthProvider actual) {
        super(String.format(MESSAGE, expected, actual));
    }
}
