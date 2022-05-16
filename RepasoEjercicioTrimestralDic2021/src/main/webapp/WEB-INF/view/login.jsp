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
<title><fmt:message key="login" /></title>
</head>
<body>
	<div class="container mt-5">
		<div class="row justify-content-center mt-5">
			<div class="col-6">
				<form method="POST">
					<label><fmt:message key="user" /></label><input type="email" class="form-control" name="email" required>
					<label><fmt:message key="password" /></label><input type="password" class="form-control" name="password" required>
					<input type="submit" class="btn btn-primary w-100 mt-3" value="<fmt:message key="enter" />" />
				</form>
				<p class="text-primary text-center mt-3">
					<a href="Registro"><fmt:message key="register" /></a>
				</p>
			</div>
		</div>
	</div>

</body>
</html>