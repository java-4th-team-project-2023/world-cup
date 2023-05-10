package com.pickpick.repository;

import com.pickpick.dto.page.Page;
import com.pickpick.entity.Reply;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReplyMapperTest {

    @Autowired
    ReplyMapper mapper;

    @Test
    @DisplayName("댓글이 정상적으로 저장되어야한다")
    @Transactional
    @Rollback
    void saveTest(){
        // given
        Reply reply = Reply.builder()
                .text("하하")
                .writer("haha")
                .gameId(1)
                .build();
        boolean flag = mapper.save(reply);

        assertTrue(flag);
    }

    @Test
    @DisplayName("1번 game_id 댓글이 정상적으로 댓글 수정이 되어야한다")
    void modifyTest(){
        // given
        Reply reply = Reply.builder()
                .text("고래상어")
                .gameId(1)
                .build();
        boolean flag = mapper.modify(reply);

        assertTrue(flag);
    }



}