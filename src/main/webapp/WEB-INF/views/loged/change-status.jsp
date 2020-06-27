<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zmiana statusu zadania</title>
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
        <form:radiobuttons path="status" items="${statuses}"/>
        <button class="button" type="submit">Zmień</button>
    </form:form>
</div>
<div class="footer">
    <%@include file="/WEB-INF/views/includes/footer.jsp" %>
</div>
</body>
</html>
