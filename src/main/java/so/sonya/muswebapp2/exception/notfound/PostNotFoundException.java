package so.sonya.muswebapp2.exception.notfound;

import so.sonya.muswebapp2.model.Post;

public final class PostNotFoundException extends NotFoundException {
    public PostNotFoundException() {
        super(Post.class);
    }
}
