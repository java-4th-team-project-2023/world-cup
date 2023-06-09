package com.pickpick.repository;

import com.pickpick.dto.player.PlayerModifyRequestDTO;
import com.pickpick.dto.search.Search;
import com.pickpick.entity.Player;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PlayerMapper {

    // 선수 등록
    boolean registerPlayer(Player player);

    // 선수 카운트 횟수 업데이트
    boolean updatePlayer(Player player);

    // 선수 삭제
    boolean deletePlayer(int playerId);

    // 선수 수정
    boolean modifyPlayer(PlayerModifyRequestDTO dto);

    // 특정 게임의 선수 목록 조회
    List<Player> findAll(@Param("gameId")int gameId, @Param("page")Search page);

    // 특정 게임의 선수 목록 조회
    List<Player> findAllPlayer(int gameId);

    // 특정 선수 조회
    Player findOne(int playerId);

    // 특정 길이의 목록을 랜덤하게 뽑아서 리턴
    List<Player> findN(@Param("gameId") int gameId, @Param("number") int number);

    // 랭킹 목록 카운트
    int count(int gameId);

    void deleteAllByGameId(int gameId);

    int checkPlayerId(int playerId);

}
