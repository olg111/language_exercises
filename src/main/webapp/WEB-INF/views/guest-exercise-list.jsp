<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>

<html>
<body>

<h2>Dear Guest, Choose an exercise</h2>
<br>
<!--  придумать что показать юзеру если нету упражнений, топиков, предложений -->
<table>
    <tr>
        <th>Exercises</th>
    </tr>

    <c:forEach var="ex" items="${exById}">

        <tr>
            <td>
                &bull;    <a href="/guest/showExercises/${ex.topic.id}/${ex.id}">${ex.name}</a>
            </td>
        </tr>

    </c:forEach>

</table>

<br>

       <a href="${pageContext.request.contextPath}/guest">Return to topics</a>

</body>

</html>