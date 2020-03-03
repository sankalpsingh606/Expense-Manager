<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="productHome.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Page Title</title>
<link rel='stylesheet' href='css/style.css'>
</head>
<body>
	<header>
		<div class="view">
			<h2>Add Product</h2>

			<hr>
			<form action="product?opt=3" method="post">

				<select name="category">
                        <option>Select Category</option>
                        <option>Food</option>
                        <option>Shopping</option>
                        <option>Bills</option>
                        <option>Others</option>
                    </select>
                    
				 <input type="text"name="name" placeholder="Enter Your Product Name">
				  <input type="number"name="price" placeholder="Enter Your Price">
				   <input type="date" name="dates">
				   <input type="submit" value="Submit">

			</form>
</div>

	</header>
</body>
</html>
