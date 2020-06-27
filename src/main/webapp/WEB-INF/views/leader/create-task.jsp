<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formularz dodawania zadania</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="top">
</div>
<div class="nav">
    <%@include file="/WEB-INF/views/includes/header.jsp" %>
</div>
<div id="grad">
    <form:form method="POST" modelAttribute="task">
        <div class="register">
            <span><form:label class="labels" path="title">Tytuł:</form:label>
                <form:input class="textfield" type="text" path="title"/></span>
            <span><form:label class="labels" path="description">Opis:</form:label>
                <form:textarea class="textfield" path="description"/></span>
            <span><form:label class="labels" path="userList">Do kogo przypisać:</form:label>
            <form:select name="user_id" class="userList" path="userList">
                <c:forEach var="user" items="${userList}">
                    <option value="${user.id}">${user.firstName} ${user.surname}</option>
                </c:forEach>
            </form:select></span></br>
            <span><input class="button" type="submit" value="Zarejestruj"></span>
        </div>
    </form:form>
</div>
<div class="footer">
    <%@include file="/WEB-INF/views/includes/footer.jsp" %>
</div>
</body>
</html>
