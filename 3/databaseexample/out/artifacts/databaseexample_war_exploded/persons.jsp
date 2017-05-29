<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: eugen
  Date: 23.03.2016
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <title>Persons</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<table>
    <thead>
    <tr><th>id</th><th>Имя</th><th>Фамилия</th><th>Возраст</th><th>Адрес</th></tr>
    </thead>
    <c:forEach items="${persons}" var="p">
        <tr>
            <td>${p.id}</td> <td>${p.firstName}</td> <td>${p.lastName}</td><td>${p.age}</td><td>${p.adress}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
