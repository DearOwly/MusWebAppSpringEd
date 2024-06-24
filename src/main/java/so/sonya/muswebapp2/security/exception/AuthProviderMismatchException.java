package so.sonya.muswebapp2.security.exception;

import org.springframework.security.core.AuthenticationException;
import so.sonya.muswebapp2.model.user.AuthProvider;

public final class AuthProviderMismatchException extends AuthenticationException {
    private static final String MESSAGE = "Authentication provider mismatch: expected %s but got %s";

    public AuthProviderMismatchException(AuthProvider expected, AuthProvider actual) {
        super(String.format(MESSAGE, expected, actual));
    }
}
