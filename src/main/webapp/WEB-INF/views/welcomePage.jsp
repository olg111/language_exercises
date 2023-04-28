<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html>


<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style><%@include file="/styles/style-welcome-page.css"%></style>

</head>
<body>

<header>

	<div>
		<svg>
            <defs>
                <linearGradient id="grad1" x1="0%" y1="0%" x2="100%" y2="0%">
                    <stop offset="0%"
                	    style="stop-color:rgb(100,100,100);stop-opacity:1" />
                	<stop offset="100%"
                        style="stop-color:rgb(200,200,200);stop-opacity:1" />
                </linearGradient>
            </defs>
                <circle cx="50" cy="50" r="30" stroke="rgb(95,95,95)" stroke-width="3" fill="url(#grad1)"/>

                <text fill="#ffffff" font-size="45" font-family="Brush Script MT, cursive" x="25" y="65">LE</text>
        </svg>
    </div>

	<form id="logout" action="/logout" method="post">
	    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>

    <nav class="topnav">
        <div class="topnav-centered">
            <a href="${pageContext.request.contextPath}/guest">Topics</a>
            <a href="${pageContext.request.contextPath}/guest">Theory</a>
        </div>


        <div class="topnav-right">
            <a href="${pageContext.request.contextPath}/loginPage">LOGIN</a>
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <a href="javascript:document.getElementById('logout').submit()">Logout</a>
            </c:if>

        </div>
    </nav>
</header>

<main>
	<p>If you are a beginner and want to learn how to use tenses correctly, our exercises and basic grammar course will help you achieve your goal. </p>
</main>

<footer>

    <p class="footerp"> Contact: <span style="color: blue">bla bla</span></p>

</footer>


</body>
</html>


