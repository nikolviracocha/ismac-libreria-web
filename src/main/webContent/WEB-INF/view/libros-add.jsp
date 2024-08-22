<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario de Libro</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/libros/add" method="post">
    <input type="hidden" id="idLibro" name="idLibro" value="${libro.idLibro}">
    
    <label for="titulo">titulo</label>
    <input type="text" id="titulo" name="titulo" value="${libro.titulo}" required>
    <br/>    
    
    <label for="editorial">Editorial</label>
    <input type="text" id="editorial" name="editorial" value="${libro.editorial}">
    <br/>    
    
    <label for="numPaginas">Número de Páginas</label>
    <input type="number" id="numPaginas" name="numPaginas" value="${libro.numPaginas}">
    <br/>    
    
    <label for="edicion">Edición</label>
    <input type="text" id="edicion" name="edicion" value="${libro.edicion}">
    <br/>    
    
    <label for="idioma">Idioma</label>
    <input type="text" id="idioma" name="idioma" value="${libro.idioma}">
    <br/>    
    
    <label for="fechaPublicacion">Fecha de Publicación</label>
    <input type="date" id="fechaPublicacion" name="fechaPublicacion" value="${fn:escapeXml(libro.fechaPublicacion)}" required>
    <br/>    
    
    <label for="descripcion">Descripción</label>
    <input type="text" id="descripcion" name="descripcion" value="${libro.descripcion}">
    <br/>    
    
    <label for="tipoPasta">Tipo Pasta</label>
    <input type="text" id="tipoPasta" name="tipoPasta" value="${libro.tipoPasta}">
    <br/>    
    
    <label for="ISBN">ISBN</label>
    <input type="text" id="ISBN" name="ISBN" value="${libro.ISBN}">
    <br/>    
    
    <label for="numEjemplares">Número de Ejemplares</label>
    <input type="number" id="numEjemplares" name="numEjemplares" value="${libro.numEjemplares}">
    <br/>    
    
    <label for="portada">Portada</label>
    <input type="text" id="portada" name="portada" value="${libro.portada}">
    <br/>    
    
    <label for="presentacion">Presentación</label>
    <input type="text" id="presentacion" name="presentacion" value="${libro.presentacion}">
    <br/>    
    
    <label for="precio">Precio</label>
    <input type="text" id="precio" name="precio" value="${libro.precio}" pattern="^\d+(\.\d{1,2})?$">
   <br/>
		Categoria
		<select id="idCategoria" name="idCategoria">			
			<c:forEach var="item" items="${categorias}">
				<option value="${item.idCategoria}" ${item.idCategoria == libro.categoria.idCategoria ? 'selected' : '' } > ${item.categoria} </option>
			</c:forEach>					
		</select>
			
		<br/>
		Autor
		<select id="idAutor" name="idAutor">
			<c:forEach var="item" items="${autores}">
				<option value="${item.idAutor}"  ${item.idAutor == libro.autor.idAutor ? 'selected' : ''} > ${item.nombre} ${item.apellido} </option>
			</c:forEach>			
		</select>	
		<br/>
    
    <button type="submit">Guardar</button>  
    <button type="button" onclick="window.location.href='${pageContext.request.contextPath}/libros/findAll';">Cancelar</button>
</form>

</body>
</html>
