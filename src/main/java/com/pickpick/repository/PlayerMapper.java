package com.pickpick.repository;

import com.pickpick.dto.player.PlayerModifyRequestDTO;
import com.pickpick.dto.player.PlayerSelectRequestDTO;
import com.pickpick.entity.Player;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlayerMapper {

    // 선수 등록
    boolean registerPlayer(Player player);

    // 선수 카운트 횟수 업데이트
    boolean updatePlayer(PlayerSelectRequestDTO dto);

    // 선수 삭제
    boolean deletePlayer(int playerId);

    // 선수 수정
    boolean modifyPlayer(PlayerModifyRequestDTO dto);

    // 전체 선수 목록 조회
    List<Player> findAll();

    // 특정 선수 조회
    Player findOne(int playerId);


}
