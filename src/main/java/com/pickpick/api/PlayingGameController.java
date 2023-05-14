package com.pickpick.api;

import com.pickpick.service.PlayingGameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/v1/plays")
@RequiredArgsConstructor
public class PlayingGameController {

    private final PlayingGameService service;



}
