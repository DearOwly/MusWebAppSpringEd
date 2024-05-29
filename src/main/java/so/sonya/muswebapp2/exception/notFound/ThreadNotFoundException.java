package so.sonya.muswebapp2.exception.notFound;

import so.sonya.muswebapp2.exception.notFound.NotFoundException;

public class ThreadNotFoundException extends NotFoundException {
    public ThreadNotFoundException() {
        super("Thread not found");
    }
}
