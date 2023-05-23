package com.pickpick.service;

import com.pickpick.dto.player.PlayerListResponseDTO;
import com.pickpick.dto.search.Search;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PlayerServiceTest {

    @Autowired
    PlayerService playerService;

    @Test
    void findAllServiceTest() {
        Search page = new Search();
        page.setPageNo(1);
        page.setKeyword("커");
        List<PlayerListResponseDTO> all = playerService.findAll(8, page);
        System.out.println("all = " + all);
    }
}