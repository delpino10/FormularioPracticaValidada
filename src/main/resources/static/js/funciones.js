// Revela el texto insertado en los input passwords
function verContrasenia(){
    let clave = document.getElementById('clave');
    let confirmarClave = document.getElementById('confirmarClave');

    if (clave.type === 'password'){
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
        if (elementos[i].type === 'radio') {
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

// Cambia el idioma de la pagina
$(document).ready(function() {
    // Obtener el parámetro 'idioma' de la URL
    function getParameterByName(name) {
        const url = new URL(window.location.href);
        return url.searchParams.get(name);
    }

    const selectedOption = getParameterByName('idioma');

    // Si hay un idioma en la URL, seleccionarlo en el select
    if (selectedOption) {
        $('#idioma').val(selectedOption);
    }
    $("#idioma").change(function () {
        let selectedOption = $('#idioma').val();
        if (selectedOption !== ''){
            window.location.replace('/formulario/devuelve-formulario?idioma=' + selectedOption);
        }
    });
});

// PopUp de confirmación de reseteo
// mensaje en Español e Inglés
function confirmarReseteo(nombreFormulario){
    let mensaje;
    let idioma = document.getElementById('idioma').value;

    if (idioma === "es") {
        mensaje = "Pulsa Aceptar para establecer el valor por defecto de los campos del formulario. " +
            "Pulsa Cancelar para abortar esta operación.";
    } else if (idioma === "en") {
        mensaje = "Press Accept to reset the form fields value. Press Cancel to abort this operation."
    } else {
        mensaje ="Unknown language / Idioma desconocido"
    }

    if (confirm(mensaje)) { // si se pulsa Aceptar
// se resetea el formulario
        document.getElementById(nombreFormulario).reset();
    }
}

// PopUp de confirmación de envio
// mensaje en Español e Inglés
function confirmarEnvio(nombreFormulario){
    let mensaje;
    let idioma = document.getElementById('idioma').value;

    if (idioma === "es") {
        mensaje = "Pulsa Aceptar para enviar el formulario. " +
            "Pulsa Cancelar para abortar esta operación.";
    } else if (idioma === "en") {
        mensaje = "Click Accept to submit the form. Click Cancel to abort this operation."
    } else {
        mensaje ="Unknown language / Idioma desconocido"
    }

    if (confirm(mensaje)) { // si se pulsa Aceptar
// se resetea el formulario
        document.getElementById(nombreFormulario).submit();
    }
}


