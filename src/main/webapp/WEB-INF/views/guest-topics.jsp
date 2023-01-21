<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>

<html>
<body>

<h2>Dear Guest, Choose a topic</h2>
<br>

<table>
    <tr>
        <th>Topics</th>
    </tr>
    <c:forEach var="topic" items="${allTop}">

    <tr>
        <td>
            <li>
                <a href="/guest/showExercises/${topic.id}">${topic.name}</a>
            </li>
        </td>
    </tr>

    </c:forEach>

</table>

</body>

</html>