<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formularz edycji użytkownika</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="top">
</div>
<div class="nav">
    <%@include file="/WEB-INF/views/includes/header.jsp" %>
</div>
<form:form method="POST" modelAttribute="user">
    <div class="register">
        <form:label path="username">Login:</form:label></br>
        <form:input path="username" class="textfield" type="text"/></br>
        <form:label path="firstName">Imię:</form:label></br>
        <form:input path="firstName" class="textfield" type="text"/></br>
        <form:label path="surname">Nazwisko:</form:label></br>
        <form:input path="surname" class="textfield" type="text"/></br>
       <form:select path="role">
            <c:forEach items="${roles}" var="role">
                <form:option value="${role}">${role}</form:option>
            </c:forEach>
        </form:select>
        </br><input class="button" type="submit" value="Zmień">
    </div>
</form:form>
<div class="footer">
    <%@include file="/WEB-INF/views/includes/footer.jsp" %>
</div>
</body>
</html>
