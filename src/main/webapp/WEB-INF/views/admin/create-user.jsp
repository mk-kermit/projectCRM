<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formularz dodawania użytkownika</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>

<div class="nav">
    <%@include file="/WEB-INF/views/includes/header.jsp" %>
</div>
<form action="POST">
    <div class="register">
        <label>Login:</label></br>
        <input class="textfield" type="text"/></br>
        <label>Hasło:</label></br>
        <input class="textfield" type="password"/></br>
        <label>Imię:</label></br>
        <input class="textfield"type="text"/></br>
        <label>Nazwisko:</label></br>
        <input class="textfield" type="text"/></br>
        <input class="button" type="submit" value="Zarejestruj">
    </div>
</form>
<div class="footer">
    <%@include file="/WEB-INF/views/includes/footer.jsp" %>
</div>
</body>
</html>
