<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

          <tr>
                <td> <a href="/ex">${topic.name}</a></td>
          </tr>

    </c:forEach>

</table>

</body>

</html>