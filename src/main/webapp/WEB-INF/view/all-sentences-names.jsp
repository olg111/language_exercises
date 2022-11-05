<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<body>

<h2>Choose a sentence</h2>
<br>

<table>
    <tr>
        <th>Sentence</th>
    </tr>

    <c:forEach var="allSent" items="${sentById}">


          <c:url var="updateButton" value="/updateInfoSentences">
                <c:param name="sentId" value="${allSent.id}"/>
          </c:url>

          <c:url var="deleteButton" value="/deleteSentence">
                <c:param name="sentId" value="${allSent.id}"/>
          </c:url>




            <tr>
                <td> <a href="">${allSent.sentence}</a></td>

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
                    <c:url var="addNewSentence" value="/addNewSentence/${topicId}">
                    </c:url>
                    <input type="button" value="Add"
                    onclick="window.location.href = '${addNewSentence}'"/>

                <br>
                <br>

                     <c:url var="chooseExercise" value="/showExercises/${topicId}">
                     </c:url>
                     <input type="button" value="Return to exercises"
                     onclick="window.location.href = '${chooseExercise}'"/>

                <br>
                <br>

                     <c:url var="chooseTopic" value="/">
                     </c:url>
                     <input type="button" value="Return to topics"
                     onclick="window.location.href = '${chooseTopic}'"/>


</body>

</html>