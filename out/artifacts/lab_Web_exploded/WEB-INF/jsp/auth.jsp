<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Authorization</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
    <style>body{background-color: #f5f5f5; color: #333333} input{background-color: #ffffff} select, button{background-color: #ffc107 !important; color: #333333 !important;}</style>
</head>
<body>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="text"/>
<c:set var="text">
    <fmt:message key="authorization_title"/>
</c:set>
<custom:header text="${text}"/>
<div class="container" style="min-height: 100vh; padding-top: 50px">
    <form action="${pageContext.request.contextPath}/client/auth.html" method="post">
        <div class="form-group">
            <label for="email"><fmt:message key="email"/></label>
            <input class="form-control" id="email" name="email" placeholder="<fmt:message key="email"/>">
        </div>
        <div class="form-group">
            <label for="password"><fmt:message key="password"/></label>
            <input class="form-control" id="password" name="password" placeholder="<fmt:message key="password"/>">
        </div>
        <div>
            <button class="btn btn-danger" style="border-color: #ffc107"><fmt:message key="submit_auth"/></button>
        </div>
    </form>
</div>
</body>
</html>