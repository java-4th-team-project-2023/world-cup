package com.pickpick.controller;

import com.pickpick.dto.page.Page;
import com.pickpick.dto.player.PlayerListResponseDTO;
import com.pickpick.dto.player.PlayerOneResponseDTO;
import com.pickpick.dto.search.Search;
import com.pickpick.service.PlayerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/rank")
@Slf4j
@RequiredArgsConstructor
public class RankingController {

    private final PlayerService playerService;

    @GetMapping("/ranking")
    public String replyPage(int gameId, Model model) {
        log.info("하이루 랭킹페이지 들어옴 {}", gameId);
        List<PlayerListResponseDTO> playerList = playerService.findAllPlayer(gameId);
        model.addAttribute("gameId", gameId);
        model.addAttribute("playerList",playerList);
        return "rank/ranking";
    }

    @GetMapping("/winner")
    public String winnersPage(Integer gameId, int playerId,int round, Model model) {
        log.info("/rank/winner GET! ");
        model.addAttribute("gameId", gameId);
        model.addAttribute("round",round);
        PlayerOneResponseDTO dto = playerService.findOne(playerId);
        model.addAttribute("dto",dto);
        return "rank/winner";
    }

    @GetMapping("/{gameId}/page/{pageNo}")
    @ResponseBody
    public ResponseEntity<?> list(
            @PathVariable int gameId,
            @PathVariable int pageNo){
        log.info("/rank/{}/page/{} : GET!!", gameId, pageNo);

        return ResponseEntity.ok().body("");
    }

}
