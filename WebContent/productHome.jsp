<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Page Title</title>
    <link rel='stylesheet'  href='css/style.css'>
    
</head>
<body>
    <header>
        <div class="main">
        <div class="logo">
            <img src="images/logo.png">
        </div>
        
      <ul>
          <li><a href="addProduct.jsp">Add Product</a>  </li>
          <li><a href="search.jsp">Product Search By Date</a>  </li>
          <li><a href="product?opt=5">Show All Product</a>  </li>
          <li><a href="amountsearch.jsp">Total Amount</a>  </li>
          <li><a href="">Amount With Category</a>  </li>
          
        </ul>
        </div>
        
        <div class="view">
			<h2><c:out value="Your are Successfully Logged in"></c:out></h2>
		</div>
        
        </header>
        </body>
</html>