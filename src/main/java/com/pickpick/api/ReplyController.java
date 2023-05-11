package com.pickpick.api;

import com.pickpick.dto.page.Page;
import com.pickpick.dto.reply.ReplyListResponseDTO;
import com.pickpick.dto.reply.ReplyModifyRequestDTO;
import com.pickpick.dto.reply.ReplySaveRequestDTO;
import com.pickpick.entity.Reply;
import com.pickpick.service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/replies")
@Slf4j
public class ReplyController {

    private final ReplyService replyService;

    // 댓글 20개씩 조회
    @GetMapping("/{gameId}/page/pageNo")
    public ResponseEntity<?> replyList(
            @PathVariable int gameId,
            @PathVariable int pageNo
    ){
        log.info("/api/replies/{}/page/{} : GET!!",gameId,pageNo);

        Page page = new Page();
        page.setPageNo(pageNo);
        page.setAmount(20);

        ReplyListResponseDTO replyList = replyService.getList(gameId, page);
        return ResponseEntity.ok().body(replyList);
    }

    // 댓글 등록 기능
    @PostMapping
    public ResponseEntity<?> saveReply(
            @Validated @RequestBody ReplySaveRequestDTO dto
            , BindingResult result
            ){
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body("입력값을 제대로 입력해주세요!");
        }

        try {
            ReplyListResponseDTO responseDTO = replyService.save(dto);
            return ResponseEntity.ok().body(responseDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("등록에 실패했습니다");
        }
    }

    // 댓글 수정 기능
    @PutMapping
    public ResponseEntity<?> modifyReply(
            @Validated @RequestBody ReplyModifyRequestDTO dto
            ,BindingResult result
            ){
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body("입력값을 제대로 입력해주세요!");
        }
        try {
            ReplyListResponseDTO responseDTO = replyService.modify(dto);
            return ResponseEntity.ok().body(responseDTO);
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("수정 실패");
        }
    }

}
