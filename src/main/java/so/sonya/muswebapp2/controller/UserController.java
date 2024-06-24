package so.sonya.muswebapp2.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import so.sonya.muswebapp2.security.details.UserDetailsWithId;

@Controller
public class UserController {
    @GetMapping(value = "/users")
    public ModelAndView getAll() {
        return new ModelAndView("users");
    }

    @GetMapping(value = "/user")
    public ModelAndView getOne(@AuthenticationPrincipal UserDetailsWithId user) {
        return new ModelAndView("user");
    }
}
