package so.sonya.muswebapp2.exception.notfound;

import so.sonya.muswebapp2.model.Comment;

public final class CommentNotFoundException extends NotFoundException {
    public CommentNotFoundException() {
        super(Comment.class);
    }
}
