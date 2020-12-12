<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Add publication</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
    <style>body{background-color: #f5f5f5; color: #333333} input{background-color: #ffffff} textarea{background-color: #ffffff} button{background-color: #ffc107 !important; color: #333333 !important;}</style>
</head>
<body>
    <fmt:setLocale value="${sessionScope.lang}"/>
    <fmt:setBundle basename="text"/>
    <c:set var="text">
        <fmt:message key="add_title"/>
    </c:set>
    <custom:header text="${text}"/>
    <div class="container" style="min-height: 100vh; padding-top: 50px">
        <form action="${pageContext.request.contextPath}/client/save-publ.html" method="post">
            <div class="form-group">
                <label for="article-name"><fmt:message key="article_name"/>: </label>
                <input class="form-control" id="article-name" name="article-name" placeholder="<fmt:message key="article_name"/>">
            </div>
            <div class="form-group">
                <label for="article-cost"><fmt:message key="article_cost"/>: </label>
                <input type="number" class="form-control" id="article-cost" name="article-cost" placeholder="<fmt:message key="article_cost"/>">
            </div>
            <div class="form-group">
                <label for="article-description"><fmt:message key="article_description"/>: </label>
                <textarea class="form-control" id="article-description" name="article-description" placeholder="<fmt:message key="article_description"/>"></textarea>
            </div>
            <div>
                <button class="btn btn-danger" style="border-color: #0067ac"><fmt:message key="add_submit"/></button>
            </div>
        </form>
    </div>
</body>
</html>