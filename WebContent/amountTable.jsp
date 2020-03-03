<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@include file="productHome.jsp" %>

<!DOCTYPE html>
<html>
<head>
<style>  
table{  
            border-collapse: collapse;  
            width: 100%;   
        }  
    th,td{  
        border: 2px solid black;   
        padding: 15px;  
    }  
</style>  

<title>Page Title</title>
<link rel='stylesheet' href='css/style2.css'>

</head>
<body>
	<header>
		<div class="view">
			<h2>Total Amount</h2>
			<hr>
<hr>
<c:choose>
	<c:when test="${fn:length(list) gt 0 }">
		<table >
		<tr>
		<td>Category</td>
		<td>Total Amount</td>
</tr>
		<c:forEach items="${list}" var="product">
			<tr>
			
				<td>${product.category}</td>
				<td>${product.price}</td>
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