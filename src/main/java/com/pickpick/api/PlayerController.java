package com.pickpick.api;

import com.pickpick.dto.player.PlayerRegisterRequestDTO;
import com.pickpick.entity.Player;
import com.pickpick.service.PlayerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j @RequestMapping("/api/v1/players")
public class PlayerController {

    private final PlayerService playerService;

    // 선수 등록
    @PostMapping
    public ResponseEntity<?> registerPlayer(PlayerRegisterRequestDTO dto) {
        boolean flag = playerService.registerPlayer(dto);
        log.info("/api/v1/players POST! dto: {}", dto);
        return ResponseEntity.ok().body(flag);
    }

    // 게임 생성 후 '강' 수에 맞는 선수 목록 리턴
    @GetMapping("/{gameId}/num/{number}")
    public ResponseEntity<?> getGameplayPlayers(@PathVariable int gameId, @PathVariable int number) {
        List<Player> playerList = playerService.findN(gameId, number);

        log.info("/api/v1/players/{}/num/{} GET! playerList: {}", gameId, number, playerList);

        return ResponseEntity.ok().body(playerList);
    }

    // 선수 매치 승
    @PatchMapping("/{playerId}")
    public ResponseEntity<?> matchWin(@PathVariable int playerId) {
        return null;
    }

}
