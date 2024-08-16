<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Libros</title>
</head>
<body>

    <h1>Libros</h1>
    
   <button onclick="window.location.href='/ismac-libreria-web/libros/findOne?opcion=1'; return false;">Agregar</button>
   
 
   <table>
    <thead>
        <tr> 
            <th>ID</th>
            <th>Título</th>
            <th>Editorial</th>
            <th>Num. Páginas</th>
            <th>Idioma</th>
            <th>Fecha Publicación</th>
            <th>Descripción</th>
            <th>Tipo Pasta</th>
            <th>ISBN</th>
            <th>Num. Ejemplares</th>
            <th>Portada</th>
            <th>Presentación</th>
            <th>Precio</th>
            <th>Categoría</th>
            <th>Autor</th>
            <th>Acciones</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="item" items="${libros}"> 
            <tr>
                <td>${item.idLibro}</td>
                <td>${item.titulo}</td>
                <td>${item.editorial}</td>
                <td>${item.numPaginas}</td>
                <td>${item.idioma}</td>
                <td>${fn:substring(item.fechaPublicacion,0,10)}</td>
                <td>${item.descripcion}</td>
                <td>${item.tipoPasta}</td>
                <td>${item.ISBN}</td>
                <td>${item.numEjemplares}</td>
                <td>
                    <img alt="Portada de libro" width="100" height="100" src="${pageContext.request.contextPath}/resources/img/${item.portada}" />
                </td>
                <td>${item.presentacion}</td>
                <td>${item.precio}</td>
                <td>${item.categoria.categoria}</td>
                <td>${item.autor.nombre} ${item.autor.apellido}</td>
                <td>
              <button onclick="window.location.href='/ismac-libreria-web/libros/findOne?idLibro=${item.idLibro}&opcion=1'; return false;">
    Actualizar
</button>
<button onclick="window.location.href='/ismac-libreria-web/libros/del?idLibro=${item.idLibro}'; return false;">
    Eliminar
</button>
               			                   
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
   