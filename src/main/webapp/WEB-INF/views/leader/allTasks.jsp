<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spis wszystkich zadań</title>
</head>
<body>
<table class="allTasks">
    <c:forEach var="task" items="${taskList}">
        <tr>
            <td>${task.id}</td>
            <td>${task.title}</td>
            <td>${task.description}</td>
            <td>${task.status}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
