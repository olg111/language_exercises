<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>

<html>
<body>

<h2>Dear Guest, Choose an exercise</h2>
<br>
<table>


	<c:if test="${fn:length(exById) < 1 }">
        <h3> No exercises, try again later :( </h3>
    </c:if>

    <c:if test="${fn:length(exById) > 0 }">


		    <tr>
		        <th> <h3> <c:out value="${exById[0].topic.name}"/> </h3> </th>
		    </tr>

		    <c:forEach var="ex" items="${exById}">

		        <tr>
		            <td>
		                &bull;    <a href="/guest/showExercises/${ex.topic.id}/${ex.id}">${ex.name}</a>
		            </td>
		        </tr>

		    </c:forEach>
	</c:if>

</table>

<br>

       <a href="${pageContext.request.contextPath}/guest">Return to topics</a>

</body>

</html>