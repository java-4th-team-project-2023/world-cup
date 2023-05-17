<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="/assets/css/login.css">

    <script src="/assets/js/login.js" defer></script>

</head>

<!--  -->

<body>

    <!-- 로그인 화면 시작 -->
    <div class="container" id="container">
        <!-- 회원가입 정보 화면 box -->
        <div class="form-container sign-up-container">
            <form action="#">
                <!-- 회원가입 정보 화면 -->
                <h1 id="SignUp">회원가입</h1>
                <div class="social-container">
                    <a href="#" class="social" id="KakaoTalk"></a>
                    <a href="#" class="social" id="Google"></a>
                    <a href="#" class="social" id="Naver"></a>
                </div> <!-- end social-container -->
                <span>가입하실 정보를 입력하세요!</span>
                <input type="text" placeholder="Name" />
                <input type="email" placeholder="Email" />
                <input type="password" placeholder="Password" />
                <button id="SignUpBtn">회원가입</button>
            </form> <!-- end form -->
        </div> <!-- end form-container / sign-up-container -->

        <!-- 로그인 정보 화면 box -->
        <div class="form-container sign-in-container">
            <!-- 뒤로가기 버튼 -->
            <!-- <div class="return-box"><a href="/views/include/header.html"></a></div> -->

            <form action="#">
                <!-- 로그인 정보 화면 -->
                <h1 id="SignIn">로그인</h1>
                <div class="social-container">
                    <a href="#" class="social" id="KakaoTalk"></a>
                    <a href="#" class="social" id="Google"></a>
                    <a href="#" class="social" id="Naver"></a>
                </div> <!-- end social-container -->
                <span>또는 계정을 입력하세요!</span>
                <input type="email" placeholder="Email" />
                <input type="password" placeholder="Password" />
                <!-- 비밀번호 찾기 text -->
                <a href="#" id="Text">비밀번호 찾기</a>
                <button id="SignInBtn">로그인</button>
            </form> <!-- end form -->
        </div>

        <!-- goast 버튼 클릭시 패널 이동 -->
        <div class="overlay-container">
            <div class="overlay">
                <!-- 로그인 화면 시 오른쪽 패널 -->
                <div class="overlay-panel overlay-left">
                    <h1 id="Text">환영합니다!</h1>
                    <p>To keep connected with us please login with your personal info</p>
                    <button class="ghost" id="signIn">로그인 페이지로</button>
                    <button class="ghost" id="Main"><a href="/views/include/header.html">메인 화면으로</a></button>
                </div> <!-- end overlay-panel / overlay-left -->
                <!-- 회원가입 화면 시 왼쪽 패널 -->
                <div class="overlay-panel overlay-right">
                    <h1 id="Text">반갑습니다!</h1>
                    <p id="Text">Enter your personal details and start journey with us</p>
                    <button class="ghost" id="signUp">회원가입 페이지로</button>
                    <button class="ghost" id="Main"><a href="/views/include/header.html">메인 화면으로</a></button>
                </div> <!-- end overlay-panel / overlay-right -->
            </div> <!-- end overlay -->
        </div> <!-- end overlay-container -->
    </div> <!-- end container -->
    <!-- 로그인 화면 끝 -->

</body>

</html>