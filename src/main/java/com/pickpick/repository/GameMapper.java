package com.pickpick.repository;

import com.pickpick.dto.search.Search;
import com.pickpick.entity.Game;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GameMapper {

    // 전체 게임 목록 조회
    public List<Game> findAll(Search page);

    // 게임 플레이 수 업데이트
    public void updatePlayCount(Game game);

    // 게임 이름 업데이트
    public void updateGameName(Game game);

    // 게임 삭제
    public void deleteGame(int gameId);

    // 해당 게임의 선수 수 조회
    public int countPlayer(int gameId);

    // 게임 등록
    public void insertGame(Game game);
}
