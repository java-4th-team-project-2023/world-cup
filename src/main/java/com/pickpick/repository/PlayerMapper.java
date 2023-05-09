package com.pickpick.repository;

import com.pickpick.dto.player.PlayerModifyRequestDTO;
import com.pickpick.dto.player.PlayerSelectRequestDTO;
import com.pickpick.entity.Player;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PlayerMapper {

    // 선수 등록
    boolean registerPlayer(Player player);

    // 플레이어 카운트 횟수 업데이트
    boolean updatePlayer(PlayerSelectRequestDTO dto);

    // 선수 삭제
    boolean deletePlayer(int playerId);

    // 선수 수정
    boolean modifyPlayer(PlayerModifyRequestDTO dto);
}
