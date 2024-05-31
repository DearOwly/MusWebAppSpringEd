package so.sonya.muswebapp2.exception;

import so.sonya.muswebapp2.model.Message;

public class MessageNotFoundException extends NotFoundException {
    public MessageNotFoundException() {
        super(Message.class);
    }
}
