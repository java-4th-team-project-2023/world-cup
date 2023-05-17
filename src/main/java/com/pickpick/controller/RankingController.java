package com.pickpick.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rank")
@Slf4j
public class RankingController {

    @GetMapping("/ranking")
    public String replyPage(int gameId){
        log.info("하이루 랭킹페이지 들어옴");
        return "rank/ranking";
    }

    @GetMapping("/winner")
    public String winnersPage(int gameId, int playerId) {
        log.info("/rank/winner GET! ");
        return "rank/winner";
    }

}
