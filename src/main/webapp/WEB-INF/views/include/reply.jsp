<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 댓글 게시판 box -->
<section class="reply-box">
    <!-- 댓글 게시판 header -->
    <div class="rpheader">
        <!-- 댓글 게시판 header 목록 box -->
        <ul class="rpheader-list-box">
            <!-- 댓글 게시판 header 목록 버튼 -->
            <a href="/games/start?gameId=${gameId}">
                <li class="rpheader-list">다시하기</li>
            </a>
            <a href="/games/list">
                <li class="rpheader-list">목 록</li>
            </a>
            <a href="/rank/ranking?gameId=${gameId}">
                <li class="rpheader-list">랭 킹</li>
            </a>
        </ul> <!-- end rpheader-list-box -->
    </div> <!-- end rpheader -->

    <!-- 댓글 게시판 main -->
    <section class="rpboard-box">
        <!-- 댓글 게시판 main box-->
        <div class="rpboard-list-box">
            <!-- 댓글 게시판 목록-->
            <div class="rpboard-list">
                <!-- 댓글 게시판 목록 header -->

                <div class="rplist-header">
                    <!-- 댓글 게시판 목록 댓글쓰기 (아래로 내려가기) 버튼 -->


                    <!-- 댓글 총 갯수 -->
                    <div class="rpcount">
                        <p id="replyCnt">총 댓글 : 0 개</p>
                    </div> <!-- end rpcount -->

                    <!-- 댓글 정렬 기준 -->
                    <div class="rpsorting">정렬 기준</div> <!-- end rpsorting -->

                    <!-- 댓글 정렬기준 드롭 다운 버튼 -->
                    <div class="rpsorting-wrapper">
                        <nav>
                            <ul class="rpsorting-list-box">
                                <li class="rpsorting-list like-reply" data-sorted="like">
                                    <p>인기 댓글순</p>
                                </li>
                                <li class="rpsorting-list fast-reply" data-sorted="fast">
                                    <p>최신순</p>
                                </li> <!-- end rpsorting-list -->
                            </ul> <!-- end rpsorting-list-box -->
                        </nav>
                    </div> <!-- end rpsorting-wrapper -->
                </div> <!-- end rplist-header -->

                <!-- 댓글 main 전체 -->
                <section class="rpboard-viewmain-box">
                    <!-- 댓글 main -->
                    <div class="rpboard-viewmain">


                        <!-- 반복 -->
                        <!-- 댓글 박스 시작 -->
                        <!-- <div class="rpboard-rpbox">

                        </div>  -->
                        <!-- end rpboard-rpbox -->
                        <!-- 댓글 박스 종료 -->




                    </div> <!-- end rpboard-viewmain -->
                    <!-- <div class="rpboard-more-view-btn">
                        <p>더 보기</p>
                    </div> -->
                </section> <!-- end rpboard-viewmain-box -->


            </div> <!-- end rpboard-list -->
        </div> <!-- end rpboard-list-box -->
    </section> <!-- end rpboard-box -->

    <!-- 댓글 입력창 + 댓글 입력 버튼 -->
    <c:if test="${not empty login}">
        <section class="rpboard-user-nickname-reply-replyBtn-box">
            <input class="user-nickname" type="text" placeholder="닉네임" name="writer" value="익명">
            <div class="rpboard-input-btn-box">
                <div class="rpboard-input-box"><input type="text" name="text" class="input-box"
                                                    placeholder="댓글을 입력해주세요..."></input></div>
                <div class="rpboard-rpBtn-box">
                    <button class="rpBtn" type="button"><p>등 록
                        <p></button>
                </div>
            </div>
        </section>
    </c:if>
    <c:if test="${empty login}">
        <section class="rpboard-user-nickname-reply-replyBtn-box" style="background-color: #fff; font-size: 40px; display: flex; justify-content: center; align-content: center;">
            댓글 입력은 로그인이 필요합니다.
        </section>
    </c:if>

</section>
<!-- end reply-box -->

