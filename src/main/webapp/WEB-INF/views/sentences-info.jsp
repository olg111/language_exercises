<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>

<html>
<body>

<h2>Sentences Info</h2>
<br>

<form:form action="/addNewSentence/${topicId}/saveSentence" modelAttribute="sentence">

        <form:hidden path="id"/>

        Use pattern "bla bla {answer=world}, bla {answer=world}"
        <br><br>
        Write a new sentence <form:input path="sentence"/>
        Write a hint <form:input path="hint"/>
        <br><br>


        <form:hidden path="exercise.id" value="${exerciseId}"/>




        <br><br>

         <input type="submit" value="OK">


</form:form>


</body>