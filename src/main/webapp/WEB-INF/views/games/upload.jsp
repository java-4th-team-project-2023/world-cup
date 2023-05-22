!<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link href="/assets/css/include.css">

    <%@ include file="../include/static-head.jsp"%>

    <script src="/assets/js/include.js" defer></script>

</head>

<body>
    <%@ include file = "../include/header.jsp" %>
    <div class="wrapper">
        <div class="upload-new-wrapper">
            <div class="uplaod-info-theme">
                <div class="info-title">
                    <!-- 월드컵의 제목 적기 -->
                </div>
                <div class="info-detail">
                    <!-- 게임 내용 설명하기, 하고싶은 말 적기 -->
                </div>
                <div class="info-img-upload">
                    <!-- 이미지 등록하기 -->
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
                        <button class="plusBtn">플러스</button>
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