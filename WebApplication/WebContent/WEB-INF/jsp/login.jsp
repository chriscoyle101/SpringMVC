<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<head>

<link href="<c:url value="/resources/css/style.css" /> "rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>

<html>
	<body>
		<form class="login-form" method="post" action="/WebApplication/search.html">
		
			<p class="login-text">
				<span class="fa-stack fa-lg"> 
					<i class="fa fa-circle fa-stack-2x"></i> 
					<i class="fa fa-lock fa-stack-1x"></i>
				</span>
			</p>
		
			<input 	class="login-username" name="username" placeholder="Username" autofocus="true" /> 
		
			<input	class="login-password" name="password" placeholder="Password" />
		
		 	<input type="submit"  value="Submit" class="login-submit" />
		</form>
	
	<div class="underlay-photo"></div>
	<div class="underlay-black"></div>	
</body>
</html>
