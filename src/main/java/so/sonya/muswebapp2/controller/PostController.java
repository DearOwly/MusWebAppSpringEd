package so.sonya.muswebapp2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
public class PostController {
    @GetMapping(value = "/posts")
    public ModelAndView getAll() {
        return new ModelAndView("posts");
    }

    @GetMapping(value = "/posts/{post_id}")
    public ModelAndView getOne(@PathVariable UUID post_id) {
        return new ModelAndView("post");
    }
}
