<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>

<html>
<body>

<h2>Topics Info</h2>
<br>

<form:form action="saveExercise" modelAttribute="exercise">

        <form:hidden path="id"/>
        New Exercise name <form:input path="name"/>
        <br><br>



        Topic name (id) <form:select path ="topic.id">


                       <form:options items="${topics}"/>

        </form:select>


        <br><br>

         <input type="submit" value="OK">


</form:form>


</body>