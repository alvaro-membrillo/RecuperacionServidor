<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="include/bootstrap.jsp" />
<title>Añadir Producto</title>
</head>
<body>
	<div class="container mt-5">
		<jsp:include page="include/barra.jsp" />
		<div class="row justify-content-center mt-5">
			<div class="col-6">
				<form method="POST">
					<label>Product Code</label><input type="text" class="form-control" name="productCode" required>
					<label>Product Name</label><input type="text" class="form-control" name="productName" required>
					<label>Product Line</label>
					<select class="form-control" name="categoria">
						<c:forEach items="${categorias}" var="c">
							<option>${c.productLine}</option>
						</c:forEach>
					</select>
					<label>Product Scale</label><input type="text" class="form-control" name="productScale" required>
					<label>Product Vendor</label><input type="text" class="form-control" name="productVendor" required>
					<label>Product Description</label><input type="text" class="form-control" name="productDescription" required>
					<label>Stock</label><input type="number" class="form-control" name="stock" required>
					<label>Buy Price</label><input type="number" step="any" class="form-control" name="buyPrice" required>
					<label>MSRP</label><input type="number" step="any" class="form-control" name="msrp" required>
					<input type="submit" class="btn btn-primary w-100 mt-3" value="CREATE PRODUCT" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>