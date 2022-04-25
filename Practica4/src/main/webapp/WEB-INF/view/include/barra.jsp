<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="bootstrap.jsp" />

<ul class="nav bg-primary">

	<li class="nav-item"><a class="nav-link text-white"
		aria-current="page" href="<%=request.getContextPath()%>">Inicio</a></li>

	<c:if test="${sessionScope.role eq 'user'}">
		<li class="nav-item text-white">ZONA DE USUARIO</li>
	</c:if>
	<c:if test="${sessionScope.role eq 'admin'}">
		<li class="nav-item"><a href="${pageContext.request.contextPath}/Admin/AddCustomer" class="text-white">Añadir Cliente</a></li>
		<li class="nav-item text-white">ZONA DE ADMINISTRACIÓN</li>
	</c:if>

	<li class="nav-item"><a class="text-white"
		href="<%=request.getContextPath() + "/Logout"%>"><i class="bi bi-box-arrow-left"></i></a></li>

</ul>
