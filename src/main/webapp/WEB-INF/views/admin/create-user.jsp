<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formularz dodawania użytkownika</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="top">
</div>
<div class="nav">
    <%@include file="/WEB-INF/views/includes/header.jsp" %>
</div>
<div id="grad">
    <form:form method="POST" modelAttribute="user">
        <div class="register">
        <span><form:label class="labels" path="username">Login:</form:label></br>
                <form:input class="textfield" path="username"/></span>
            <span><form:label class="labels" path="password">Hasło:</form:label></br>
        <form:password class="textfield" path="password"/></span>
            <span><form:label class="labels" path="firstName">Imię:</form:label></br>
        <form:input class="textfield" path="firstName"/></span>
            <span><form:label class="labels" path="surname">Nazwisko:</form:label></br>
        <form:input class="textfield" path="surname"/></span>
            <form:radiobuttons path="role" items="${roles}"/>
            </br><input class="button" type="submit" value="Zarejestruj"/>
        </div>
    </form:form>
</div>
<div class="footer">
    <%@include file="/WEB-INF/views/includes/footer.jsp" %>
</div>
</body>
</html>
