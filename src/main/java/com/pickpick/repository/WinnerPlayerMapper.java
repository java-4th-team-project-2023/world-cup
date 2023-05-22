package com.pickpick.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WinnerPlayerMapper {

    void save(@Param("winnerId") int winnerId, @Param("playingGameId") int playingGameId);

    void delete(@Param("winnerId") int winnerId, @Param("playingGameId") int playingGameId);

    List<Integer> findAll(int playingGameId);

    int count(int playingGameId);

    void deleteAll(int playingGameId);

    int findLatest(int playingGameId);
}
