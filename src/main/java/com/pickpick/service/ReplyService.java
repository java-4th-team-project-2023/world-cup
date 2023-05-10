package com.pickpick.service;

import com.pickpick.dto.page.Page;
import com.pickpick.dto.page.PageMaker;
import com.pickpick.dto.reply.ReplyDetailResponseDTO;
import com.pickpick.dto.reply.ReplyListResponseDTO;
import com.pickpick.dto.reply.ReplySaveRequestDTO;
import com.pickpick.entity.Reply;
import com.pickpick.repository.ReplyMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReplyService {

    private final ReplyMapper replyMapper;


    public ReplyListResponseDTO getList(int gameId, Page page) {

        List<ReplyDetailResponseDTO> replyList = replyMapper.findAll(gameId, page)
                .stream()
                .map(reply -> new ReplyDetailResponseDTO(reply))
                .collect(Collectors.toList());
        int count = replyMapper.count(gameId);

        return ReplyListResponseDTO.builder()
                .count(count)
                .pageMaker(new PageMaker(page,count))
                .replyList(replyList)
                .build();
    }

    public ReplyListResponseDTO save(ReplySaveRequestDTO dto) throws SQLException {
        Reply reply = dto.toEntity();
        boolean flag = replyMapper.save(reply);
        if (!flag) {
            log.warn("replu registered fail!");
            throw new SQLException("댓글 저장 실패");
        }
        return getList(dto.getGameId(),new Page(1,20));
    }
}
