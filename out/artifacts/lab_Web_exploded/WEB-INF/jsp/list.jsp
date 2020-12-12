<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Publications</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
    <style>body{background-color: #f5f5f5; color:#ffc107} td, th{background-color: #f5f5f5 !important; color: #333333 !important;}</style>
</head>
<body>
    <fmt:setLocale value="${sessionScope.lang}"/>
    <fmt:setBundle basename="text"/>
    <c:set var="text">
        <fmt:message key="publications_title"/>
    </c:set>
    <custom:header text="${text}"/>
    <div class="container" style="min-height: 100vh; padding-top: 50px">
        <div>
            <c:if test="${sessionScope.user.role == 'admin'}">
                <a class="btn btn-danger" style="text-align: center; background-color: #ffc107; color: #333333; border-color: #ffc107" href="${pageContext.request.contextPath}/client/add-publ.html">
                    <fmt:message key="add_publication"/>
                </a>
            </c:if>
        </div>
        <table class="table table-dark">
            <thead>
            <tr>
                <th style="width: 5%">№</th>
                <th style="width: 65%"><fmt:message key="link_publication"/></th>
                <c:choose>
                    <c:when test="${sessionScope.user.role == 'admin'}">
                        <th style="width: 10%"><fmt:message key="delete_publication"/></th>
                    </c:when>
                    <c:otherwise>
                        <th style="width: 10%"><fmt:message key="order_publication"/></th>
                    </c:otherwise>
                </c:choose>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="publication" items="${articles}" varStatus="loop">
                <tr>
                    <td style="vertical-align: baseline">${loop.index + 1}</td>
                    <td style="vertical-align: baseline">
                        <a style="text-decoration: none; color: #333333 " href="${pageContext.request.contextPath}/client/details.html?id=${publication.id}">
                            <fmt:message key="view_publication"/>
                                ${publication.name}
                        </a>
                    </td>
                    <c:choose>
                        <c:when test="${sessionScope.user.role == 'admin'}">
                            <td style="vertical-align: baseline">
                                <a style="text-decoration: underline; color: #333333 " href="${pageContext.request.contextPath}/client/delete-publ.html?id=${publication.id}">
                                    <fmt:message key="delete_publication"/>
                                </a>
                            </td>
                        </c:when>
                        <c:otherwise>
                            <td style="vertical-align: baseline">
                                <a style="text-decoration: underline; color: #333333 " href="${pageContext.request.contextPath}/client/order.html?id=${publication.id}">
                                    <fmt:message key="order_publication"/>
                                </a>
                            </td>
                        </c:otherwise>
                    </c:choose>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <c:if test="${sessionScope.user.role == 'reader'}">
            <div>
                <a class="btn btn-danger" style="text-align: center; background-color: #ffc107; color: #333333 ; border-color: #333333 " href="${pageContext.request.contextPath}/client/payment.html">
                    <fmt:message key="payment_submit"/>
                </a>
            </div>
        </c:if>
    </div>
</body>
</html>