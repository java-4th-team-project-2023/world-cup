package com.pickpick.api;

import com.pickpick.dto.page.Page;
import com.pickpick.dto.reply.request.ReplyLikeRequestDTO;
import com.pickpick.dto.reply.response.ReplyListResponseDTO;
import com.pickpick.dto.reply.request.ReplyModifyRequestDTO;
import com.pickpick.dto.reply.request.ReplySaveRequestDTO;
import com.pickpick.service.ReplyService;
import com.pickpick.util.LoginUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/replies")
@Slf4j
public class ReplyController {

    private final ReplyService replyService;

    // 댓글 20개씩 조회
    @GetMapping("/{gameId}/page/{pageNo}")
    public ResponseEntity<?> replyList(
            @PathVariable int gameId,
            @PathVariable int pageNo
    ){
        log.info("/api/replies/{}/page/{} : GET!!",gameId,pageNo);

        ReplyListResponseDTO replyList = replyService.getList(gameId);
//        log.info("replyList : {}", replyList);
        return ResponseEntity.ok().body(replyList);
    }

    // 댓글 등록 기능
    @PostMapping
    public ResponseEntity<?> saveReply(
            @Validated @RequestBody ReplySaveRequestDTO dto
            , HttpSession session
            , BindingResult result
            ){
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body("입력값을 제대로 입력해주세요!");
        }

        try {
            ReplyListResponseDTO responseDTO = replyService.save(dto,session);
            return ResponseEntity.ok().body(responseDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("등록에 실패했습니다");
        }
    }

    // 댓글 좋아요 기능
    @PostMapping("/like")
    public ResponseEntity<?> likeReply(
            @Validated @RequestBody ReplyLikeRequestDTO dto
            , HttpSession session) {
        // 댓글 좋아요 로직 수행
        log.info("rNo {}",dto);
        replyService.likeReply(dto,session);
        return ResponseEntity.ok().build();
    }



    // 댓글 신고 기능
    @PostMapping("/report")
    public ResponseEntity<?> reportReply(
            @Validated @RequestBody ReplyLikeRequestDTO dto
            , HttpSession session) {
        // 댓글 좋아요 로직 수행
        log.info("!!!! {}",dto);
        replyService.reportReply(dto,session);
        return ResponseEntity.ok().build();
    }

    // 댓글 삭제 요청 처리
    @DeleteMapping("/{replyNo}")
    public ResponseEntity<?> delete(@PathVariable int replyNo) {

        log.info("/api/replies/{} DELETE!", replyNo);

        try {
            ReplyListResponseDTO responseDTO
                    = replyService.delete(replyNo);
            return ResponseEntity
                    .ok()
                    .body(responseDTO);
        } catch (Exception e) {
            return ResponseEntity
                    .internalServerError()
                    .body(e.getMessage());
        }

    }

    // 댓글 수정 기능
    @PutMapping("/modify")
    public ResponseEntity<?> modify(
            @Validated @RequestBody ReplyModifyRequestDTO dto,
            HttpSession session){

            ReplyListResponseDTO responseDTO = replyService.modify(dto,session);


        return ResponseEntity.ok().body(responseDTO);
    }
}
