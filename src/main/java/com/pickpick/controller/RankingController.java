package com.pickpick.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rank")
@Slf4j
public class RankingController {

    @GetMapping("/ranking")
    public String replyPage(Integer gameId, Model model){
        log.info("하이루 랭킹페이지 들어옴 {}" ,gameId);
        model.addAttribute("gameId",gameId);
        return "rank/ranking";
    }

    @GetMapping("/winner")
    public String winnersPage(Integer gameId, int playerId) {
        log.info("/rank/winner GET! ");
        return "rank/winner";
    }

}
