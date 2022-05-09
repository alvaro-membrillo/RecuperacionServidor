<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="include/bootstrap.jsp" />
<title>Login</title>
</head>
<body>
	<div class="container mt-5">
		<div class="row justify-content-center mt-5">
			<div class="col-6">
				<form method="POST">
					<label>Usuario</label><input type="text" class="form-control" name="usuario" required>
					<label>Password</label><input type="password" class="form-control" name="password" required>
					<input type="submit" class="btn btn-primary w-100 mt-3" value="Entrar" />
				</form>
				<p class="text-primary text-center mt-3">
					<a href="Registro">Registrar usuario</a>
				</p>
			</div>
		</div>
	</div>

</body>
</html>