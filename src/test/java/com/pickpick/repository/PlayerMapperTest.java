package com.pickpick.repository;

import com.pickpick.dto.player.PlayerModifyRequestDTO;
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
    @DisplayName("playerId 가 2 인 카운트 횟수를 모두 1씩 증가시키면 잘 동작해야 한다.")
    @Transactional
    @Rollback
    void updatePlayerTest() {
        playerMapper.findOne(2)
                .joinGame()
                .winFight()
                .winFinal()
                ;

        assertEquals(1, playerMapper.findOne(2).getJoinGameCount());
        assertEquals(2, playerMapper.findOne(2).getFightCount());
        assertEquals(2, playerMapper.findOne(2).getSelectedWinCount());
        assertEquals(1, playerMapper.findOne(2).getFinalWinCount());
    }

    @Test
    @DisplayName("playerId가 2 인 선수를 삭제하면 잘 삭제되어야 한다.")
    @Transactional
    @Rollback
    void deletePlayerTest() {
        playerMapper.deletePlayer(2);

        assertNull(playerMapper.findOne(2));
    }

    @Test
    @DisplayName("playerId가 2 인 선수의 이름을 2로 바꾸고 사진 경로를 2로 바꾸면 잘 바뀌어야 한다")
    @Transactional
    @Rollback
    void modifyPlayerTest() {
        playerMapper.modifyPlayer(PlayerModifyRequestDTO.builder()
                .playerId(2)
                .playerName("2")
                .playerImgPath("2")
                .build());

        assertEquals("2", playerMapper.findOne(2).getPlayerName());
        assertEquals("2", playerMapper.findOne(2).getPlayerImgPath());
    }

    @Test
    @DisplayName("game 1의 findAll의 반환 리스트의 길이가 1이어야 한다.")
    void findAllTest() {
        assertEquals(1, playerMapper.findAll(1).size());
    }
}