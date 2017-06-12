<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cursos</title>
</head>
<body>
<header>
</header>
<nav>
<ul>
	<li><a href="<c:url value='/cursos'/>">Gestor Cursos</a></li>
    <li><a href="#">Importar fichero datos</a></li>

</ul>
</nav>
<main>
<section id="listadoCursos">
<header><h2>Listado de los últimos 10 cursos</h2></header>
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

<c:forEach var="curso" items="${listadoCursos}" begin="0" end="9">
	<tr>
		<td>${curso.id}</td>
		<td>${curso.nombre}</td>
		<td>${curso.codigo}</td>
	</tr>
	</c:forEach>
</c:when>
<c:otherwise>
	<tr><td colspan="4">En breve mostraremos un listado de los cursos más recientes</td></tr>
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