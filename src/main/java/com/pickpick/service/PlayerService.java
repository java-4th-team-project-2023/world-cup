package com.pickpick.service;

import com.pickpick.dto.player.PlayerRegisterRequestDTO;
import com.pickpick.repository.PlayerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service @Slf4j
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerMapper playerMapper;

    // 선수 등록
    public boolean registerPlayer(PlayerRegisterRequestDTO dto) {
        return playerMapper.registerPlayer(dto.toEntity());
    }

}
