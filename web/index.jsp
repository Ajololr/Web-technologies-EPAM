<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <title>Main</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
    </head>
    <body style="background-color: #f5f5f5">
        <fmt:setLocale value="${sessionScope.lang}"/>
        <fmt:setBundle basename="text"/>
        <c:set var="text">
            <fmt:message key="welcome"/>
        </c:set>
        <custom:header text="${text}"/>
        <div class="container" style="min-height: 100vh; padding-top: 50px;">
            <h3 class="text-center" style="color: #333333">
                <a style="color: #333333; text-decoration:underline" href="${pageContext.request.contextPath}/client/auth.html"><fmt:message key="login"/></a>
                <fmt:message key="or"/>
                <a style="color: #333333; text-decoration:underline" href="${pageContext.request.contextPath}/client/registration.html"><fmt:message key="registration"/></a>
            </h3>
        </div>
    </body>
</html>