package org.jadelpino.practicaformulario.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.jadelpino.practicaformulario.model.Colecciones;
import org.jadelpino.practicaformulario.model.DatosFormulario;
import org.jadelpino.practicaformulario.model.Pais;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.Locale;
import java.util.Map;

// Controlador Principal
@Controller
@RequestMapping("formulario")
public class PrincipalController {
    // Iniciamos el contador de las interacciones
    int interaccion = 1;

    // Lista de Países procedentes del modelo
    @ModelAttribute("lista_paises")
    private Map<String, Pais> devuelveListaPaices() {
        return Colecciones.getListaPaises();
    }
    // Lista de Géneros procedentes del modelo
    @ModelAttribute("lista_generos")
    private Map<String, String> devuelveListaGeneros() {
        return Colecciones.getListaGeneros();
    }
    // Lista de Estilos Musicales procedentes del modelo
    @ModelAttribute("lista_musicas")
    private Map<String, String> devuelveListaMusicas() {
        return Colecciones.getListaMusicas();
    }
    // Lista de Aficiones procedentes del modelo
    @ModelAttribute("lista_aficiones")
    private Map<String, String> devuelveListaAficiones() {
        return Colecciones.getListaAficiones();
    }


    // Envía la plantilla del formulario a rellenar por el usuario
    @GetMapping("devuelve-formulario")
    public String devuelveFormulario(
            Model modelo,
            // Acceso al POJO para pasarselos al modelo de la vista
            @ModelAttribute ("datosFormulario") DatosFormulario datosFormulario,
            // Clase que obtiene info del Cliente HTTP
            HttpServletRequest request) {
        // Método que recopila y muestra la Información del Cliente en la cabecera
        informacionCliente(request,modelo);
        // Renderiza el Título
        modelo.addAttribute("Original", "");
        // Renderiza las Interacciones
        modelo.addAttribute("interaccion", interaccion);

        // Devuelve la vista desde el controlador
        return "contenido";
    }


    // Recibe los parámetros del formulario y los pasa de nuevo a la vista
    @PostMapping("recibeParametrosYRepinta")
    public String recibeParametros(

            // @ModelAttribute sirve para pasar datos al modelo de la vista.
            // Si se quita @ModelAttribute, habría que pasarlo con model.addAttribute
            // modelo.addAttribute("datos-formulario", datosFormulario);
            @Valid @ModelAttribute DatosFormulario datosFormulario,
            BindingResult bindingResult,
            // Accedemos a los datos de la cabecera
            HttpServletRequest request,
            // accedemos al nombre del archivo/s subido/s
            @RequestParam(value = "archivos") String archivo,
            // accedemos al objeto que muestran las coordenadas en x
            // de la imagen
            @RequestParam(name = "imagen.x", required = false) Integer x,
            // accedemos al objeto que muestran las coordenadas en y
            // de la imagen
            @RequestParam(name = "imagen.y", required = false) Integer y,
            Model modelo) {

        // Mensaje de error vacío para insertar un th:if en la vista
        String mensajeNOK = "";
        // Muestra el mensaje cuando el formulario no contiene errores
        // Mensaje de error vacío para insertar un th:if en la vista
        String mensajeOK = "";
        // Mostrar el mensaje de las coordenadas en la vista
        String coordenadas = coordenadasImage(x,y);

        // Información del Cliente en la cabecera
        informacionCliente(request, modelo);

        // Suma la las veces que se ha rellenado un campo
        Integer camposRellenados = sumaCampos(datosFormulario);

        // Si hay errores
        if(bindingResult.hasErrors()) {
            // Interacciones
            interaccion++;
            // Renderiza interacciones
            modelo.addAttribute("interaccion", interaccion);
            // Renderiza Título
            modelo.addAttribute("Repintado", " ");
            // Renderiza mensaje de Error
            modelo.addAttribute("mensajeNOK", mensajeNOK);
            // Renderiza Mostrar el nombre del archivo
            modelo.addAttribute("archivo", archivo);
            // Renderiza las coordenadas de la imagen
            modelo.addAttribute("coordenadas", coordenadas);
            // muestra las veces que se ha rellenado un campo
            modelo.addAttribute("contadorParametros", camposRellenados);


            // Muestra los errores del fallo de aplicación
            erroresGlobales(datosFormulario, bindingResult);

            return "contenido";
        }
        // Si no Hay errores

        // Suma 1 las Interacciones
        interaccion++;

        //Renderiza el Título Repintado
        modelo.addAttribute("titulo", " Repintado");
        // Renderiza el valor de las interacciones
        modelo.addAttribute("interaccion", interaccion);
        // Renderiza el Mensaje
        modelo.addAttribute("mensajeOK", mensajeOK);
        // Renderiza el nombre del archivo
        modelo.addAttribute("archivo", archivo);
        // Renderiza las coordenadas de la imagen
        modelo.addAttribute("coordenadas", coordenadas);
        // muestra las veces que se ha rellenado un campo
        modelo.addAttribute("contadorParametros", camposRellenados);

        return "contenido";
    }

    // Muestra el mensaje de las coordenadas de la imagen en la vista
    public static String coordenadasImage (Integer x , Integer y) {
        return (x != null && y != null)
                ? "imagen.x: " + x + " e imagen.y: " + x
                : "";
    }


    // #################### Informacion Cliente ##########################

    //@GetMapping("informacion")
    public void informacionCliente(HttpServletRequest request, Model model) {
        // Obtiene la dirección IP del cliente
        String DireccionIp = request.getRemoteAddr();
        // Obtiene la información del navegador
        String navegador = identificarNavegador(request);
        // Obtiene el Sistema Opertaivo
        String SO = obtenerSistemaOperativo(request);
        // Obtiene el motor de renderizado del navegador
        String renderizado = obtenerMotorRenderizado(request);
        // Obtiene el encabezado "Host" de la solicitud HTTP
        String hostSolicitado = request.getHeader("Host");
        // Obtiene el idioma y locale principal del navegador
        Locale localePrincipal = request.getLocale();

        model.addAttribute("direccionIp", DireccionIp);
        model.addAttribute("navegador", navegador);
        model.addAttribute("SO", SO);
        model.addAttribute("renderizado", renderizado);
        model.addAttribute("hostSolicitado", hostSolicitado);
        model.addAttribute("localePrincipal", localePrincipal.toString());

    }

    // Método para extraer el sistema operativo del User-Agent
    private String obtenerSistemaOperativo(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");
        if (userAgent == null) return "Desconocido";
        // Identifica los sistemas operativos
        if (userAgent.contains("Windows")) {
            return "Windows";
        } else if (userAgent.contains("Macintosh") || userAgent.contains("Mac OS X")) {
            return "macOS";
        } else if (userAgent.contains("Linux")) {
            return "Linux";
        }
        return "Desconocido";
    }

    private String obtenerMotorRenderizado(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");
        if (userAgent == null) {
            return "Desconocido";
        }
        // Detectar motores de renderizado según el User-Agent
        if (userAgent.contains("Gecko") && !userAgent.contains("WebKit")) {
            return "Gecko (Firefox)";
        } else if (userAgent.contains("AppleWebKit") && userAgent.contains("Chrome")) {
            return "Blink (Chromium-based)";
        } else if (userAgent.contains("AppleWebKit")) {
            return "WebKit (Safari)";
        }

        return "Desconocido";
    }

    public String identificarNavegador(HttpServletRequest request) {
        // Accede al User Agent
        String userAgent = request.getHeader("User-Agent");
        // Si el User Agent  null
        if (userAgent == null) {
            return "Desconocido";
        }
        // Detectar el navegador según el User-Agent
        if (userAgent.contains("Chrome") && !userAgent.contains("Chromium")) {
            return "Google Chrome";
        } else if (userAgent.contains("Firefox")) {
            return "Mozilla Firefox";
        } else if (userAgent.contains("Safari") && !userAgent.contains("Chrome")) {
            return "Apple Safari";
        } else if (userAgent.contains("Edg")) {
            return "Microsoft Edge";
        } else if (userAgent.contains("OPR") || userAgent.contains("Opera")) {
            return "Opera";
        } else if (userAgent.contains("Trident") || userAgent.contains("MSIE")) {
            return "Internet Explorer";
        }

        return "Navegador desconocido";
    }


    // Gestionar los null para mostrar el mensaje de error Global

    public static void erroresGlobales(DatosFormulario datosFormulario,
                                       BindingResult bindingResult) {
        if((datosFormulario.getNombre() == null)
                || (datosFormulario.getClave() == null)
                || (datosFormulario.getConfirmarClave() == null)
                || (datosFormulario.getGeneroSeleccionado() == null)
                || (datosFormulario.getPaisSeleccionado() == null)
                || (datosFormulario.getFechaNacimiento() == null)
                || (datosFormulario.getEdad() == null)
                || (datosFormulario.getPeso() == null)
                || (datosFormulario.getPrefijoTelefonico() == null)
                || (datosFormulario.getTelefono() == null)
                || (datosFormulario.getUrl() == null)
                || (datosFormulario.getArchivos() == null)
                || (datosFormulario.getComentarios() == null)
                || (datosFormulario.getLicencia() == null)
        ) {
            // Muestra el mensaje "Error en el funcionamiento de la aplicación"
            bindingResult.reject("Validacion.error.aplicacion");
        }
    }

    private int sumaCampos(DatosFormulario datos) {
        int contador = 0;

        if(datos.getNombre()!=null && !datos.getNombre().equals("")){
            contador++;
        }
        if(datos.getClave()!=null && !datos.getClave().isEmpty()){
            contador++;
        }
        if(datos.getConfirmarClave()!=null && !datos.getConfirmarClave().isEmpty()){
            contador++;
        }
        if(datos.getGeneroSeleccionado()!=null && !datos.getGeneroSeleccionado().isEmpty()){
            contador++;
        }
        if(datos.getPaisSeleccionado()!=null && !datos.getPaisSeleccionado().isEmpty()){
            contador++;
        }
        if(datos.getFechaNacimiento()!=null && !datos.getFechaNacimiento().equals("")){
            contador++;
        }
        if(datos.getEdad()!=null && datos.getEdad()!=0){
            contador++;
        }
        if(datos.getPeso()!=null && datos.getPeso()!=0.0){
            contador++;
        }
        if(datos.getPrefijoTelefonico()!=null && !datos.getPrefijoTelefonico().isEmpty()){
            contador++;
        }
        if(datos.getTelefono()!=null && !datos.getTelefono().isEmpty()){
            contador++;
        }
        if(datos.getEmail()!=null && !datos.getEmail().isEmpty()){
            contador++;
        }
        if(datos.getUrl()!=null && !datos.getUrl().isEmpty()){
            contador++;
        }
        if(datos.getArchivos()!=null && !datos.getArchivos().isEmpty()){
            contador++;
        }
        if(datos.getComentarios()!=null && !datos.getComentarios().isEmpty()){
            contador++;
        }
        if(datos.getLicencia() != null){
            contador++;
        }
        if(datos.getMusicasSeleccionadas()!=null){
            contador++;
        }
        if(datos.getAficionesSeleccionadas()!=null){
            contador++;
        }

        return contador;
    }


}
