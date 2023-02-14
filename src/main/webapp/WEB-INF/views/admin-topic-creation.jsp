<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>

<html>
<body>

<h2>${title}</h2>
<br>

<form:form action="saveTopic" modelAttribute="topic">

    <form:hidden path="id"/>

    New Topic
    <form:input path="name"/>
    <br><br>

    <input type="submit" value="OK">
    <br><br>

    <a href="${pageContext.request.contextPath}/admin">Return to topics</a>

</form:form>


</body>