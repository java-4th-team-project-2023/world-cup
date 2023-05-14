package com.pickpick.repository;

import com.pickpick.entity.PlayingGame;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlayingGameMapper {

    boolean save(PlayingGame playingGame);

    List<PlayingGame> findByAccountId(int accountId);

    PlayingGame findOne(int playingGameId);

    boolean delete(int playingGameId);

    boolean update(PlayingGame playingGame);

}
