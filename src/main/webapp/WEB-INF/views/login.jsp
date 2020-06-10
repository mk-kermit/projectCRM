<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Login page</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script type="text/javascript">
        function validate() {
            if (document.f.username.value == "" && document.f.password.value == "") {
                alert("Login i hasło wymagane");
                document.f.username.focus();
                return false;
            }
            if (document.f.username.value == "") {
                alert("Login wymagany");
                document.f.username.focus();
                return false;
            }
            if (document.f.password.value == "") {
                alert("Hasło wymagane");
                document.f.password.focus();
                return false;
            }
        }
    </script>
</head>
<body>
<div class="container">
    <div class="text-center">
        <form method="post">
            <div><label> User Name : <input type="text" name="username"/> </label></div>
            <div><label> Password: <input type="password" name="password"/> </label></div>
            <div><input type="submit" value="Sign In"/></div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </div>
</div>
</body>
</html>
