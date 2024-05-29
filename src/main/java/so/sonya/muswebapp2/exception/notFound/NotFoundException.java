package so.sonya.muswebapp2.exception.notFound;

import org.springframework.http.HttpStatus;
import so.sonya.muswebapp2.exception.ServiceException;

public class NotFoundException extends ServiceException {
    public NotFoundException(String message){
        super(message, HttpStatus.NOT_FOUND);
    }
}
