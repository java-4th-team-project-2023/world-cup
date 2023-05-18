<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="/assets/js/start.js" defer></script>
    <link rel="stylesheet" href="/assets/css/start.css">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>

    <title>Document</title>
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
                        <li class="header-menu-list"><a href="/views/include/header.html">HOME</a></li>
                        <li class="header-menu-list"><a href="/views/jsp/upload.html">월드컵 만들기</a></li>

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
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
                </div>

            </div>
        </div>
    </div>







    <div id="game">

    </div>
  

</body>

</html>