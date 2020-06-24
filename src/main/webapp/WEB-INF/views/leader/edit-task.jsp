<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formularz edycji zadania</title>
</head>
<body>
<div class="top">
</div>
<div class="nav">
    <%@include file="/WEB-INF/views/includes/header.jsp" %>
</div>
<form:form method="POST" modelAttribute="task">
    <div class="register">
        <label>Tytuł:</label></br>
        <input class="textfield" type="text"/></br>
        <label>Opis:</label></br>
        <input class="textfield" type="text"/></br>
        <label>Do kogo przypisać:</label></br>
        <select name = "user_id" class="userList">
            <c:forEach var="user" items="${userList}">
                <option value="${user.id}">${user.firstName} ${user.surname}</option>
            </c:forEach>
        </select></br>
        </br><input class="button" type="submit" value="Zmień">
    </div>
</form:form>
<div class="footer">
    <%@include file="/WEB-INF/views/includes/footer.jsp" %>
</div>
</body>
</html>
