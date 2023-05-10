package com.pickpick.repository;

import com.pickpick.entity.Reply;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReplyMapperTest {

    @Autowired
    ReplyMapper mapper;

    @Test
    @DisplayName("댓글이 정상적으로 저장되어야한다")
    @Transactional
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

}