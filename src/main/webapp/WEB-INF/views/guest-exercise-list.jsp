<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
	                <c:if test="${fn:length(exById) < 1 }">
	                    <h3> No exercises, try again later :( </h3>
	                </c:if>

	                <c:if test="${fn:length(exById) > 0 }">
		                <c:forEach var="ex" items="${exById}">
		                    <a href="/guest/showExercises/${ex.topic.id}/${ex.id}">${ex.name}</a>
		                </c:forEach>
	                </c:if>
	                <br>
	                <a class="return" href="${pageContext.request.contextPath}/guest">Return to topics</a>

	            </nav>
        	</aside>

        	<section>
        	    <h3><p>Dear Guest, Choose an exercise</p></h3>
        	</section>



		<!-- FOOTER include -->
        <jsp:include page="footer.jsp" />
	</body>
</html>