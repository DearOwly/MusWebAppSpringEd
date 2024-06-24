package so.sonya.muswebapp2.exception.notfound;

import so.sonya.muswebapp2.model.Message;

public final class MessageNotFoundException extends NotFoundException {
    public MessageNotFoundException() {
        super(Message.class);
    }
}
