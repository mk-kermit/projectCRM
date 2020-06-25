<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<form:form method="POST" modelAttribute="task">
    <div class="register">
        <form:label path="title">Tytuł:</form:label></br>
        <form:input class="textfield" type="text" path="title"/></br>
        <form:label path="description">Opis:</form:label></br>
        <form:input class="textfield" type="text" path="description"/></br>
     <form:label path="userList">Do kogo przypisać:</form:label></br>
        <form:select name = "user_id" class="userList" path="userList">
            <c:forEach var="user" items="${userList}">
                <option value="${user.id}">${user.firstName} ${user.surname}</option>
            </c:forEach>
        </form:select></br>
        <input class="button" type="submit" value="Zarejestruj">
    </div>
</form:form>
<div class="footer">
    <%@include file="/WEB-INF/views/includes/footer.jsp" %>
</div>
</body>
</html>
