<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista wszystkich userów</title>
</head>
<body>
<div class="top">
</div>
<div class="nav">
    <%@include file="/WEB-INF/views/includes/header.jsp" %>
</div>
<table class="allUsers">
    <c:forEach var="user" items="${userList}">
        <c:if test="${user.role != 'ROLE_ADMIN'}">
            <tr>
                <td>${user.id}</td>
                <td>${user.firstName}</td>
                <td>${user.surname}</td>
                <td>${user.role}</td>
            </tr>
        </c:if>
    </c:forEach>
</table>
<div class="footer">
    <%@include file="/WEB-INF/views/includes/footer.jsp" %>
</div>
</body>
</html>
