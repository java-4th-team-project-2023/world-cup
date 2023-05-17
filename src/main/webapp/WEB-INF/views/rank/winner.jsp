<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <%@ include file="../include/static-head.jsp" %>

    <link rel="stylesheet" href="/assets/css/reply.css">

</head>
<body>

<%@ include file="../include/header.jsp" %>

<!--  -->



    <section class="rank-reply-wrapper">

        <!-- 결과창 + 댓글게시판 box -->
        <div class="rank-reply-box">
            <!-- 결과창 box -->
            <section class="rank-box">
                <!-- 전체 갯수 출력 + 검색창 box 묶음 -->
                <div class="select-search-box">

                    <!-- 전체 갯수 출력 창 -->
                    <select class="select-view-number" id="Select-View-Number">
                        <!-- 전체 갯수 출력 리스트 -->
                        <option value="10" class="select-number">10</option>
                        <option value="10" class="select-number">20</option>
                        <option value="10" class="select-number">30</option>
                    </select> <!-- end select-view-number -->

                    <!-- 검색창 box -->
                    <div class="search-box">
                        <!-- 검색창 text -->
                        <input type="text" class="search-text" id="Search-Text" placeholder="Search...">
                        <!-- 검색창 버튼 -->
                        <span><button type="" class="search-btn" id="Search-Btn"><img src="/assets/img/Search.png"
                                                                                      alt="search" id="Search"></button></span>
                    </div> <!-- end search-box -->
                </div> <!-- end select-search-box -->

                <div class="winner-img-box">
                    <div class="winner-img-name">OOO 월드컵 OOO강 우승</div>
                    <div class="winner-img"></div>
                </div>

            </section> <!-- end rank-box -->

            <!-- 댓글 게시판 box -->
            <section class="reply-box">
                <!-- 댓글 게시판 header -->
                <div class="rpheader">
                    <!-- 댓글 게시판 header 목록 box -->
                    <ul class="rpheader-list-box">
                        <!-- 댓글 게시판 header 목록 버튼 -->
                        <a href="#">
                            <li class="rpheader-list">다시하기</li>
                        </a>
                        <a href="/views/include/header.html">
                            <li class="rpheader-list">목 록</li>
                        </a>
                        <a href="/rank/ranking">
                            <li class="rpheader-list">랭 킹</li>
                        </a>
                        <a href="#">
                            <li class="rpheader-list">공 유</li>
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
                                <div class="bot-btns">
                                    <p class="moveBottomBtn">댓글 쓰러가기</p>
                                </div>

                                <!-- 댓글 총 갯수 -->
                                <div class="rpcount">
                                    <p>총 댓글 : 0 개</p>
                                </div> <!-- end rpcount -->

                                <!-- 댓글 정렬 기준 -->
                                <div class="rpsorting">정렬 기준</div> <!-- end rpsorting -->

                                <!-- 댓글 정렬기준 드롭 다운 버튼 -->
                                <div class="rpsorting-wrapper">
                                    <nav>
                                        <ul class="rpsorting-list-box">
                                            <li class="rpsorting-list">
                                                <p>인기 댓글순</p>
                                            </li>
                                            <li class="rpsorting-list">
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
                                    <div class="rpboard-rpbox">
                                        <!-- 사용자 닉네임 + 작성일자 box -->
                                        <div class="rpboard-nickname-local-date-box">
                                            <!-- 사용자 닉네임 -->
                                            <div class="rpboard-nickname">조경훈</div>
                                        </div> <!-- end rpboard-nickname-local-date-box -->
                                        <!-- 사용자 댓글 -->
                                        <div class="rpboard-replies-box">
                                            <div class="rpboard-replies">나는야 핵인싸 개간지</div>
                                        </div>
                                        <!-- 댓글 좋아요 + 댓글 신고 box -->
                                        <div class="rpboard-like-report-box">
                                            <!-- 댓글 좋아요 -->
                                            <div class="like" id="Like">좋아요</div>
                                            <!-- 댓글 신고 -->
                                            <div class="report" id="Report">신고</div>
                                        </div> <!-- end rpboard-like-report-box -->
                                        <!-- 대댓글 -->
                                        <div class="reply-to-comment">댓글 n개</div>
                                    </div> <!-- end rpboard-rpbox -->
                                    <!-- 댓글 박스 종료 -->


                                    <!-- 댓글 더보기 버튼 -->


                                </div> <!-- end rpboard-viewmain -->
                                <div class="rpboard-more-view-btn">
                                    <p>더 보기</p>
                                </div>
                            </section> <!-- end rpboard-viewmain-box -->


                        </div> <!-- end rpboard-list -->
                    </div> <!-- end rpboard-list-box -->
                </section> <!-- end rpboard-box -->

                <!-- 댓글 입력창 + 댓글 입력 버튼 -->
                <section class="rpboard-user-nickname-reply-replyBtn-box">
                    <input class="user-nickname" type="text" placeholder="닉네임" name="writer">
                    <div class="rpboard-input-btn-box">
                        <div class="rpboard-input-box"><input type="text" name="text" class="input-box"
                                                              placeholder="댓글을 입력해주세요..."></input></div>
                        <div class="rpboard-rpBtn-box">
                            <button class="rpBtn" type="button"><p>등 록
                                <p></button>
                        </div>
                    </div>
                </section>


            </section> <!-- end reply-box -->


        </div>
    </section>
    <!-- reply container 끝 -->


<script>
    // 해당 게임 아이디 (진호형꺼에서 받아오기)
    const gameId = '${game.gameId}';

    // 댓글 요청 URI
    const URL = '/api/replies';

    // 댓글 목록 렌더링 함수
    function renderReplyList({
                                 count, pageMaker, replyList
                             }) {

        // 총 댓글 수 렌더링
        document.getElementById('replyCnt').textContent = "총 댓글 수 : " + count + " 개";

        // 댓글 내용 렌더링
        // 각 댓글 하나의 태그
        let tag = '';

        if (replyList === null || replyList.length === 0) {
            document.querySelector('.rpboard-viewmain-box').textContent = "댓글이 아직 없습니다!";

        } else {
            for (let rep of replyList) {

                const {gameId, replyNo, writer, text, date} = rep;

                // document.querySelector('.rpboard-nickname').textContent = writer;
                // document.querySelector('.rpboard-replies').textContent = text;
                // document.querySelector('.rpboard-nickname-local-date-box').textContent = date;

                tag += "<div class='rpboard-rpbox'>" +
                    "<div class='rpboard-nickname-local-date-box' data-replyNo='" + replyNo + "'>" +
                    "<div class='rpboard-nickname'>" + writer + "</div>" +
                    "<span class='rpboard-local-date-box'>" + date + "</span>" +
                    "</div>" +
                    "<div class='rpboard-replies-box'>" +
                    "<div class='rpboard-replies'>" + text + "</div>" +
                    "</div>" +
                    "<div class='rpboard-like-report-box'>" +
                    "<div class='like' id='Like'>좋아요</div>" +
                    "<div class='report' id='Report'>신고</div>" +
                    "</div>" +
                    "</div>";


                // if (currentAccount === rep.account || auth === 'ADMIN') {
                //     tag +=
                //         "         <a id='replyModBtn' class='btn btn-sm btn-outline-dark' data-bs-toggle='modal' data-bs-target='#replyModifyModal'>수정</a>&nbsp;" +
                //         "         <a id='replyDelBtn' class='btn btn-sm btn-outline-dark' href='#'>삭제</a>";
                // // }
                // tag += "       </div>" +
                //     "    </div>" +
                //     " </div>";
            }
        }


        // 생성된 댓글 tag 렌더링
        document.querySelector('.rpboard-viewmain').innerHTML = tag;

        // 페이지 렌더링
        // renderPage(pageInfo);

    }


    // 댓글 목록 불러오기 함수
    function getReplyList(pageNo = 1) {
        fetch(`\${URL}/2/page/\${pageNo}`) // ${gameId}
            .then(res => res.json())
            .then(responseResult => {
                console.log(responseResult);
                renderReplyList(responseResult);
            });


    }

    // 댓글 등록 처리 이벤트 함수
    function makeReplyRegisterClickEvent() {

        const $regBtn = document.querySelector('.rpBtn');

        $regBtn.onclick = e => {

            const $rt = document.querySelector('.input-box');
            const $rw = document.querySelector('.user-nickname');

            console.log($rt.value);
            console.log($rw.value);


            // 클라이언트 입력값 검증
            if ($rt.value.trim() === '') {
                alert('댓글 내용은 필수입니다!');
                return;
            } else if ($rw.value.trim() === '') {
                alert('댓글 작성자 이름은 필수입니다!');
                return;
            } else if ($rw.value.trim().length < 2 || $rw.value.trim().length > 8) {
                alert('댓글 작성자 이름은 2~8자 사이로 작성하세요!');
                return;
            }


            // # 서버로 보낼 데이터
            const payload = {
                text: $rt.value,
                writer: $rw.value,
                gameId: 2
            };

            // # GET방식을 제외하고 필요한 객체
            const requestInfo = {
                method: 'POST',
                headers: {
                    'content-type': 'application/json'
                },
                body: JSON.stringify(payload)
            };

            // # 서버에 POST요청 보내기
            fetch(URL, requestInfo)
                .then(res => {
                    if (res.status === 200) {
                        alert('댓글이 정상 등록됨!');
                        // 입력창 비우기
                        $rt.value = '';
                        $rw.value = '';

                        // 마지막페이지 번호
                        // const lastPageNo = document.querySelector('.pagination').dataset.fp;
                        getReplyList();
                    } else {
                        alert('댓글 등록에 실패함!');
                    }
                });
        };
    }

    //========= 메인 실행부 =========//
    (function () {

// 첫 댓글 페이지 불러오기
        getReplyList();
        getReplyList();

// 댓글 등록 이벤트 등록
        makeReplyRegisterClickEvent();
    })();

</script>

</body>
</html>