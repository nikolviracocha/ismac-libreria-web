<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Clientes</h1>
	
			
	
	<table>
			<thead>
				<tr> 
			
					<th>idCliente </th>
					<th>Cedula </th>
					<th>Nombre </th>
					<th>Apellido </th>
					<th>Direccion </th>
					<th>Telefono </th>
					<th>Correo </th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="item" items="${clientes}"> 
				<tr>
						<td> ${item.idCliente}</td>
						<td> ${item.cedula}</td>
						<td> ${item.nombre}</td>
						<td> ${item.apellido}</td>
						<td> ${item.direccion}</td>
						<td> ${item.telefono}</td>
						<td> ${item.correo}</td>
						
						<td> 
							<button> Actualizar </button>
							<button> Eliminar </button>
						</td>
				</tr>
			</c:forEach>
			</tbody>
	</table>
			
			
</body>
</html>