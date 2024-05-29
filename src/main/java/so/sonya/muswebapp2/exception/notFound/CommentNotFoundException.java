package so.sonya.muswebapp2.exception.notFound;

public class CommentNotFoundException extends NotFoundException {

    public CommentNotFoundException() {
        super("Comment not found");
    }
}
