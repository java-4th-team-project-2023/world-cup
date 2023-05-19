package com.pickpick.api;

import com.pickpick.dto.page.Page;
import com.pickpick.dto.playingGame.MatchPlayingRequestDTO;
import com.pickpick.dto.playingGame.MatchUpdateRequestDTO;
import com.pickpick.dto.playingGame.PlayingGameAndPlayersResponseDTO;
import com.pickpick.dto.playingGame.PlayingGameSaveRequestDTO;
import com.pickpick.service.PlayingGameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

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

        int playingGameId = service.saveGameAndPlayers(dto);

        return ResponseEntity.ok().body(playingGameId);

    }

    // 매치가 끝난 후 업데이트
    @PutMapping("/{playingGameId}/{winnerId}/{loserId}")
    public ResponseEntity<?> updateEndOfMatch(
            @PathVariable int playingGameId,
            @PathVariable int winnerId,
            @PathVariable int loserId
    ) {

        PlayingGameAndPlayersResponseDTO dto = service.match(MatchPlayingRequestDTO.builder()
                .playingGameId(playingGameId)
                .winnerId(winnerId)
                .loserId(loserId)
                .build());

        // 랜덤한 두 명의 플레이어 길이가 0이면 게임 끝남
        if (dto.getRandomTwoPlayers().size() == 0) {
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create("/rank/winner?gameId=" + service.getGameId(playingGameId) + "&playerId=" + winnerId + "&round=" + dto.getTotalRound()));
            return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
        }

        return ResponseEntity.ok().body(dto);
    }

    // 리셋 요청
    @PutMapping("/{playingGameId}")
    public ResponseEntity<?> reset(@PathVariable int playingGameId) {

        log.info("/api/v1/plays/{} PUT!", playingGameId);

        PlayingGameAndPlayersResponseDTO dto = service.reset(playingGameId);

        // dto가 null 인 것은 라운드 처음이기 때문에 리셋할 수 없다는 것
        if (dto == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().body(dto);
    }

//    // 라운드가 끝난 후 업데이트 요청
//    필요없을듯...
//    @PutMapping
//    public ResponseEntity<?> updateEndOfRound(@Validated @RequestBody MatchUpdateRequestDTO dto) {
//
//        log.info("/api/v1/plays PUT!");
//
//        service.updateEndOfMatch(dto);
//        service.updateEndOfRound(dto.getPlayingGameId());
//
//        return ResponseEntity.ok().build();
//    }

    // 게임 삭제
    @DeleteMapping("/{playingGameId}")
    public ResponseEntity<?> delete(@PathVariable int playingGameId) {

        log.info("/api/v1/plays/{} DELETE!", playingGameId);

        service.deletePlayingGame(playingGameId);

        return ResponseEntity.ok().build();
    }

}
