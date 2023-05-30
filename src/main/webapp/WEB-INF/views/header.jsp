<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>


<header>

	<div>
		<svg style="height:70px">
            <defs>
                <linearGradient id="grad1" x1="0%" y1="0%" x2="100%" y2="0%">
                    <stop offset="0%"
                	    style="stop-color:rgb(100,100,100);stop-opacity:1" />
                	<stop offset="100%"
                        style="stop-color:rgb(200,200,200);stop-opacity:1" />
                </linearGradient>
            </defs>
                <circle cx="50" cy="35" r="30" stroke="#808080" stroke-width="3" fill="url(#grad1)"/>

                <text fill="#ffffff" font-size="40" font-family="Brush Script MT, cursive" x="26" y="52">LE</text>
        </svg>
    </div>

	<form id="logout" action="/logout" method="post">
	    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>

    <nav class="topnav">
        <div class="topnav-centered">
            <a href="${pageContext.request.contextPath}/guest">Topics</a>
            <a href="${pageContext.request.contextPath}/theory">Theory</a>
        </div>


        <div class="topnav-right">
            <a href="${pageContext.request.contextPath}/loginPage">LOGIN</a>
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <a href="javascript:document.getElementById('logout').submit()">LOGOUT</a>
            </c:if>

        </div>
    </nav>
</header>
