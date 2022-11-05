<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
<body>

<h2>Topics Info</h2>
<br>

<form:form action="saveTopic" modelAttribute="topic">

        <form:hidden path="id"/>

        New Topic <form:input path="name"/>
        <br><br>

         <input type="submit" value="OK">


</form:form>


</body>