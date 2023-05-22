<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <%@ include file="../include/static-head.jsp" %>
    <script src="/assets/js/start.js" defer></script>

    <link rel="stylesheet" href="/assets/css/start.css">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>

    <title>Document</title>
</head>

<body>

<%@ include file="../include/header.jsp" %>

<!-- game page 시작 -->

<a href="#" data-toggle="modal" data-target="#myModal" class="hiddenBtn" style="display: none;">이미지 모달띄우기</a>


<div class="modal fade" id="myModal" data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog modal-xl modal-dialog-centered">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">사진제목</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <div>
                    게임을 선택하세요
                </div>
                <div>
                    <select id="round">

                    </select>
                </div>

            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
                <button type="button" id="send" class="btn btn-secondary" data-dismiss="modal">확인</button>
                <button type="button" id="close" class="btn btn-secondary" data-dismiss="modal">닫기</button>
            </div>

        </div>
    </div>
</div>

<div id="game-wrapper">

    <div id="game-title-wrapper">${gameName}<span id="round-info"></span></div>

    <div id="game" data-player-count="${playerCount}" data-game-id="${gameId}">

    </div>

    <button id="resetBtn">
        되돌리기
    </button>
</div>


</body>

</html>