<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="include/bootstrap.jsp" />
<title>Inicio</title>
</head>
<body>
	<div class="container mt-5">
		<jsp:include page="include/barra.jsp" />
		<div class="row justify-content-center mt-5">
			<div class="col-6">
				<form method="POST">
					<label>ProductCode</label>
					<input type="text" class="form-control" name="productCode" disabled>
					<label>ProductName</label>
					<input type="text" class="form-control" name="productName" required>
					<label>ProductLine</label>
					<input type="text" class="form-control" name="productLine" required>
					<label>ProductScale</label>
					<input type="text" class="form-control" name="productScale" required>
					<label>ProductVendor</label>
					<input type="text" class="form-control" name="productVendor" required>
					<label>ProductDescription</label>
					<input type="text" class="form-control" name="productDescription" required>
					<label>QuantityInStock</label>
					<input type="number" class="form-control" name="quantityInStock" required>
					<label>BuyPrice</label>
					<input type="number" class="form-control" name="buyPrice" required>
					<label>MSRP</label>
					<input type="number" class="form-control" name="msrp" required>
					<input type="submit" class="btn btn-primary w-100 mt-3" value="MODIFICAR" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>