package so.sonya.muswebapp2.exception.notFound;

import so.sonya.muswebapp2.exception.notFound.NotFoundException;

public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException() {
        super("User not found");
    }
}
