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
                <li>
                    <a href="/guest/showExercises/${ex.topic.id}/guest/showSentences/${ex.id}">${ex.name}</a>
                </li>
            </td>
        </tr>

    </c:forEach>

</table>

<br>

<!--  это не нужно, можно напрямую использовать строку в href -->
<c:url var="chooseTopic" value="/guest">
</c:url>
<input type="button" value="Return to topics"
       onclick="window.location.href = '${chooseTopic}'"/>

</body>

</html>