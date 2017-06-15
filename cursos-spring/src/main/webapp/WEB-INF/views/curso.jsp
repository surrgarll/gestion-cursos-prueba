<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gestor Cursos</title>
</head>
<body>
<header>
</header>
<nav>
<ul>
	<li><a href="<c:url value='/'/>">Home</a></li>
	<li><a href="<c:url value='/cursos'/>">Gestor Cursos</a></li>
</ul>
</nav>
<main>
<section id="formCurso">
<header><h2>Formulario Curso</h2></header>
<form:form action="save" method="post" modelAttribute="curso">
	<div>
		<form:label path="id">Id</form:label>
		<form:input path="id"/>	
	</div>
	<div>
		<form:label path="nombre">Nombre</form:label>
		<form:input path="nombre"/>
	</div>
	<div>
		<form:label path="codigo">Codigo</form:label>
		<form:input path="codigo"/>
	</div>
	<div>
		<c:set var="b" value="Crear"></c:set>
		<c:if test="${curso.id>0}">
			<c:set var="b" value="Editar"/>
		</c:if>
		<input type="submit" value="${b}"/>
	</div>
</form:form>
</section>
</main>
<footer>
Realizada por Ipartek Soc. Coop.
</footer>
</body>
</html>