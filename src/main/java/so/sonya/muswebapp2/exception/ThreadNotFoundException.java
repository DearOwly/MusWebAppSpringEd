package so.sonya.muswebapp2.exception;

import so.sonya.muswebapp2.model.Thread;

public class ThreadNotFoundException extends NotFoundException {
    public ThreadNotFoundException() {
        super(Thread.class);
    }
}
