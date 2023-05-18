package com.pickpick.api;

import com.pickpick.dto.page.Page;
import com.pickpick.dto.playingGame.MatchUpdateRequestDTO;
import com.pickpick.dto.playingGame.PlayingGameSaveRequestDTO;
import com.pickpick.service.PlayingGameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController @Slf4j
@RequestMapping("/api/v1/plays")
@RequiredArgsConstructor
public class PlayingGameController {

    private final PlayingGameService service;

    // 해당 계정이 플레이하던 전체 게임 목록을 리턴
    @GetMapping("/{accountId}/page/{pageNo}")
    public ResponseEntity<?> findAll(@PathVariable int accountId,
                                     @PathVariable int pageNo) {

        log.info("/api/v1/plays/{} GET!",  accountId);

        return ResponseEntity.ok().body(service.findAll(accountId, Page.builder()
                        .pageNo(pageNo)
                        .amount(10)
                .build()));
    }

    // 플레이하던 게임 요청
    @GetMapping("/{playingGameId}")
    public ResponseEntity<?> findOne(@PathVariable int playingGameId) {

        log.info("/api/v1/plays/{} GET!", playingGameId);

        return ResponseEntity.ok().body(service.findOne(playingGameId));
    }

    // 플레이중인 게임 생성
    @PostMapping
    public ResponseEntity<?> create(@Validated @RequestBody PlayingGameSaveRequestDTO dto) {

        log.info("/api/v1/plays POST!");

        service.saveGameAndPlayers(dto);

        return ResponseEntity.ok().build();

    }

    // 매치가 끝난 후 업데이트
    @PutMapping("{winnerId}/{loserId}")
    public ResponseEntity<?> updateEndOfMatch(@PathVariable int winnerId, @PathVariable int loserId) {
        return null;
    }

    // 라운드가 끝난 후 업데이트 요청
    @PutMapping
    public ResponseEntity<?> updateEndOfRound(@Validated @RequestBody MatchUpdateRequestDTO dto) {

        log.info("/api/v1/plays PUT!");

        service.updateEndOfMatch(dto);
        service.updateEndOfRound(dto.getPlayingGameId());

        return ResponseEntity.ok().build();
    }

    // 게임 종료 혹은 삭제
    @DeleteMapping("/{playingGameId}")
    public ResponseEntity<?> delete(@PathVariable int playingGameId) {

        log.info("/api/v1/plays/{} DELETE!", playingGameId);

        service.deletePlayingGame(playingGameId);

        return ResponseEntity.ok().build();
    }

}
