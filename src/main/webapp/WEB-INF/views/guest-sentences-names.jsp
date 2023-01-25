<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>

<html>
<body>
<style>
.sentence-item {
    display: flex;
    gap: 12px
}

.correctAnswer {
  color: blue;
  font-weight:bold;
}

.incorrectAnswer {
  color: red;
  font-weight:bold;
}



</style>

<h2>Dear Guest, Fill in the sentences</h2>
<br>


<table>

    <tr>
        <th>${exName}</th>
    </tr>


    <c:forEach var="sentenceListHashMap" items="${allListsHashMap}" varStatus="status">
<!--              <p>Индекс: ${status.getIndex()}</p> -->
            <tr>

                <td class="sentence-item">
                        <c:forEach var="hashMap" items="${sentenceListHashMap}">
                            <c:choose>
                                <c:when test="${hashMap.type.equals('text')}">
                                        ${hashMap.content}
                                </c:when>
                                <c:when test="${hashMap.type.equals('input')}">
                                    <div>
                                        <input class="answer-${status.getIndex()}" type="text"  data-rightAnswer="${hashMap.content}"  />
                                        <div class="marker-${status.getIndex()}"> </div>
                                    </div>

                                </c:when>
                                <c:when test="${hashMap.type.equals('hint')}">
                                       (${hashMap.content})
                               </c:when>
                            </c:choose>
                        </c:forEach>
                        <div>
                            <input type="button" value="check" onclick="checkAnswer(${status.getIndex()})">
                        </div>
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
    let markerList = document.getElementsByClassName('marker-' + index);
    console.log(inputAnswerList);
    console.log(markerList);




        for (var i = 0; i < Array.prototype.slice.call(inputAnswerList).length; i++) {

            if (inputAnswerList[i].dataset.rightanswer.trim().toLowerCase() === inputAnswerList[i].value.trim().toLowerCase())
              {
              markerList[i].classList.remove("incorrectAnswer");
              markerList[i].classList.add("correctAnswer");
              markerList[i].innerHTML =  "ok!"  ;

              } else {
              markerList[i].classList.remove("correctAnswer");
              markerList[i].classList.add("incorrectAnswer");
               markerList[i].innerHTML = inputAnswerList[i].dataset.rightanswer.trim();
              }


        }


    }
</script>
</body>

</html>