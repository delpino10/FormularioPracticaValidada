// Revela el texto insertado en los input passwords
function verContrasenia(){
    let clave = document.getElementById('clave');
    let confirmarClave = document.getElementById('confirmarClave');

    if (clave.type == 'password'){
        clave.type = 'text'
        confirmarClave.type = 'text'
    }else {
        clave.type = 'password'
        confirmarClave.type = 'password'
    }

}

function deseleccionarRadio(botonesRadioName) {
    const elementos = document.getElementsByName(botonesRadioName);
    for (let i = 0; i <elementos.length; i++) {
        if (elementos[i].type == 'radio') {
            elementos[i].checked = false;
        }
    }
}