<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
    
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
        <link rel="stylesheet" href="/assets/css/reply.css">
        <script src="/assets/js/burgerbtn.js" defer></script>
        <script src="/assets/js/topbtn.js" defer></script>
        <script src="/assets/js/search.js" defer></script>
    
    </head>
    <body>
        <header>
            <div class="header">
                <div class="header-container">
                    <h1 class="logo">
                        <a href="#" id="Logo"><i class="far fa-hand-rock"></i></a>
                    </h1>
    
                    <!--상단 BAR-MENU-->
                    <nav class="gnb">
                        <ul class="header-menu-box">
                            <li class="header-menu-list"><a href="#">HOME</a></li>
                            <li class="header-menu-list"><a href="#">월드컵 만들기</a></li>
                            <!-- <c:if test="${}">  -->
                            <li class="header-menu-list"><a href="#">내가 만든 월드컵</a></li>
                            <div class="login-box"><a href="/views/jsp/login.html" id="Login">LOGIN</a></div>
                            <!-- </c:if> -->
                        </ul>
                        <input type="checkbox" id="icon">
                        <label for="icon">
                            <!--label은 인라인 스타일-->
                            <span></span>
                            <span></span>
                            <span></span>
                        </label>
                        <nav class="inr-menu">
                            <ul class="inr-menu-list-box">
                                <li class="inr-menu-list"><a href="#">내 정보</a></li>
                                <li class="inr-menu-list"><a href="#">menu2</a></li>
                                <li class="inr-menu-list"><a href="#">menu3</a></li>
                                <li class="inr-menu-list"><a href="#">menu4</a></li>
                                <li class="inr-menu-list"><a href="#">menu5</a></li>
                            </ul>
                        </nav>
                </div>
            </div>
        </header>
        <button id="go-top"><svg xmlns="http://www.w3.org/2000/svg" fill="currentColor" class="bi bi-arrow-up-circle-fill"
                viewBox="0 0 16 16">
                <path fill-rule="evenodd"
                    d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-7.5 3.5a.5.5 0 0 1-1 0V5.707L5.354 7.854a.5.5 0 1 1-.708-.708l3-3a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1-.708.708L8.5 5.707V11.5z" />
            </svg></button>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
        <!-- reply container 시작 -->
        <section class="rank-reply-wrapper">
    
            <div class="rank-reply-box">
                <section class="rank-box">
                    <div class="select-search-box">
                        <select class="select-view-number" id="Select-View-Number">
                            <option value="10" class="select-number">10</option>
                            <option value="10" class="select-number">20</option>
                            <option value="10" class="select-number">30</option>
                        </select>
                        <div class="search-box">
                            <input type="text" class="search-text" id="Search-Text" placeholder="Search...">
                            <span><button type="" class="search-btn" id="Search-Btn"><img src="/assets/img/Search.png"
                                        alt="search" id="Search"></button></span>
                        </div>
                    </div>
                </section>
    
                <section class="reply-box">
                    <div class="rpheader">
                        <ul class="rpheader-list-box">
                            <a href="#">
                                <li class="rpheader-list">다시하기</li>
                            </a>
                            <a href="#">
                                <li class="rpheader-list">목 록</li>
                            </a>
                            <a href="#">
                                <li class="rpheader-list">공 유</li>
                            </a>
                        </ul>
                    </div>
    
                    <section class="rpboard-box">
                        <div class="rpboard-list-box">
                            <div class="rpboard-list">
                                
                            </div>
                        </div>
                    </section>
    
    
    
    
                    <section class="rpboard-reply-replybtn-box">
                        <div class="rpboard-reply">
                            <input type="text" name="reply" id="Reply">
                        </div>
                        <button type="button" class="replybtn"><p>등 록</p></button>
                    </section>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
                </section>
    
    
    
    
    
    
    
    
    
    
        </section>
        <!-- reply container 끝 -->
    
    </body>
    
</html>