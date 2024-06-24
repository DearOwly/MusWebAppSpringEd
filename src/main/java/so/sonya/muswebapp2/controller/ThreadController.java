package so.sonya.muswebapp2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
public class ThreadController {
    @GetMapping(value = "/threads")
    public ModelAndView getAll() {
        return new ModelAndView("threads");
    }

    @GetMapping(value = "/threads/{thread_id}")
    public ModelAndView getOne(@PathVariable UUID thread_id) {
        return new ModelAndView("thread");
    }
}
