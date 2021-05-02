<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>

    <link href="CSS/cssPag2.css" rel="stylesheet" />

    <title>Pet-Citizens</title>
    <meta charset="utf-8">
    <meta name="Keywords" content="perros,mascotas,canino,felino">
    <meta name="description" content="Per-ctizens un lugar donde va a poder regstrar a tu amigo de 4 patas  ">
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

            <h4>Selecciona la imagena</h4>

        </div>

        <div class="contenedor_registrar"></div>
        <div class="formularioRegistrar">
            <div id="form">
                <div>Cargar Imagen</div>
                <form method="post" action="uploadFile" enctype="multipart/form-data">
                    Choose a file:</br> <input type="file" accept="image/x-png,image/gif,image/jpeg" name="uploadFile"  class="Input"/><input type="submit" value="Upload"/>

                </form>
                <div class = "textoDescripcion">
                    <input type="text" name="descripcion" class="control" id="Id" placeholder="Ingrese Descripcion" class ="campoTexto">
                </div>

                <p class="warning" id="warning"></p>
            </div>
        </div>
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