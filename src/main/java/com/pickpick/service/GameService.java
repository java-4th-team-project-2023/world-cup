package com.pickpick.service;

import com.pickpick.dto.game.GameInsertRequestDTO;
import com.pickpick.dto.game.GameListResponseDTO;
import com.pickpick.dto.game.GameNameUpdateRequestDTO;
import com.pickpick.dto.game.PlayCountUpdateRequestDTO;
import com.pickpick.dto.search.Search;
import com.pickpick.entity.Game;
import com.pickpick.repository.GameMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service @Slf4j
@RequiredArgsConstructor
public class GameService {

    private final GameMapper mapper;

    // 전체 게임 목록 조회
    public List<GameListResponseDTO> findAll(Search page) {

        return mapper.findAll(page).stream()
                .map(g -> new GameListResponseDTO(g, mapper.randomPlayerImage(g.getGameId())))
                .collect(Collectors.toList());
    }

    // 게임 플레이 수 업데이트
    public boolean updatePlayCount(PlayCountUpdateRequestDTO dto) {
        return mapper.updatePlayCount(Game.builder()
                        .gameId(dto.getGameId())
                        .playCount(dto.getPlayCount())
                .build());
    }

    // 게임 이름 업데이트
    public boolean updateGameName(GameNameUpdateRequestDTO dto) {
        return mapper.updateGameName(Game.builder()
                        .gameId(dto.getGameId())
                        .gameName(dto.getGameName())
                .build());
    }

    // 게임 삭제
    public boolean deleteGame(int gameId) {
        return mapper.deleteGame(gameId);
    }

    // 게임 선수 수 조회
    public int countPlayer(int gameId) {
        return mapper.countPlayer(gameId);
    }

    // 게임 등록
    public int insertGame(GameInsertRequestDTO dto
//                          ,PlayerRegisterRequestDTO playerRegisterRequestDTO
    ) {
        Game newGame = Game.builder()
                .gameName(dto.getGameName())
                .accountId(dto.getAccountId())
                .build();
//        Player.builder()
//                .gameId(playerRegisterRequestDTO.getGameId())
//                .playerName(playerRegisterRequestDTO.getPlayerName())
//                .playerImgPath(playerRegisterRequestDTO.getPlayerImgPath())
//                .build();
        if (!mapper.insertGame(newGame)) {
            return -1;
        }

        return newGame.getGameId();
    }

    // 게임 숫자 조회
    public int countGame() {
        return mapper.countGame();
    }

    // 계정 id로 게임 조회
     public List<GameListResponseDTO> findGameByAccountId(String accountId, Search page) {
         return mapper.findGameByAccountId(accountId, page).stream()
                 .map(g -> new GameListResponseDTO(g, mapper.randomPlayerImage(g.getGameId())))
                 .collect(Collectors.toList());
     }

     // 게임 id로 게임 조회
    public Game findGameById(int gameId) {
        return mapper.findGameById(gameId);
    }

    public void increasePlayCount(int gameId) {
        mapper.increasePlayCount(gameId);
    }
}
