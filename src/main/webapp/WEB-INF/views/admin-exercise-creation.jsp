<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@page contentType="text/html;charset=UTF-8" language="java" %>
    <%@page isELIgnored="false" %>
    <!DOCTYPE html>

    <html>
    <body>

    <h2>Create a exercise</h2>
    <br>

    <form:form action="/admin/saveExercise" modelAttribute="exercise">

        <form:hidden path="id"/>
        New Exercise name
        <form:input path="name"/>
        <br><br>

     <form:hidden path="topic.id" value="${topicId}"/>

    <br><br>

    <input type="submit" value="OK">

    <br><br>

    <a href="${pageContext.request.contextPath}/admin/showExercises/${topicId}">Return to exercises</a>


</form:form>


</body>