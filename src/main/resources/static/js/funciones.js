// #### Botones #######

// ## Contraseñas #######
// Revela el texto insertado en los inputs passwords
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

// ## Géneros #######
// Deselecciona todos los Géneros
function deseleccionarGenero(botonesRadio) {
    const elementos = document.getElementsByName(botonesRadio);
    for (let i = 0; i <elementos.length; i++) {
        if (elementos[i].type === 'radio') {
            elementos[i].checked = false;
        }
    }
}

// ## Aficiones #######
// Deselecciona todos las Aficiones
function deseleccionarAficiones(){
        // Seleccionar todos los checkboxes dentro de aficiones
        const checkboxes = document.querySelectorAll('#aficion_seleccionada');

        // Iterar sobre cada checkbox y deseleccionarlos
        checkboxes.forEach(function(checkbox) {
            checkbox.checked = false;
        });
}

// Selecciona todas las Aficiones
function seleccionarAficiones(){
    // Seleccionar todos los checkboxes dentro de aficiones
    const checkboxes = document.querySelectorAll('#aficion_seleccionada');

    // Iterar sobre cada checkbox y deseleccionarlos
    checkboxes.forEach(function(checkbox) {
        checkbox.checked = true;
    });
}

// # Estilos Musicales #######
// Deselecciona todos los estilos musicales
function deseleccionarMusica() {
    // Seleccionar el select por su id
    const select = document.getElementById('musica');

    // Desmarcar todas las opciones seleccionadas
    for (let i = 0; i < select.options.length; i++) {
        select.options[i].selected = false;
    }
}

// Selecciona todos los estilos musicales
function seleccionarMusica() {
    // Seleccionar el select por su id
    const select = document.getElementById('musica');

    // Marcar todas las opciones seleccionadas
    for (let i = 0; i < select.options.length; i++) {
        select.options[i].selected = true;
    }
}


// Vacía el formulario de datos pùlsando el botón vaciar
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

// Cambia el idioma de la página
$(document).ready(function() {
    // Obtener el parámetro 'idioma' de la URL
    function getParameterByName(name) {
        const url = new URL(window.location.href);
        return url.searchParams.get(name);
    }
    // Guardar el parámetro 'idioma'
    const selectedOption = getParameterByName('idioma');

    // Sí hay un 'idioma' en la URL, seleccionarlo en el select
    if (selectedOption) {
        $('#idioma').val(selectedOption);
    }
    // Cambia el idioma a través de la URL
    $("#idioma").change(function () {
        let idiomaSeleccionado = $('#idioma').val();
        if (idiomaSeleccionado !== ''){
            window.location.replace('/formulario/devuelve-formulario?idioma=' + idiomaSeleccionado);
        }
    });
});


// #### Pop Up Boxes #######

// PopUp de confirmación de reseteo
// Mensaje en Español e Inglés
function confirmarReseteo(nombreFormulario){
    let mensaje;
    // Accedemos al valor del id 'idioma'
    let idioma = document.getElementById('idioma').value;
    // Si 'idioma' está puesto en español
    if (idioma === "es") {
        //Muestra el mensaje en español
        mensaje = "Pulsa Aceptar para establecer el valor por defecto de los campos del formulario. " +
            "Pulsa Cancelar para abortar esta operación.";
    // Si 'idioma' está puesto en español
    } else if (idioma === "en") {
        //Muestra el mensaje en inglés
        mensaje = "Press Accept to reset the form fields value. Press Cancel to abort this operation."
    } else {
        // Muestra el mensaje si el idioma no es conocido
        mensaje ="Unknown language / Idioma desconocido"
    }

    if (confirm(mensaje)) { // si se pulsa Aceptar se resetea el formulario
        document.getElementById(nombreFormulario).reset();
    }else{
        console.log("Operación cancelada por el usuario.")
    }
}

// PopUp de confirmación de envío
// Mensaje en Español e Inglés
function confirmarEnvio(nombreFormulario){
    let mensaje;
    // Accedemos al valor del id 'idioma'
    let idioma = document.getElementById('idioma').value;

    if (idioma === "es") {
        mensaje = "Pulsa Aceptar para enviar el formulario. " +
            "Pulsa Cancelar para abortar esta operación.";
    } else if (idioma === "en") {
        mensaje = "Click Accept to submit the form. Click Cancel to abort this operation."
    } else {
        mensaje ="Unknown language / Idioma desconocido"
    }

    if (confirm(mensaje)) { // si se pulsa Aceptar se envía el formulario
        document.getElementById(nombreFormulario).submit();
    }else{
        console.log("No enviado")
    }
}

// #### Banderas #######

// Banderas Países y Prefijos Telefónicos Seleccionados
$(document).ready(function() {
    function formatOption(option) {
        // Si no encuentra clave, devuelve el texto
        if (!option.id) {
            return option.text;
        }
        let imageUrl;
        // Si th:value="${p.key} = 'es'
        if(option.id === 'es'){
            // Asigna la ruta relativa a la bandera correspondiente
            imageUrl = '../img/espania.jpg';
        // Si th:value="${p.key} = 'it'
        }else if(option.id === 'it'){
            imageUrl = '../img/italia.jpg';
        // Si th:value="${p.key} = 'pt'
        }else if(option.id === 'pt'){
            imageUrl = '../img/portugal.jpg';
        // Si th:value="${p.key} = 'fr'
        }else if(option.id === 'fr'){
            imageUrl = '../img/francia.jpg';
            // Si th:value="${p.key} = 'en'
        }else if(option.id === 'en'){
            imageUrl = '../img/uk.jpg';
        }
        return $(
            // Devuelve un span donde se aloja la imagen de la bandera
            '<span><img src="' + imageUrl + '" class="img-flag"  alt="Bandera del país"/> ' + option.text + '</span>'
        );
    }

    // Select Países
    $('#pais_seleccionado').select2({
        templateResult: formatOption,
        templateSelection: formatOption,
        minimumResultsForSearch: Infinity
    });
    // Select Prefijo Telefónico
    $('#prefijoTelefonico').select2({
        templateResult: formatOption,
        templateSelection: formatOption,
        minimumResultsForSearch: Infinity
    });
    // Select Camnio de idioma
    $('#idioma').select2({
        templateResult: formatOption,
        templateSelection: formatOption,
        minimumResultsForSearch: Infinity
    });
});





