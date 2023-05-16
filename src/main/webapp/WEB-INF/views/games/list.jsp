<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>

    <%@ include file="../include/static-head.jsp" %>

    <link rel="stylesheet" href="/assets/css/list.css">

</head>
<body>

<%@ include file="../include/header.jsp" %>

<div id="main-wrapper">

    <div class="page-amount-select">
        <label for="page-size">Items per page:</label>
        <select name="page-size" id="page-size">
            <option value="9">9</option>
            <option value="15">15</option>
            <option value="21">21</option>
            <option value="27">27</option>
        </select>
    </div>

    <div class="card-list">
        <a href="/rank/ranking" class="card">
            <img src="https://via.placeholder.com/300x200" alt="Placeholder Image">
            <h3>Card 1</h3>
        </a>
        <a href="https://example.com" class="card">
            <img src="https://via.placeholder.com/300x200" alt="Placeholder Image">
            <h3>Card 2</h3>
        </a>
        <a href="https://example.com" class="card">
            <img src="https://via.placeholder.com/300x200" alt="Placeholder Image">
            <h3>Card 3</h3>
        </a>
        <a href="https://example.com" class="card">
            <img src="https://via.placeholder.com/300x200" alt="Placeholder Image">
            <h3>Card 4</h3>
        </a>
        <a href="https://example.com" class="card">
            <img src="https://via.placeholder.com/300x200" alt="Placeholder Image">
            <h3>Card 5</h3>
        </a>
        <a href="https://example.com" class="card">
            <img src="https://via.placeholder.com/300x200" alt="Placeholder Image">
            <h3>Card 6</h3>
        </a>
        <a href="https://example.com" class="card">
            <img src="https://via.placeholder.com/300x200" alt="Placeholder Image">
            <h3>Card 7</h3>
        </a>
        <a href="https://example.com" class="card">
            <img src="https://via.placeholder.com/300x200" alt="Placeholder Image">
            <h3>Card 8</h3>
        </a>
        <a href="https://example.com" class="card">
            <img src="https://via.placeholder.com/300x200" alt="Placeholder Image">
            <h3>Card 9</h3>
        </a>
    </div>

    <div class="page-select">
        <button class="page-link first">First</button>
        <button class="page-link prev">Prev</button>
        <button class="page-link" data-page="1">1</button>
        <button class="page-link" data-page="2">2</button>
        <button class="page-link" data-page="3">3</button>
        <button class="page-link" data-page="4">4</button>
        <button class="page-link" data-page="5">5</button>
        <button class="page-link next">Next</button>
        <button class="page-link last">Last</button>
    </div>

    <div class="search-container">
        <form class="search-form">
            <label>
                <input type="text" placeholder="Search...">
            </label>
            <button type="submit">Search</button>
        </form>
    </div>
</div>

</body>
</html>