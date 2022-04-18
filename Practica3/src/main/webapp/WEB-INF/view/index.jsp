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
		<div class="row justify-content-center mt-5">
		<jsp:include page="include/barra.jsp" />
			
			<c:if test="${sessionScope.role eq 'user'}">
				<h1>Categorías disponibles</h1>
				<ul>
					<c:forEach items="${categorias}" var="c">
						<li><a href="${pageContext.request.contextPath}/MostrarProductos?productLine=${c.productLine}">${c.productLine}</a></li>
					</c:forEach>
				</ul>
			</c:if>
			<c:if test="${sessionScope.role eq 'admin'}">
				<h1>Operaciones disponibles </h1>
				<ul>
					<li><a href="<%=request.getContextPath()+"/Admin/Empleados"%>">Mostrar Empleados</a></li>
					<li><a href="<%=request.getContextPath()+"/Admin/AddEmpleado"%>">Añadir Empleado</a></li>
				</ul>
			</c:if>
			
		</div>
	</div>
</body>
</html>