<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>

    <link href="CSS/cssPag1.css" rel="stylesheet" />

    <title>Pet-Citizens</title>
    <meta charset="utf-8">
    <meta name="Keywords" content="perros,mascotas,canino,felino">
    <meta name="description" content="Per-ctizens un lugar donde va a poder regstrar a tu amigo de 4 patas  ">
    <meta name="author" content="Andres Nuñez, Juan Felipe Ruiz">
    <script src="https://d3js.org/d3.v5.min.js"></script>

</head>

<body>
<header class="header">
    <div class="container logo-navContanier">
        <nav class="navigation">
            <ul>

            </ul>
        </nav>
    </div>
</header>
<main class="Main">

    <Section class="fomr-register">

        <div class="tituloRegistro">

            <h4>Registra tu mascota</h4>

        </div>

        <div class="contenedor_registrar"></div>
        <form class="formularioRegistrar">
            <div id="form">
                <div>Cargar Imagen</div>
                <form method="post" action="uploadFile" enctype="multipart/form-data">
                    Choose a file:</br> <input type="file" accept="image/x-png,image/gif,image/jpeg" name="uploadFile"  class="Input"/><input type="submit" value="Upload"/>

                </form>
                <div class = "textoDescripcion">
                    <input type="text" name="userName" class="control" id="Id" placeholder="Ingrese Descripcion">
                </div>

                <div>Apache FileUpload</div>
                <form method="post" action="uploadFile" enctype="multipart/form-data">
                    Choose a file: <input type="file" name="uploadFile"/><input type="submit" value="Upload"/>
                    <input type="text" name="textoDescripcion"/>
                </form>

                <p class="warning" id="warning"></p>
            </div>
        </form>
        </div>

    </Section>



</main>

<footer class="footer">
    <div class="container">
        <p>diesñada por juan felipe ruiz, Andres Nuñez, Jose Navas W, Jorge Andres Ramirez</p>
    </div>
</footer>


</body>

</html>