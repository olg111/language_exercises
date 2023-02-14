<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>

<html>
<body>

<h2>Sentence list</h2>
<br>

<table>

    <tr>
        <th> <h3> ${exName} </h3> </th>

    </tr>

    <c:forEach var="sentById" items="${sentById}">

        <c:url var="updateButton" value="/admin/updateInfoSentences/${topicId}/${exerciseId}">
            <c:param name="sentId" value="${sentById.id}"/>
        </c:url>

       <tr>
            <td>
                &bull;    ${sentById.sentence}</a>
            </td>

            <td>
                <input type="button" value="Update"
                       onclick="window.location.href = '${updateButton}'"/>
            </td>

            <td>
                <form:form action="/admin/deleteSentence/${topicId}/${sentById.id}"  method="post">
                       <input type="submit" value="Delete"/>
                </form:form>
            </td>

        </tr>

    </c:forEach>

</table>

<br>
<c:url var="addNewSentence" value="/admin/addNewSentence/${topicId}/${exerciseId}">
</c:url>
<input type="button" value="Add"
       onclick="window.location.href = '${addNewSentence}'"/>

<br><br>

       <a href="${pageContext.request.contextPath}/admin/showExercises/${topicId}">Return to exercises</a>

<br><br>

       <a href="${pageContext.request.contextPath}/admin">Return to topics</a>

</body>

</html>