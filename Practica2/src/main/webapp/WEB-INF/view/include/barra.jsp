<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="bootstrap.jsp" />

<ul class="nav bg-primary">

	<li class="nav-item"><a class="nav-link text-white" aria-current="page"
		href="<%=request.getContextPath()%>">Inicio</a>
	</li>

	<li class="nav-item"><a class="nav-link text-white" aria-current="page"
		href="<%=request.getContextPath() + "/Oficinas"%>">Buscar oficinas</a></li>


	<li class="nav-item">
		<p class="text-white">
			Está usted logeado como: 
			<%=session.getAttribute("firstName") + " " + session.getAttribute("lastName")%>
		</p>
	</li>

	<li class="nav-item">
		<a class="text-white" href="<%= request.getContextPath() + "/Logout" %>">Salir</a>
	</li>

</ul>
