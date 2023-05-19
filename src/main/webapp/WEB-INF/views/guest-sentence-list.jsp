<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>

<html>

	<head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style><%@include file="/styles/style-main.css"%></style>
    </head>

	<body>

		<!-- HEADER include -->
        <jsp:include page="header.jsp" />

		<style>



		</style>

		<main>
			<aside>
				<nav class="sidenav">
					<a class="return"  href="${pageContext.request.contextPath}/guest/showExercises/${topicId}">Return to exercises</a>
                    <a class="return"  href="${pageContext.request.contextPath}/guest">Return to topics</a>
				</nav>

			</aside>

			<section>

                		    <c:if test="${fn:length(allListsHashMap) < 1 }">
                            	<h3> No sentences, try again later :( </h3>
                            </c:if>

                            <p><h4>${exName}</h4></p>

						<ol>
                			<c:if test="${fn:length(allListsHashMap) > 0}">
                			    <c:forEach var="sentenceListHashMap" items="${allListsHashMap}" varStatus="status">
                			            <li>
	                                        <div class="sentence-item">
	                                            <c:forEach var="hashMap" items="${sentenceListHashMap}">
	                                                <c:choose>
	                                                    <c:when test="${hashMap.type.equals('text')}">
	                                                        ${hashMap.content}
	                                                    </c:when>
	                                                    <c:when test="${hashMap.type.equals('input')}">
	                                                        <div>
	                                                            <input class="answer-${status.getIndex()}" type="text"
	                                                                   data-rightAnswer="${hashMap.content}"/>
	                                                            <div class="marker-${status.getIndex()}"></div>
	                                                        </div>

	                                                    </c:when>
	                                                    <c:when test="${hashMap.type.equals('hint')}">
	                                                        (${hashMap.content})
	                                                    </c:when>
	                                                </c:choose>
	                                            </c:forEach>
	                                            <div>
	                                                <input type="button" class="button" value="check" onclick="checkAnswer(${status.getIndex()})">
	                                            </div>
	                                        </div>
                			            </li>

                			    </c:forEach>
                			</c:if>
                		</ol>
			</section>

		<br>



		<br>


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

		<!-- FOOTER include -->
        <jsp:include page="footer.jsp" />
	</body>
</html>