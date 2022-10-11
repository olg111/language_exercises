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

    <c:forEach var="ex" items="${allEx}">

          <tr>
                <td> <a href="">${ex.name}</a></td>
          </tr>

    </c:forEach>

</table>

</body>

</html>