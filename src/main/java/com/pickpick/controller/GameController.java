package com.pickpick.controller;

import com.pickpick.dto.account.response.LoginUserResponseDTO;
import com.pickpick.dto.game.GameInsertRequestDTO;
import com.pickpick.dto.page.PageMaker;
import com.pickpick.dto.player.PlayerRegisterRequestDTO;
import com.pickpick.dto.search.Search;
import com.pickpick.entity.Game;
import com.pickpick.service.GameService;
import com.pickpick.service.PlayerService;
import com.pickpick.util.LoginUtil;
import com.pickpick.util.upload.fileUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/games")
@Slf4j
public class GameController {

    @Value("${file.upload.rootPath}")
    private String rootPath;
    private final GameService gameService;
    private final PlayerService playerService;

    // 게임 목록 페이지
    @GetMapping("/list")
    public String list(Model model,
                       Search page) {

        log.info("/games/list GET! page: {}", page);
        page.setAmount(6);
        model.addAttribute("gameList", gameService.findAll(page));
        model.addAttribute("maker", new PageMaker(page, gameService.countGame()));

        return "games/list";
    }


    // 게임 만들기 페이지 이동
    @GetMapping("/make")
    public String makeGame(HttpServletRequest request) {

        if (request.getSession().getAttribute("login") == null) {
            return "redirect:/account/sign-in";
        }

        return "games/upload";
    }

    // 게임 만들기 요청
    @PostMapping("/make")
    public String makeGame(HttpSession session, String gameName, String[] playerName,
                           @RequestParam("playerImgPath") MultipartFile[] file) {

// 로그인
        LoginUserResponseDTO login = (LoginUserResponseDTO) session.getAttribute("login");

        if (login == null) {
            return "redirect:/account/sign-in";
        }

//        for (MultipartFile multipartFile : file) {
//            log.info("이미지파일의 이름을 알려주세요 {}", multipartFile.getOriginalFilename());
//            savePath = fileUtil.uploadFile(multipartFile, rootPath);
//        }
        for (String s : playerName) {
            log.info("playerName은 무엇일까요 {}", s);
        }
        log.info("/games/make POST! gameName: {}", gameName);


        GameInsertRequestDTO gameInsertRequestDTO = GameInsertRequestDTO.builder()
                .gameName(gameName)
                .accountId(login.getAccountId())
                .build();
        int gameId = 0;
        gameId = gameService.insertGame(gameInsertRequestDTO);
        log.info("gameId: {}", gameId);

//        각 이미지 경로넣기 및 이름 저장
        String savePath = null;
        for (int i = 0; i < file.length; i++) {
            savePath = fileUtil.uploadFile(file[i],rootPath);
            PlayerRegisterRequestDTO playerRegisterRequestDTO = PlayerRegisterRequestDTO.builder()
                    .gameId(gameId)
                    .playerName(playerName[i])
                    .playerImgPath(savePath)
                    .build();
//      log.info("이게 맞나? {}",playerRegisterRequestDTO);
            playerService.registerPlayer(playerRegisterRequestDTO);
        }

        return "redirect:/games/modify?gameId=" + gameId;
    }

    // 랭킹 페이지 이동
    @GetMapping("/reply")
    public String makeRanking(HttpSession session) {
        System.out.println("들옴");
        log.info(" session: {}", session.getAttribute("login"));
        return "rank/ranking";
    }

    // 게임 수정 페이지 이동
    @GetMapping("/modify")
    public String modifyGame(Integer gameId, Model model, HttpSession session) {

        log.info("/games/modify GET! gameId : {} ", gameId);

        if (session.getAttribute(LoginUtil.LOGIN_KEY) == null) {
            return "redirect:/account/sign-in";
        }

        Game game = gameService.findGameById(gameId);

        if (!LoginUtil.isAdmin(session) && !LoginUtil.isMine(session, game.getAccountId())) {
            return "redirect:/games/list";
        }


        model.addAttribute("gameId", gameId);

        return "games/modify";
    }

    // 게임 수정 요청
    @PostMapping("/modify")
    public String modifyGame(HttpSession session, int gameId) {
        if (!LoginUtil.isMine(session, gameService.findGameById(gameId).getAccountId())
                && !LoginUtil.isAdmin(session)) {
            return "redirect:/games/list";
        }

        return "redirect:/";
    }

    // 내가 만든 월드컵 목록 이동
    @GetMapping("/my-world-cup")
    public String myWorldCup(Model model, Search page, HttpSession session) {

        if (session.getAttribute("login") == null) {
            return "redirect:/account/sign-in";
        }

        log.info("/games/my-world-cup GET! page: {}", page);
        model.addAttribute("gameList", gameService.findGameByAccountId(LoginUtil.getCurrentLoginMemberAccount(session), page));
        model.addAttribute("maker", new PageMaker(page, gameService.countGame()));

        return "games/list";
    }

    // 게임 플레이 페이지 이동
    @GetMapping("/start")
    public String gameStart(int gameId, Model model) {
        int playerCount = gameService.countPlayer(gameId);

        gameService.increasePlayCount(gameId);

        model.addAttribute("gameId", gameId);
        model.addAttribute("playerCount", playerCount);
        model.addAttribute("gameName", gameService.findGameById(gameId).getGameName());

        return "games/start";
    }

    // 게임 삭제 요청
    @GetMapping("/delete")
    public String delete(int gameId, HttpSession session) {

        if (!LoginUtil.isMine(session, gameService.findGameById(gameId).getAccountId())
                && !LoginUtil.isAdmin(session)) {
            return "redirect:/games/list";
        }

        gameService.deleteGame(gameId);

        return "redirect:/games/list";
    }

}
