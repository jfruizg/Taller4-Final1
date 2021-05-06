console.log('hola')

document.querySelector('#boton').addEventListener('click', traerDatos);

function traerDatos() {
    var xhr = new XMLHttpRequest();
    const data = JSON.parse(xhr.responseText);
    xhr.open('GET', data, true);

    xhr.send();

    xhr.onreadystatechange = function () {

        if (this.readyState == 4 && this.status == 200) {

            console.log(this.responseText);
            let daots = JSON.parse(this.responseText);

            let res = document.querySelector('#res');
            res.innerHTML = '';


            for (let item of daots) {
                res.innerHTML += `
             <tr>
                <th>${item.nombre}</th>
                <th>${item.fecha}</th>
                <th>${item.descripcion}</th>
                <th>${item.imagen}</th>
            </tr>
                `
            }
        }
    }
}
                    
