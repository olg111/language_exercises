<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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


          <c:url var="updateButton" value="/updateInfoExercise">
                <c:param name="exId" value="${ex.id}"/>
          </c:url>

          <c:url var="deleteButton" value="/deleteExercise">
                <c:param name="exId" value="${ex.id}"/>
          </c:url>


            <tr>
                <td> <a href="">${ex.name}</a></td>

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
                    <c:url var="addNewExercise" value="/addNewExercise">
                    </c:url>
                    <input type="button" value="Add"
                    onclick="window.location.href = '${addNewExercise}'"/>

                <br>
                <br>


                     <c:url var="chooseTopic" value="/">
                     </c:url>
                     <input type="button" value="Return to topics"
                      onclick="window.location.href = '${chooseTopic}'"/>


</body>

</html>