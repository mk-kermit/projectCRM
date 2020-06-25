<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formularz dodawania użytkownika</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
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
        <form:input class="textfield" path="username"/></br>
        <form:label path="password">Hasło:</form:label></br>
        <form:password class="textfield" path="password" /></br>
        <form:label path="firstName">Imię:</form:label></br>
        <form:input class="textfield" path="firstName"/></br>
        <form:label path="surname">Nazwisko:</form:label></br>
        <form:input class="textfield" path="surname"/></br>
        <form:radiobuttons path="role" items="${roles}"/>
        </br><input class="button" type="submit" value="Zarejestruj"/>
    </div>
</form:form>
<div class="footer">
    <%@include file="/WEB-INF/views/includes/footer.jsp" %>
</div>
</body>
</html>
