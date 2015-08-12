function muestraPopUpCampoNoVacio(selector) {
    configurarPopUpChiquito(selector, 'Campo Requerido', 'Este campo no puede ser vácio');
}

function muestraPopUpCampoNoVacioConMensaje(selector, mensaje) {
    configurarPopUpChiquito(selector, 'Campo Requerido', mensaje);
}

function muestraPopUpCampoNumerico(selector) {
    configurarPopUpChiquito(selector, 'Campo Inválido', 'Ingrese un número');
}

function muestraPopUpExtencionNoValida(selector, mensaje) {
    configurarPopUpChiquito(selector, 'Extención inválida', mensaje);
}

function muestraPopUpTituloAndMensaje(selector, titulo, mensaje) {
    //$(selector).attr('data-placement', 'top');
    configurarPopUpChiquito(selector, titulo, mensaje);
}

function configurarPopUpChiquito(selector, titulo, mensaje){
    $(selector).attr('data-toggle', 'popover');
    $(selector).attr('data-trigger', 'focus');
    $(selector).attr('title', titulo);
    $(selector).attr('data-content', mensaje);
    $(selector).popover('show');
}


function cierraPopUpChiquito(selector) {
    $(selector).popover('hide');
    $(selector).removeAttr('data-toggle');
    $(selector).removeAttr('data-trigger');
    $(selector).removeAttr('title');
    $(selector).removeAttr('data-content');
}

function setOption(options, texto) {
    $.each(options, function(indice, valor) {
        if ($(valor).text() === texto) {
            $(valor).prop('selected', true);
        }
    });
}

function limpiarInputs() {
    $.each($('input'), function(indice, valor) {
        $(valor).val('');
        cierraPopUpChiquito($(valor));
        $(valor).removeAttr('style');
    });
    $.each($('select'), function(indice, valor) {
        $(valor).val('0');
        cierraPopUpChiquito($(valor));
        $(valor).removeAttr('style');
    });
}

function regresaData(input, name){
    var data = new FormData();
    data.append(name, input.files[0]);
    return data;
}