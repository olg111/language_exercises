<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>

<html>
<body>

<h2>Add new sentences</h2>
<br>



<table>


    <tr>
        <th>${exName}</th>

    </tr>



    <c:forEach var="sentById" items="${sentById}">


          <c:url var="updateButton" value="/admin/updateInfoSentences/${topicId}">
                <c:param name="sentId" value="${sentById.id}"/>
          </c:url>

          <c:url var="deleteButton" value="/admin/deleteSentence/${topicId}">
                <c:param name="sentId" value="${sentById.id}"/>
          </c:url>




            <tr>
                <td>
                    <li>
                        <a href="">${sentById.sentence}</a>
                    </li>
                </td>


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
                    <c:url var="addNewSentence" value="/admin/addNewSentence/${topicId}/${exerciseId}">
                    </c:url>
                    <input type="button" value="Add"
                    onclick="window.location.href = '${addNewSentence}'"/>

                <br>
                <br>

                     <c:url var="chooseExercise" value="/admin/showExercises/${topicId}">
                     </c:url>
                     <input type="button" value="Return to exercises"
                     onclick="window.location.href = '${chooseExercise}'"/>

                <br>
                <br>

                     <c:url var="chooseTopic" value="/admin">
                     </c:url>
                     <input type="button" value="Return to topics"
                     onclick="window.location.href = '${chooseTopic}'"/>


</body>

</html>