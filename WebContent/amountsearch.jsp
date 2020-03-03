<%@ include file="productHome.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Page Title</title>
<link rel='stylesheet' href='css/style2.css'>

</head>
<body>
	<header>
		<div class="view">
			<h2>Amount search</h2>
			<hr>
			<form action="product?opt=9" method="post">
				<input type="date" name="from"> <input type="date"
					name="to"> <input type="submit" value="Submit"
					name="searchBtn">
			</form>
		</div>

	</header>
	
</body>
</html>