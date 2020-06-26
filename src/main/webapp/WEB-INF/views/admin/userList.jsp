<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista wszystkich userów</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="top">
</div>
<div class="nav">
    <%@include file="/WEB-INF/views/includes/header.jsp" %>
</div>
<div id="grad">
    <table class="allItems">
        <tr>
            <th>ID</th>
            <th>Imię</th>
            <th>Nazwisko</th>
            <th>Uprawnienia</th>
            <th>Akcje</th>
        </tr>
        <c:forEach var="user" items="${userList}">
            <c:if test="${user.role != 'ROLE_ADMIN'}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.firstName}</td>
                    <td>${user.surname}</td>
                    <td>${user.role}</td>
                    <td>
                        <button class="btn-link"><a href="/admin/edit-user/${user.id}">Edycja użytkownika</a></button>
                        <button class="btn-link"><a href="/admin/delete/${user.id}">Usunięcie użytkownika</a></button>
                    </td>
                </tr>
            </c:if>
        </c:forEach>
    </table>
</div>
<div class="footer">
    <%@include file="/WEB-INF/views/includes/footer.jsp" %>
</div>
</body>
</html>
