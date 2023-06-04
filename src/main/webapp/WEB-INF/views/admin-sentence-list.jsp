<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>

<html>
	<head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style><%@include file="/styles/style-main.css"%></style>
        <title>Language exercises</title>
    </head>

	<body>
		<!-- HEADER include -->
    	<jsp:include page="header.jsp" />

    	<main>
    	    <aside>

    	        <nav class="sidenav">
    	            <br>
					<a class="return" href="${pageContext.request.contextPath}/admin/showExercises/${topicId}">Return to exercises</a>
    	            <a class="return" href="${pageContext.request.contextPath}/admin">Return to topics</a>
    	        </nav>
    	    </aside>

    	    <section>
    	            <h3>Dear Admin, here you can create a new sentence</h3>
                    <h4> ${exName} </h4>

					<ol>
	                    <c:forEach var="sentById" items="${sentById}">
	                        <c:url var="updateButton" value="/admin/updateInfoSentences/${topicId}/${exerciseId}">
	                            <c:param name="sentId" value="${sentById.id}"/>
	                        </c:url>

							<li>
	                             <div class="flex-container">
						            <p class="sentence-item">${sentById.sentence}</p>

						            <div class="action-container">

		                                <input class="input-admin update-button" type="button" value="Update"
		                                       onclick="window.location.href = '${updateButton}'"/>

		                                <form:form action="/admin/deleteSentence/${topicId}/${sentById.id}"  method="post">
		                                       <input class="input-admin delete-button" type="submit" value="Delete"/>
		                                </form:form>
		                            </div>
	                            </div>
							</li>
	                    </c:forEach>
					</ol>
                    <br>
                    <c:url var="addNewSentence" value="/admin/addNewSentence/${topicId}/${exerciseId}"></c:url>
                    <input class="input-admin add-ok-button" type="button" value="Add"
                           onclick="window.location.href = '${addNewSentence}'"/>

    	    </section>
    	</main>

</body>

		<!-- FOOTER include -->
        <jsp:include page="footer.jsp" />
</html>