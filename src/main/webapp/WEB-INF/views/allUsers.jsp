<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>All Users</title>

    <style>
        tr:first-child {
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>
</head>
<body>
<h2>List of Users</h2>
<table>
    <tr>
        <td>ID</td>
        <td>LAST NAME</td>
        <td>FIRST NAME</td>
        <td>AGE</td>
        <td>PHONE NUMBER</td>
        <td>DESIGNATION</td>
        <td></td>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.lastName}</td>
            <td>${user.firstName}</td>
            <td>${user.age}</td>
            <td>${user.phone}</td>
            <td>${user.gender}</td>
            <td><a href="<c:url value='/edit-${user.id}-user' />">edit</a></td>
            <td><a href="<c:url value='/delete-${user.id}-user' />">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>