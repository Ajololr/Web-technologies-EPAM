<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Payment</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
    <style>body{background-color: #f5f5f5; color: #333333} td, th {background-color: #f5f5f5; color: #333333} input{background-color: #ffffff} button{background-color: #ffc107 !important; color: #333333 !important;}</style>
</head>
<body>
    <fmt:setLocale value="${sessionScope.lang}"/>
    <fmt:setBundle basename="text"/>
    <c:set var="text">
        <fmt:message key="payment_title"/>
    </c:set>
    <custom:header text="${text}"/>
    <div class="container" style="min-height: 100vh; padding-top: 50px">
        <table class="table table-dark">
            <thead>
            <tr>
                <th style="width: 5%">№</th>
                <th style="width: 65%"><fmt:message key="link_publication"/></th>
                <th style="width: 10%"><fmt:message key="article_cost"/></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="publication" items="${publication_list}" varStatus="loop">
                <tr>
                    <td style="vertical-align: baseline">${loop.index + 1}</td>
                    <td style="vertical-align: baseline">${publication.name}</td>
                    <td style="vertical-align: baseline">${publication.cost}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <form action="${pageContext.request.contextPath}/client/payment-submit.html" method="post">
            <div class="form-group">
                <label for="card"><fmt:message key="card_number"/></label>
                <input type="number" class="form-control" id="card" name="card" placeholder="<fmt:message key="card_number"/>">
            </div>
            <div class="form-group">
                <label for="exp-date"><fmt:message key="exp_date"/></label>
                <input type="date" class="form-control" id="exp-date" name="exp-date" placeholder="<fmt:message key="exp_date"/>">
            </div>
            <div class="form-group">
                <label for="cvv"><fmt:message key="cvv"/></label>
                <input class="form-control" id="cvv" name="cvv" placeholder="<fmt:message key="cvv"/>">
            </div>
            <div>
                <button class="btn btn-danger" style="border-color: #0067ac"><fmt:message key="payment_submit"/></button>
            </div>
        </form>
    </div>
</body>
</html>