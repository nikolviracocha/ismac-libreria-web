<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulario de Libro</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-table.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>

<div class="container mt-4">
    <h2>Formulario de Libro</h2>
    <form action="${pageContext.request.contextPath}/libros/add" method="post" class="needs-validation" novalidate>
        <input type="hidden" id="idLibro" name="idLibro" value="${libro.idLibro}">

        <div class="form-group">
            <label for="titulo" class="form-label">Título</label>
            <input type="text" class="form-control" id="titulo" name="titulo" value="${libro.titulo}" required>
        </div>

        <div class="form-group">
            <label for="editorial" class="form-label">Editorial</label>
            <input type="text" class="form-control" id="editorial" name="editorial" value="${libro.editorial}">
        </div>

        <div class="form-group">
            <label for="numPaginas" class="form-label">Número de Páginas</label>
            <input type="number" class="form-control" id="numPaginas" name="numPaginas" value="${libro.numPaginas}">
        </div>

        <div class="form-group">
            <label for="edicion" class="form-label">Edición</label>
            <input type="text" class="form-control" id="edicion" name="edicion" value="${libro.edicion}">
        </div>

        <div class="form-group">
            <label for="idioma" class="form-label">Idioma</label>
            <input type="text" class="form-control" id="idioma" name="idioma" value="${libro.idioma}">
        </div>

        <div class="form-group">
            <label for="fechaPublicacion" class="form-label">Fecha de Publicación</label>
            <input type="date" class="form-control" id="fechaPublicacion" name="fechaPublicacion" value="${fn:escapeXml(libro.fechaPublicacion)}" required>
        </div>

        <div class="form-group">
            <label for="descripcion" class="form-label">Descripción</label>
            <input type="text" class="form-control" id="descripcion" name="descripcion" value="${libro.descripcion}">
        </div>

        <div class="form-group">
            <label for="tipoPasta" class="form-label">Tipo de Pasta</label>
            <input type="text" class="form-control" id="tipoPasta" name="tipoPasta" value="${libro.tipoPasta}">
        </div>

        <div class="form-group">
            <label for="ISBN" class="form-label">ISBN</label>
            <input type="text" class="form-control" id="ISBN" name="ISBN" value="${libro.ISBN}">
        </div>

        <div class="form-group">
            <label for="numEjemplares" class="form-label">Número de Ejemplares</label>
            <input type="number" class="form-control" id="numEjemplares" name="numEjemplares" value="${libro.numEjemplares}">
        </div>

        <div class="form-group">
            <label for="portada" class="form-label">Portada</label>
            <input type="text" class="form-control" id="portada" name="portada" value="${libro.portada}">
        </div>

        <div class="form-group">
            <label for="presentacion" class="form-label">Presentación</label>
            <input type="text" class="form-control" id="presentacion" name="presentacion" value="${libro.presentacion}">
        </div>

        <div class="form-group">
            <label for="precio" class="form-label">Precio</label>
            <input type="text" class="form-control" id="precio" name="precio" value="${libro.precio}" pattern="^\d+(\.\d{1,2})?$">
        </div>

        <div class="form-group">
            <label for="idCategoria" class="form-label">Categoría</label>
            <select id="idCategoria" name="idCategoria" class="form-control">
                <c:forEach var="item" items="${categorias}">
                    <option value="${item.idCategoria}" ${item.idCategoria == libro.categoria.idCategoria ? 'selected' : ''}>${item.categoria}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label for="idAutor" class="form-label">Autor</label>
            <select id="idAutor" name="idAutor" class="form-control">
                <c:forEach var="item" items="${autores}">
                    <option value="${item.idAutor}" ${item.idAutor == libro.autor.idAutor ? 'selected' : ''}>${item.nombre} ${item.apellido}</option>
                </c:forEach>
            </select>
        </div>

        <div class="mt-3">
            <button type="submit" class="btn btn-primary">Guardar</button>
            <button type="button" class="btn btn-secondary" onclick="window.location.href='${pageContext.request.contextPath}/libros/findAll';">Cancelar</button>
        </div>
    </form>
</div>

<script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>
<script>
    (function() {
        'use strict';
        const forms = document.querySelectorAll('.needs-validation');
        Array.from(forms).forEach(form => {
            form.addEventListener('submit', event => {
                if (!form.checkValidity()) {
                    event.preventDefault();
                    event.stopPropagation();
                }
                form.classList.add('was-validated');
            }, false);
        });
    })();
</script>

</body>
</html>

