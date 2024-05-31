package so.sonya.muswebapp2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {
    @GetMapping("/login")
    public String login() {
        return "/account/login";
    }

    @GetMapping("/test")
    public String test() {
        return "/account/test";
    }
}
