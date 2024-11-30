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

function deseleccionarAficiones(){
        // Obtener todos los checkboxes dentro del formulario
        const checkboxes = document.querySelectorAll('#aficion_seleccionada');

        // Iterar sobre cada checkbox y deseleccionarlos
        checkboxes.forEach(function(checkbox) {
            checkbox.checked = false;
        });
}

function seleccionarAficiones(){
    // Obtener todos los checkboxes dentro del formulario
    const checkboxes = document.querySelectorAll('#aficion_seleccionada');

    // Iterar sobre cada checkbox y deseleccionarlos
    checkboxes.forEach(function(checkbox) {
        checkbox.checked = true;
    });
}

function deseleccionarMusica() {
    // Obtener el select por su id
    const select = document.getElementById('musica');

    // Desmarcar todas las opciones seleccionadas
    for (let i = 0; i < select.options.length; i++) {
        select.options[i].selected = false;
    }
}

function seleccionarMusica() {
    // Obtener el select por su id
    const select = document.getElementById('musica');

    // Desmarcar todas las opciones seleccionadas
    for (let i = 0; i < select.options.length; i++) {
        select.options[i].selected = true;
    }
}

function vaciarFormulario() {
    // Obtener el formulario
    const formulario = document.getElementById('formulario');

    // Recorrer todos los elementos del formulario
    Array.from(formulario.elements).forEach(function(element) {
        if (element.type === 'text' || element.type === 'email' || element.type === 'textarea') {
            // Vaciar los campos de texto, email y textarea
            element.value = '';
        } else if (element.type === 'checkbox' || element.type === 'radio') {
            // Desmarcar los checkboxes y radios
            element.checked = false;
        } else if (element.tagName === 'SELECT') {
            // Vaciar los selects (seleccionar la primera opción por defecto)
            element.selectedIndex = -1;  // Esto los deselecciona todos
        }
    });
}