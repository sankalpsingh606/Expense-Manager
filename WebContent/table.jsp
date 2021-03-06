<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@include file="productHome.jsp" %>

<!DOCTYPE html>
<html>
<head>
<title>Page Title</title>
<link rel='stylesheet' href='css/style2.css'>
<style>  
table, th, td {  
    border: 1px solid black;  
    border-collapse: collapse;  
}  
</style>  

</head>
<body>
	<header>
		<div class="view">
			<h2>All Product</h2>
			<hr>
<hr>
<c:choose>
	<c:when test="${fn:length(list) gt 0 }">
		<table  border='2'>
		<tr><td>Product ID</td>
		<td>Category</td>
		<td>Name</td>
		<td>Price</td>
		 <td>Purchase Date</td>
		 <td>Remove</td>
		 
		
		<c:forEach items="${list}" var="product">
			<tr>
			<td>${product.product_id}</td>
				<td>${product.category}</td>
				<td>${product.name}</td>
				<td>${product.price}</td>
				<td>${product.dates}</td>
				<td><a href="delete.jsp">remove</a> </td>
				
			</tr>
		</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<h1>No Items.</h1>
	</c:otherwise>

</c:choose>

</div>

	</header>
	
</body>
</html>