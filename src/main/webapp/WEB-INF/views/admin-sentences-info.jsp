<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>

<html>
<body>

<h2>Sentences Info</h2>
<br>

<form:form action="/admin/addNewSentence/${topicId}/admin/saveSentence" modelAttribute="sentence">

        <form:hidden path="id"/>

        Use pattern "I /{like}/ cats and he /{likes}/ dogs."
        <br><br>
        Write a new sentence <form:input path="sentence"/>
        Write a hint <form:input path="hint"/>
        <br><br>


        <form:hidden path="exercise.id" value="${exerciseId}"/>




        <br><br>

         <input type="submit" value="OK">


</form:form>


</body>