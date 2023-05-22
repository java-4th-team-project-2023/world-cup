package com.pickpick.api;

import com.pickpick.dto.account.response.LoginUserResponseDTO;
import com.pickpick.dto.page.Page;
import com.pickpick.dto.player.*;
import com.pickpick.dto.playingGame.PlayingGameSaveRequestDTO;
import com.pickpick.dto.search.Search;
import com.pickpick.entity.Account;
import com.pickpick.entity.Player;
import com.pickpick.entity.PlayingGamePlayers;
import com.pickpick.service.PlayerService;
import com.pickpick.service.PlayingGameService;
import com.pickpick.util.LoginUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j @RequestMapping("/api/v1/players")
public class PlayerController {

    private final PlayerService playerService;
    private final PlayingGameService playingGameService;

    // 선수 등록
    @PostMapping
    public ResponseEntity<?> registerPlayer(@Validated @RequestBody PlayerRegisterRequestDTO dto
    , BindingResult result) {

        log.info("/api/v1/players");

        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.toString());
        }

        boolean flag = playerService.registerPlayer(dto);

        log.info("/api/v1/players POST! dto: {}", dto);

        return ResponseEntity.ok().body(flag);
    }

    // 게임 생성 후 '강' 수에 맞는 선수 목록을 PlayingGameService 에 전달하여 PlayingGame 생성후 playingGameId 리턴
    @PostMapping("/{gameId}/num/{number}")
    public ResponseEntity<?> getGameplayPlayers(
            HttpSession session,
            @PathVariable int gameId, @PathVariable int number
    ) {
        log.info("/api/v1/players/{}/num/{} GET!", gameId, number);

        List<PlayerGameResponseDTO> playerList = playerService.findN(gameId, number);

        String accountId = null;

        try {
            accountId = ((LoginUserResponseDTO) session.getAttribute(LoginUtil.LOGIN_KEY)).getAccountId();
        } catch (NullPointerException ignored) {
        }

        int playingGameId = playingGameService.saveGameAndPlayers(PlayingGameSaveRequestDTO.builder()
                .gameId(gameId)
                .totalRound(number)
                .accountId(accountId)
                .currentRound(number)
                .playerIdList(playerList.stream()
                        .map(PlayerGameResponseDTO::getPlayerId)
                        .collect(Collectors.toList()))
                .build());

        return ResponseEntity.ok().body(playingGameId);
    }

    // 선수 한명 리턴
    @GetMapping("/{playerId}")
    public ResponseEntity<?> getPlayer(@PathVariable int playerId) {
        log.info("/api/v1/players/{} GET!", playerId);

        PlayerOneResponseDTO player = playerService.findOne(playerId);

        return ResponseEntity.ok().body(player);
    }

    // 선수 매치
    @PatchMapping("/{playerId}/result/{isWin}")
    public ResponseEntity<?> match(@PathVariable int playerId, @PathVariable boolean isWin) {

        boolean flag;

        if (isWin) {

            flag = playerService.playerWin(playerId);

        } else {

            flag = playerService.playerMatchLose(playerId);

        }

        log.info("/api/v1/players/{}/result/{} PATCH!", playerId, isWin);

        if (!flag) return ResponseEntity.status(500).build();

        return ResponseEntity.ok().build();

    }

    // 선수 우승
    @PatchMapping("/{playerId}")
    public ResponseEntity<?> win(@PathVariable int playerId) {

        boolean flag = playerService.playerWin(playerId);

        log.info("/api/v1/players/{} PATCH! result : {}", playerId, flag);

        if (!flag) return ResponseEntity.status(500).build();

        return ResponseEntity.ok().build();

    }

    // 이전 경기 리셋
    @PatchMapping("/{winnerId}/{loserId}")
    public ResponseEntity<?> resetMatch(@PathVariable int winnerId, @PathVariable int loserId) {

        boolean flag1 = playerService.winnerMatchReset(winnerId);
        boolean flag2 = playerService.loserMatchReset(loserId);

        log.info("/api/v1/players/{}/{} PATCH ", winnerId, loserId);

        if (!flag1 || !flag2) return ResponseEntity.status(500).build();

        return ResponseEntity.ok().build();
    }

    // 선수 삭제
    @DeleteMapping("/{playerId}")
    public ResponseEntity<?> deletePlayer(@PathVariable int playerId) {

        boolean flag = playerService.deletePlayer(playerId);

        log.info("/api/v1/players/{} DELETE", playerId);

        if (!flag) return ResponseEntity.status(500).build();

        return ResponseEntity.ok().build();

    }

    // 선수 수정
    @PutMapping
    public ResponseEntity<?> modifyPlayer(@Validated @RequestBody PlayerModifyRequestDTO dto
    , BindingResult result) {

        if (result.hasErrors()) return ResponseEntity.badRequest().body(result.toString());

        boolean flag = playerService.updatePlayer(dto);

        log.info("/api/v1/players : PUT!");

        if (!flag) return ResponseEntity.status(500).build();

        return ResponseEntity.ok().build();
    }

    // 특정 게임의 선수 목록 조회
    @GetMapping("/{gameId}/pageNo/{pageNo}/amount/{amount}")
    public ResponseEntity<?> findAll(@PathVariable int gameId,
                                     @PathVariable int pageNo,
                                     @PathVariable int amount) {

        Search page = new Search();
        page.setAmount(amount);
        page.setPageNo(pageNo);

        log.info("/api/v1/players/{} : GET! ", gameId);

        List<PlayerListResponseDTO> playerList = playerService.findAll(gameId, page);

        if (playerList == null) return ResponseEntity.badRequest().build();

        return ResponseEntity.ok().body(playerList);
    }

}
