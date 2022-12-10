<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>

<html>
<body>

<h2>Choose a topic</h2>
<br>

<table>
    <tr>
        <th>Topics</th>
    </tr>
    <c:forEach var="topic" items="${allTop}">


      <c:url var="updateButton" value="/updateInfoTopic">
            <c:param name="topId" value="${topic.id}"/>
      </c:url>

      <c:url var="deleteButton" value="/deleteTopic">
            <c:param name="topId" value="${topic.id}"/>
      </c:url>


      <tr>
                <td> <a href="/showExercises/${topic.id}">${topic.name}</a></td>

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
 <c:url var="addNewTopic" value="/addNewTopic"></c:url>

 <c:url var="logout" value="/logout"></c:url>

 <c:url var="login" value="/login"></c:url>






<input type="button" value="Add"
    onclick="window.location.href = '${addNewTopic}'"/>



<br><br>

    <input type="button" value="Login"
         onclick="window.location.href = '${login}'"/>

<br><br>

<input type="button" value="Logout"
     onclick="window.location.href = '${logout}'"/>



</body>

</html>