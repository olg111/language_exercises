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
        	    <p><h3>Topics</h3></p>
        	    <nav class="sidenav">

					<c:if test="${fn:length(allTop) < 1 }">
						<h3> No topics, try again later :( </h3>
                    </c:if>

                    <c:if test="${fn:length(allTop) > 0 }">

                        <c:forEach var="topic" items="${allTop}">
                    	    <tr>
                    		<td>
                    		    <a href="/guest/showExercises/${topic.id}">${topic.name}</a>
                    		</td>
                    		</tr>
                    	</c:forEach>
                   </c:if>

        	    </nav>

        	</aside>

        	<section>
        			<p> Dear Guest, Choose a topic </p>
        	</section>
        </main>

		<!-- FOOTER include -->
        <jsp:include page="footer.jsp" />
	</body>
</html>