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
        Player one = playerMapper.findOne(2);
        one.joinGame();
        one.winFight();
        one.winFinal();
        one.increaseFightCount();

        assertEquals(1, one.getJoinGameCount());
        assertEquals(3, one.getFightCount());
        assertEquals(2, one.getSelectedWinCount());
        assertEquals(1, one.getFinalWinCount());
    }

    @Test
    @DisplayName("playerId가 3 인 선수를 삭제하면 잘 삭제되어야 한다.")
    void deletePlayerTest() {
        playerMapper.deletePlayer(3);

        assertNull(playerMapper.findOne(3));
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

    @Test
    @DisplayName("playerId가 2인 선수의 fight_count를 1, selected_win_count를 1 증가시켜야 한다")
    void increaseCountTest() {
        Player one = playerMapper.findOne(2);
        one.winFight();

        assertEquals(1, one.getFightCount());
        assertEquals(1, one.getSelectedWinCount());
    }

    @Test
    @DisplayName("playerId가 2인 선수의 fight_count를 1, selected_win_count를 1 감소시켜야 한다")
    void decreaseCountTest() {
        Player one = playerMapper.findOne(2);
        one.decreaseSelectedCount();

        assertEquals(0, one.getFightCount());
        assertEquals(0, one.getSelectedWinCount());
    }
}