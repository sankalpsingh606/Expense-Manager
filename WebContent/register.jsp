<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="index.jsp"%>

<!DOCTYPE html>
<html>
<head>

<link rel='stylesheet' href='css/register.css'>
</head>
<body>
	<header>

		<div class="view">
			<h2>Register</h2>
			<hr>
			<form action="product?opt=1" method="post">

				<input type="text" name="name" placeholder="Enter Your Name">
				 <input type="text"name="username" placeholder="Enter Your User Name">
				  <input type="password"name="password" placeholder="Enter Your Password">
				   <input type="submit" value="Submit">

			</form>

		</div>

	</header>
</body>
</html>