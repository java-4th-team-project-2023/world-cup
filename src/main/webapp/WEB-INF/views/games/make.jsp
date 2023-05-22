<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <%@ include file="../include/static-head.jsp"%>
</head>
<body>

<%@ include file="../include/header.jsp"%>

<div id="main-wrapper">
    <form action="/games/make" method="post">
        <label>
            게임 이름
            <input type="text" name="gameName">
        </label>
        <button type="submit">등록</button>
    </form>
</div>

</body>
</html>
