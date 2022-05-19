<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="bootstrap.jsp" />
<fmt:setBundle basename="interface" />

<c:if test="${sessionScope.usuario!=null}">
	<nav class="navbar navbar-expand-lg navbar-light bg-primary">
		<div class="collapse navbar-collapse" id="navbarNavDropdown">
			<ul class="navbar-nav">
			
			<!-- USUARIOS -->
				<c:if test="${role eq 'user'}">
					<li class="nav-item active"><a class="nav-link text-white"
						href="${pageContext.request.contextPath}/Home">Inicio</a></li>
					<li class="nav-item"><p class="nav-link text-white"><fmt:message key="zone"/></p></li>
				</c:if>
				
			<!-- ADMIN -->
				<c:if test="${role eq 'admin'}">
					<li class="nav-item active"><a class="nav-link text-white"
						href="${pageContext.request.contextPath}/Home">Inicio</a></li>
					<li class="nav-item active"><a class="nav-link text-white"
						href="${pageContext.request.contextPath}/Admin/AddProduct">Añadir Producto</a></li>
					<li class="nav-item"><p class="nav-link text-white">ZONA DE ADMINISTRACION</p></li>
				</c:if>
				
				<li class="nav-item active"><fmt:message key="loggedas" />: ${firstName} ${lastName}</li>
				
				<li class="nav-item active"><a class="text-white" href="${pageContext.request.contextPath}/LogOut">
					<i class="bi bi-box-arrow-left"></i></a></li>
			</ul>
		</div>
	</nav>
</c:if>
