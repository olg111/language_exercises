<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html>

<html>

	<head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style><%@include file="/styles/style-login.css"%></style>
    </head>


	<body onload='document.loginForm.username.focus();'>

		<c:if test="${not empty error}">
		    <div>${error}</div>
		</c:if>
		<c:if test="${not empty message}">
		    <div>${message}</div>
		</c:if>

		<form class="form" name='login' action="<c:url value='/loginPage' />" method='POST'>
			<h3 style="text-align: center;">Login page</h3>

		            <p style="form-p">UserName:</p>
		            <input class="input" type='text' name='username' value=''/>
		            <p style="form-p">Password:</p>
		            <input class="input" type='password' name='password'/>
		            <input name="submit" type="submit" value="submit"/>

		    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		</form>

	</body>
</html>