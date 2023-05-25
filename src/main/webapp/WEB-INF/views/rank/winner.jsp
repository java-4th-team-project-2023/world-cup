<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PICKPICK</title>

    <%@ include file="../include/static-head.jsp" %>
    <link rel="icon" href="/assets/img/favicon.png">
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

                <!-- 검색창 box -->
                <div class="search-box">
                    <!-- 검색창 text -->
                    <input type="text" class="search-text" id="Search-Text" placeholder="Search...">
                    <!-- 검색창 버튼 -->
                    <span>
                        <button type="" class="search-btn" id="Search-Btn"><img src="/assets/img/Search.png"
                                                                                  alt="search"
                                                                                  id="Search">
                        </button>
                    </span>
                </div> <!-- end search-box -->
            </div> <!-- end select-search-box -->

            <div class="winner-img-box">
                <div class="winner-img-name"> ${gameName} 월드컵 ${round}강 우승 : ${dto.playerName}</div>
                <div class="winner-img">
                </div>
            </div>

        </section> <!-- end rank-box -->

        <%@ include file="../include/reply.jsp"%>


    </div>
</section>
<!-- reply container 끝 -->

<script>
    // 우승자 사진 뿌려주기
    document.querySelector('.winner-img').style.backgroundImage = 'url("${dto.playerImgPath}")';

    // 해당 게임 아이디 (진호형꺼에서 받아오기)
    const gameId = '${gameId}';

    // 댓글 요청 URI
    const URL = '/api/replies';

    // 로그인한 회원 계정명
    const currentAccount = '${login.accountId}';

    // 비동기 처리(댓글번호)
    const $viewMain = document.querySelector('.rpboard-viewmain');

    // 우승 비율
    const final = '${player.finalWinRate}';
    // 총 경기 비율
    const match = '${player.matchWinRate}';

    const $searchInput = document.getElementById('Search-Text');

    const $searchBtn = document.getElementById('Search');


    // 댓글 목록 렌더링 함수
    function renderReplyList({
                                 count,
                                 replyList
                             }) {

        // console.log("!!!"+replyList);
        // 총 댓글 수 렌더링
        document.getElementById('replyCnt').textContent = "총 댓글 수 : " + count + " 개";

        // 댓글 내용 렌더링
        // 각 댓글 하나의 태그
        let tag = '';

        if (replyList === null || replyList.length === 0) {
            tag += "댓글이 아직 없습니다!";

        } else {
            for (let rep of replyList) {
                console.log("###" + "${login.auth}");
                const {
                    gameId,
                    replyNo,
                    writer,
                    text,
                    date,
                    accountId,
                    likeCount
                } = rep;

                tag += `
                    <div class="rpboard-rpbox" data-reply-no="\${replyNo}">
                        <div class="rpboard-nickname-local-date-box">`;

                if (currentAccount === rep.accountId || "${login.auth}" === 'ADMIN') {
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
                            </div>
                            `;
                }
                tag += `
                    </div>
                        <div class="rpboard-like-report-box">
                                    <div class="like rpboard-like-replies-btn" id="Like">
                                        <span>
                                            <div class="like-count">\${likeCount}</div>
                                        </span>

                                    </div>
                                <div class="report rpboard-report-replies-btn" id="Report">
                                </div>
                            </div>
                        </div>`;


            }
        }
        // 생성된 댓글 tag 렌더링
        $viewMain.innerHTML = tag;

    }


    // 댓글 목록 불러오기 함수
    function getReplyList(sortBy='fast', pageNo = 1) {
        fetch(`\${URL}/\${gameId}/page/\${pageNo}/sort/\${sortBy}`) // ${gameId}
            .then(res => res.json())
            .then(responseResult => {
                // console.log(responseResult);
                renderReplyList(responseResult);
            });

    }

    $likeReply.onclick = e => {
        console.log($likeReply.dataset.sorted);
        getReplyList($likeReply.dataset.sorted);
    }

    $fastReply.onclick = e => {
        console.log($fastReply.dataset.sorted);
        getReplyList($fastReply.dataset.sorted);
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
                        // $rw.value = '익명';

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
                if(currentAccount === ''){
                    alert('로그인 후 사용하세요!');
                    return;
                }
                console.log('삭제버튼 클릭!!');
                if (!confirm('정말 삭제합니까?')) return;

                // console.log($replyNo);
                // 서버에 삭제 비동기 요청
                fetch(URL + '/' + $replyNo, {
                    method: 'DELETE'
                }).then(res => {
                    if (res.status !== 200) {
                        alert('댓글 삭제 실패!');
                        return;
                    }

                    alert('댓글이 정상 삭제됨!');
                    return res.json();

                }).then(responseResult => {
                    renderReplyList(responseResult);
                });
            } else if (e.target.matches('.rpboard-like-replies-btn')) { // 좋아요 기능
                // console.log("!!!!!!!"+currentAccount);
                // console.log(document.querySelector('.rpboard-nickname-local-date-box'));
                if(currentAccount === ''){
                    alert('로그인 후 사용하세요!');
                    return;
                }
                // console.log('좋아요 클릭!!');

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
                            alert('좋아요!');
                            getReplyList();
                        } else {
                            alert('좋아요 실패!');
                        }
                    });
            } else if (e.target.matches('.rpboard-report-replies-btn')) { // 신고 기능
                if(currentAccount === ''){
                    alert('로그인 후 사용하세요!');
                    return;
                }
                // console.log(document.querySelector('.rpboard-nickname-local-date-box'));
                // console.log('신고 클릭!!');

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
                            alert('신고!');
                            getReplyList();
                        } else {
                            alert('신고 실패함!');
                        }
                    });
            } else if (e.target.matches('.rpboard-modify-replies-btn')) { // 수정 기능

                const payload = {
                    replyNo: $replyNo,
                    gameId: +gameId,
                    text: text
                };

                const requestInfo = {
                    method: 'PUT',
                    headers: {
                        'content-type': 'application/json'
                    },
                    body: JSON.stringify(payload)
                }


            } else { // 다른곳 클릭하면 보여줌
                console.log("다른곳 클릭");
            }


        }
    }


    //========= 메인 실행부 =========//
    (function () {

        // 첫 댓글 페이지 불러오기
        getReplyList();

        // 댓글 등록 이벤트 등록
        if (currentAccount !== "") {
            makeReplyRegisterClickEvent();
        }
        // 삭제 이벤트 등록
        replyRemoveClickEvent();
    })();
</script>



</body>
</html>