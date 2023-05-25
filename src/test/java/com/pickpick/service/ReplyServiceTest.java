package com.pickpick.service;

import com.pickpick.dto.reply.response.ReplyListResponseDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReplyServiceTest {

    @Autowired
    ReplyService service;

    @Test
    void getListTest(){
        int gameId = 1;
        String sortBy = "like";

        ReplyListResponseDTO list = service.getList(gameId, sortBy);
        System.out.println("list = " + list);

    }

}