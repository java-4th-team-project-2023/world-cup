<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/assets/css/modify.css">
</head>

<body>

<div class="wrapper">

    <div class="modify-wrapper">
        <div class="menu-wrapper">
            <p>기본정보</p>
            <p>이미지 수정/삭제</p>
        </div>
        <div class="container-title"><span>이미지 수정/삭제</span></div>
        <form action="#" method="POST" id="form">
            <div class="modify-title">
                <div class="modify-list-container">

                    <ul id="player-list">
                        <li class="list-title">
                            <div>순위</div>
                            <div name="playerName">이미지</div>
                            <div>이름변경</div>
                            <div>이미지변경</div>
                            <div>삭제</div>
                            <div>우승비율(전체게임수/최종우승)</div>
                        </li>
                        <!-- <c:forEach var="player" items="${playerList}"> -->
                        <!--
                        <li class="list-content">
                            <div></div>
                            <div name="playerImgPath">선택된 이미지</div>
                            <div name="playerName"><input id="modify-name" type="text"></div>
                            <div name="playerImgPath"><input id="modify-file" type="file"></div>
                            <div name="delete"><button id="delbtn" type="button">삭제하기</button></div>
                            <div name=""></div>
                        </li> -->
                        <!-- </c:forEach> -->
                    </ul>

                </div>
            </div>
        </form>
    </div>
</div>

<script>
    (() => {
        // 선수 목록 불러오는 비동기 요청
        // 요청 주소
        const URI = '/api/v1/players/${gameId}/pageNo/1/amount/9';

        // 요청 보내기
        fetch(URI)
            .then(res => res.json())
            .then(responseResult => {
                renderPlayerList(responseResult);
            });
    })();

    function renderPlayerList(responseResult) {

        const $playerList = document.getElementById('player-list');

        responseResult.forEach(p => {밋

            const $player = document.createElement('li');
            $player.classList.add('list-content');

            $player.innerHTML = `
                            <div></div>
                            <div name="playerImgPath"><img src='\${p.playerImgPath}'></div>
                            <div name="playerName"><input id="modify-name" type="text" value='\${p.playerName}'></div>
                            <div name="playerImgPath"><input id="modify-file" type="file"></div>
                            <div name="delete"><button id="delbtn" type="button">삭제하기</button></div>
                            <div name=""></div>
                       `;

            $playerList.appendChild($player);

        });
    }
</script>

</body>

</html>