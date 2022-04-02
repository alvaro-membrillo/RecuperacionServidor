<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>CENTRAL DE VIAJES</h1>

	<c:if test="${sessionScope.usuario == null}">
		<form action="" method="POST">
			<label>Usuario</label>
			<input type="text" name="usuario">
			<label>Password</label>
			<input type="password" name="password">
			<label>Confirmar Password</label>
			<input type="password" name="confirmar">
			<label>Email</label>
			<input type="text" name="email">
			<input type="submit" name="enviar">
		</form>
	</c:if>

	<c:if test="${sessionScope.usuario != null}">
		
		<jsp:include page="include/barra.jsp" />
		<!--<h1>VOLVER</h1> <h1>SALIR</h1>
		<h3>Usuario: </h3>
		<h3>Sesión: </h3>-->
		
		<img alt="" src="https://icon-library.com/images/icon-website/icon-website-0.jpg">
	</c:if>

</body>
</html>