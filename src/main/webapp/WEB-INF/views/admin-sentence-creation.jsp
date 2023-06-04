<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>

<html>
	<head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style><%@include file="/styles/style-main.css"%></style>
    </head>

	<body>
			<!-- HEADER include -->
        	<jsp:include page="header.jsp" />

        <main>

            <aside>
				<h3>Return</h3>
                <nav class="sidenav">
                    <a href="${pageContext.request.contextPath} /admin/showExercises/${topicId}/${exerciseId}"> Return to sentences</a>
                </nav>
            </aside>

            <section>
            	<h3>${title}</h3>

				<form:form action="/admin/saveSentence/${topicId}" modelAttribute="sentence">
	            <form:hidden path="id"/>


	    Use pattern <span style="color: red;"> "I_/{like}/_cats_and_he_/{likes}/_dogs."</span>
	    <Br>
	    Use a <span style="color: red;">space character</span> instead of "<span style="color: red;">_</span>".


	    <br><br>
	    Write a new sentence
	    <form:input class="input-text" path="sentence"/>
	    <form:errors path="sentence"/>

	    <br>
	    Write a hint <span style="color: red;"> "to like, to like"</span>
	    <form:input class="input-text" path="hint"/>
	    <form:errors path="hint"/>

	    <br><br>

	    <form:hidden path="exercise.id" value="${exerciseId}"/>

	    <input type="submit" value="OK">


				</form:form>

            </section>
		<!-- FOOTER include -->
        <jsp:include page="footer.jsp" />

	</body>
</html>