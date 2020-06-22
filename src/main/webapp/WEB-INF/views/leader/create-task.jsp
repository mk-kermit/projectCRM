<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formularz dodawania zadania</title>
</head>
<body>
<div class="top">
</div>
<div class="nav">
    <%@include file="/WEB-INF/views/includes/header.jsp" %>
</div>
<form action="POST">
    <div class="newform">
        <label>Tytuł:</label></br>
        <input class="textfield" type="text"/></br>
        <label>Opis:</label></br>
        <input class="textfield" type="text"/></br>
        <label>Do kogo przypisać:</label></br>
        <select class="userList">
            <c:forEach var="user" items="${userList}">
                <option>${user.firstName} ${user.surname}</option>
            </c:forEach>
        </select></br>
        <input class="button" type="submit" value="Zarejestruj">
    </div>
</form>
<div class="footer">
    <%@include file="/WEB-INF/views/includes/footer.jsp" %>
</div>
</body>
</html>
