package so.sonya.muswebapp2.exception;

import so.sonya.muswebapp2.model.User;

public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException() {
        super(User.class);
    }
}
