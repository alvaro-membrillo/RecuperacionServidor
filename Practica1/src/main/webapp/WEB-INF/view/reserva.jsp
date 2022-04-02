<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="include/bootstrap.jsp" />
</head>
<body>
	
	<jsp:include page="include/barra.jsp" />
	
	<h1>DATOS DE LA RESERVA</h1>

	<form action="" method="POST">
		<label>Fecha de Inicio</label>
		<input type="date" name="inicio">
		<label>Fecha de Fin</label>
		<input type="date" name="final">
		<label>Número de personas</label>
		<input type="number" name="personas">
		
		<jsp:useBean id="reserva" scope="session" class="org.iesalixar.servidor.model.Reserva" />
		
		<h3>SERVICIOS</h3>
		
		<input type="checkbox">
		<label>Wifi</label>
		<input type="checkbox">
		<label>Toallas</label>
		<input type="checkbox">
		<label>Desayuno</label>
		<input type="checkbox">
		<label>Limpieza</label>
		<input type="checkbox">
		<label>Ruta guiada</label>
		<input type="checkbox">
		<label>Sauna</label>
		
		<input type="submit" name="RESERVAR">
	</form>


</body>
</html>