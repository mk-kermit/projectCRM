<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="/css/style.css">
<div class="topnav">
    <a href="/logout">Wyloguj</a>
    <sec:authorize access="hasAuthority('ROLE_ADMIN')">
        <a href="/admin/userList">Lista użytkowników</a>
        <a href="/admin/create-user">Formularz utworzenia użytkownika</a>
        <a class="active" href="/admin/">Strona główna</a>
    </sec:authorize>
    <sec:authorize access="hasAuthority('ROLE_LEADER')">
        <a href="/leader/allTasks">Wszystkie zadania</a>
        <a href="/leader/create-task">Formularz utworzenia nowego zadania</a>
        <a class="active" href="/leader/">Strona główna</a>
    </sec:authorize>
    <sec:authorize access="hasAuthority('ROLE_USER')">
        <a href="/loged/myTasks">Moje zadania</a>
        <a class="active" href="/loged/">Strona główna</a>
    </sec:authorize>
</div>