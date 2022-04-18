<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="include/bootstrap.jsp" />
<title>Añadir empleado</title>
</head>
<body>
	<div class="container mt-5">
		<jsp:include page="include/barra.jsp" />
		<div class="row justify-content-center mt-5">
			<div class="col-6">
				<form method="POST">
					<label>Número de empleado</label><input type="number" class="form-control" name="employeeNumber" required>
					<label>Apellidos</label><input type="text" class="form-control" name="lastName" required>
					<label>Nombre</label><input type="text" class="form-control" name="firstName" required>
					<label>Extension</label><input type="text" class="form-control" name="extension" required>
					<label>Email</label><input type="email" class="form-control" name="email" required>
					<label>Puesto</label><input type="text" class="form-control" name="jobTitle" required>
					<label>Oficina</label>
					<select class="form-select" name="office">
						<c:forEach items="${offices}" var="o">
							<option value="${o.officeCode}">${o.city}</option>
						</c:forEach>
					</select>
					<label>Jefe</label>
					<select class="form-select" name="boss">
						<c:forEach items="${employees}" var="b">
							<option value="${b.employeeNumber}">${b.firstName} ${b.lastName}</option>
						</c:forEach>
					</select>
					<input type="submit" class="btn btn-primary w-100 mt-3" value="Añadir empleado" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>