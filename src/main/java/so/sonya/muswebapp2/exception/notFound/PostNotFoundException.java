package so.sonya.muswebapp2.exception.notFound;

public class PostNotFoundException extends NotFoundException {
    public PostNotFoundException() {
        super("Post not found");
    }
}
