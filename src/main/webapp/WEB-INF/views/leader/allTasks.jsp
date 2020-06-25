<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spis wszystkich zadań</title>
</head>
<body>
<div class="top">
</div>
<div class="nav">
    <%@include file="/WEB-INF/views/includes/header.jsp" %>
</div>
<table class="allTasks">
    <tr>
        <th>ID</th>
        <th>Tytuł</th>
        <th>Opis</th>
        <th>Status</th>
        <th>Akcje</th>
    </tr>
    <c:forEach var="task" items="${taskList}">
        <tr>
            <td>${task.id}</td>
            <td>${task.title}</td>
            <td>${task.description}</td>
            <td>${task.status}</td>
            <td>
                <button class="btn-link"><a href="/leader/edit-task/${task.id}"> Edycja zadania</a></button>
                <button class="btn-link"><a href="#">Usunięcie zadania</a></button>
            </td>
        </tr>
    </c:forEach>
</table>
<div class="footer">
    <%@include file="/WEB-INF/views/includes/footer.jsp" %>
</div>
</body>
</html>
