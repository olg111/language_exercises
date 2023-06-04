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
        <title>Language exercises</title>
    </head>

	<body>
		<!-- HEADER include -->
    	<jsp:include page="header.jsp" />

    	<main>

	        <aside>
	            <h3>Topic list</h3>
	            <nav class="sidenav">

	                <c:forEach var="topic" items="${allTop}">

	                    <c:url var="updateButton" value="/admin/updateInfoTopic">
	                        <c:param name="topId" value="${topic.id}"/>
	                    </c:url>

	                    <a href="/admin/showExercises/${topic.id}">${topic.name}</a>

	                </c:forEach>
				</nav>
	        </aside>

	        <section>
	            <p> <h3> Dear Admin, here you can create a new topic </h3> </p>
	            <c:forEach var="topic" items="${allTop}">

	                <c:url var="updateButton" value="/admin/updateInfoTopic">
	                    <c:param name="topId" value="${topic.id}"/>
	                </c:url>


				<div class="flex-container">
	                <p>${topic.name}</p>

	                <div class="action-container">

	                    <input class="input-admin update-button" type="button" value="Update"
	                        onclick="window.location.href = '${updateButton}'"/>

	                    <form:form action="/admin/deleteTopic/${topic.id}"  method="post">
	                     <input class="input-admin delete-button" type="submit" value="Delete"/>
	                    </form:form>
	                </div>
				</div>
	            </c:forEach>

	            <br>

	            <c:url var="addNewTopic" value="/admin/addNewTopic"></c:url>
	            <input class="input-admin add-ok-button" type="button" value="Add"
	                   onclick="window.location.href = '${addNewTopic}'"/>

	        </section>
    	</main>

		<!-- FOOTER include -->
        <jsp:include page="footer.jsp" />
	</body>

</html>