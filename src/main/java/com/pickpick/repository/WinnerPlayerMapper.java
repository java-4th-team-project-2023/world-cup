package com.pickpick.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.binding.BindingException;

import java.net.BindException;
import java.util.List;

@Mapper
public interface WinnerPlayerMapper {

    void save(@Param("winnerId") int winnerId, @Param("playingGameId") int playingGameId);

    void delete(@Param("winnerId") int winnerId, @Param("playingGameId") int playingGameId);

    List<Integer> findN(@Param("playingGameId") int playingGameId, @Param("number") int number);

    int count(int playingGameId);

    void deleteAll(int playingGameId);

    int findLatest(int playingGameId) throws BindingException;
}
