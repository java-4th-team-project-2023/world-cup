package com.pickpick;

import com.pickpick.dto.page.Page;
import com.pickpick.dto.search.Search;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class HomeController {

    @GetMapping("/")
    public String home() {

        log.info("/ GET!");

        return "redirect:/games/list";
    }

    @GetMapping("/login")
    public String login() {
        return "jsp/login";
    }

}
