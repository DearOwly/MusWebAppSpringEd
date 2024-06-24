package so.sonya.muswebapp2.security.exception;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

public final class EmailNotFoundException extends UsernameNotFoundException {
    public EmailNotFoundException(String email) {
        super("Could not find user with email " + email);
    }
}
