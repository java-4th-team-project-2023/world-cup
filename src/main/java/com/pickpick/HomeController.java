package com.pickpick;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "games/list";
    }

    @GetMapping("/login")
    public String login() {
        return "jsp/login";
    }

}
