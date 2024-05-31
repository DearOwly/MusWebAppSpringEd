package so.sonya.muswebapp2.exception;

import so.sonya.muswebapp2.model.Post;

public class PostNotFoundException extends NotFoundException {
    public PostNotFoundException() {
        super(Post.class);
    }
}
