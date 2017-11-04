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
<form:form method="post" action="/addBook/${studentId}" commandName="book">
    <table border="1" cellpadding="8" cellspacing="0">
        <tr>
            <td>Title</td>
            <td><input type="text" name="title" value=""></td>
        </tr>
        <tr>
            <td>Pages</td>
            <td><input type="text" name="pages" value=""></td>
        </tr>
        <tr>
            <td>Author</td>
            <td><input type="text" name="author" value=""></td>
        </tr>
        <tr>
            <td><input type="submit" value="Add Book"/></td>
        </tr>
    </table>
</form:form>

</body>
</html>
