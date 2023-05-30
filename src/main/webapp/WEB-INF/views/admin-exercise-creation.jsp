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
                    <a class="return" href="${pageContext.request.contextPath}/admin/showExercises/${topicId}">Return to exercises</a>
                 </nav>
             </aside>

             <section>
                <h3>${title}</h3>
                <form:form action="/admin/saveExercise" modelAttribute="exercise">
                    <form:hidden path="id"/>
                    <h5>New Exercise name</h5>
                    <form:input class="input-text" path="name"/>
                    <form:errors path="name"/>
                    <br>
                    <form:hidden path="topic.id" value="${topicId}"/>
	                <br>
                    <input class="input-admin add-ok-button" type="submit" value="OK">
            </form:form>
            </section>

		</main>

		<!-- FOOTER include -->
        <jsp:include page="footer.jsp" />

	</body>
</html>