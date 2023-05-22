package com.pickpick.repository;

import com.pickpick.dto.page.Page;
import com.pickpick.entity.PlayingGame;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlayingGameMapper {

    boolean save(PlayingGame playingGame);

    List<PlayingGame> findByAccountId(int accountId, Page page);

    PlayingGame findOne(int playingGameId);

    void delete(int playingGameId);

    void update(PlayingGame playingGame);

    int getGameId(int playingGameId);

    // 해당 계정이 플레이하던 게임이 있는지 확인
    Integer searchByAccountId(String accountId, int gameId);

}
