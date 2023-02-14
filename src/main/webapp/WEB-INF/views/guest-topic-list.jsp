<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>

<html>
	<body>
		<h2>Dear Guest, Choose a topic</h2>
		<br>
		<table>

			<c:if test="${fn:length(allTop) < 1 }">
	            <h3> No topics, try again later :( </h3>
	        </c:if>

	        <c:if test="${fn:length(allTop) > 0 }">


			    <tr>
			        <th> <h3>Topics</h3> </th>
			    </tr>
			    <c:forEach var="topic" items="${allTop}">
			        <tr>
			            <td>
			                    &bull; <a href="/guest/showExercises/${topic.id}">${topic.name}</a>
			            </td>
			        </tr>
			    </c:forEach>
			</c:if>

		</table>
	</body>
</html>