package so.sonya.muswebapp2.exception.notfound;

import so.sonya.muswebapp2.model.user.User;

public final class UserNotFoundException extends NotFoundException {
    public UserNotFoundException() {
        super(User.class);
    }
}
