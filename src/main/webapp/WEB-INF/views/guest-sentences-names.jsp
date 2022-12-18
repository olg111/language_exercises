<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>

<html>
<body>

<h2>Dear Guest, Fill in the sentences</h2>
<br>


<table>


    <tr>
        <th>${exName}</th>
    </tr>


    <c:forEach var="sentById" items="${sentById}">


            <tr>
                <td> <a href="">${sentById.sentence}</a></td>

                <td>
                      <input type="button" value="check">
                </td>

             </tr>


    </c:forEach>

</table>

                <br>

                     <c:url var="chooseExercise" value="/guest/showExercises/${topicId}">
                     </c:url>
                     <input type="button" value="Return to exercises"
                     onclick="window.location.href = '${chooseExercise}'"/>

                <br>
                <br>

                     <c:url var="chooseTopic" value="/guest">
                     </c:url>
                     <input type="button" value="Return to topics"
                     onclick="window.location.href = '${chooseTopic}'"/>


</body>

</html>