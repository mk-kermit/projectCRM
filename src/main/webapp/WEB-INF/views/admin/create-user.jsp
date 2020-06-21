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
        <div class="row">
            <div class="col">
                <label>Login:</label><input type="text"/></br>
            </div>
            <div class="col">
                <label>Hasło:</label><input type="password"/></br>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <label>Imię:</label><input type="text"/></br>
            </div>
            <div class="col">
                <label>Nazwisko:</label><input type="text"/></br>
            </div>
        </div>
        <div class="row">
            <input type="submit" value="Zarejestruj">
        </div>
    </form>
</body>
</html>
