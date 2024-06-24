package so.sonya.muswebapp2.exception.notfound;

import so.sonya.muswebapp2.model.Thread;

public final class ThreadNotFoundException extends NotFoundException {
    public ThreadNotFoundException() {
        super(Thread.class);
    }
}
