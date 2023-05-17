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

            <a href="https://example.com" class="card" data-game-id="${g.gameId}">
                <div class="img-box">
                    <c:forEach items="${g.thumbnails}" var="t">
                        <img src="${t}" alt="thumbnails">
                    </c:forEach>
                </div>
                <h3>${g.gameName}</h3>
                <div class="button-wrapper">
                    <button class="game-modify-btn">수정하기</button>
                    <button class="game-ranking-btn">랭킹보기</button>
                </div>
            </a>

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


    <div class="search-container">
        <form class="search-form">
            <label>
                <input type="text" placeholder="Search..." name="keyword" id="search_keyword">
            </label>
            <button>Search</button>
        </form>
    </div>
</div>

<script>

    // main function
    (() => {
        // 검색 버튼 이벤트 등록
        searchBtnEvent();
    })();

    function searchBtnEvent() {
        const $searchBtn = document.querySelector('.search-form button');

        $searchBtn.onclick = e => {
            e.preventDefault();
            window.location.href = "/games/list?pageNo=" + ${maker.page.pageNo}
                +"&amount=9"
                +"&keyword=" + document.getElementById('search_keyword').value;
        };
    }
</script>

</body>
</html>