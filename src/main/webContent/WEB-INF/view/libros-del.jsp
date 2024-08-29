<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="ISO-8859-1">
    <title>Eliminar Libro</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f7f7;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px 40px;
            text-align: center;
            max-width: 400px;
            width: 100%;
        }

        h1 {
            color: #333;
            margin-bottom: 20px;
        }

        .warning {
            font-size: 18px;
            color: #d9534f;
            margin-bottom: 20px;
        }

        .button-group {
            display: flex;
            justify-content: center;
            gap: 20px; /* Espacio entre los botones */
        }

        button {
            padding: 10px 20px;
            font-size: 16px;
            border-radius: 5px;
            border: none;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .btn-submit {
            background-color: #d9534f;
            color: #ffffff;
        }

        .btn-submit:hover {
            background-color: #c9302c;
        }

        .btn-cancel {
            background-color: #5bc0de;
            color: #ffffff;
        }

        .btn-cancel:hover {
            background-color: #31b0d5;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>Eliminar Libro</h1>

    <form action="del" method="get">
        <input type="hidden" id="idLibro" name="idLibro" value="${libro.idLibro}" />
        <div class="warning"><strong>¿Desea eliminar el dato?</strong></div>
        <div class="button-group">
            <button type="submit" class="btn-submit">Eliminar</button>
            <button class="btn-cancel" onclick="window.location.href='/ismac-libreria-web/libros/findAll';return false;">Cancelar</button>
        </div>
    </form>
</div>

</body>
</html>