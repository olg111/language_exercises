<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>

<html>
<body>

<h2>Dear Guest, Fill in the sentences</h2>
<br>


<table>

    <tr>
        <th>${exName}</th>
    </tr>


    <c:forEach var="sentenceListHashMap" items="${allListsHashMap}" varStatus="status">
<!--              <p>Индекс: ${status.getIndex()}</p> -->
            <tr>

                <td>
                    <li>
                        <c:forEach var="hashMap" items="${sentenceListHashMap}">
                            <c:choose>
                                <c:when test="${hashMap.type.equals('text')}">
                                        ${hashMap.content}
                                </c:when>
                                <c:when test="${hashMap.type.equals('input')}">
                                       <input class="answer-${status.getIndex()}" type="text"  data-rightAnswer="${hashMap.content}"  />
                                     <!--   <div> re </div> -->
                                </c:when>
                                <c:when test="${hashMap.type.equals('hint')}">
                                       (${hashMap.content})
                               </c:when>
                            </c:choose>
                        </c:forEach>
                    </li>
                </td>

                <td>
                      <input type="button" value="check" onclick="checkAnswer(${status.getIndex()})">
                </td>

            </tr>

    </c:forEach>

</table>
            <br>
                 <c:url var="chooseExercise" value="/guest/showExercises/${topicId}">
                 </c:url>
                 <input type="button" value="Return to exercises"
                 onclick="window.location.href = '${chooseExercise}'"/>
            <br>
            <br>
                 <c:url var="chooseTopic" value="/guest">
                 </c:url>
                 <input type="button" value="Return to topics"
                 onclick="window.location.href = '${chooseTopic}'"/>
<script>
    function checkAnswer(index) {
    let inputAnswerList = document.getElementsByClassName('answer-' + index);
    console.log(inputAnswerList);

        for (var i = 0; i < Array.prototype.slice.call(inputAnswerList).length; i++) {

            console.log(inputAnswerList[i].dataset.rightanswer.trim().toLowerCase() === inputAnswerList[i].value.trim().toLowerCase());
        }


    }
</script>
</body>

</html>