package com.pickpick.repository;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LoserPlayerMapper {

    void save(int loserId, int playingGameId);

    void delete(int loserId, int playingGameId);

    List<Integer> findAll(int playingGameId);

    int count(int playingGameId);


    int findLatest(int playingGameId);
}
