package so.sonya.muswebapp2.aspect;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import so.sonya.muswebapp2.propertyeditors.UUIDEditor;

import java.util.UUID;

@ControllerAdvice
public class GlobalBindingInitializer {
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(UUID.class, new UUIDEditor());
    }
}
