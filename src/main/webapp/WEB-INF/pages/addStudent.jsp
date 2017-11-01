<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Aero
  Date: 21.10.2017
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form method="post" action="addStudent" commandName="student">
        <tr>
            <td>Name</td>
            <td><input type="text" name="name" value=""></td>
        </tr>
        <tr>
            <td>Age</td>
            <td><input type="text" name="age" value=""></td>
        </tr>
        <tr>
            <td>Etrumural</td>
            <td><input type="checkbox" name="isExtrumural"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Add Student"></td>
        </tr>
    </form:form>
</body>
</html>
