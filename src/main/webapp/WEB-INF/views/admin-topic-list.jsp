<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>

<html>
<body>

<h2>Topic list</h2>
<br>

<table>
    <tr>
        <th> <h3>Topics</h3> </th>
    </tr>
    <c:forEach var="topic" items="${allTop}">


        <c:url var="updateButton" value="/admin/updateInfoTopic">
            <c:param name="topId" value="${topic.id}"/>
        </c:url>

        <tr>
            <td>
                &bull;    <a href="/admin/showExercises/${topic.id}">${topic.name}</a>
            </td>

            <td>
                <input type="button" value="Update"
                       onclick="window.location.href = '${updateButton}'"/>
            </td>

            <td>
                <form:form action="/admin/deleteTopic/${topic.id}"  method="post">
                    <input type="submit" value="Delete"/>
	            </form:form>
            </td>

        </tr>

    </c:forEach>

</table>

<br>
<c:url var="addNewTopic" value="/admin/addNewTopic"></c:url>


<input type="button" value="Add"
       onclick="window.location.href = '${addNewTopic}'"/>


<br><br>


<c:url value="/logout" var="logoutUrl"/>
<form id="logout" action="${logoutUrl}" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
<c:if test="${pageContext.request.userPrincipal.name != null}">
    <a href="javascript:document.getElementById('logout').submit()">Logout</a>
</c:if>


</body>

</html>