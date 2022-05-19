<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<fmt:setBundle basename="interface" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="include/bootstrap.jsp" />
<title>Inicio</title>
</head>
<body>
	<div class="container mt-5">
		<div class="row justify-content-center mt-5">
			<c:if test="${sessionScope.usuario==null}">
				<div class="col-6">
					<form method="POST">
						<label><fmt:message key="user" /></label> <input type="text"
							class="form-control" name="usuario" required>
						<!--<label>firstName</label>
						<input type="text" class="form-control" name="firstName" required>
						<label>lastName</label>
						<input type="text" class="form-control" name="lastName" required>-->
						<label><fmt:message key="password" /></label> <input
							type="password" class="form-control" name="password" required>
						<input type="submit" class="btn btn-primary w-100 mt-3"
							value="<fmt:message key="enter" />" />
					</form>
					<p class="text-primary text-center mt-3">
						<a href="Registro"><fmt:message key="register" /></a>
					</p>
				</div>
			</c:if>
			<c:if test="${sessionScope.usuario!=null}">
				<jsp:include page="include/barra.jsp" />

				<c:if test="${sessionScope.role eq 'user'}">
<!-- 					<img class="img-fluid" width="100" src="img/user.png" /> -->
				</c:if>
				<c:if test="${sessionScope.role eq 'admin'}">
<!-- 					<img class="img-fluid" width="100" src="img/admin.jpg" /> -->
					<div class="container mt-5">
						<div class="row justify-content-center mt-5">
							<table class="table table-striped">
								<thead>
									<tr>
										<th scope="col">Código</th>
										<th scope="col">Nombre</th>
										<th scope="col">Categoría</th>
										<th scope="col">Stock</th>
										<th scope="col">Precio</th>
										<th scope="col">Acción</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${productos}" var="product">
										<tr>
											<td>${product.productName}</td>
											<td>${product.productCode}</td>
											<td>${product.productLine}</td>
											<td>${product.productScale}</td>
											<td>${product.productVendor}</td>
											<td>${product.productDescription}</td>
											<td>${product.quantityInStock}</td>
											<td>${product.buyPrice}</td>
											<td>${product.msrp}</td>
											<td><a href="EditarProduct?p=${product.productCode}"><i
													class="bi bi-pencil-fill"></i></a></td>
										</tr>
									</c:forEach>
								</tbody>

							</table>

						</div>
					</div>
				</c:if>
			</c:if>
		</div>
	</div>
</body>
</html>