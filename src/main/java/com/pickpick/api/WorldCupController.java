package com.pickpick.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/world-cups")
public class WorldCupController {

    // 게임 시작 요청 받기
    @GetMapping("/{gameId}")
    public String gameStart() {
        return "";
    }

}
