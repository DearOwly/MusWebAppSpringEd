package so.sonya.muswebapp2.exception;

import so.sonya.muswebapp2.model.Comment;

public class CommentNotFoundException extends NotFoundException {
    public CommentNotFoundException() {
        super(Comment.class);
    }
}
