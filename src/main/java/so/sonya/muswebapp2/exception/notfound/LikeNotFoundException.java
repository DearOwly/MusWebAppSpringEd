package so.sonya.muswebapp2.exception.notfound;

import so.sonya.muswebapp2.model.Like;

public final class LikeNotFoundException extends NotFoundException {
    public LikeNotFoundException() {
        super(Like.class);
    }
}
