<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Details</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
    <style>body{background-color: #f5f5f5; color: #333333} h3{background-color: #f5f5f5 !important; color: #333333 !important;}  h4{color:#333333}</style>
</head>
<body>
    <fmt:setLocale value="${sessionScope.lang}"/>
    <fmt:setBundle basename="text"/>
    <c:set var="text">
        ${article.name}
    </c:set>
    <custom:header text="${text}"/>
    <div class="container" style="min-height: 100vh; padding-top: 50px">
        <h3><fmt:message key="article_name"/>: </h3>
        <h4>${article.name}</h4>
        <h3><fmt:message key="article_cost"/>: </h3>
        <h4>${article.cost}</h4>
        <h3><fmt:message key="article_description"/>: </h3>
        <h4>${article.description}</h4>
    </div>
</body>
</html>