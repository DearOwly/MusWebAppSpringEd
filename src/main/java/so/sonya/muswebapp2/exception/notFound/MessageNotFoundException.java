package so.sonya.muswebapp2.exception.notFound;

public class MessageNotFoundException extends NotFoundException {
    public MessageNotFoundException() {
        super("Message not found");
    }
}
