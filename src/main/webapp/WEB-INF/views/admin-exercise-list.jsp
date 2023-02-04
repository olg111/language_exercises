<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
    <body>

        <h2>Exercise list</h2>
        <br>

        <table>
            <tr>
                <th>Exercises</th>
            </tr>

            <c:forEach var="ex" items="${exById}">

                <c:url var="updateButton" value="/admin/updateInfoExercise">
                    <c:param name="exId" value="${ex.id}"/>
                </c:url>

                <tr>
                    <td>
                        &bull;   <a href="/admin/showExercises/${ex.topic.id}/${ex.id}">${ex.name}</a>


                    <td>
                        <input type="button" value="Update"
                            onclick="window.location.href = '${updateButton}'"/>
                    </td>

                    <td>
                        <form:form action="/admin/deleteExercise/${ex.id}"  method="post">
                            <input type="submit" value="Delete"/>
                        </form:form>
                    </td>

                </tr>


            </c:forEach>

        </table>

        <br>
        <c:url var="addNewExercise" value="/admin/addNewExercise/${topicId}"></c:url>
        <input type="button" value="Add"
            onclick="window.location.href = '${addNewExercise}'"/>

        <br>
        <br>


        <a href="${pageContext.request.contextPath}/admin">Return to topics</a>


    </body>

</html>