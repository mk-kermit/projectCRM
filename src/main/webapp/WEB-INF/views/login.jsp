<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Strona logowania</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div id="grad">
    <div class="newform">
        <form method="POST" action="/login">
            <label> User Name : <input type="text" name="username"/> </label>
            <label> Password: <input type="password" name="password"/> </label>
            <input type="submit" value="Sign In"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </div>
</div>
</body>
</html>
