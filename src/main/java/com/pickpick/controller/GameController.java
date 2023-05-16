package com.pickpick.controller;

import com.pickpick.dto.page.PageMaker;
import com.pickpick.dto.search.Search;
import com.pickpick.entity.Game;
import com.pickpick.service.GameService;
import com.pickpick.service.PlayerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.juli.logging.Log;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/games")
@Slf4j
public class GameController {

    private final GameService gameService;
    private final PlayerService playerService;

    // 게임 목록 페이지
    @GetMapping("/list")
    public String list(Model model,
                       Search page) {

        log.info("/games/list GET! page: {}", page);
        model.addAttribute("gameList", gameService.findAll(page));
        model.addAttribute("maker", new PageMaker(page, gameService.countGame()));

        return "games/list";
    }

    // 게임 만들기 페이지 이동
    @GetMapping("/make")
    public String makeGame(HttpServletRequest request) {

        if (request.getSession().getAttribute("login") == null) {
            return "redirect:/account/sign-in";
        }

        return "/games/make";
    }

    // 랭킹 페이지 이동
    @GetMapping("/reply")
    public String makeRanking(HttpSession session){
        System.out.println("들옴");
        log.info(" session: {}",session.getAttribute("login"));
        return "jsp/reply";
    }

    // 게임 수정 페이지 이동
    @GetMapping("/modify")
    public String modifyGame(int gameId, Model model) {

        model.addAttribute("gameId", gameId);

        return "/games/modify";
    }

}
