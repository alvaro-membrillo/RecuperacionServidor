<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmar</title>
</head>
<body>

	<jsp:include page="include/barra.jsp"></jsp:include>
	
	<h1>RESERVA CONFIRMADA</h1>
	
	<p>FECHA DE INICIO: <%= session.getAttribute("inicio") %></p>
	<p>FECHA FINALIZACIÓN: </p>
	<p>NÚMERO DE PERSONAS: </p>
	<p>SERVICIOS RESERVADOS: </p>

</body>
</html>