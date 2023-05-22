<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--header-->
<header>
    <div class="header">
        <div class="header-container">
            <h1 class="logo">
                <a href="/" id="Logo"><i class="far fa-hand-rock"></i></a>
            </h1>

            <!--상단 BAR-MENU-->
            <nav class="gnb">
                <ul class="header-menu-box">
                    <li class="header-menu-list"><a href="/games/list">HOME</a></li>
                    <li class="header-menu-list"><a href="/games/make">월드컵 만들기</a></li>
                    <!-- 로그인 검증 -->

                    <c:if test="${login eq null}">
                        <li class="login-box"><a href="/account/sign-in" id="Login">LOGIN</a></li>
                    </c:if>
                </ul>
                <c:if test="${login ne null}">
                    <input type="checkbox" id="icon">

                    <label for="icon" class="transition">
                        <!--label은 인라인 스타일-->
                        <span></span>
                        <span></span>
                        <span></span>
                    </label>

                    <nav class="inr-menu" data-account-id="${login.accountId}">
                        <ul class="inr-menu-list-box">

                            <li class="inr-menu-list"><a href="/games/my-world-cup">내가 만든 월드컵</a></li>
                            <li class="inr-menu-list"><a href="/account/sign-out">로그아웃</a></li>

                        </ul>
                    </nav>

                </c:if>
            </nav>
        </div>
    </div>
</header>
<button id="go-top">
    <svg xmlns="http://www.w3.org/2000/svg" fill="currentColor" class="bi bi-arrow-up-circle-fill"
         viewBox="0 0 16 16">
        <path fill-rule="evenodd"
              d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-7.5 3.5a.5.5 0 0 1-1 0V5.707L5.354 7.854a.5.5 0 1 1-.708-.708l3-3a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1-.708.708L8.5 5.707V11.5z"></path>
    </svg>
</button>
