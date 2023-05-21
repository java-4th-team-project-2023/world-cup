<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>

    <%@ include file="../include/static-head.jsp" %>

    <link rel="stylesheet" href="/assets/css/list.css">

</head>
<body>

<%@ include file="../include/header.jsp" %>

<div id="main-wrapper">

<%--    <div class="page-amount-select">--%>
<%--        <label for="page-size">Items per page:</label>--%>
<%--        <select name="page-size" id="page-size">--%>
<%--            <option value="9">9</option>--%>
<%--            <option value="15">15</option>--%>
<%--            <option value="21">21</option>--%>
<%--            <option value="27">27</option>--%>
<%--        </select>--%>
<%--    </div>--%>

    <div class="card-list">

        <c:forEach items="${gameList}" var="g">

            <span  class="card" data-game="${g.gameId}">
                <div class="img-box">
                    <c:forEach items="${g.thumbnails}" var="t">
                        <img src="${t}" alt="thumbnails">
                        <img src="${t}" alt="thumbnails">
                    </c:forEach>
                </div>
                <h3>${g.gameName}</h3>
                <div class="button-wrapper">
                    <button class="game-modify-btn">수정하기</button>
                    <button class="game-ranking-btn" onclick="window.location.href='/rank/ranking?gameId=${g.gameId}'">랭킹보기</button>
                </div>
            </span>
        </c:forEach>
    </div>


    <ul class="page-select">


        <li class="page-item"><a class="page-link"
                                 href="/games/list?pageNo=${1}&type=${s.type}&keyword=${s.keyword}">&lt;&lt;</a>
        </li>


        <c:if test="${maker.prev}">
            <li class="page-item"><a class="page-link"
                                     href="/games/list?pageNo=${maker.begin - 1}&type=${s.type}&keyword=${s.keyword}">prev</a>
            </li>
        </c:if>

        <c:forEach var="i" begin="${maker.begin}" end="${maker.end}" step="1">
            <li data-page-num="${i}" class="page-item">
                <a class="page-link" href="/games/list?pageNo=${i}&type=${s.type}&keyword=${s.keyword}">${i}</a>
            </li>
        </c:forEach>

        <c:if test="${maker.next}">
            <li class="page-item"><a class="page-link"
                                     href="/games/list?pageNo=${maker.end + 1}&type=${s.type}&keyword=${s.keyword}">next</a>
            </li>
        </c:if>

        <li class="page-item"><a class="page-link"
                                 href="/games/list?pageNo=${maker.finalPage}&type=${s.type}&keyword=${s.keyword}">&gt;&gt;</a>
        </li>

    </ul>


    <section class="search-container">
        <form class="search-form">
            <div class="input-btn-box">
                <input type="text" placeholder="Search..." name="keyword" id="search_keyword">
                <button><div class="search-btn-img-box"></div></button>
            </div>
        </form>
    </section>
</div>

<script>

    // const $rankBtn = document.querySelector('.game-ranking-btn');
    // $rankBtn.onclick = e => {
    //     console.log("이동");
    //     const $gameId = e.target.closest('.card').dataset.game;
    //     window.location.href = 'rank/ranking?gameId='+$gameId.value;
    // };
    // main function

    
    const $img_boxes = document.querySelectorAll('.img-box');
    

    function searchBtnEvent() {
        const $searchBtn = document.querySelector('.search-form button');

        $searchBtn.onclick = e => {
            e.preventDefault()
            window.location.href = '/games/list?pageNo=' + '${maker.page.pageNo}'
                +'&amount=9'
                +'&keyword=' + document.getElementById('search_keyword').value;
        };
    }

    // function goGameStartPage(){
    //     $img_box.onclick = e =>{

    //         // console.log(e.tartget);
    //         const cardGameNum = e.target.closest('.card');

    //         console.log(+cardGameNum.dataset.game);
            
    //         window.location.href = "/games/start?gameId=" + cardGameNum.dataset.game;
    //     }
    // }   

    function goGameStartPage() {
  $img_boxes.forEach($img_box => {
    $img_box.addEventListener('click', e => {
      const cardGameNum = e.target.closest('.card');
      console.log(+cardGameNum.dataset.game);
      window.location.href = "/games/start?gameId=" + cardGameNum.dataset.game;
    });
  });
}
       
    (() => {
        // 검색 버튼 이벤트 등록
        searchBtnEvent();
        
        // 게임 스타트 페이지 이동
        goGameStartPage();
    })();
    

</script>

</body>
</html>