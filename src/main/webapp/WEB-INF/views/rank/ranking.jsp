<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <%@ include file="../include/static-head.jsp" %>

    <link rel="stylesheet" href="/assets/css/reply.css">
    <link rel="stylesheet" href="/assets/css/ranking.css">

    <!-- <script src="/assets/js/bottombtn.js" defer></script> -->
    <script src="/assets/js/search.js" defer></script>
    <!-- <script src="/assets/js/localdate.js" defer></script> -->

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


                <!-- 랭킹 페이지 전체 -->
                <section class="ranking-wrapper">
                    <!-- 랭킹 페이지 header -->
                    <nav>
                        <ul class="rkheader">
                            <!-- 랭킹 페이지 header 목록 -->
                            <li class="rkheader-list" id="Ranking">
                                <p class="rkheader-list-text">순위</p>
                            </li>
                            <li class="rkheader-list" id="Image">
                                <p class="rkheader-list-text">이미지</p>
                            </li>
                            <li class="rkheader-list" id="Name">
                                <p class="rkheader-list-text">이름</p>
                            </li>
                            <li class="rkheader-list" id="Winning-Percentage">
                                <p class="rkheader-list-text">우승 비율</p>
                            </li>
                            <li class="rkheader-list" id="Winning-Rate">
                                <p class="rkheader-list-text">승률</p>
                            </li>
                        </ul>
                    </nav>


                    <!-- 반복 -->
                    <!-- 랭킹 목록 box -->
                    <c:forEach var="player" items="${playerList}">
                    <section class="rkboard-ranking-wrapper">
                        <ul class="rkboard-ranking-list-box">
                            <!-- 순위 -->
                            <li class="rkboard-ranking-list" id="Ranking">
                                <p class="rkboard-list-text">1</p>
                            </li>
                            <!-- 이미지 -->
                            <li class="rkboard-ranking-list" id="Image">
                                <a href="/assets/img/cat.jpg">
                                    <img src="${player.playerImgPath}" alt="${player.playerName}">
                                </a>
                            </li>
                            <!-- 이름 -->
                            <li class="rkboard-ranking-list" id="Name">
                                <p class="rkboard-list-text">${player.playerName}</p>
                            </li>
                            <!-- 우승 비율 -->
                            <li class="rkboard-ranking-list" id="Winning-Percentage" data-final="${player.finalWinRate}">
                                <div class="graph">
                                    <div class="bar-text">
                                        <p>${player.finalWinRate}</p>
                                    </div>
                                    <div class="bar" style="width: '${player.finalWinRate}%'"></div>
                                </div>
                            </li>
                            <!-- 승률 -->
                            <li class="rkboard-ranking-list" id="Winning-Rate" data-winning="${player.matchWinRate}">
                                <div class="graph">
                                    <div class="bar-text">
                                        <p>${player.matchWinRate}</p>
                                    </div>
                                    <div class="bar" style="width: '${player.matchWinRate}%';"></div>
                                </div>
                            </li>
                        </ul>
                    </section>
                </c:forEach>

                </section>


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
                        <a href="/views/jsp/ranking.html">
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
                <c:if test="${not empty login}">
                <section class="rpboard-user-nickname-reply-replyBtn-box">
                        <input class="user-nickname" type="text" placeholder="닉네임" name="writer">
                    <div class="rpboard-input-btn-box">
                        <div class="rpboard-input-box"><input type="text" name="text" class="input-box"
                                placeholder="댓글을 입력해주세요..."></input></div>
                        <div class="rpboard-rpBtn-box">
                            <button class="rpBtn" type="button">
                                <p>등 록
                                    <p>
                            </button>
                        </div>
                    </div>
                </section>
            </c:if>


            </section> <!-- end reply-box -->


        </div>
    </section>
    <!-- reply container 끝 -->


    <script>
        // 해당 게임 아이디 (진호형꺼에서 받아오기)
        const gameId = '${gameId}';

        // 댓글 요청 URI
        const URL = '/api/replies';

        // 로그인한 회원 계정명
        const currentAccount = '${login.accountId}';
        console.log("!!!" + currentAccount);

        // 비동기 처리(댓글번호)
        const $viewMain = document.querySelector('.rpboard-viewmain');

        // 우승 비율
        const final = '${player.finalWinRate}';
        // 총 경기 비율
        const match = '${player.matchWinRate}';

        if(isNaN(final))


        // 댓글 목록 렌더링 함수
        function renderReplyList({
            count,
            pageMaker,
            replyList
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
                    console.log("###" + rep.accountId);
                    const {
                        gameId,
                        replyNo,
                        writer,
                        text,
                        date,
                        accountId,
                        pageMaker
                    } = rep;

                    tag += `
                    <div class="rpboard-rpbox" data-reply-no="\${replyNo}">
                        <div class="rpboard-nickname-local-date-box">`;

                    if (currentAccount === rep.accountId) {
                        tag += `
                            <div class="rpboard-delete-replies-box">
                            <button class="rpboard-delete-replies-btn"></button>
                            </div>`;
                    }

                    tag += `
                            <div class="rpboard-nickname">\${writer}</div>
                            <span class="rpboard-local-date-box">\${date}</span>
                        </div>
                        <div class="rpboard-replies-box">
                            <div class="rpboard-replies">\${text}</div>`;

                    if (currentAccount === rep.accountId) {
                        tag += `
                            <div class="rpboard-modify-replies-box">
                            <button class="rpboard-modify-replies-btn"></button>
                            </div>`;
                    }

                    tag += `
                        </div>
                        <div class="rpboard-like-report-box">
                            <div class="like" id="Like">
                            <button class="rpboard-like-replies-btn">좋아요</button>
                            </div>
                            <div class="report" id="Report">
                            <button class="rpboard-report-replies-btn">신고</button>
                            </div>
                        </div>
                    </div>`;

                }
            }


            // 생성된 댓글 tag 렌더링
            document.querySelector('.rpboard-viewmain').innerHTML = tag;

        }


        // 댓글 목록 불러오기 함수
        function getReplyList(pageNo = 1) {
            fetch(`\${URL}/\${gameId}/page/\${pageNo}`) // ${gameId}
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

                // console.log($rt.value);
                // console.log($rw.value);


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
                    gameId: +gameId
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

                            getReplyList();
                        } else {

                            alert('댓글 등록에 실패함!');
                        }
                    });
            };
        }

        // 댓글 삭제,좋아요,신고 기능 함수
        function replyRemoveClickEvent() {

            $viewMain.onclick = e => {
                const rp = e.target.closest('.rpboard-rpbox');
                // console.log(rp);
                const $replyNo = rp.dataset.replyNo;
                if (e.target.matches('.rpboard-delete-replies-btn')) { // 삭제 기능
                    console.log('삭제버튼 클릭!!');
                    if (!confirm('정말 삭제합니까?')) return;

                    // console.log($replyNo);
                    // 서버에 삭제 비동기 요청
                    fetch(URL + '/' + $replyNo, {
                        method: 'DELETE'
                    }).then(res => {
                        if (res.status === 200) {
                            alert('댓글이 정상 삭제됨!');
                            return res.json();
                        } else {
                            alert('댓글 삭제 실패!');
                        }
                    }).then(responseResult => {
                        renderReplyList(responseResult);
                    });
                }
                else if (e.target.matches('.rpboard-like-replies-btn')) { // 좋아요 기능

                    console.log(document.querySelector('.rpboard-nickname-local-date-box'));
                    console.log('좋아요 클릭!!');

                    // # 서버로 보낼 데이터
                    const payload = {
                        replyNo: $replyNo,
                        gameId: +gameId
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
                    fetch(URL + "/like", requestInfo)
                        .then(res => {
                            if (res.status === 200) {
                                alert('좋아요가 정상!');

                                getReplyList();
                            } else {
                                alert('좋아요 실패함!');
                            }
                        });
                }
                else if (e.target.matches('.rpboard-report-replies-btn')) { // 신고 기능

                    console.log(document.querySelector('.rpboard-nickname-local-date-box'));
                    console.log('신고 클릭!!');

                    // # 서버로 보낼 데이터
                    const payload = {
                        replyNo: $replyNo,
                        gameId: +gameId
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
                    fetch(URL + "/report", requestInfo)
                        .then(res => {
                            if (res.status === 200) {
                                alert('신고 정상!');

                                // 마지막페이지 번호
                                // const lastPageNo = document.querySelector('.pagination').dataset.fp;
                                getReplyList();
                            } else {
                                alert('신고 실패함!');
                            }
                        });
                }
                    else{
                        console.log("다른곳 클릭");
                        return;
                }   
            }


            // else if (e.target.matches('#replyModBtn')) {
            //     // console.log('수정 화면 진입!');

            //     // 클릭한 수정 버튼 근처에 있는 텍스트 읽기
            //     const replyText = e.target.parentElement.previousElementSibling.textContent;
            //     // console.log(replyText);

            //     // 모달에 모달바디에 textarea에 읽은 텍스트를 삽입
            //     document.getElementById('modReplyText').value = replyText;

            //     // 다음 수정완료 처리를 위해 미리 
            //     // 수정창을 띄울 때 댓글번호를 모달에 붙여놓자
            //     const $modal = document.querySelector('.modal');
            //     $modal.dataset.rno = rno;
            // }
        };



        //========= 메인 실행부 =========//
        (function () {

            // 첫 댓글 페이지 불러오기
            getReplyList();

            // 댓글 등록 이벤트 등록
            makeReplyRegisterClickEvent();

            // 삭제 이벤트 등록
            replyRemoveClickEvent();

        })();
    </script>

</body>

</html>