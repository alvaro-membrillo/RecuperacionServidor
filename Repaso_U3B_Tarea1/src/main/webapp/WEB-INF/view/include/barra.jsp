<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${sessionScope.usuario!=null}">
	<jsp:include page="bootstrap.jsp" />
	<fmt:setBundle basename="interface" />

	<ul class="nav bg-primary">

		<li class="nav-item"><a class="nav-link text-white"
			aria-current="page" href="<%=request.getContextPath()%>/Home">Inicio</a></li>

		<c:if test="${role=='user'}">
			<li class="nav-item"><a
				href="${pageContext.request.contextPath}/Oficinas"
				class="text-white">Buscar Oficinas</a></li>
		</c:if>

		<li class="nav-item">Está usted logeado como: ${firstName} ${lastName}</li>

		<li class="nav-item"><a class="text-white"
			href="<%=request.getContextPath() + "/Logout"%>">Salir</a></li>

	</ul>
</c:if>