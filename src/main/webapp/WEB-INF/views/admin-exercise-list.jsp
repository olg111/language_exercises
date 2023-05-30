<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	            <h3> <c:out value="${exById[0].topic.name}"/> </h3>
	            <nav class="sidenav">
		            <c:forEach var="ex" items="${exById}">
						<a href="/admin/showExercises/${ex.topic.id}/${ex.id}">${ex.name}</a>
		            </c:forEach>
		            <br>
		            <a class="return" href="${pageContext.request.contextPath}/admin">Return to topics</a>
	            </nav>
	        </aside>

			<section>
				<p> <h3> Dear Admin, here you can create a new exercise </h3> </p>
	            <c:forEach var="ex" items="${exById}">

	                <c:url var="updateButton" value="/admin/updateInfoExercise/${topicId}">
	                    <c:param name="exId" value="${ex.id}"/>
	                </c:url>

	                <div class="flex-container">
	                    <p>${ex.name}</p>
	                    <div class="action-container">


	                        <input class="input-admin update-button" type="button"  value="Update"
	                            onclick="window.location.href = '${updateButton}'"/>

	                        <form:form action="/admin/deleteExercise/${ex.id}"  method="post">
	                            <input class="input-admin delete-button" type="submit" value="Delete"/>
	                        </form:form>
	                    </div>
					</div>
	            </c:forEach>

                <br>

                <c:url var="addNewExercise" value="/admin/addNewExercise/${topicId}"></c:url>
                <input class="input-admin add-ok-button" type="button" value="Add"
                    onclick="window.location.href = '${addNewExercise}'"/>
            </section>

    </body>

		<!-- FOOTER include -->
        <jsp:include page="footer.jsp" />

</html>