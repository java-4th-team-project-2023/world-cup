package com.pickpick.repository;

import com.pickpick.entity.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PlayerMapperTest {

    @Autowired
    private PlayerMapper playerMapper;

    @Test
    @DisplayName("플레이어를 등록하면 true가 나와야 한다.")
    void registerTest() {
        boolean flag = playerMapper.registerPlayer(Player.builder()
                .gameId(1)
                .playerName("야호1")
                .playerImgPath("야호1")
                .build());

        assertTrue(flag);
    }

    @Test
    @DisplayName("playerId 가 1 인 카운트 횟수를 모두 1씩 증가시키면 잘 동작해야 한다.")
    void updatePlayerTest() {

    }
}