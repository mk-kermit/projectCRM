<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formularz edycji użytkownika</title>
</head>
<body>
<div class="top">
</div>
<div class="nav">
    <%@include file="/WEB-INF/views/includes/header.jsp" %>
</div>
<form:form method="POST" modelAttribute="user">
    <div class="register">
        <label>Login:</label></br>
        <input class="textfield" type="text"/></br>
        <label>Imię:</label></br>
        <input class="textfield"type="text"/></br>
        <label>Nazwisko:</label></br>
        <input class="textfield" type="text"/></br>
        <form:radiobuttons path="role" items="${roles}"/>
        </br><input class="button" type="submit" value="Zmień">
    </div>
</form:form>
<div class="footer">
    <%@include file="/WEB-INF/views/includes/footer.jsp" %>
</div>
</body>
</html>
