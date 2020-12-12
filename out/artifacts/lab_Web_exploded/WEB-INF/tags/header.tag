<%@ attribute name="text" required="true" type="java.lang.String" description="Header text" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@tag pageEncoding="UTF-8"%>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="text"/>
<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #ffc107">
    <c:choose>
        <c:when test="${not empty sessionScope.user}">
            <a class="navbar-brand" style="color: #333333" href="${pageContext.request.contextPath}/client/list.html">${text}</a>
        </c:when>
        <c:otherwise>
            <a class="navbar-brand" style="color: #333333" href="#">${text}</a>
        </c:otherwise>
    </c:choose>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ol class="breadcrumb ml-auto mr-4" style="background-color: #ffffff; " id="langs">
            <li class="breadcrumb-item"><a data-value="en" style="color: #333333" href="#">EN</a></li>
            <li class="breadcrumb-item"><a data-value="ru" style="color: #333333" href="#">RU</a></li>
        </ol>
        <c:if test="${not empty sessionScope.user}">
            <a class="btn btn-danger" style="background-color: #ffffff; color: #333333; border-color: #ffc107" href="${pageContext.request.contextPath}/client/leave.html" style="min-width: 200px">
                <fmt:message key="signout"/>
            </a>
        </c:if>
    </div>
    <script>
        const langs = document.querySelector("#langs").children;
        Array.from(langs).map(lang => lang.children[0]).forEach(lang => {
            lang.addEventListener("click", async (e) => {
                e.preventDefault();
                await fetch("${pageContext.request.contextPath}/client/lang.html?value=" + lang.dataset.value);
                document.location.reload();
            });
        })
    </script>
</nav>