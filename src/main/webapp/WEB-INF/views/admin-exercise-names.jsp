<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>

<html>
<body>

<h2>Choose an exercise</h2>
<br>

<table>
    <tr>
        <th>Exercises</th>
    </tr>

    <c:forEach var="ex" items="${exById}">

          <c:url var="updateButton" value="/admin/updateInfoExercise">
                <c:param name="exId" value="${ex.id}"/>
          </c:url>

          <c:url var="deleteButton" value="/admin/deleteExercise">
                <c:param name="exId" value="${ex.id}"/>
          </c:url>




            <tr>
                <td> <a href="/admin/showExercises/${ex.topic.id}/admin/showSentences/${ex.id}">${ex.name}</a></td>

                <td>
                      <input type="button" value="Update"
                      onclick="window.location.href = '${updateButton}'"/>
                </td>

                <td>
                      <input type="button" value="Delete"
                      onclick="window.location.href = '${deleteButton}'"/>
                </td>

             </tr>


    </c:forEach>

</table>

                <br>
                    <c:url var="addNewExercise" value="/admin/addNewExercise">
                    </c:url>
                    <input type="button" value="Add"
                    onclick="window.location.href = '${addNewExercise}'"/>

                <br>
                <br>


                     <c:url var="chooseTopic" value="/admin">
                     </c:url>
                     <input type="button" value="Return to topics"
                      onclick="window.location.href = '${chooseTopic}'"/>


</body>

</html>