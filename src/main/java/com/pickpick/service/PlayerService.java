package com.pickpick.service;

import com.pickpick.dto.player.*;
import com.pickpick.dto.search.Search;
import com.pickpick.entity.Player;
import com.pickpick.repository.PlayerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service @Slf4j
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerMapper playerMapper;

    // 선수 등록
    public boolean registerPlayer(PlayerRegisterRequestDTO dto) {
        return playerMapper.registerPlayer(dto.toEntity());
    }

    private boolean updatePlayer(Player player) {
        return playerMapper.updatePlayer(Player.builder()
                .playerId(player.getPlayerId())
                .fightCount(player.getFightCount())
                .selectedWinCount(player.getSelectedWinCount())
                .joinGameCount(player.getJoinGameCount())
                .finalWinCount(player.getFinalWinCount())
                .build());
    }

    // 선수 매치 승
    public boolean playerMatchWin(int playerId) {
        Player player = playerMapper.findOne(playerId);

        player.winFight();

        return updatePlayer(player);
    }

    // 선수 매치 패
    public boolean playerMatchLose(int playerId) {
        Player player = playerMapper.findOne(playerId);

        player.increaseFightCount();

        return updatePlayer(player);
    }

    // 선수 우승
    public boolean playerWin(int playerId) {
        Player player = playerMapper.findOne(playerId);

        player.winFinal();

        return updatePlayer(player);
    }

    // 승자 매치 리셋
    public boolean winnerMatchReset(int playerId) {
        Player player = playerMapper.findOne(playerId);

        player.decreaseSelectedCount();

        return updatePlayer(player);
    }

    // 패자 매치 리셋
    public boolean loserMatchReset(int playerId) {
        Player player = playerMapper.findOne(playerId);

        player.decreaseFightCount();

        return updatePlayer(player);
    }

    // 선수 삭제
    public boolean deletePlayer(int playerId) {
        return playerMapper.deletePlayer(playerId);
    }

    // 선수 수정
    public boolean updatePlayer(PlayerModifyRequestDTO dto) {
        return playerMapper.modifyPlayer(dto);
    }

    // 특정 게임의 선수 목록 조회
    public List<PlayerListResponseDTO> findAll(int gameId, Search page) {
        return playerMapper.findAll(gameId, page)
                .stream()
                .map(PlayerListResponseDTO::new)
                .collect(Collectors.toList());
    }

    // 랭킹 페이지 목록 가져오기
    public List<PlayerListResponseDTO> findAllPlayer(int gameId) {
        return playerMapper.findAllPlayer(gameId)
                .stream()
                .map(PlayerListResponseDTO::new)
                .collect(Collectors.toList());
    }

    // 특정 선수 조회
    public PlayerOneResponseDTO findOne(int playerId) {
        return new PlayerOneResponseDTO(playerMapper.findOne(playerId));
    }

    // 특정 길이의 목록을 랜덤하게 뽑아서 리턴
    public List<PlayerGameResponseDTO> findN(int gameId, int number) {

        List<Player> playerList = playerMapper.findN(gameId, number);

        playerList.forEach(player -> {
                player.joinGame();
                updatePlayer(player);
        });

        return playerList.stream()
                .map(PlayerGameResponseDTO::new)
                .collect(Collectors.toList());
    }

    public void deleteAllByGameId(int gameId) {
        playerMapper.deleteAllByGameId(gameId);
    }

}
