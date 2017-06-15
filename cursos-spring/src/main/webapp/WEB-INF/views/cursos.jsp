<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<section id="listadoCursos">

<header><h2>Listado de cursos</h2></header>
<a href="<c:url value='/cursos/addCurso' />">Nuevo</a>
<a href="<c:url value='/cursos/importarArchivo' />">Importar fichero datos</a>
<table>
	<thead>
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Código</th>
		</tr>
	</thead>
	<tbody>
<c:choose>
<c:when test="${not empty listadoCursos}">

<c:forEach var="curso" items="${listadoCursos}">
	<tr>
		<td>${curso.id}</td>
		<td>${curso.nombre}</td>
		<td>${curso.codigo}</td>
		<td><a href="<c:url value='/cursos/${curso.id}'/>">Modificar</a>
		<a href="<c:url value='/cursos/deleteCurso/${curso.id}'/>">Eliminar</a>
		</td>
	</tr>
	</c:forEach>
</c:when>
<c:otherwise>
	<tr><td colspan="4">"${mensaje}"</td></tr>
</c:otherwise>
</c:choose>
</tbody>
</table>

</section>
</main>
<footer>
Realizada por Ipartek Soc. Coop.
</footer>
</body>
</html>