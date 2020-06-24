<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Moje zadania</title>
</head>
<body>
<div class="top">
</div>
<div class="nav">
    <%@include file="/WEB-INF/views/includes/header.jsp" %>
</div>
<table>
    <c:forEach var="task" items="${myTasks}">
        <tr>
            <td>${task.id}</td>
            <td>${task.title}</td>
            <td>${task.description}</td>
            <td>${task.status}</td>
        </tr>
    </c:forEach>
</table>
<div class="footer">
    <%@include file="/WEB-INF/views/includes/footer.jsp" %>
</div>
</body>
</html>
