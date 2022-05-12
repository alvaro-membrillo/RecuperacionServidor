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
<title><fmt:message key="register" /></title>
</head>
<body>
	<div class="container mt-5">
		<div class="row justify-content-center mt-5">
			<div class="col-6">
				<h2><fmt:message key="registerTitle" /></h2>
				<form method="POST">
					<label><fmt:message key="user" /></label>
					<input type="text" class="form-control" name="usuario" required>
					<label><fmt:message key="email" /></label>
					<input type="email" class="form-control" name="email" required>
					<label><fmt:message key="firstName" /></label>
					<input type="text" class="form-control" name="firstName" required>
					<label><fmt:message key="lastName" /></label>
					<input type="text" class="form-control" name="lastName" required>
					<label><fmt:message key="password" /></label>
					<input type="password" class="form-control" name="password" required>
					<input type="submit" class="btn btn-primary w-100 mt-3" value="<fmt:message key="register" />" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>