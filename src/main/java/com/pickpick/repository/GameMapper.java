package com.pickpick.repository;

import com.pickpick.dto.search.Search;
import com.pickpick.entity.Game;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GameMapper {

    // 전체 게임 목록 조회
    List<Game> findAll(Search page);

    // 게임 플레이 수 업데이트
    boolean updatePlayCount(Game game);

    // 게임 이름 업데이트
    boolean updateGameName(Game game);

    // 게임 삭제
    boolean deleteGame(int gameId);

    // 해당 게임의 선수 수 조회
    int countPlayer(int gameId);

    // 게임 등록
    boolean insertGame(Game game);

    int countGame();
}
