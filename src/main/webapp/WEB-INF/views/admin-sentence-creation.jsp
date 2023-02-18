<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>

<html>
<body>

	<style>

    			.pattern {
    			  color: red;
    			  font-weight:bold;
    			}
    </style>

	<h2>${title}</h2>
	<br>

	<form:form action="/admin/saveSentence/${topicId}" modelAttribute="sentence">

	    <form:hidden path="id"/>


	    Use pattern <span class="pattern"> "I /{like}/ cats and he /{likes}/ dogs."</span>


	    <br><br>
	    Write a new sentence
	    <form:input path="sentence"/>
	    Write a hint <span class="pattern"> "to like, to like"</span>
	    <form:input path="hint"/>
	    <br><br>

	    <form:hidden path="exercise.id" value="${exerciseId}"/>

	    <input type="submit" value="OK">

	    <br><br>

	   <a href="${pageContext.request.contextPath} /admin/showExercises/${topicId}/${exerciseId}"> Return to sentences</a>

	</form:form>

</body>
</html>