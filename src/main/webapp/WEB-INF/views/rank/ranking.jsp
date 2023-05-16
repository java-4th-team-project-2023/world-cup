<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
    <link rel="stylesheet" href="/assets/css/reply.css">
    <script src="/assets/js/burgerbtn.js" defer></script>
    <script src="/assets/js/topbtn.js" defer></script>
    <!-- <script src="/assets/js/bottombtn.js" defer></script> -->
    <script src="/assets/js/search.js" defer></script>
    <!-- <script src="/assets/js/localdate.js" defer></script> -->
</head>
<body>

    <!--header 시작 -->
    <header>
        <!-- header -->
        <div class="header">
            <!-- header 묶음 box -->
            <div class="header-container">
                <!-- header-logo -->
                <h1 class="logo">
                    <!-- header-logo -->
                    <a href="#" id="Logo"><i class="far fa-hand-rock"></i></a>
                </h1>

                <!-- 상단 BAR-MENU -->
                <nav class="gnb">
                    <!-- 상단 BAR-MENU box -->
                    <ul class="header-menu-box">
                        <!-- 상단 BAR-MENU 목록 -->
                        <li class="header-menu-list"><a href="#">HOME</a></li>
                        <li class="header-menu-list"><a href="#">월드컵 만들기</a></li>

                        <!-- <c:if test="${}">  (반복처리) -->
                        <li class="header-menu-list"><a href="#">내가 만든 월드컵</a></li>
                        <div class="login-box"><a href="/views/jsp/login.html" id="Login">LOGIN</a></div>
                        <!-- </c:if> -->

                    </ul> <!-- end header-menu-box -->

                    <!-- 햄버거 버튼 시작 -->
                    <input type="checkbox" id="icon">
                    <!-- 햄버거 버튼 -->
                    <label for="icon">
                        <span></span> <!-- 햄버거 버튼 첫번째 막대기 -->
                        <span></span> <!-- 햄버거 버튼 두번째 막대기 -->
                        <span></span> <!-- 햄버거 버튼 세번째 막대기 -->
                    </label>

                    <!-- 햄버거 버튼 클릭시 나오는 메뉴창 -->
                    <nav class="inr-menu">
                        <!-- 햄버거 버튼 클릭시 나오는 메뉴창 리스트 box-->
                        <ul class="inr-menu-list-box">
                            <!-- 햄버거 버튼 클릭시 나오는 메뉴창 리스트 -->
                            <li class="inr-menu-list"><a href="#">내 정보</a></li>
                            <li class="inr-menu-list"><a href="#">menu2</a></li>
                            <li class="inr-menu-list"><a href="#">menu3</a></li>
                            <li class="inr-menu-list"><a href="#">menu4</a></li>
                            <li class="inr-menu-list"><a href="#">menu5</a></li>
                        </ul> <!-- end inr-menu-list-box -->
                    </nav> <!-- end inr-menu -->
            </div> <!-- end gnb -->
        </div> <!-- end header-container -->
    </header> <!-- header 종료 -->

    <!-- 올라가기 버튼 -->
    <button id="go-top"><svg xmlns="http://www.w3.org/2000/svg" fill="currentColor" class="bi bi-arrow-up-circle-fill"
            viewBox="0 0 16 16">
            <path fill-rule="evenodd"
                d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-7.5 3.5a.5.5 0 0 1-1 0V5.707L5.354 7.854a.5.5 0 1 1-.708-.708l3-3a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1-.708.708L8.5 5.707V11.5z" />
        </svg></button>

    <!--header 끝 -->

    <!--  -->

    <!-- reply container 시작 -->
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
                        <a href="#">
                            <li class="rpheader-list">목 록</li>
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

                                <!-- <button type="button" class="rpwriter"></button> -->

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
                                     <!-- end rpboard-rpbox -->
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
                        <div class="rpboard-input-box"><input type="text" name="text" class="input-box" placeholder="댓글을 입력해주세요..."></input></div>
                        <div class="rpboard-rpBtn-box"><button class="rpBtn" type="button"><p>등 록<p></button></div>
                    </div>
                </section>

                

            </section> <!-- end reply-box -->

            
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
            document.getElementById('replyCnt').textContent = "총 댓글 수 : "+count+" 개";

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
        function getReplyList(pageNo=1) {

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
    }

    else if ($rw.value.trim() === '') {
        alert('댓글 작성자 이름은 필수입니다!');
        return;
    }
    else if ($rw.value.trim().length < 2 || $rw.value.trim().length > 8) {
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
    (function() {

// 첫 댓글 페이지 불러오기
getReplyList();

// 댓글 등록 이벤트 등록
makeReplyRegisterClickEvent();
    })();

    </script>

</body>
</html>