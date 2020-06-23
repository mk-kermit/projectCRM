
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista wszystkich userów</title>
</head>
<body>
<table class="allUsers">
    <c:forEach var="user" items="${userList}">
        <tr>
            <td>${user.id}</td>
            <td>${user.firstName}</td>
            <td>${user.surname}</td>
            <td>${user.roles}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
