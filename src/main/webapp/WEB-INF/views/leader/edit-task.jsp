<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formularz edycji zadania</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="top">
</div>
<div class="nav">
    <%@include file="/WEB-INF/views/includes/header.jsp" %>
</div>
<form:form method="POST" modelAttribute="task">
    <div class="register">
        <span><form:label path="description">Opis:</form:label>
        <input class="textfield" type="text"/></span>
        </br><input class="button" type="submit" value="Zmień">
    </div>
</form:form>
<div class="footer">
    <%@include file="/WEB-INF/views/includes/footer.jsp" %>
</div>
</body>
</html>
