package com.pickpick.service;

import com.pickpick.repository.PlayerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service @Slf4j
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerMapper playerMapper;


}
