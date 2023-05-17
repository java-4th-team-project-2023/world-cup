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

<body>
    <div class="container" id="container">
        <div class="form-container sign-up-container">
            <form action="/account/sign-up" method="post">
                <h1>Create Account</h1>
                <div class="social-container">
                    <a href="#" class="social" id="KakaoTalk"></a>
                    <a href="#" class="social" id="Google"></a>
                    <a href="#" class="social" id="Naver"></a>
                </div>
                <span>or use your email for registration</span>
                <input type="text" name="accountId" placeholder="아이디" />
                <input type="email" name="email" placeholder="이메일" />
                <input type="password" name="password" placeholder="비밀번호" />
                <button type="submit">Sign Up</button>
            </form>
        </div>
        <div class="form-container sign-in-container">
            <form action="/account/sign-in" method="post">
                <h1>Sign in</h1>
                <div class="social-container">
                    <a href="#" class="social" id="KakaoTalk"></a>
                    <a href="#" class="social" id="Google"></a>
                    <a href="#" class="social" id="Naver"></a>
                </div>
                <span>or use your account</span>
                <input type="text" name="accountId" placeholder="아이디" />
                <input type="password" name="password" placeholder="비밀번호" />
                <a href="#" id="Text">Forgot your password?</a>
                <button>Sign In</button>
            </form>
        </div>
        <div class="overlay-container">
            <div class="overlay">
                <div class="overlay-panel overlay-left">
                    <h1 id="Text">Welcome Back!</h1>
                    <p>To keep connected with us please login with your personal info</p>
                    <button class="ghost" id="signIn">Sign In</button>
                </div>
                <div class="overlay-panel overlay-right">
                    <h1 id="Text">Hello, Friend!</h1>
                    <p id="Text">Enter your personal details and start journey with us</p>
                    <button class="ghost" id="signUp">Sign Up</button>
                </div>
            </div>
        </div>
    </div>

</body>

</html>