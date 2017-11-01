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
    <c:if test="${!empty students}">
        <table border="1" cellpadding="8" cellspacing="0">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Age</th>
                <th>Created Date</th>
                <th>Extrumural</th>
                <th></th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach items="${students}" var="student">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>${student.age}</td>
                    <td>${student.createdDate}</td>
                    <td><c:if test="${student.isExtrumutal==true}">+</c:if></td>
                    <td><a href="updateStudent/${student.id}">Update</a> </td>
                    <td><a href="deleteStudent/${student.id}">Delete</a> </td>
                    <td><a href="listOfBooks/${student.id}">List Of Books</a> </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
<a href="addStudent.jsp">Add student</a>
</body>
</html>
