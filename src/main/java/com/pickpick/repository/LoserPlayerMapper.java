package com.pickpick.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LoserPlayerMapper {

    void save(@Param("loserId") int loserId,@Param("playingGameId") int playingGameId);

    void delete(@Param("loserId") int loserId,@Param("playingGameId") int playingGameId);

    List<Integer> findAll(int playingGameId);

    int count(int playingGameId);


    int findLatest(int playingGameId);
}
