<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    
    <%@ include file="../include/static-head.jsp"%>
    
    <link rel="stylesheet" href="/assets/css/modify.css">
</head>

<body>

<%@ include file="../include/header.jsp"%>

<div class="wrapper">

    <div class="modify-wrapper">
        <div class="menu-wrapper">
            <p>기본정보</p>
            <p>이미지 수정 / 삭제</p>
        </div>
        <div class="container-title"><span>이미지 수정 / 삭제</span></div>
        <form action="#" method="POST" id="form">
            <div class="modify-title">
                <div class="modify-list-container">

                    <ul>
                        <li class="list-title">
                            <div>순위</div>
                            <div name="playerName">이미지</div>
                            <div>이름 변경</div>
                            <div>이미지 변경</div>
                            <div>삭제</div>
                            <div>우승비율 (전체게임수 / 최종우승)</div>
                        </li>

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
        const URI = '/api/v1/players/${gameId}/pageNo/1/amount/10';

        // 요청 보내기
        fetch(URI)
            .then(res => res.json())
            .then(responseResult => {
                renderPlayerList(responseResult);
            });
    })();

    function renderPlayerList(responseResult) {

        const $playerList = document.querySelector('.modify-list-container')

        responseResult.forEach(p => {

            const $player = document.createElement('li');
            $player.classList.add('list-content');

            $player.innerHTML = `

                            <div>
                                <div class="ranking-box">
                                    <div id="Ranking">1</div>
                                </div>
                            </div>
                            <div>
                                <div class="img-box">
                                    <img class="img" name="playerImgPath" src="/assets/img/cat.jpg" alt=""
                                         id="Image">
                                </div>
                            </div>
                            <div>
                                <div class="modify-name-box">
                                    <input name="playerName" id="modify-name" type="text"
                                           placeholder="변경할 사진의 이름을 적어주세요">
                                </div>
                            </div>
                            <div name="">
                                <div class="changeimg-box">
                                    <input id="modify-file" type="file" accept="image/*">
                                    <button class="changeimg" type="button">변경하기</button>
                                </div>
                            </div>
                            <div>
                                <div class="delbtn-box">
                                    <button id="delbtn" type="button">삭제</button>
                                </div>
                            </div>
                            <div name="">
                                <div class="img-modify-list-box">

                                    <ul>
                                        <li class="img-modify-list" id="Winning-Percentage">
                                            <div class="graph">
                                                <div class="bar-text">
                                                    <p>90%</p>
                                                </div>
                                                <div class="bar" style="width: 90%;"></div>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                       `;

            $playerList.appendChild($player);

        });
    }
</script>

</body>

</html>