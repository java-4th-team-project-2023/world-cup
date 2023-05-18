package com.pickpick.repository;

import com.pickpick.dto.page.Page;
import com.pickpick.entity.Reply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReplyMapper {

    // 댓글 등록
    boolean save(Reply reply);

    // 댓글 수정
    boolean modify(Reply reply);

    // 댓글 삭제
    boolean deleteOne(int replyNo);

    // 댓글 개별 조회
    Reply findOne(int replyNo);

    // 댓글 목록 조회
    List<Reply> findAll(
            @Param("gId") int gameId,
            @Param("page")Page page
            );

    // 총 댓글 수 조회
    int count(int gameId);

    // 해당 회원이 좋아요한 댓글 존재하는지
    int findLikeOne(@Param("replyNo") int replyNo,@Param("accountId") String accountId);

    // 좋아요하면 테이블 data넣기
    boolean addLikeUser(@Param("replyNo")int replyNo,@Param("accountId") String accountId);

    // 좋아요 횟수 올리기
    int likeUpCounting(int replyNo);

    // 해당 회원이 신고한 댓글 존재하는지
    int findReportOne(@Param("replyNo") int replyNo,@Param("accountId") String accountId);

    // 신고하면 테이블 data넣기
    boolean addReportUser(@Param("replyNo")int replyNo,@Param("accountId") String accountId);

    // 신고 횟수 올리기
    int ReportUpCounting(int replyNo);
}
