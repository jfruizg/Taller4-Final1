<%--
  Created by IntelliJ IDEA.
  User: juanf
  Date: 4/05/2021
  Time: 10:16 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tabla</title>
</head>
<style>
    table, th, td{
        border: 1px solid black;
        border-collapse: collapse;
    }
</style>
<body>
<script>
    var imagen=1;
    while(error==false)
    {
        var uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
        var carpeta= obtener_imagen(uploadPath);
        var img= new Image();
        img.src=""+carpeta+"/"+imagen+".jpg";
        img.onerror=error(imagen);
        imagen++;
    }

    function error(numero)
    {
        error=yes;
        total=numero
    }
</script>
<table id="table">
    <th>
        Foto
    </th>
    <th>
        Descripción
    </th>
    <th>
        Hora
    </th>
    <th>
        Descargar
    </th>
</table>
</body>
</html>
