package so.sonya.muswebapp2.exception.notfound;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public sealed class NotFoundException extends ResponseStatusException permits CommentNotFoundException,
                                                                              LikeNotFoundException,
                                                                              MessageNotFoundException,
                                                                              PostNotFoundException,
                                                                              ThreadNotFoundException,
                                                                              UserNotFoundException {
    private static final String SIMPLE_MESSAGE = "%s not found";

    public NotFoundException(Class<?> type) {
        super(HttpStatus.NOT_FOUND, String.format(SIMPLE_MESSAGE, type.getSimpleName()));
    }
}
