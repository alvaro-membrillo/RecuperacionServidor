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
<title>ProductLineReport</title>
</head>
<body>
	<jsp:include page="include/barra.jsp" />

	<div class="container mt-5">
		<div class="row justify-content-center mt-2">
			<p>Informe de Categoría: ${categoria}</p>
			<p>Número de Productos: ${totalProductos}</p>
			<p>Productos Vendidos: ${ventas}</p>
		</div>
	</div>
</body>
</html>