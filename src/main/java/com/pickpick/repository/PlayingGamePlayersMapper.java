package com.pickpick.repository;

import com.pickpick.entity.PlayingGamePlayers;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlayingGamePlayersMapper {

    void save(PlayingGamePlayers playingGamePlayers);

    void delete(PlayingGamePlayers playingGamePlayers);

    List<PlayingGamePlayers> findAllByGameId(int playingGameId);

    int count(int playingGameId);

    void deleteAll(int playingGameId);
}
