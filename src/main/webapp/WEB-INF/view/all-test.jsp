<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<body>


<h2>Topics Info</h2>
<br>


<form action="saveExercise" method="POST" modelAttribute="exercise">

        <input type="hidden" name="id" value="${exercise.id}"/>

        New Exercise name <input name='name' type='text'/>
        <br><br>
        Topic name (id)

        <select name="topicId">
            <c:forEach var="item" items="${topics}">
                <option value="${item.id}" >   ${item.name} </option>
            </c:forEach>
        </form:select>

        <br><br>

         <input type="submit" value="OK">


</form>


</body>

</html>