package com.pickpick.repository;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WinnerPlayerMapper {

    void save(int winnerId, int playingGameId);

    void delete(int winnerId, int playingGameId);

    List<Integer> findAll(int playingGameId);

    int count(int playingGameId);

    void deleteAll(int playingGameId);

}
