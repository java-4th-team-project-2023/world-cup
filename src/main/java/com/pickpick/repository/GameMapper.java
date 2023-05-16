package com.pickpick.repository;

import com.pickpick.dto.search.Search;
import com.pickpick.entity.Game;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;
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
    int insertGame(Game game);

    int countGame();

    // 랜덤으로 두 명의 선수 이미지 경로 리턴
    List<String> randomPlayerImage(int gameId);

    List<Game> findGameByAccountId(String accountId, Search page);

    Game findGameById(int gameId);
}
