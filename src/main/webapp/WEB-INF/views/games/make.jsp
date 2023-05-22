!<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
    <link rel="stylesheet" href="../../assets/css/upload.css">
    <script src="/assets/js/upload.js" defer></script>

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


</body>
<!--header 끝 -->









<div id="main-wrapper" class="wrapper">

    <div class="upload-new-wrapper">
        <div class="menu-wrapper">
            <p>기본정보</p>
            <p>이미지 수정/삭제</p>
        </div>
        <div class="container-title"><span>기본정보 입력하기</span></div>
        <form action="/games/make" method="post" enctype="multipart/form-data">
        <div class="upload-info-theme-box">
            <div class="upload-info-theme">
                <div class="basic-info">
                    <div class="info-title-wrapper flex">
                        <!-- 월드컵의 제목 적기 -->
                        <span class="title">제목</span>
                        <div class="input-wrapper ">
                            <input type="text" class="info-title input" name="gameName" placeholder="월드컵의 제목을 입력하세요">
                        </div>
                    </div>

                </div>
                <!-- 리스트 추가 및 삭제 버튼 -->
                <ul class="title-ul">
                    <li class="list-title">
                        <div class="list-title-list" name="playerName">등록하기</div>
                        <div class="list-title-list uploadMenu">사진</div>
                        <div class="list-title-list">이름</div>
                        <div class="list-title-list">삭제</div>
                    </li>
                </ul>
                <ul class="content-ul">
                    <li class="list-content">
                        <div class="img-container-box" name="">
                            <div class="img-container">
                                <input type="file" name="playerImgPath" class="addImg" accept="image/*">
                                <!-- <label for="" class="imgtype">imgtype선택</label> -->
                                <button class="changeimg" type="button">사진등록</button>
                            </div>
                        </div>
                        <div>
                            <div class="register-img-box">
                                <div class="img-box">
                                    <img class="img" name="playerImgPath"
                                        src="https://upload.wikimedia.org/wikipedia/commons/thumb/6/6e/Golde33443.jpg/280px-Golde33443.jpg"
                                        alt="">
                                </div>
                            </div>
                        </div>
                        <div>
                            <div class="register-img-name-box">
                                <input name="playerName" class="playerName" type="text"
                                    placeholder="등록할 사진의 이름을 입력해주세요">
                            </div>
                        </div>
                        <div>
                            <div class="delete-img-box">
                                <button id="delbtn" type="button">삭제</button>
                            </div>
                        </div>

                    </li>

                </ul>

                <div class="savebtnWrapper">

                    <div class="btnWrapper flex">
                        <button class="plusBtn" type="button">플러스</button>
                        <button class="saveBtn" type="submit" name="saveBtn">저장하기</button>
                    </div>


                </div>

            </div>

        </div>

        </form>

    </div>

</div>
</div>



</body>

</html>