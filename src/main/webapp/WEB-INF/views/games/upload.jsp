
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PICKPICK</title>
    <link rel="icon" href="/assets/img/favicon.png">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
    <link rel="stylesheet" href="../../assets/css/upload.css">
    <script src="/assets/js/upload.js" defer></script>

</head>

<body>
<%@ include file="../include/header.jsp" %>



<div id="main-wrapper" class="wrapper">

    <div class="upload-new-wrapper">
        <div class="menu-wrapper">
            <p>기본정보</p>
            <p>이미지 수정/삭제</p>
        </div>
        <div class="container-title"><span>기본정보 입력하기</span></div>
        <form action="/games/make" method="post" id="form" enctype="multipart/form-data">
            <div class="upload-info-theme-box">
                <div class="upload-info-theme">
                    <div class="basic-info">
                        <div class="info-title-wrapper flex">
                            <!-- 월드컵의 제목 적기 -->
                            <button type="button" class="plusBtn">입력칸 추가</button>
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

                    </ul>

                    <div class="savebtnWrapper">

                        <div class="btnWrapper flex">
                            <button class="saveBtn" type="submit" name="saveBtn">저장하기</button>
                        </div>


                    </div>

                </div>

            </div>

        </form>

    </div>

</div>



</body>

</html>