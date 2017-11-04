<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Aero
  Date: 21.10.2017
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:if test="${!empty books}">
        <table border="1" cellpadding="8" cellspacing="0">
            <tr>
                <th>Id</th>
                <th>StudentId</th>
                <th>Title</th>
                <th>Pages</th>
                <th>Author</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach items="${books}" var="book">
                <tr>
                    <td>${book.id}</td>
                    <td>${book.title}</td>
                    <td>${book.pages}</td>
                    <td>${book.author}</td>
                    <td><a href="/updateBook/${book.id}">Update</a> </td>
                    <td><a href="/deleteBook/${book.id}">Delete</a> </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
<a href="/addBook/${studentId}">Add Book</a>
</body>
</html>
