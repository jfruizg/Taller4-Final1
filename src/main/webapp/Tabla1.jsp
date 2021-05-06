<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tabla</title>
    <link href="CSS/cssTable.css" rel="stylesheet"/>
    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<ul>
    <li><a href="Tabla.html">Inge truco</a></li>
</ul>
<table id="authorsTbl">
    <thead>
    <tr>
        <th>nombre</th>
        <th>fecha</th>
        <th>descripcion</th>
        <th>Imagen</th>

    </tr>
    </thead>
    <tbody>
    </tbody>
</table>



<script>
    function printTable(elementId, servlet, columns,actions = []) {
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function() {
            if (xhr.readyState == 4) {
                var data = JSON.parse(xhr.responseText);
                console.log(data);
                var tbodyRef = document.getElementById(elementId).getElementsByTagName('tbody')[0];
                data.map(d => {
                    var newRow = tbodyRef.insertRow();
                    columns.map(c => {
                        var cell = newRow.insertCell();
                        var text = document.createTextNode(d[c]);
                        cell.appendChild(text);
                    });

                    if (actions.includes('create-book')) {
                        var cell = newRow.insertCell();
                        var action = document.createElement('button');
                      //  action.setAttribute('onclick', 'location.href="./upload.jsp?file=' + d['file'] +'ocation.href="./upload"'+ d['upload']+';');
                        var text = document.createTextNode('Descargar');
                        action.appendChild(text);
                        cell.appendChild(action);
                    }
                });
            }
        }
        xhr.open('GET', '${pageContext.request.contextPath}/' + servlet, true);
        xhr.send(null);
    }
    // Printing authors

    printTable(elementId = 'authorsTbl', servlet = 'GetCities', columns = ['nombre', 'fecha', 'descripcion', 'imagines' ],actions = ['create-book']);
</script>

</body>
</html>