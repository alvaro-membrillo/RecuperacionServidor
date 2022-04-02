<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="include/bootstrap.jsp" />
<title>Oficinas</title>
</head>
<body>
	<div class="container mt-5">
		<div class="row justify-content-center mt-5">
			<div class="col-6">
				<c:choose>
					<c:when test="${offices!=null and offices.size()>0}">
						<jsp:include page="include/barra.jsp" />
						<form method="get">
							<label>Oficina</label>
							<select class="form-control" name="oficina">
								<c:forEach items="${offices}" var="o">
									<option value="${o.officeCode}">${o.city}</option>
								</c:forEach>
							</select> <input type="submit" class="btn btn-primary w-100 mt-3"
								value="OBTENER DATOS" />
						</form>
						<c:if test="${offices!=null}">
							<p>DATOS DE LA OFICINA DE ${oficinas.city}</p>
							<p>Code: ${oficinas.officeCode}</p>
							<p>Ciudad: ${oficinas.city}</p>
							<p>Telefono: ${oficinas.phone}</p>
							<p>Direccion 1: ${oficinas.addressLine1}</p>
							<p>Direccion 2: ${oficinas.addressLine2}</p>
							<p>Estado: ${oficinas.state}</p>
							<p>Pais: ${oficinas.country}</p>
							<p>Codigo Postal: ${oficinas.postalCode}</p>
							<p>Territorio: ${oficinas.territory}</p>
						</c:if>
					</c:when>
					<c:when test="${offices!=null and offices.size()==0}">
						<p class="text-danger">NO HAY RESULTADOS</p>
					</c:when>
				</c:choose>
			</div>
		</div>
	</div>
</body>
</html>