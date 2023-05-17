package com.pickpick.service;

import com.pickpick.dto.page.Page;
import com.pickpick.dto.page.PageMaker;
import com.pickpick.dto.reply.response.ReplyDetailResponseDTO;
import com.pickpick.dto.reply.response.ReplyListResponseDTO;
import com.pickpick.dto.reply.request.ReplyModifyRequestDTO;
import com.pickpick.dto.reply.request.ReplySaveRequestDTO;
import com.pickpick.entity.Reply;
import com.pickpick.repository.ReplyMapper;
import com.pickpick.util.LoginUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import static com.pickpick.util.LoginUtil.*;
import static java.util.stream.Collectors.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReplyService {

    private final ReplyMapper replyMapper;

    // 댓글 조회기능
    public ReplyListResponseDTO getList(int gameId, Page page) {

        List<ReplyDetailResponseDTO> replyList = replyMapper.findAll(gameId, page)
                .stream()
                .map(ReplyDetailResponseDTO::new)
                .collect(toList());
        int count = replyMapper.count(gameId);
        log.info("!!!! count :{}",count);
        return ReplyListResponseDTO.builder()
                .count(count)
                .pageMaker(new PageMaker(page,count))
                .replyList(replyList)
                .build();
    }

    // 댓글 저장 기능
    public ReplyListResponseDTO save(ReplySaveRequestDTO dto, HttpSession session) throws SQLException {

        Reply reply = dto.toEntity();
        if (LoginUtil.isLogin(session)){
            reply.setAccountId(getCurrentLoginMemberAccount(session));
        }
        log.info("!!!!!gameId : {}",reply.getGameId());
        boolean flag = replyMapper.save(reply);
        if (!flag) {
            log.warn("reply save fail!");
            throw new SQLException("댓글 저장 실패");
        }
        return getList(dto.getGameId(),new Page(1,20));
    }

    public ReplyListResponseDTO modify(ReplyModifyRequestDTO dto) throws SQLException{

        Reply reply = dto.toEntity();
        boolean flag = replyMapper.modify(reply);
        if (!flag){
            log.warn("reply modify fail!");
            throw new SQLException("댓글 수정 실패");
        }

        return getList(dto.getGameId(),new Page(1,20));

    }

    // 댓글 삭제 서비스
    @Transactional // 트랜잭션 처리
    public ReplyListResponseDTO delete(final int replyNo)
            throws Exception {

        int gameId = replyMapper.findOne(replyNo).getGameId();
        replyMapper.deleteOne(replyNo);

        return getList(
                gameId
                , new Page(1, 10)
        );
    }

    // 댓글 좋아요 기능
    public boolean likeReply(int replyNo,HttpSession session) {
        if(isLogin(session))return false;
        String loginMemberAccount = getCurrentLoginMemberAccount(session);

        int likeOne = replyMapper.findLikeOne(replyNo, loginMemberAccount);
        if (likeOne == 1) return false;
        replyMapper.addLikeUser(replyNo,loginMemberAccount);
        replyMapper.likeUpCounting(replyNo);
        return true;
    }
}
