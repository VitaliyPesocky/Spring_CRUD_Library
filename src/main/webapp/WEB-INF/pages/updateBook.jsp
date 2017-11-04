<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <h2><a href="/">Home</a> </h2>
    <c:url var="saveUrl" value="/updateBook/${bookAttribute.id}"/>
<form:form modelAttribute="bookAttribute" method="post" action="${saveUrl}">
    <table>
        <tr>
            <td><form:label path="id">Id</form:label></td>
            <td><form:input path="id"/></td>
        </tr>
        <tr>
            <td><form:label path="title">Title</form:label></td>
            <td><form:input path="title"/></td>
        </tr>
        <tr>
            <td><form:label path="pages">Pages</form:label></td>
            <td><form:input path="pages"/></td>
        </tr>
        <tr>
            <td><form:label path="author">Author</form:label></td>
            <td><form:input path="author"/></td>
        </tr>
    </table>
    <input type="submit" value="Save"/>
</form:form>
</body>
</html>
