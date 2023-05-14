package com.pickpick.repository;

import com.pickpick.entity.PlayingGamePlayers;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlayingGamePlayersMapper {

    boolean save(PlayingGamePlayers playingGamePlayers);

    boolean delete(PlayingGamePlayers playingGamePlayers);

    List<PlayingGamePlayers> findAllByGameId(int gameId);

}
