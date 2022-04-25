<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="include/bootstrap.jsp" />
<title>Añadir cliente</title>
</head>
<body>
	<div class="container mt-5">
		<jsp:include page="include/barra.jsp" />
		<div class="row justify-content-center mt-5">
			<div class="col-6">
				<form method="POST">
					<label>Número de cliente</label><input type="number" class="form-control" name="customerNumber" required>
					<label>Nombre del cliente</label><input type="text" class="form-control" name="customerName" required>
					<label>Nombre de la persona de contacto</label><input type="text" class="form-control" name="contactFirstName" required>
					<label>Apellido de la persona de contacto</label><input type="text" class="form-control" name="contactLastName" required>
					<label>Teléfono</label><input type="text" class="form-control" name="phone" required>
					<label>Direccion1</label><input type="text" class="form-control" name="addressLine1" required>
					<label>Direccion2</label><input type="text" class="form-control" name="addressLine2" required>
					<label>Ciudad</label><input type="text" class="form-control" name="city" required>
					<label>Estado</label><input type="text" class="form-control" name="state" required>
					<label>CP:</label><input type="text" class="form-control" name="postalCode" required>
					<label>País</label><input type="text" class="form-control" name="country" required>
					<label>Empleado</label>
					<select class="form-select" name="salesRepEmployeeNumber">
						<c:forEach items="${listaEmpleados}" var="e">
							<option value="${e.employeeNumber}">${e.lastName}, ${e.firstName}</option>
						</c:forEach>
					</select>
					<label>Límite de Crédito</label><input type="number" class="form-control" name="creditLimit" required>
					<input type="submit" class="btn btn-primary w-100 mt-3" value="Añadir" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>